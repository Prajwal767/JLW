import java.sql.*;

public class BankingService {

    public void addCustomer(Customer customer) {

        try (Connection con =
                     DBConnection.getConnection()) {

            String query =
                    "INSERT INTO customers(customer_name,balance) VALUES(?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(
                    1,
                    customer.getCustomerName());

            ps.setDouble(
                    2,
                    customer.getBalance());

            ps.executeUpdate();

            System.out.println(
                    "Customer Added Successfully");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void displayCustomers() {

        try (Connection con =
                     DBConnection.getConnection()) {

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM customers");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("account_id")
                                + " | "
                                + rs.getString("customer_name")
                                + " | "
                                + rs.getDouble("balance"));
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void updateBalance(
            int accountId,
            double newBalance) {

        try (Connection con =
                     DBConnection.getConnection()) {

            String query =
                    "UPDATE customers SET balance=? WHERE account_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setDouble(1, newBalance);
            ps.setInt(2, accountId);

            ps.executeUpdate();

            System.out.println(
                    "Balance Updated");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void deleteCustomer(
            int accountId) {

        try (Connection con =
                     DBConnection.getConnection()) {

            String query =
                    "DELETE FROM customers WHERE account_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, accountId);

            ps.executeUpdate();

            System.out.println(
                    "Customer Deleted");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void transferMoney(
            int fromId,
            int toId,
            double amount)
            throws BankingException {

        Connection con = null;

        try {

            con = DBConnection.getConnection();

            con.setAutoCommit(false);

            String debitQuery =
                    "UPDATE customers SET balance = balance - ? WHERE account_id=?";

            PreparedStatement debit =
                    con.prepareStatement(debitQuery);

            debit.setDouble(1, amount);
            debit.setInt(2, fromId);

            int rows1 =
                    debit.executeUpdate();

            String creditQuery =
                    "UPDATE customers SET balance = balance + ? WHERE account_id=?";

            PreparedStatement credit =
                    con.prepareStatement(creditQuery);

            credit.setDouble(1, amount);
            credit.setInt(2, toId);

            int rows2 =
                    credit.executeUpdate();

            if (rows1 == 0 || rows2 == 0) {

                throw new BankingException(
                        "Invalid Account ID");
            }

            con.commit();

            System.out.println(
                    "Transfer Successful");

        } catch (Exception e) {

            try {

                if (con != null) {
                    con.rollback();
                }

            } catch (SQLException ex) {

                ex.printStackTrace();
            }

            System.out.println(
                    "Transaction Failed");

        } finally {

            try {

                if (con != null) {
                    con.close();
                }

            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
    }
}