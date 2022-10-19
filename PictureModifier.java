import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

public class PictureModifier extends JPanel implements ItemListener {
    //attributs
    //checkboxes
    JCheckBox glassesButton;
    JCheckBox hairButton;
    JCheckBox teethButton;
    JCheckBox chinButton;

    //holds the choices for the picture
    StringBuffer choices;

    //lable for the picture
    JLabel pictureLabel;

    //constructor for the modifier
    public PictureModifier() {
        //call the super class
        super(new BorderLayout());

        //creat the check boxes
        chinButton = new JCheckBox("Chin");
        chinButton.setMnemonic(KeyEvent.VK_C);
        chinButton.setSelected(true);

        glassesButton = new JCheckBox("Glasses");
        glassesButton.setMnemonic(KeyEvent.VK_C);
        glassesButton.setSelected(true);

        hairButton = new JCheckBox("hair");
        hairButton.setMnemonic(KeyEvent.VK_C);
        hairButton.setSelected(true);

        teethButton = new JCheckBox("teeth");
        teethButton.setMnemonic(KeyEvent.VK_C);
        teethButton.setSelected(true);

        //regestier a listener for the check boxes
        chinButton.addItemListener(this);
        glassesButton.addItemListener(this);
        hairButton.addItemListener(this);
        teethButton.addItemListener(this);

        //set the value of the choices to discribe the accesories on the geek
        choices = new StringBuffer("cght");

        //set up th e pic label
        pictureLabel = new JLabel();
        pictureLabel.setFont(pictureLabel.getFont().deriveFont(Font.ITALIC));
        updatePicture();

        //put the check voxes in the coulum in a panel
        JPanel checkPanel = new JPanel(new GridLayout(0, 1));
        checkPanel.add(chinButton);
        checkPanel.add(glassesButton);
        checkPanel.add(hairButton);
        checkPanel.add(teethButton);

        //add the cjeckboxes ns the pictures label tp the panle and
        //then set the border on the frame
        add(checkPanel, BorderLayout.LINE_START);
        add(pictureLabel, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }//end constructor

    //listen to the checkBoxes
    public void itemStateChange(ItemEvent e){

        //the combination of the index and the character determination
        //the name of the file that's needed tp display the correct
        //accesories for the geek
        int index = 0;
        char c = '_';
        Object source = e.getItemSelectable();

        //check to see which checkbox the user clicked
        //and set the correctsponding values for the images name
        if(source == chinButton){
            index = 0;
            c = 'c';

        }else if (source == glassesButton){
            index = 1;
            c ='g';

        } else if (source == hairButton) {
            index = 2;
            c = 'h';

        }else if (source == teethButton){
            index = 3;
            c = 't';
        }//end if

        //Now that we know which button was pushed, find out
        //whether it was selected or deselected.
        if (e.getStateChange() == ItemEvent.DESELECTED) {
            c = '-';
        } //end ig

        //Apply the change to the string.
        choices.setCharAt(index, c);

        //Call the method to swap out the picture
        updatePicture();
    } //end method

    //Method to change the picture
    protected void updatePicture() {
        //Get the icon corresponding to the image.
        Icon icon = new ImageIcon(
                "images/geek-"
                        + choices.toString()
                        + ".gif");

        //Set the icon for the picture and the tool tiptext for the choices
        pictureLabel.setIcon(icon);
        pictureLabel.setToolTipText(choices.toString());
        if (icon == null) {
            pictureLabel.setText("Missing Image");
        } else {
            pictureLabel.setText(null);
        }//end if
    }//end method

    //Create the GUI and show it.
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Geek Picture Modifier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new PictureModifier();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }//end method

    //Main method
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }//end run method
        });//end method
    }//end main method

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}


