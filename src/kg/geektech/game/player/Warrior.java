package kg.geektech.game.player;

import kg.geektech.game.player.Boss;
import kg.geektech.game.player.Hero;
import kg.geektech.game.player.SuperAbility;
import kg.geektech.general.RPG_Game;

public class Warrior extends Hero {
    public Warrior(int health, int damage, String name) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int coef = RPG_Game.random.nextInt(2) + 1;
        boss.setHealth(boss.getHealth() - coef * this.getDamage());
        System.out.println(this.getName() + " hits critically " + coef * this.getDamage());

    }
}
