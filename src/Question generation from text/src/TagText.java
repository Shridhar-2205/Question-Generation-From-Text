/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tagtext;
import java.io.IOException;
import java.util.Scanner;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

/**
 *
 * @author Henil
 */
 
public class TagText {
    
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
 
        // Initialize the tagger
        MaxentTagger tagger = new MaxentTagger("taggers/english-left3words-distsim.tagger");
        Scanner in=new Scanner(System.in);
        // The sample string
        String sample = in.nextLine();
 
        // The tagged string
        String tagged = tagger.tagString(sample);
 
        // Output the result
        System.out.println(tagged);
    }
}

