package rescue;

import java.io.IOException;

public class DataFileException extends RescueSystemException {

    public DataFileException(String message) {
        super(message);
    }

    public DataFileException(String message, IOException cause) {
        super(message);
        initCause(cause);
    }
}