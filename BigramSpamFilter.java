/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bigramspamfilter;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Pattern;

/**
 *
 * @author JoeV5
 */
public class BigramSpamFilter {
    private static String file;
    private static String[] strs;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws 
            FileNotFoundException, IOException {
        // TODO code application logic here
        /** get File **/
           String totalData = "";
           Pattern tempPattern = Pattern.compile(" \\S. ");
           
           String fileName = "SampleData.txt";
           File name = new File(fileName);
           String str;
           String line;
           FileReader fReader = null;
           Vector<String> v = new Vector(2);
           Iterator itV =  v.iterator();
           HashMap<String, Integer> nGramTable= new HashMap<String, Integer>();
           Iterator itH = null;
           strs = new String[10];
           
           // Read the File
           try{
               fReader = new FileReader(fileName);
           }catch (FileNotFoundException e){
               e.printStackTrace();
           }
           BufferedReader input = new BufferedReader(fReader); 
           
           // Data put into HashMap and detect numbers of Collision
           try{
               while((line = input.readLine()) !=  null){
                   if(line.equals("")) continue;
                   /** (2) words consist of letters and digits only **/
                   strs = line.split("[ ]?\\W?[ ]+");
                   
                   String keyH = new String(); //for the key in HashMap
                    for(String temp :  strs){
                        /** (1) words are case insensitive **/
                        temp = temp.toLowerCase();
                        temp = temp.replaceAll("\\W","");

                        v.addElement(temp);
                        if(v.size() > 2)
                            v.removeElementAt(0);
                        
                        if(v.size() != 1){
                                // create the key to the HashMap 
                                // by connecting v[0] & v[1]
                                keyH = v.get(0).toString() + " " 
                                        + v.get(1).toString();

                            if(nGramTable.get(keyH) == null){
                                nGramTable.put(keyH, 1);                        
                            }else{ //nGramTable.get(v) ! = null
                                System.out.println("repeated key is found! key : " + keyH);
                                int tempVal = nGramTable.get(keyH).intValue();
                                tempVal++;
                                nGramTable.put(keyH, tempVal);
                            }
                        }
                    } // end of for each temp in strs
               }
               
               /** 
                * Use the iterator to calculate the Probability in HashMap 
                * @authou JoeH
                **/
               double kTotal = nGramTable.size();
               double prodTotal = 1; // the production of total Probability
               itH = nGramTable.keySet().iterator();
               while(itH.hasNext()){
                   Object key = itH.next();    
                   int weight = 1; // the factor of re-occurrence bi-gram
                   weight *= nGramTable.get(key);
                   prodTotal *= Math.pow(weight, weight);
                   kTotal += weight-1;
               }
               double ans = Math.pow(prodTotal, 1/kTotal);
               // PRINT the Answer Here!
               System.out.println("k is " + kTotal);
               System.out.println("Probability is :" +ans );
               ans = roundDouble(ans);
               System.out.println("round answer: " + ans);
           } 
           catch (IOException e){
               e.printStackTrace();
           }
    }
    static double roundDouble(double doubleValue){
        doubleValue *= 100000;
        int roundToInt = (int)(doubleValue + 0.5);
        doubleValue = (double)roundToInt/100000;
        return doubleValue;
    }    
}
