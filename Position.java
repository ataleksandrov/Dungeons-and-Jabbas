package bg.uni.sofia.fmi.mjt.dungeon.actor;

public class Position {

	private int x;
	private int y;
	
	public Position(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void moveLeft(){
		x--;
	}
	
	public void moveRight(){
		x++;
	}
	
	public void moveUp(){
		y--;
	}
	
	public void moveDown(){
		y++;
	}
}
