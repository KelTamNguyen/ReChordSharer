package rechordsharer;

import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

 class datamanager {


	
private Scanner x;
	
	public void getdata() {
		
		try {
			x = new Scanner(new File("C:\\Users\\tampe\\Desktop\\account.txt"));//Whatever we need to read from a file we can put here.
			
		}
		catch(Exception e) {
			System.out.println("ERROR! NO FILE FOUND!"); //If no file is found it shows this.
		}
	}
	
	
	public String  readdata() {//this is where the file is read all context below it can be used to 
		                 //fit whatever component is needed.
		String line = null;
		while(x.hasNextLine())
		{
			
		   
		
		  line =x.nextLine();
		   
		}
		
		return line;

		
		
	}
	
	public  void writedata() {
        try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("Hello World");
            writer.write("\r\n");   // write new line
            writer.write("Good Bye!");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
	
	
	
	
	
	
	
	public void closedata() {//closes the file
		x.close();
	}
	
	
	
	
	

}
