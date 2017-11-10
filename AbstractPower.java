package bg.uni.sofia.fmi.mjt.dungeon.treasure;

public abstract class AbstractPower implements Treasure,Comparable<AbstractPower>{
	
	protected String name;
	protected int damage;
	
	public String getName(){
		return name;
	}
	
	public int getDamage(){
		return damage;
	}
	
	public int compareTo(AbstractPower o){
		if(this.getDamage() > o.getDamage()){
			return 1;
		}
		if(this.getDamage() < o.getDamage()){
			return -1;
		}
		return 0;
	}
}
