package rescue;

public class TeamMember {
    private final String name;

    public TeamMember(String name, String name1) throws InvalidTeamException {
        if (name1 == null) {
            throw new InvalidTeamException("Team member name cannot be null");
        }
        String trimmed = name1.trim();
        if (trimmed.isEmpty()) {
            throw new InvalidTeamException("Team member name cannot be blank");
        }
        if (trimmed.contains(",")) {
            throw new InvalidTeamException("Team member name cannot contain comma");
        }
        if (trimmed.contains(";")){
            throw new InvalidTeamException("Team member name cannot contain semicolon");
        }
        this.name = name1;
    }

    public String getName() {
        return name;
    }

}
