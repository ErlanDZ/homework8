package kg.geektech.game.player;

import kg.geektech.general.RPG_Game;

public class Thor extends Hero{
    public Thor(int health, int damage, String name) {
        super(health, damage, SuperAbility.STUN, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        boolean tor= RPG_Game.random.nextBoolean();
        if (tor){
            boss.setDamage(0);
            System.out.println(this.getName() + " оглушил БОССА");
        }else {
            boss.setDamage(50);
            System.out.println(this.getName() + " НЕ оглушил БОССА");

        }
    }
}
