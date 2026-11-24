package rescue;

public class MissingEquipmentException extends TeamNotSuitableException {

    public MissingEquipmentException(String message) {
        super(message);
    }
}