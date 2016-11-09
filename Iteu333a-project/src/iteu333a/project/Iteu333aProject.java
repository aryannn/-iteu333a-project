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
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Import here...
public class Iteu333aProject {
    
    //Global variable here...
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        
        //Main codes here...
        try{
            Scanner scan = new Scanner(new FileReader("input.txt"));
            PrintWriter writer = new PrintWriter("Test.java", "UTF-8");
            Set<String> var1 = new HashSet<>();
            Set<String> var2 = new HashSet<>();
            
            while (scan.hasNext()){
                String str = scan.nextLine();
                //print file
                System.out.println(str);
                if(str.matches(""))
                {
                    //newline
                }
                // check for comment
                else if((str.contains("//")))
                {
                    System.out.println("comment detected");
                }
                //check if semicolon is present
                else
                {
                    if(str.endsWith(";"))
                    {
                        //if contains print
                        if(str.contains("print"))
                        {
                          str = str.replace("print", "System.out.println");
                          System.out.println(str);
                          //if print contains variable
                          if((str.contains("print")) && (str.contains("(")) && (!str.contains("\"")))
                          {
                             //add variables from print to array
                             var2.add(getVariablefromPrint(str));
                              System.out.println(var2); 
                          }
                        }
                        else if(str.startsWith("("))
                        {
                            System.out.println("should be print(\"\");");
                        }
                        //check if datatype is present
                        else if((!str.contains("int")) && (!str.contains("float")) && (!str.contains("double")) && (!str.contains("String")) && (!str.contains("char")))  
                        {
                            System.out.println("no datatype detected");
                        }               
                        else
                        {
                          System.out.println("datatype detected");
                          // add variables to array
                          var1.add(getVariablefromDatatype(str));
                          //check for correct datatype
                          checkfordatatype(str);
                          //print array
                          System.out.println(var1);
                        }
                    }
                    else
                    {
                        System.out.println("No semicolon detected.");
                    } 
                    
                }
                 //concatenate string 
                String regex = "pan+cake";
                String string = "pancake";

                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(string);

                while (matcher.find()) {
                System.out.println("Full match: " + matcher.group(0));
                for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
                 }
                    }
                isWhitespace(str);
                writer.println(str);
                System.out.println();
            }
            writer.close();
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
//check for correct datatype   
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
public static String getVariablefromDatatype(String str)
{
    Pattern variable = Pattern.compile("[ ][a-zA-Z]*[a-zA-Z0-9_]{1,}");
    Matcher match6 = variable.matcher(str);
    String[] result = null;
    
    while(match6.find())
    {
        String newvar2 = match6.group();
        result = newvar2.split(" "); 
    }
    return result[1];
    }
public static String getVariablefromPrint(String str)
{
    Pattern print = Pattern.compile("[(][a-zA-Z]*[a-zA-Z0-9_]{1,}[)]");
    Matcher printmatch = print.matcher(str);
    String[] varmatch = null;

   while(printmatch.find())
   {
       String newvar3 = printmatch.group();
       System.out.println(newvar3);
       newvar3 = newvar3.replace("(","\"");
       newvar3 = newvar3.replace(")","\"");
       System.out.println(newvar3);
       varmatch = newvar3.split("\""); 
   } 
    return varmatch[1];
    }
    public static String getVariablefromDatatype(String str)
{
    Pattern variable = Pattern.compile("[ ][a-zA-Z]*[a-zA-Z0-9_]{1,}");
    Matcher match6 = variable.matcher(str);
    String[] result = null;
    
    while(match6.find())
    {
        String newvar2 = match6.group();
        result = newvar2.split(" "); 
    }
    return result[1];
    }
public static String getVariablefromPrint(String str)
{
    Pattern print = Pattern.compile("[(][a-zA-Z]*[a-zA-Z0-9_]{1,}[)]");
    Matcher printmatch = print.matcher(str);
    String[] varmatch = null;

   while(printmatch.find())
   {
       String newvar3 = printmatch.group();
       System.out.println(newvar3);
       newvar3 = newvar3.replace("(","\"");
       newvar3 = newvar3.replace(")","\"");
       System.out.println(newvar3);
       varmatch = newvar3.split("\""); 
   } 
    return varmatch[1];
    }



 //check spaces 
static boolean isWhitespace(String strs) {
      
      System.out.println("One Space");

      }
      int spac = strs.length();
      for (int i = 0; i < spac; i++) {
          if ((Character.isWhitespace(strs.charAt(i)) == false)) {
              return false;
          }
      }
      return true;
  }
}



