package backEnd;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class GameArea extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Enemy> enemies;
	
	public GameArea() {
		enemies = new ArrayList<Enemy>();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Enemy enemy : enemies) {
			//Add two more parameters after getYval to set image dimensions
			g.drawImage(enemy.getImage(), enemy.getXval(), enemy.getYval(), null);
		}
	}

	public List<Enemy> getEnemies() {
		return enemies;
	}

	public void addEnemy(Enemy enemy) {
		enemies.add(enemy);
	}
	
	public void removeEnemy(Enemy enemy) {
		enemies.remove(enemy);
	}
}
