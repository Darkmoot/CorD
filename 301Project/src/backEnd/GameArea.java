package backEnd;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class GameArea extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Enemy> enemies;
	public ArrayList<Player> players;
	
	//the list of our current lesson, could be changed to a single lesson maybe?
	private Lesson currentLesson;
	private boolean showLesson;
	
	public GameArea() {
		enemies = new ArrayList<Enemy>();
		players = new ArrayList<Player>();
		currentLesson = new Lesson(0,0);
		showLesson = true; //set to true initially
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		
		/*
		//Add a bool for whether to draw
		//TODO add the paint for lessons
		
		if (showLesson) {
			g.drawImage(currentLesson.getImage(), currentLesson.getXCoor(),
					currentLesson.getYCoor(),530,480,null);
			
		}//only render the lesson if we have it set to true
		else {
		*/
	
			
			for (Player player : players) {
				//Add two more parameters after getYval to set image dimensions
				g.drawImage(player.getImage(), player.getXval(), player.getYval(), 40, 52, null);
			}
			
			
			for (Enemy enemy : enemies) {
				//Add two more parameters after getYval to set image dimensions
				g.drawImage(enemy.getImage(), enemy.getXval(), enemy.getYval(), 30, 46, null);
			}
		}


	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	//returns the list for the current lessons
	public Lesson getLesson() {
		return this.currentLesson;
	}
	//toggle Lesson
	public void toggleLesson() {
		this.showLesson = !this.showLesson;
		//switch back and forth between shoing the lesson or not
	}
	
	public boolean isLessonActive() {
		return this.showLesson;
	}
	

	public void addEnemy(Enemy enemy) {
		enemies.add(enemy);
	}

	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void removeEnemy(Enemy enemy) {
		enemies.remove(enemy);
	}
}
