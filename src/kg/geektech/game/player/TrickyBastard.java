package kg.geektech.game.player;

import kg.geektech.general.RPG_Game;

public class TrickyBastard extends Hero {
    public TrickyBastard(int health, int damage, String name) {
        super(health, damage, SuperAbility.PRETEND_DEAD, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        boolean bast = RPG_Game.random.nextBoolean();
        if (bast){
           this.setHealth(this.getHealth()+boss.getDamage());
            System.out.println(this.getName() + " притворился мертвым ");
            if (this.getHealth() > 250){

            }
            else {
                this.setHealth(this.getHealth());
            }
        }
        else {
            System.out.println(this.getName() + "  в игре ");
        }


    }
}
