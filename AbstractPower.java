package bg.uni.sofia.fmi.mjt.dungeon.treasure;

public abstract class AbstractPower implements Treasure,Comparable<AbstractPower>{
	
	public abstract String getName();
	public abstract int getDamage();
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
