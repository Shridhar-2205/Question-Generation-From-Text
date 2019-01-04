/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tagtext;

public class Splitme {

    public static void main(String[] args) {
       
int i=0;
    String speech = "Four_verb score_noun wuck_noun no_verb";
    String[] result = speech.split(" ");
    String[] a;
    String[] a1 = new String[result.length];
    String[] a2 = new String[result.length];
    
    for (int x=0; x<result.length; x++) {
      
       a =result[x].split("_");
       a1[i]=a[0];
       a2[i]=a[1];
       i++;
    }
    for(i=0;i<a1.length;i++){
        System.out.println(a1[i]+" is "+a2[i]);
    }
        
       
    }
}