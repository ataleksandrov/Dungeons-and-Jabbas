package bg.uni.sofia.fmi.mjt.dungeon.actor;

import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public interface Character extends Actor{
	public Position getPosition();
	public void setPosition(Position position);
	public void takeHealing(int healingPoints);
	public void takeMana(int manaPoints);
	public void equip(Weapon weapon);
	public void learn(Spell spell);
}
