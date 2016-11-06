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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Import here...
public class Iteu333aProject {

    
    public static ArrayList<String> output;
    //Global variable here...
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        
       
        //Main codes here...
        try{Scanner scan = new Scanner(new FileReader("input.txt"));
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
                            System.out.println("no datatype detected");

                        }               
                        else
                        {
                          System.out.println("datatype detected");
                        //check for correct datatype
                          checkfordatatype(str);
                        //check for parenthesis
                          checkParenthesis(str);
                        }
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
//check for integer datatype
    
public static String checkfordatatype(String str)
{
    Pattern intresult = Pattern.compile("int [a-zA-Z]*[a-zA-Z0-9_]{1,}.[=]*[-]*[0-9]{1,8}[;]");
    Matcher match1 = intresult.matcher(str);
    Pattern stringresult = Pattern.compile("String [a-zA-Z]*[a-zA-Z0-9_]{1,}.[=]*[\"][\\w\\s]{0,}[\"]");
    Matcher match2 = stringresult.matcher(str);
    Pattern charresult = Pattern.compile("char [a-zA-Z]*[a-zA-Z0-9_]{1,}.[=]*['][a-zA-Z\\s]{0,1}[']");
    Matcher match3 = charresult.matcher(str);
    Pattern doubleresult = Pattern.compile("double [a-zA-Z]*[a-zA-Z0-9_]{1,}.[=]*[0-9]{1,8}[.][0-9]{1,8}");
    Matcher match4 = doubleresult.matcher(str);
    Pattern floatresult = Pattern.compile("float [a-zA-Z]*[a-zA-Z0-9_]{1,}.[=]*[0-9]{1,4}[.][0-9]{1,4}[fF]");
    Matcher match5 = floatresult.matcher(str);
    
    for(int i=0; i<str.length();i++)
    {
        //check for integer,double and float datatype
        if(((str.charAt(i)=='i') && (str.charAt(i+1)=='n') && (str.charAt(i+2)=='t')) || ((str.charAt(i)=='d') && (str.charAt(i+1)=='o') && (str.charAt(i+2)=='u') && (str.charAt(i+3)=='b') && (str.charAt(i+4)=='l') && (str.charAt(i+5)=='e')) || ((str.charAt(i)=='f') && (str.charAt(i+1)=='l') && (str.charAt(i+2)=='o') && (str.charAt(i+3)=='a') && (str.charAt(i+4)=='t')))
        {
            if((!str.contains("'")) && (!str.contains("\"")))
            {
                if(((!match5.find()) && (!match1.find())) && (!match4.find()))
                {
                    System.out.println("wrong initialization");
                }
                else
                {
                    System.out.println("correct initialization");
                }
            }
            else
            {
                System.out.println("Wrong datatype");
            }
        }
        
        //check for String datatype
        else if((str.charAt(i)=='S') && (str.charAt(i+1)=='t') && (str.charAt(i+2)=='r') && (str.charAt(i+3)=='i') && (str.charAt(i+4)=='n') && (str.charAt(i+5)=='g'))
        {
          if(match2.find())
          {
              System.out.println("correct initialization");
          }
          else
          {
              System.out.println("wrong initialization");
          }
        }
        //check for correct char datatype
        else if((str.charAt(i)=='c') && (str.charAt(i+1)=='h') && (str.charAt(i+2)=='a') && (str.charAt(i+3)=='r'))
        {
            if(match3.find())
            {
                System.out.println("correct initialization");
            }
            else
            {
                System.out.println("wrong initialization");
            }
        }
    
    }
    return str;
}
public static String checkParenthesis( String str) 
{
    Pattern feedback1 = Pattern.compile("[\\w]+[(].+[)][;]");
    Matcher match1 = feedback1.matcher(str);
    for(int i=0;i<str.length();i++)
    {
        if(str.contains("("))
        {
            if(match1.find())
            {
                if(!str.contains(")")){
                    System.out.println("wrong initialization");
                    output.add(str);
                }
                else{
                    System.out.println("correct initialization");
                    output.add(str);                    
                }
                
            }
            else
            {
                System.out.println("wrong initialization");
                output.add(str);
            }
        }
        break;
    }
    return str;
}
 //concatenate string 
public static String strconcat (String str){
 
     Pattern p = Pattern.compile ("[a-zA-Z][0-9]");
     Matcher m1 = p.matcher (str);
     Pattern p2 = Pattern.compile("[a-zA-Z][0-9]");
     Matcher m2 = p2.matcher(str);
     
     while (m1.find() && m2.find())
     {
       System.out.println(m1.group() + ""+ m2.group());
     }
        return str;

}
 //check spaces 
public static boolean isWhitespace(String str) {
      if (str == null) {
          return false;
      }
      int spac = str.length();
      for (int i = 0; i < spac; i++) {
          if ((Character.isWhitespace(str.charAt(i)) == false)) {
              System.out.println("One Space Only.");
              return false;
          }
      }
      return true;
  }

}



