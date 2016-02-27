package userInterface;

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
    private javax.swing.JPanel GameArea;
    private javax.swing.JScrollPane InputScroll;
    private javax.swing.JTextArea InputText;
    private javax.swing.JScrollPane QuestionScroll;
    private javax.swing.JTextArea QuestionText;
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
        InputText = new javax.swing.JTextArea();
        GameArea = new javax.swing.JPanel();
        QuestionScroll = new javax.swing.JScrollPane();
        QuestionText = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        InputText.setColumns(20);
        InputText.setRows(5);
        InputScroll.setViewportView(InputText);

        javax.swing.GroupLayout GameAreaLayout = new javax.swing.GroupLayout(GameArea);
        GameArea.setBackground(java.awt.Color.WHITE);
        GameArea.setLayout(GameAreaLayout);
        GameAreaLayout.setHorizontalGroup(
            GameAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );
        
        GameAreaLayout.setVerticalGroup(
            GameAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

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
                        .addComponent(GameArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(InputScroll))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(GameArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(QuestionScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(InputScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }                     

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }

               
}