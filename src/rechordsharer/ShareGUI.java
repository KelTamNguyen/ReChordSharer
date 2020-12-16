package rechordsharer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author tampe
 */
public class ShareGUI extends JFrame
{
    private static JTextArea messageContent, messageContent2;
    private static JTextField username;
    private static JButton postBtn, msgBtn;
    private static boolean isValidMSG, isValidTarget;
    
    public void createAndShowGUI() {
 
        // Create and set up the window.
        final JFrame frame = new JFrame("Share with Twitter");
 
        // Display the window.
        frame.setSize(350, 350);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
 
        // set grid layout for the frame
        frame.getContentPane().setLayout(new GridLayout(1, 1));
 
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
        String opt1 = "Post a public Tweet on ReChord's Twitter";
        String opt2 = "Send a Twitter DM to someone";
 
        tabbedPane.addTab("Post Tweet", null, make_p1(), opt1);
        tabbedPane.addTab("Send DM", null, make_p2(), opt2);
 
        frame.getContentPane().add(tabbedPane);
 
    }
 
    private static JPanel make_p1() {
        JPanel p = new JPanel();
        p.add(new Label("Write a Tweet (maximum 280 characters):"));
        
        messageContent = new JTextArea(10,15);
        p.add(messageContent);
        
        postBtn = new JButton("Tweet");
        postBtn.addActionListener(new PostButtonListener());
        p.add(postBtn);
        
        p.setLayout(new FlowLayout(FlowLayout.LEFT));
        return p;
    }
    
    private static JPanel make_p2() {
        JPanel p = new JPanel();
        p.add(new JLabel("recipient's username (do not include @)"));
        username = new JTextField(15);
        p.add(username);
        p.add(new Label("Write a Tweet (maximum 280 characters):"));
        
        messageContent2 = new JTextArea(10,15);
        p.add(messageContent2);
        
        msgBtn = new JButton("Send");
        msgBtn.addActionListener(new MsgButtonListener());
        p.add(msgBtn);
        
        p.setLayout(new FlowLayout(FlowLayout.LEFT));
        return p;
    }
    
    public static boolean checkMsg(String message)
    {
        isValidMSG = true;
        
        if (message.isEmpty())
        {
            isValidMSG = false;
            JOptionPane.showMessageDialog(null,"ERROR!\n Please enter a message.");
        }
        else if (message.length() > 240)
        {
            isValidMSG = false;
            JOptionPane.showMessageDialog(null,"ERROR!\n Message exceeds Twitter's character limit.");
        }
        return isValidMSG;
    }
    
    public static boolean checkTarget(String target)
    {
        isValidTarget = true;
        
        if (target.isEmpty())
        {
            isValidTarget = false;
            JOptionPane.showMessageDialog(null,"ERROR!\n Please enter a Twitter handle.");
        }
        if (target.contains("@"))
        {
            isValidTarget = false;
            JOptionPane.showMessageDialog(null,"ERROR!\n Please do not include @ in Twitter handle");
        }
        
        return isValidTarget;
    }
    
    private static class PostButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String message = messageContent.getText();
            checkMsg(message);
            if (isValidMSG == true)
            {
                //Test usernames:
                //Kelvin's surf account (follower account): 
                //KelvinN14259373
                //Caleb's Twitter (does not follow the sender Kelvin):
                //caleb_walls4
                MessageManager m = new MessageManager();
                m.updateStatus(message);
            }
        }
    }
    
    private static class MsgButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String target = username.getText();
            String dmessage = messageContent2.getText();
            checkTarget(target);
            checkMsg(dmessage);
            
            if (isValidTarget == true && isValidMSG == true)
            {
                MessageManager m = new MessageManager();
                m.sendDirectMessage(target, dmessage);
            }
        }
    }
    
}
