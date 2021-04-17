package kg.geektech.general;

import kg.geektech.game.player.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random();

    public  static void start(){
        Boss boss = new Boss(1000, 50);

        Warrior warrior = new Warrior(250,15, "IRON MAN");
        Medic doc = new Medic(230,10, 15, "Mantis");
        Magic magic = new Magic(260,25, "Doctor Strange");
        Berserk berserk = new Berserk(230,20, "Rouge");
        Medic assistant = new Medic(240,15, 5, "Mantis assistants");
        TrickyBastard bastard = new TrickyBastard(250,20, "STARK");
        Thor thor = new Thor(270, 20,"THOR");
        Golem golem = new Golem(300, 15, "Helping");

        Hero[] heroes = {warrior, magic, doc, berserk, assistant, bastard, thor, golem};
        printStatistics(boss, heroes);

        while (!isGameFinish(boss, heroes)){
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes){
        if ( boss.getHealth() > 0) {
            bossHits(boss, heroes);
        }
        heroesHits(boss, heroes);
        heroesApplySuperPower(boss, heroes);
        printStatistics(boss, heroes);
    }
    public static void bossHits(Boss boss, Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }

        }
    }

    public static void heroesHits(Boss boss, Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }

        }
    }
    public static void heroesApplySuperPower (Boss boss, Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0) {
                heroes[i].applySuperAbility(boss, heroes);
            }

        }
    }

    public static boolean isGameFinish(Boss boss, Hero[] heroes){
        if (boss.getHealth() <= 0){
            System.out.println("Heroes won!!! ");
            return true;
        }
        boolean allHeroesDad = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0){
                allHeroesDad = false;
                break;
            }
        }
        if (allHeroesDad){
            System.out.println("Boss won!!!");
        }
        return allHeroesDad;
    }
    public static void printStatistics(Boss boss, Hero[] heroes){
        System.out.println("_______________");
        System.out.println("Boss health " + boss.getHealth() + " [" + boss.getDamage() + "]");

        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getName() + " health " + heroes[i].getHealth() +
                    " [" + heroes[i].getDamage() + "]");

        }
    }
}
