package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class Spell extends AbstractPower{

	private String name;
	private int damage;
	private int manaCost;
	
	public Spell(String name, int damage, int manaCost){
		this.name = name;
		this.damage = damage;
		this.manaCost = manaCost;
	}
	
	public Spell(){
		
	}
	
	@Override
	public String collect(Hero hero) {
		hero.learn(this);
		return "Spell found! Damage points: "
					+damage
					+", Mana cost: "
					+manaCost;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getDamage() {
		return damage;
	}

	public int getManaCost(){
		return manaCost;
	}
}
