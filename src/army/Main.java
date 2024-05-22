package army;

import army.entity.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Soldier soldier = new Soldier(1, Rank.CORPORAL);
        Officer officer = new Officer("asghar", 1);
        Bullet bullet = new Bullet(7);
        Bullet bullet2 = new Bullet(2);
        Bullet bulle3 = new Bullet(7);
        Bullet bulle4 = new Bullet(7);
        Bullet[] bullets = {bullet, bullet2, bulle3, bulle4};
        soldier.setBullets(bullets);
        officer.runExam(soldier);
        ////
        Soldier soldier2 = new Soldier(1, Rank.PRIVATE);
        Bullet bullet10 = new Bullet(7);
        Bullet bullet11 = new Bullet(9);
        Bullet bulle12 = new Bullet(7);
        Bullet bulle13 = new Bullet(7);
        Bullet[] bullets2 = {bullet10, bullet11, bulle12, bulle13};
        soldier.setBullets(bullets2);
        officer.runExam(soldier);
        GarrisonCommander.showReportList();


    }

}