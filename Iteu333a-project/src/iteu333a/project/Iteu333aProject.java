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
//Import here...
public class Iteu333aProject {

    //Global variable here...
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        
        //Main codes here...
        int error = 0;
        Scanner scan = new Scanner(new FileReader("code.txt"));
        PrintWriter writer = new PrintWriter("Test.java", "UTF-8");
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("int", "double", "float", "String", "char"));
        while (scan.hasNext()){
            String str = scan.nextLine();
            //check syntax;
            System.out.println(str);
            if(!str.endsWith(";")){
                error++;
                System.out.print(" " + error + ". Syntax Error, no semicolon at the end");
            }
            else if (!str.matches("int|double|float|String|char")){
                error++;
                System.out.print(" " + error + ". Syntax Error, no data type");
            }
            
            writer.println(str);
        }
        writer.close();
        
    }
}
