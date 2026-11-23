package rescue;

public class InvalidCsvDataException extends RescueSystemException {

    private final String fileName;
    private final int lineNumber;

    public InvalidCsvDataException(String fileName, int lineNumber, String message) {
        super(message);
        this.fileName = fileName;
        this.lineNumber = lineNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public int getLineNumber() {
        return lineNumber;
    }
}