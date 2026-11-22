package rescue;

public class MissingLocationException extends InvalidIncidentException {

    public MissingLocationException(String message) {
        super(message);
    }
}