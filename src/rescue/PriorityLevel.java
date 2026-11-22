package rescue;

public enum PriorityLevel {
    CRITICAL(80),
    HIGH(50),
    MEDIUM(30),
    LOW(0);

    private final int minScore;

    PriorityLevel(int minScore) {
        this.minScore = minScore;
    }

    public int getMinScore() {
        return minScore;
    }

    public static PriorityLevel fromScore(int score) {
        for (PriorityLevel level : PriorityLevel.values()) {
            if (score >= level.minScore) {
                return level;
            }
        }
        return LOW;
    }
}
