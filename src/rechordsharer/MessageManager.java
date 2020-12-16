package rechordsharer;

import javax.swing.JOptionPane;
import twitter4j.*;
import twitter4j.conf.*;


public class MessageManager 
{
    public void updateStatus(String textContent)
    {
        try{
            ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
            .setOAuthConsumerKey("EW0SMZPu4FLbJNCq4BtZ4EcsO")
            .setOAuthConsumerSecret("MAedYBD2V0gIKyOx3bQiGEzJfXoYp9v83R6HfqR6DQT5rmq5z9")
            .setOAuthAccessToken("946049965301862404-l7cJhUWMrR004TPcPkLf5eH4Mn8ttfp")
            .setOAuthAccessTokenSecret("IHfFUYDNDYEMDfyEN5LZ9ZaU5JxANzWDZnSmPWwqTJgAA");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        Status status = twitter.updateStatus(textContent);
        JOptionPane.showMessageDialog(null,"Successfully updated the status to [" + status.getText() + "].");
        }
        catch (TwitterException te)
        {
            //te.printStackTrace();
            JOptionPane.showMessageDialog(null,"Failed to update status: " + te.getMessage() + "\nTwitter may be down");
        }
    }
        
    public void sendDirectMessage(String targetID, String textContent)
    {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
            .setOAuthConsumerKey("EW0SMZPu4FLbJNCq4BtZ4EcsO")
            .setOAuthConsumerSecret("MAedYBD2V0gIKyOx3bQiGEzJfXoYp9v83R6HfqR6DQT5rmq5z9")
            .setOAuthAccessToken("946049965301862404-l7cJhUWMrR004TPcPkLf5eH4Mn8ttfp")
            .setOAuthAccessTokenSecret("IHfFUYDNDYEMDfyEN5LZ9ZaU5JxANzWDZnSmPWwqTJgAA");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        
        try{
            twitter.sendDirectMessage(targetID, textContent);
            JOptionPane.showMessageDialog(null,"Message Sent!");
        }
        catch (TwitterException te){
            //te.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERROR!\n Failed to send a direct message. Make sure the reipient follows your Twitter account.");
        }
    }
    
    public void postCount(String playlistName)
    {
        WebCounter w = new WebCounter();
        int count = w.getCount();
        updateStatus("\"" + playlistName  + "\"" + " has " + count + " listeners!");
    }
}
