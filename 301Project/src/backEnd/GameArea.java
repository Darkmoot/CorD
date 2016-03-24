package backEnd;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class GameArea extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Enemy> enemies;
	public ArrayList<Player> players;
	private List Lesson;
	
	public GameArea() {
		enemies = new ArrayList<Enemy>();
		players = new ArrayList<Player>();
		Lesson = new ArrayList();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		//Add a bool for whether to draw
		//TODO add the paint for lessons
		
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
	public List getLesson() {
		return this.Lesson;
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
