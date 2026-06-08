import java.io.*;

public class FileProcessor {
public static void processFile(String inputFile)
        throws IOException {

    String outputFile =
            "output_" + inputFile;

    try (
            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(inputFile));

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(outputFile));

            BufferedWriter logger =
                    new BufferedWriter(
                            new FileWriter(
                                    "processing.log",
                                    true))
    ) {

        String line;
        int lineCount = 0;

        while ((line = reader.readLine()) != null) {

            writer.write(
                    line.toUpperCase());

            writer.newLine();

            lineCount++;
        }

        logger.write(
                Thread.currentThread().getName()
                        + " processed "
                        + inputFile
                        + " | Lines: "
                        + lineCount);

        logger.newLine();

        System.out.println(
                inputFile
                        + " processed successfully.");
    }
}

}
