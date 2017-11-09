package bg.uni.sofia.fmi.mjt.dungeon;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Enemy;
import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;
import bg.uni.sofia.fmi.mjt.dungeon.actor.Position;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Treasure;

public class GameEngine {

	private char[][] map;
	private Hero hero;
	private Enemy[] enemies;
	private Treasure[] treasures;
	private boolean[] enemiesUsed;
	private boolean[] treasuresUsed;
	
	public GameEngine(char[][] map, Hero hero, Enemy[] enemies, Treasure[] treasures){
		this.map = map;
		this.hero = hero;
		this.enemies = enemies;
		this.treasures =  treasures;
		this.enemiesUsed =  new boolean[enemies.length];
		this.treasuresUsed = new boolean[treasures.length];
	}
	
	private char getCharAtPosition(Position position){
		return map[position.getY()][position.getX()];
	}
	
	public char[][] getMap(){
		return map;
	}
	
	public String makeMove(int command){
		String message="";
		Position current = new Position(hero.getPosition().getX(),hero.getPosition().getY());
		switch (command) {
		case 0:
			current.moveLeft();
			break;
		case 1:
			current.moveUp();
			break;
		case 2:
			current.moveRight();
			break;
		case 3:
			current.moveDown();
			break;
		default:
			message = "Unknown command entered.";
			return message;
		}
		switch (getCharAtPosition(current)) {
		case '.':
			message = "You moved successfully to the next position.";
			setCharAtPosition(hero.getPosition(),'.');
			setCharAtPosition(current, 'H');
			hero.setPosition(current);
			break;
		
		case'#':
			message ="Wrong move. There is an obstacle and you cannot bypass it.";
			break;
			
		case 'T':
			for(int i = 0;i < treasuresUsed.length;i++){
				if(!treasuresUsed[i]){
					message = treasures[i].collect(hero);
					treasuresUsed[i] = true;
					break;
				}
			}
			setCharAtPosition(hero.getPosition(),'.');
			setCharAtPosition(current, 'H');
			hero.setPosition(current);
			break;
			
		case'E':
			for(int i=0;i<enemiesUsed.length;i++){
				if(!enemiesUsed[i]){
					message = hero.combatMessage(enemies[i]);
					enemiesUsed[i] = true;	
					break;
				}
			}
			if(hero.isAlive()){
				setCharAtPosition(hero.getPosition(),'.');
				setCharAtPosition(current, 'H');
				hero.setPosition(current);
			}
			break;
			
		case'G':
			message = "You have successfully passed through the dungeon. Congrats!";
			break;
		}
		return message;
	}
	
	public void setCharAtPosition(Position position,char c){
		map[position.getY()][position.getX()] = c;
	}
	
}
