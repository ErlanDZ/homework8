package kg.geektech.game.player;

import kg.geektech.general.RPG_Game;

public class Berserk extends Hero {
    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int coef = boss.getDamage() / 2;
        boss.setHealth(boss.getHealth() - coef);
        System.out.println(this.getName() + " hits critically  " + coef );

    }
}
