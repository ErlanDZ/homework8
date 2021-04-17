package kg.geektech.game.player;

import kg.geektech.general.RPG_Game;

public class Magic extends Hero {
    public Magic(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int mag = RPG_Game.random.nextInt(5);
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setDamage(heroes[i].getDamage() + mag);

        }
        System.out.println(this.getName() + " УВЕЛИЧЕЛ УРОН ГЕРОЕВ НА " + mag);




    }
}
