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
        try{Scanner scan = new Scanner(new FileReader("C:\\Users\\hanna\\Documents\\NetBeansProjects\\projectCOMPILER\\src\\iteu333a\\project\\-iteu333a-project\\Iteu333a-project\\src\\iteu333a\\project\\code.txt"));
        PrintWriter writer = new PrintWriter("Test.java", "UTF-8");
        //try{
            while (scan.hasNext()){
                String str = scan.nextLine();
                //check syntax;
                System.out.println(str);
                if(!str.endsWith(";")){
                    error++;
                    System.out.println(" " + error + ". Syntax Error, no semicolon at the end");
                }
                if (!str.matches("int|double|float|String|char")){ //MAY MALI, di ko madetermine ano >_<
                    error++;
                    System.out.println(" " + error + ". Syntax Error, no data type");
                }
                if (str.matches("int|double|float")){                         //MAY MALI din >_<
                    if (str.matches("'[^'\"]*')|(\"[^'\"]*\")|([^'\"]*")){
                        error++;
                        System.out.println(" " + error + ". Syntax Error, wrong data type");
                    }
                }
                if (str.matches("String")){
                    if (!str.matches("'[^'\"]*')|(\"[^'\"]*\")|([^'\"]*")){ //di ko pa nararun hehe
                        error++;
                        System.out.println(" " + error + ". Syntax Error, must have double quotation marks");
                    }
                }
                if (str.matches("\\w[ ]{2,}\\w")){                          //di ko pa nararun din :D
                    error++;
                    System.out.println(" " + error + ". Syntax Error, consists of two or more consecutive spaces");
                }
                
                 String s = "a=0 , b=0 ,  c= 0";
                 Pattern doublespaces = Pattern.compile("\\s\\s");
                 Matcher spaces = doublespaces.matcher(s);
                 String result = spaces.replaceAll(" ");;
                 if (spaces.find()) {
                 System.out.println(result); }// check spaces
                   
                     
                String data = " //single comment \n" + " " + "/* multi\n" + " line \n" + " comment */\n";
                Pattern feedback = Pattern.compile("//.*|/\\*((.|\\n)(?!=*/))+\\*/");
                Matcher matcher = feedback.matcher(data);
                while (matcher.find()) {
                System.out.println(matcher.group());
                    } //check comments

            
                writer.println(str);
            }
            writer.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
