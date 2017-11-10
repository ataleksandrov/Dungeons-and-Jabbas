package bg.uni.sofia.fmi.mjt.dungeon.treasure;

public abstract class Potion implements Treasure{
	protected int points;
	
	public Potion(int points){
		this.points = points;
	}
	
	public int heal() {
		return points;
	}

}
