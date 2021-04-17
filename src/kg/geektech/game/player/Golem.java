package kg.geektech.game.player;

public class Golem extends Hero{
    public Golem(int health, int damage, String name) {
        super(health, damage, SuperAbility.HELPING_PERSON, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int help = boss.getDamage() / 5;

        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && heroes[i] != this){
                heroes[i].setHealth(heroes[i].getHealth() + help);

            }

        }
        this.setHealth(this.getHealth() - (boss.getDamage() - help));
        System.out.println(this.getName() + " помогает");

    }
}
