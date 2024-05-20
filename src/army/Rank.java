package army;

public enum Rank {
    LIEUTENANT("Lieutenant", 1),
    SERGEANT("Sergenant", 2),
    COPORAL("coporal", 3);


    private final String name;
    private final int level;

    // Constructor
    Rank(String name, int level) {
        if (level>3)level=3;
        if (level<1)level=1;
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
        if (level>3)level=3;
        if (level<1)level=1;
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
