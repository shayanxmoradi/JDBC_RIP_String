package army.entity;

import java.util.Arrays;

public class Soldier {
    private int id;
    private Bullet[] bullets = new Bullet[4];
    private int finalScore;
    private Rank initialRank;
    private Rank finalRank;

    public Soldier(int id, Rank initialRank) {
        this.id = id;
        this.initialRank = initialRank;
    }



    @Override
    public String toString() {
        return
                "Soldier id=" + id +
                ", \nbullets=" + Arrays.toString(bullets) +
                ", \nfinalScore=" + finalScore +
                ",\n initialRank=" + initialRank +
                ", \nfinalRank=" + finalRank +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bullet[] getBullets() {
        return bullets;
    }

    public void setBullets(Bullet[] bullets) {
        this.bullets = bullets;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public Rank getInitialRank() {
        return initialRank;
    }

    public void setInitialRank(Rank initialRank) {
        this.initialRank = initialRank;
    }

    public Rank getFinalRank() {
        return finalRank;
    }

    public void setFinalRank(Rank finalRank) {
        this.finalRank = finalRank;
    }
}
