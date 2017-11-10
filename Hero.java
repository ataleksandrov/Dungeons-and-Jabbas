package bg.uni.sofia.fmi.mjt.dungeon.actor;

import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Treasure;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public class Hero implements Character{

	private String name;
	private int health;
	private final int maxHealth;
	private int mana;
	private final int maxMana;
	private Position position;
	private Weapon weapon;
	private Spell spell;
	
	
	public Hero(String name, int health, int mana, Position position){
		this.name =  name;
		this.health = health;
		this.maxHealth = health;
		this.mana =  mana;
		this.maxMana = mana;
		this.position = position;
		this.weapon = null;
		this.spell = null;
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
		health-=damagePoints;
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

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void takeHealing(int healingPoints) {
		if(isAlive()){
			health+=healingPoints;
			if(health > maxHealth){
				health = maxHealth;
			}
		}
	}

	@Override
	public void takeMana(int manaPoints) {
		mana+=manaPoints;
		if(mana > maxMana){
			mana = maxMana;
		}
	}

	@Override
	public void equip(Weapon weapon) {
		if(weapon == null){
			return;
		}
		if(this.weapon == null || this.weapon.compareTo(weapon) < 0){
			this.weapon = weapon;
		}
	}

	@Override
	public void learn(Spell spell) {
		if(spell == null){
			return;
		}
		if(this.spell == null || this.spell.compareTo(spell) < 0){
			this.spell = spell;
		}
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String fightEnemyMessage(Enemy enemy){
		String message;
		int turn =1;
		while(this.isAlive() && enemy.isAlive()){
			if(turn%2 == 1){
				enemy.takeDamage(this.attack());
			}
			else{
				this.takeDamage(enemy.attack());
			}
			turn++;
		}
		if(this.isAlive()){
			message = "Enemy died.";
		}
		else{
			message = "Hero is dead! Game over!";
		}
		return message;
	}

	@Override
	public String collectTreasure(Treasure treasure) {
		return treasure.collect(this);
	}
	
}
