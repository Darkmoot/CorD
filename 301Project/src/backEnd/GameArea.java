package backEnd;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class GameArea extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Enemy> enemies;
	public ArrayList<Player> players;
	
	public GameArea() {
		enemies = new ArrayList<Enemy>();
		players = new ArrayList<Player>();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
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

	public void addEnemy(Enemy enemy) {
		enemies.add(enemy);
	}

	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void removeEnemy(int index) {
		enemies.remove(index);
	}
}
