package bg.uni.sofia.fmi.mjt.dungeon.actor;

import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Treasure;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public class Hero extends Character{

	private final int maxHealth;
	private final int maxMana;
	private Position position;
	
	public Hero(String name, int health, int mana, Position position){
		super(name,health,mana,null,null);
		this.maxHealth = health;
		this.maxMana = mana;
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	public void takeHealing(int healingPoints) {
		if(isAlive()){
			health+=healingPoints;
			if(health > maxHealth){
				health = maxHealth;
			}
		}
	}

	public void takeMana(int manaPoints) {
		mana+=manaPoints;
		if(mana > maxMana){
			mana = maxMana;
		}
	}

	public void equip(Weapon weapon) {
		if(weapon == null){
			return;
		}
		if(this.weapon == null || this.weapon.compareTo(weapon) < 0){
			this.weapon = weapon;
		}
	}

	public void learn(Spell spell) {
		if(spell == null){
			return;
		}
		if(this.spell == null || this.spell.compareTo(spell) < 0){
			this.spell = spell;
		}
	}

	public void setPosition(Position position) {
		this.position = position;
	}

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

	public String collectTreasure(Treasure treasure) {
		return treasure.collect(this);
	}
	
}
