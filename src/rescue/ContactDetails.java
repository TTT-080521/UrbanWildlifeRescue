package rescue;

public class ContactDetails {

    private final String name;
    private final String phone;

    public ContactDetails(String name, String phone) throws InvalidIncidentException {
        if (name == null) {
            throw new InvalidIncidentException("Name cannot be null");
        }
        String trimmedName = name.trim();
        if (trimmedName.isEmpty()) {
            throw new InvalidIncidentException("Name cannot be empty");
        }
        if(trimmedName.contains(",")) {
            throw new InvalidIncidentException("Name cannot contain commas");
        }
        if (trimmedName.contains(";")) {
            throw new InvalidIncidentException("Name cannot contain semicolons");
        }
        if (phone == null) {
            throw new InvalidIncidentException("Phone cannot be null");
        }
        String trimmedPhone = phone.trim();
        if (trimmedPhone.isEmpty()) {
            throw new InvalidIncidentException("Phone cannot be empty");
        }
        if (trimmedPhone.length() != 10) {
            throw new InvalidIncidentException("Phone cannot have 10 characters");
        }
        for (int i = 0; i < trimmedPhone.length(); i++) {
            char c = trimmedPhone.charAt(i);
            if(c < '0' || c > '9') {
                throw new InvalidIncidentException("Phone number should only have digits between 0-9");
            }
        }
        this.name = name;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }

}
