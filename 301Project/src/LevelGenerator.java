import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import userInterface.*;
import backEnd.*;

public class LevelGenerator {
	
	// code moved to Level
	// use this to generate the levels
	private int curLevel;
	private Window window;
	private QuestionFactory qf;
	
	public LevelGenerator(Window w, QuestionFactory qf) {
		
		this.curLevel = 0;
		this.qf = qf;
		this.window = w;
		
	}
	
	public Level createLevel() {
		
		this.curLevel++;
		Level level = new Level(this.window.getQuestionText(), this.window.getInputMatcher(), this.window.getGameArea(),  this.qf, new Lesson(0 , 0), this.window.getPlayerHealth());
		
		
		return level;
	}
		
	
}
