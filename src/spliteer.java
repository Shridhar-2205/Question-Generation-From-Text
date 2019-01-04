/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tagtext;
public class spliteer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
int i=0,k=0;
    String speech = "Four_vbz score_noun hjk_adj";
    String[] result = speech.split(" ");
    String hjk[]=new String[200];
    String[] result1=null;
    for (int x=0; x<result.length; x++) {
      //System.out.println(result[x]);
   result1=result[x].split("_");
    for(i=0;i<(result1.length);i++) {
    hjk[k]=result1[i];
        //System.out.println(result1[i]);
    k++;
    }
    for(i=0;i<k;i++){
        System.out.println(hjk[i]);
    }
    
    }
   
        
    
    
        // TODO code application logic here
    }
}