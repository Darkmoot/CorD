package userInterface;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;

import backEnd.Enemy;
import backEnd.GameArea;
import backEnd.Question;

/**
 *
 * @author HisProdigalSon
 */
public class Window extends javax.swing.JFrame {

    /**
	 * Generated serial number
	 */
	private static final long serialVersionUID = -4902067103909394375L;
	
    // Variables declaration - do not modify                     
    private GameArea gArea;
    private JLabel scoreboard;
    private javax.swing.JScrollPane InputScroll;
    private javax.swing.JTextArea InputText;
    private javax.swing.JScrollPane QuestionScroll;
    private javax.swing.JTextArea QuestionText;
    
	private int currentLinePrompt;
	private int currentLine;
    private String lastInput;
    
    //the inputMatcher
    private inputMatcher IMatcher;
    
    Color GAMECOLOR = new Color(188, 216, 245);
    Color INPUTBACKGROUNDCOLOR = new Color(197,251,183);
    Color QUESTIONBACKGROUNDCOLOR = new Color(202, 193, 232);
    Color QUESTIONFONTCOLOR = new Color(88,0,176);
    Font font1 = new Font ("Verdana", 0 , 14);
    Font font2 = new Font ("Verdana", Font.BOLD , 14);
    // End of variables declaration    
	
	/**
     * Creates new form Window
     */
    public Window() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() { 
    	this.IMatcher = new inputMatcher("none", new ArrayList<Question>());
    	this.currentLine = 0;
    	
    	this.setTitle("Programming Game");
        InputScroll = new javax.swing.JScrollPane();
        InputText = new javax.swing.JTextArea(">>> ");
        gArea = new GameArea();
        QuestionScroll = new javax.swing.JScrollPane();
        QuestionText = new javax.swing.JTextArea();
       
        // initial score 0
        scoreboard = new JLabel("Score: 0");
        scoreboard.setSize(100,25);
        scoreboard.setFont(font2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       
        
        InputText.setEditable(true);
        InputText.setColumns(20);
        InputText.setRows(5);
        InputScroll.requestFocus();
        
        InputText.setBackground(INPUTBACKGROUNDCOLOR);
        InputText.setFont(font1);
       
        
        InputText.setCaretPosition(4); //set up the caret postion
        currentLinePrompt = InputText.getCaretPosition();
        //System.out.println(InputText.getCaretPosition());
        
    //    QuestionText.append("Press Enter to Start Level\n");
        InputText.addKeyListener(new KeyListener() {
        	
        	@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				
				
					
				
				
					if (keyCode == KeyEvent.VK_ENTER) {
						/*if (gArea.isLessonActive()) {
						//	InputText.append("\nStart Game\n>>> ");
						//	currentLine+= 2;
							gArea.toggleLesson();
						}
						else {
						*/
					e.consume(); //consume the regular action of enter
					lastInput = InputText.getText().split("\n")[currentLine].substring(4);


					String resultFromMatching = IMatcher.matchAnswer(lastInput);
					if (InputText.getCaretPosition() == currentLinePrompt) {
						InputText.append("\n>>> ");
						currentLine++;
					}
				
					
				    
					
					else if (resultFromMatching == "correct") {
					//	System.out.println(result);
						InputText.append("\nCorrect Answer\n>>> ");
						currentLine+= 2;
						
						// update score with correct answer 
						scoreboard.setText("Score: " + IMatcher.getScore());
					} 
					
					else if (resultFromMatching == "correct") {
						//	System.out.println(result);
							InputText.append("\nAlready Answered\n>>> ");
							currentLine+= 2;
							
						} 
				
					else if (resultFromMatching == "incorrect") {
						InputText.append("\nIncorrect Answer\n>>> ");
					//	System.out.println(result);
						currentLine+= 2;
					} 
					else {
						InputText.append("\n" + resultFromMatching + "\n>>>");
						currentLine+= 2;
					}
				
					currentLinePrompt = InputText.getCaretPosition();
					
					}
        
				//}
				
				if (keyCode == KeyEvent.VK_BACK_SPACE) {
					System.out.println("I pressed the delete button");
					//If the current caret is equal to the current line prompt:
					//it means we are at the beginning of undeleteable section of the shell
					if (InputText.getCaretPosition() == currentLinePrompt) {
						System.out.println("CANNNOT DELETE");
						e.consume(); //consume delete aka dont delete text
					}
				}
				
				if (keyCode == KeyEvent.VK_A) {
					System.out.println(InputText.getCaretPosition());
				}
        	}
        	
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			
        	
        });
        
      
        InputScroll.setViewportView(InputText);

        javax.swing.GroupLayout GameAreaLayout = new javax.swing.GroupLayout(gArea);
        gArea.setBackground(GAMECOLOR);
        gArea.setBorder(BorderFactory.createLineBorder(Color.black));
        gArea.setLayout(GameAreaLayout);
        GameAreaLayout.setHorizontalGroup(
            GameAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );
        
        GameAreaLayout.setVerticalGroup(
            GameAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        //Testing adding enemy and painting it on to the screen
		
        gArea.addEnemy(new Enemy(10, 10));
		gArea.repaint();	
		
		
		
		// add scoreboard to game panel
		gArea.add(scoreboard);
		scoreboard.setLocation(430, 10);


        QuestionText.setColumns(20);
        QuestionText.setRows(5);
        QuestionText.setLineWrap(true);
        QuestionText.setWrapStyleWord(false);
        QuestionText.setEditable(false);
        
        
        
        QuestionText.setBackground(QUESTIONBACKGROUNDCOLOR);
        QuestionText.setForeground(QUESTIONFONTCOLOR);
        QuestionText.setFont(font1);

        
        QuestionScroll.setViewportView(QuestionText);
        
  
        
        QuestionText.setLineWrap(true);
        QuestionText.setWrapStyleWord(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(QuestionScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(gArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(InputScroll))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(QuestionScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(InputScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        //InputText.requestFocus();
        
        this.addWindowFocusListener(new WindowAdapter() {
            public void windowGainedFocus(WindowEvent e) {
                InputText.requestFocusInWindow();
            }
        });
        setVisible(true);
        getContentPane().setBackground(Color.BLACK);
        pack();
    }    
    
    //Getter methods for different parts of the screen
    public GameArea getGameArea() {
    	return this.gArea;
    }
    
    public javax.swing.JTextArea getInputText() {
    	return this.InputText;
    	
    }
    
    public javax.swing.JTextArea getQuestionText() {
    	return this.QuestionText;
    	
    }
    
   
    public String getLastInput() {
    	return this.lastInput;
    }

    public int getCurrentLine() {
    	return this.currentLine;
    }
    
   // currentLinePrompt = InputText.getCaretPosition();
    //added this setter to properly go to the next line
    public void setCurrentLinePrompt() {
    	this.currentLinePrompt = InputText.getCaretPosition();;
    }
    
    public inputMatcher getInputMatcher() {
    	return this.IMatcher;
    }
    
    

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
       
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }
    */

               
}

