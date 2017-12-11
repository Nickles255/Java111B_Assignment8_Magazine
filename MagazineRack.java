//*******************************************************************
//  MagazineRack.java       Author: Lewis/Loftus
//
//  Driver to exercise the MagazineList collection.
//  modified CLIN, LZHENG, and QDLI on 2017-11-29
//  created do loop to prompt user addition to Rack 2017-11-29
//*******************************************************************
import java.util.Scanner;
import java.io.*;
public class MagazineRack
{   
    //----------------------------------------------------------------
    //  Creates a MagazineList object
    //  adds magazine based on user input.
    //----------------------------------------------------------------
    public static void main(String[] args)
    {    
        MagazineList rack = new MagazineList();
        Scanner scan = new Scanner(System.in);
        String newLine; //records the data that is read in the text file
        File file = new File("mags.dat");
        
        //Read file
        try{ 
            System.out.println("Here are your magazine titles:");
            Scanner read = new Scanner(file);
            for(int j=1; read.hasNextLine();j++){
                newLine = read.nextLine();
                System.out.println(j +":"+newLine);
                }
             read.close();
            }
        catch(IOException e){
            System.out.println("Sorry no magazine exist in that file");
        }
        
          //Write the file
      try { 
            char usersAnswer;
            String output;
	        boolean condition = true; 
	        FileWriter writeFile = new FileWriter(file, true);//create a file writer
            PrintWriter fileOutPut = new PrintWriter(fileInput);//Create a PrintWriter to write file
            
            //Create a loop to prompt and read titles from user input, using user input 
            //to create each Magazine (instead of hard-coded arguments) as long 
            //as the user wants to continue.
            while(condition){
                System.out.println("Enter a magazine title");
                output = type.nextLine();
                System.out.println("do you want to enter another title y/n");
                usersAnswer = type.nextLine().toUpperCase().charAt(0);
                fileOutPut.println(output);
                //Add titles to the Magazine list
                rack.add(new Magazine(output));
                //Prompts users if they want to enter another magazine title.
                    while((usersAnswer!='Y')&&(usersAnswer!='N')){
                        System.out.println("do you want to enter another title y/n");
                        usersAnswer = type.nextLine().toLowerCase().charAt(0);
                    }
                if(usersAnswer=='N'){
                    condition = false;
                    //close the writing file
                    fileOutPut.close();                   
                }
             }   
	    }
      catch(IOException e){
            System.out.println("file is opened in another program, cannot write into the file");
        }
      System.out.println("Current Magazine Titles: \n");
        System.out.println(rack);
    }
}
