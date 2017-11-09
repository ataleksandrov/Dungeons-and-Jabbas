package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class Weapon extends AbstractPower{

	private String name;
	private int damage;
	
	public Weapon(String name, int damage){
		this.name = name;
		this.damage = damage;
	}
	
	public Weapon(){
		
	}
	
	@Override
	public String collect(Hero hero) {
		hero.equip(this);
		return "Weapon found! Damage points: "+ damage;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getDamage() {
		return damage;
	}
}
