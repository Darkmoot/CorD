package userInterface;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.text.BadLocationException;

import backEnd.Enemy;
import backEnd.GameArea;

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
    private javax.swing.JScrollPane InputScroll;
    private javax.swing.JTextArea InputText;
    private javax.swing.JScrollPane QuestionScroll;
    private javax.swing.JTextArea QuestionText;
    
	private int currentLinePrompt;
	private int currentLine;
    private String lastInput;
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
    	
    	this.setTitle("Programming Game");
        InputScroll = new javax.swing.JScrollPane();
        InputText = new javax.swing.JTextArea(">>> ");
        gArea = new GameArea();
        QuestionScroll = new javax.swing.JScrollPane();
        QuestionText = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       
        
        InputText.setEditable(true);
        InputText.setColumns(20);
        InputText.setRows(5);
        InputScroll.requestFocus();
        
        InputText.setCaretPosition(4); //set up the caret postion
        currentLinePrompt = InputText.getCaretPosition();
        //System.out.println(InputText.getCaretPosition());
        InputText.addKeyListener(new KeyListener() {
        	
        	@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				
				if (keyCode == KeyEvent.VK_ENTER) {
					//System.out.println("I pressed the Enter button");
					InputText.append("\n>>> ");
					e.consume(); //consume the regular action of enter
					//Set up the line propt count to the current since enter resets to begginning of line
					currentLinePrompt = InputText.getCaretPosition();
					
					 //System.out.println(InputText.getCaretPosition());
					
					try {
						currentLine = InputText.getLineOfOffset(InputText.getCaretPosition()); // translates to line number
						//System.out.println(currentline); //split by the >>> and then idex into by current line
						//will not take alot of time complecity
						lastInput = InputText.getText().split(">>>")[currentLine];
						System.out.println(lastInput);
						//update the last input variable
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				if (keyCode == KeyEvent.VK_BACK_SPACE) {
					System.out.println("I pressed the delete button");
					//If the current caret is equal to the current line prompt:
					//it means we are at the beginning of undeleteable section of the shell
					if (InputText.getCaretPosition() == currentLinePrompt) {
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
        gArea.setBackground(java.awt.Color.WHITE);
        gArea.setLayout(GameAreaLayout);
        GameAreaLayout.setHorizontalGroup(
            GameAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );
        
        GameAreaLayout.setVerticalGroup(
            GameAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        
		gArea.addEnemy(new Enemy(10, 10));
		gArea.repaint();		

        QuestionText.setColumns(20);
        QuestionText.setRows(5);
        QuestionText.setLineWrap(true);
        QuestionText.setWrapStyleWord(false);
        QuestionText.setEditable(false);
        QuestionScroll.setViewportView(QuestionText);

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
