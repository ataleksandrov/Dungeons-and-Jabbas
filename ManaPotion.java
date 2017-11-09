package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class ManaPotion implements Potion{

	private int manaPoints;
	
	public ManaPotion(int manaPoints){
		this.manaPoints = manaPoints;
	}
	
	@Override
	public String collect(Hero hero) {
		hero.takeMana(heal());
		return "Mana potion found! "
					+manaPoints
					+" mana points added to your hero!";
	}

	@Override
	public int heal() {
		return manaPoints;
	}

}
