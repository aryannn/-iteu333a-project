/* Project by:
 * Hanan Abubacar
 * Arianne Cera
 * Cyril Ricafort
 * Aleeza Viray
 */
package iteu333a.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Import here...
public class Iteu333aProject {

    //Global variable here...
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException{
     
        //Main codes here...
        int error = 0;
        
        try{Scanner scan = new Scanner(new FileReader("C:\\Users\\hp1\\Documents\\NetBeansProjects\\-iteu333a-project\\Testfinalproject\\src\\testfinalproject\\cs.txt"));
        PrintWriter writer = new PrintWriter("Test.java", "UTF-8");
            while (scan.hasNext()){
                String str = scan.nextLine();
                //print file
                System.out.println(str);
                //check if contains datatype
                if(str.endsWith(";"))
                {
                    //check for integer datatype
                    if((!str.contains("int")) && (!str.contains("float")) && (!str.contains("double")) && (!str.contains("string")) && (!str.contains("char")))  
                    {
                        error++;
                        System.out.println(error+".Syntax Error, no datatype detected");
                    }               
                    else
                    {
                        System.out.println("datatype detected");
                    }
                    checkIntegerdatatype(str);
                    
                }
                // check for comment
                else if((str.contains("//")))
                {
                    System.out.println("comment detected");
                }
                writer.println(str);
                System.out.println();
            }
            writer.close();
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
public static String checkIntegerdatatype( String str) 
{
  Pattern feedback = Pattern.compile("[0-9]{1,8}");
                        Matcher match = feedback.matcher(str);
                        if (match.find())
                        {
                            System.out.println("correct datatype");
                        }
                        else
                        {
                            System.out.println("wrong datatype");
                        }
    return str;
}

public static String checkStringdatatype( String str) 
{
  Pattern feedback = Pattern.compile("[0-9]{1,8}");
                        Matcher match = feedback.matcher(str);
                        if (match.find())
                        {
                            System.out.println("correct datatype");
                        }
                        else
                        {
                            System.out.println("wrong datatype");
                        }
    return str;
}

}



