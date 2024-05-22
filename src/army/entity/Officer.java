package army.entity;

public class Officer {
    private int id;
    private String name;

    public Officer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void runExam(Soldier soldier) {

        int score = 0;
        for (Bullet bullet : soldier.getBullets()) {
            score += bullet.getScore();
        }
        soldier.setFinalScore(score);
        if (soldier.getFinalScore() > 26) {

            soldier.setFinalRank(Rank.getByLevel(soldier.getInitialRank().getLevel() + 1));
        } else {
            soldier.setFinalRank(Rank.getByLevel(soldier.getInitialRank().getLevel() - 1));
        }
        GarrisonCommander.getReportList().add("--------- \n"+soldier.toString()+"---------\n");
        System.out.println(soldier);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
