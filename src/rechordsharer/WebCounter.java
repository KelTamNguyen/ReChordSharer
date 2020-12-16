package rechordsharer;

import java.io.*;
import java.util.*;

import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;






 public class WebCounter {
	
	private int count=0;
	datamanager d = new datamanager();
	
	
        
    
        
        
        public int getCount() 
        {
            d.getdata();
            int num = Integer.parseInt( d.readdata());
            while(num != 0) 
            {
                num /=10;
                ++count;
            }
            d.closedata();
            return count;
        }

}


