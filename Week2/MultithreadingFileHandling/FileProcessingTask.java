public class FileProcessingTask
implements Runnable {

private String fileName;

public FileProcessingTask(
        String fileName) {

    this.fileName = fileName;
}

@Override
public void run() {

    try {

        FileProcessor.processFile(
                fileName);

    } catch (Exception e) {

        System.out.println(
                "Error processing "
                        + fileName);

        e.printStackTrace();
    }
}

}
