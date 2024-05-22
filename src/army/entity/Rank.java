package army.entity;

public enum Rank {
    PRIVATE("Private", 1),
    CORPORAL("Corporal", 2),
    SERGEANT("Sergeant", 3),
    LIEUTENANT("Lieutenant", 4),
    CAPTAIN("Captain", 5),
    MAJOR("Major", 6),
    COLONEL("Colonel", 7),
    GENERAL("General", 8);

    private final String name;
    private final int level;

    // Constructor
    Rank(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
    // Find a rank by its level
    public static Rank getByLevel(int level) {
        for (Rank rank : values()) {
            if (rank.getLevel() == level) {
                return rank;
            }
        }
        throw new IllegalArgumentException("No rank with level " + level);
    }

    // Override toString method to return the rank name
    @Override
    public String toString() {
        return this.name;
    }
}
