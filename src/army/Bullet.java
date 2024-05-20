package army;

public class Bullet {
    private int score;

    public Bullet(int score) {

        this.score = score;
        if (score < 0 || score > 10) {
            System.out.println("invalid score");
            this.score = 0;
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Bullet{" +
                "score=" + score +
                '}';
    }
}
