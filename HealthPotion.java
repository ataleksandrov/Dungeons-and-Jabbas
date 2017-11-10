package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class HealthPotion extends Potion{
	
	public HealthPotion(int healingPoints){
		super(healingPoints);
	}
	
	@Override
	public String collect(Hero hero) {
		hero.takeHealing(heal());
		return "Health potion found! "
					+points
					+" health points added to your hero!";
	}

}
