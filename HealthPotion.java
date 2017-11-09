package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class HealthPotion implements Potion{

	private int healingPoints;
	
	public HealthPotion(int healingPoints){
		this.healingPoints = healingPoints;
	}
	
	@Override
	public String collect(Hero hero) {
		hero.takeHealing(heal());
		return "Health potion found! "
					+healingPoints
					+" health points added to your hero!";
	}

	@Override
	public int heal() {
		return healingPoints;
	}

}
