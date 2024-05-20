package army;

import army.util.Util;

import java.util.ArrayList;

public class Offiser {
    private int id;
    private String name;
    private final static int NUMBER_OF_VALID_COPORALS = 9;

    public Offiser(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void runExam(Soldier[] soldiers) {
        int corporalCounter = 0;
        for (Soldier soldier : soldiers) {

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

            if (soldier.getFinalRank().getLevel() == Rank.COPORAL.getLevel()) {

                corporalCounter++;
            }
            GarrisonCommander.getReportList().add("--------- \n" + soldier.toString() + "---------\n");

        }
        System.out.println(corporalCounter);
        if (corporalCounter >= NUMBER_OF_VALID_COPORALS) {
            GarrisonCommander.setReportList(new ArrayList<>());
            System.out.println("in this Exam we had " + corporalCounter + " corpoarl which is more than" + NUMBER_OF_VALID_COPORALS + " valid coporals" + "" +
                    "\n restarting the exam");
            Util.setupData();
        } else {
        }

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
