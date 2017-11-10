package bg.uni.sofia.fmi.mjt.dungeon.actor;

import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public class Enemy implements Actor{

	private String name;
	private int health;
	private int mana;
	private Weapon weapon;
	private Spell spell;
	
	public Enemy(String name, int health, int mana, Weapon weapon, Spell spell){
		this.name = name;
		this.health = health;
		this.mana = mana;
		this.weapon = weapon;
		this.spell = spell;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public int getMana() {
		return mana;
	}

	@Override
	public boolean isAlive() {
		return health > 0;
	}

	@Override
	public Weapon getWeapon() {
		return weapon;
	}

	@Override
	public Spell getSpell() {
		return spell;
	}

	@Override
	public void takeDamage(int damagePoints) {
		health-= damagePoints;
		if(health < 0){
			health = 0;
		}
	}

	@Override
	public int attack() {
		if(weapon == null){
			if(spell != null && spell.getManaCost() <= mana){
				mana-=spell.getManaCost();
				return spell.getDamage();
			}
			return 0;
		}
		if(spell == null || spell.getManaCost() > mana){
			return weapon.getDamage();
		}
		if(weapon.compareTo(spell) > 0){
			return weapon.getDamage();
		}
		mana-=spell.getManaCost();
		return spell.getDamage();
	}
	
}
