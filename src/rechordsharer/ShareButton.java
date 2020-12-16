package rechordsharer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ShareButton extends JFrame
{
    private JButton shareButton;
    private JPanel panel;
    
    public ShareButton()
    {
        setTitle("ReChord (Imagine this is a normal instance of the application)");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        add(panel);
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setLocationRelativeTo(null);
        
        setVisible(true);
    }
    
    private void buildPanel()
    {
        shareButton = new JButton("Share");
        shareButton.addActionListener(new ShareButtonListener());
        
        panel = new JPanel();
        panel.add(shareButton);   
    }
    
    private class ShareButtonListener  implements ActionListener
    {	
	public void actionPerformed(ActionEvent e) 
        {
            ShareGUI sharer = new ShareGUI();
            sharer.createAndShowGUI();
	}		
    }
}

