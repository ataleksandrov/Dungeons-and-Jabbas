package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class ManaPotion extends Potion{
	
	public ManaPotion(int manaPoints){
		super(manaPoints);
	}
	
	@Override
	public String collect(Hero hero) {
		hero.takeMana(heal());
		return "Mana potion found! "
					+points
					+" mana points added to your hero!";
	}

}
