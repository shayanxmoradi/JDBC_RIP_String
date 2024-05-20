package army.util;

import army.*;

import java.util.List;
import java.util.Random;

public class Util {
    public static void setupData() {
        Soldier[] soldiers = new Soldier[15];
        Offiser offiser = new Offiser("asghar", 1);
        Rank[] ranks = Rank.values();
        Random rand = new Random();
        for (int i = 0; i < 15; i++) {
            // Generate a random rank for the soldier
            Rank rank = ranks[rand.nextInt(ranks.length)];

            Soldier soldier = new Soldier(i, rank);

            Bullet[] bullets = new Bullet[4];
            for (int j = 0; j < bullets.length; j++) {
                bullets[j] = new Bullet(rand.nextInt(10) + 1); // Random caliber between 1 and 10
            }

            soldier.setBullets(bullets);

            soldiers[i] = soldier;

        }
        offiser.runExam(soldiers);

    }
}
