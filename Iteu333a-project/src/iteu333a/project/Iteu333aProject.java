/* Project by:
 * Hanan Abubacar
 * Arianne Cera
 * Cyril Ricafort
 * Aleeza Viray
 */
package iteu333a.project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Import here...
public class Iteu333aProject {

    //Global variable here...
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        
        //Main codes here...
        int error = 0;
        
        try{Scanner scan = new Scanner(new FileReader("C:\\Users\\hp1\\Documents\\NetBeansProjects\\-iteu333a-projectupdated\\Iteu333a-project\\src\\iteu333a\\project\\cs.txt"));
        PrintWriter writer = new PrintWriter("Test.java", "UTF-8");
            while (scan.hasNext()){
                String str = scan.nextLine();
                //print file
                System.out.println(str);
                // check for comment
                if((str.contains("//")))
                {
                    System.out.println("comment detected");
                }
                //check if semicolon is present
                else
                {
                    if(str.endsWith(";"))
                    {
                        //check if datatype is present
                        if((!str.contains("int")) && (!str.contains("float")) && (!str.contains("double")) && (!str.contains("String")) && (!str.contains("char")))  
                        {
                            error++;
                            System.out.println(error+".Syntax Error, no datatype detected");

                        }               
                        else
                        {
                            System.out.println("datatype detected");
                        }
                        checkIntegerdatatype(str);
                        checkStringdatatype(str);
                        checkdoubledatatype(str);
                    }
                    else
                    {
                        System.out.println("No semicolon detected.");
                    }
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
  Pattern feedback1 = Pattern.compile("[0-9]{1,8}");
  Pattern feedback2 = Pattern.compile("[a-zA-Z]");
                        Matcher match1 = feedback1.matcher(str);
                        Matcher match2 = feedback2.matcher(str);
                    for(int i=0; i<str.length();i++)
                    {
                        if(str.charAt(i)=='i' && str.charAt(i+1)=='n' && str.charAt(i+2)=='t' )
                        {
                                if(!str.contains("="))
                                {
                                    continue;
                                }
                                else
                                {
                                    if (!str.contains("\""))
                                    {
                                        if(match1.find())
                                        {
                                            System.out.println("correct initialization");
                                        }
                                        else if(match2.find())
                                        {
                                            System.out.println("wrong initialization");
                                        }
                                    }
                                else
                                {
                                    System.out.println("wrong initialization");

                                }
                            }
                        }  
                        break;
                    }
    return str;
}

public static String checkStringdatatype( String str) 
{
    Pattern feedback1 = Pattern.compile("[\"][a-zA-Z]*[\"]");
    Matcher match1 = feedback1.matcher(str);
    for(int i=0;i<str.length();i++)
    {
        if((str.charAt(i)=='S') && (str.charAt(i+1)=='t') && (str.charAt(i+2)=='r') && (str.charAt(i+3)=='i') && (str.charAt(i+4)=='n') && (str.charAt(i+5)=='g'))
        {
            if(match1.find())
            {
                System.out.println("correct initialization");
            }
            else
            {
                System.out.println("wrong initialization");
            }
        }
        break;
    }
    return str;
}
public static String checkdoubledatatype( String str) 
{
    Pattern feedback1 = Pattern.compile("\\d{1,8}[.]*\\d{1,8}");
    Matcher match1 = feedback1.matcher(str);
    for(int i=0;i<str.length();i++)
    { 
        if((str.charAt(i)=='d') && (str.charAt(i+1)=='o') && (str.charAt(i+2)=='u') && (str.charAt(i+3)=='b') && (str.charAt(i+4)=='l') && (str.charAt(i+5)=='e'))
        {
            if(match1.find())
            {
                System.out.println("correct initialization");
            }
            else
            {
                System.out.println("wrong initialization");
            }
        }
        break;
    }
    return str;
}

}