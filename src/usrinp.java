/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tagtext;

import java.io.IOException;
import java.util.Scanner;
import java.sql.*;
import java.io.*;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class usrinp extends javax.swing.JFrame {
DefaultListModel dlm = new DefaultListModel();
       String dep=""; 
int flag=0;
public usrinp() {
getContentPane().setBackground(Color.WHITE);        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        j1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jl1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        list1 = new javax.swing.JList();
        help = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Enter Sentence");

        jButton1.setText("Enter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(list1);

        help.setText("Help");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(189, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(help)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(197, 197, 197))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(27, 27, 27)
                .addComponent(jl1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(help)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        MaxentTagger tagger = new MaxentTagger("taggers/english-left3words-distsim.tagger");
        Scanner in = new Scanner(System.in);
        
        int str;
        
        
        // The sample string
        String sample = j1.getText();
        String type[] = new String[4];
String one=sample;        
// The tagged string
        String tagged = tagger.tagString(sample);

        // Output the result
        jl1.setText(tagged);
        int i = 0;
 
        String[] result = tagged.split(" ");
        String[] a;
        String[] a1 = new String[result.length];
        String[] a2 = new String[result.length];

        for (int x = 0; x < result.length; x++) {

            a = result[x].split("_");
            a1[i] = a[0];
            a2[i] = a[1];
            i++;
        }
        for (i = 0; i < a1.length; i++) {
            System.out.println(a1[i] + " is " + a2[i]);
            if (a2[i].equals("VB") || a2[i].equals("VBD") || a2[i].equals("VBG") || a2[i].equals("VBN") || a2[i].equals("VBP") || a2[i].equals("VBZ")) {
                type[1] = a1[i];
                
            }
            if (a2[i].equals("JJR") || a2[i].equals("JJS") || a2[i].equals("JJ")) {
                type[2] = a1[i];
                
            }
            if (a2[i].equals("NNP") || a2[i].equals("NNPS")) {
                type[0] = a1[i];
                
                flag=1;
            }
            if (a2[i].equals("PRP") && flag==1) {
            one=sample.replaceAll(a1[i],dep);//change     
                type[0] = dep;
                
            }
            if (a2[i].equals("NN") || a2[i].equals("NNS")) {
                type[3] = a1[i];
                
            }
            
        }
                dep=type[0];
                
                
        try {
            String url = "jdbc:derby://localhost:1527/nlp";
            String username = "nlp";
            String password = "nlp";
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            String Query = "INSERT INTO ONTOLOGY1 (SUBJECT ,PREDICATE,ADJECTIVE,OBJECT,SENTENCE)VALUES('" +type[0] +"' , '" +type[1] +"' ,'" + type[2]+"','" +type[3]+"','" +one+"')";
            stmt.execute(Query);
            JOptionPane.showMessageDialog(null, "Added to database");

        } catch (Exception ae) {

        }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
list1.setModel(dlm);
BufferedReader in = null;
    String line;
    //DefaultListModel listModel = new DefaultListModel();
    try {
        in = new BufferedReader(new FileReader("C:\\Users\\Dell\\Desktop\\symbols.txt"));//C:\Users\Dell\Desktop
        while ((line = in.readLine()) != null) {
            dlm.addElement(line); //(String.valueof(line));
        }
    } catch (IOException ex) {
        //Logger.getLogger(Frame2.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (in != null) {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(usrinp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_helpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(usrinp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usrinp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usrinp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usrinp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usrinp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton help;
    private javax.swing.JTextField j1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jl1;
    private javax.swing.JList list1;
    // End of variables declaration//GEN-END:variables
}
