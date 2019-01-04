/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tagtext;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import static java.lang.Boolean.FALSE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
public class addpargraph extends javax.swing.JFrame {
    String dep=""; 
int flag=0;
    public addpargraph() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        para = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        Ok = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sub = new javax.swing.JTextField();
        chap = new javax.swing.JComboBox();
        name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        para.setColumns(20);
        para.setRows(5);
        jScrollPane1.setViewportView(para);

        jLabel1.setText("Extract Text");

        Ok.setText("Add");
        Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkActionPerformed(evt);
            }
        });

        jLabel2.setText("Add pargraph");

        jLabel3.setText("Subject");

        jLabel4.setText("Chapter No.");

        chap.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28" }));

        jLabel6.setText("Name of Chapter");

        jButton1.setText("GENERATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(Ok)
                        .addGap(80, 80, 80)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sub, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(chap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ok)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkActionPerformed
String str=para.getText();
String sub1=sub.getText();
String cno=(String) chap.getSelectedItem();
String cname=name.getText();
 String ty[] = new String[100];
        int ct = 0;
        Pattern re = Pattern.compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)", Pattern.MULTILINE | Pattern.COMMENTS);
        Matcher reMatcher = re.matcher(str);
        while (reMatcher.find()) {
        //    System.out.println(reMatcher.group());
            ty[ct] = reMatcher.group();
            ct++;
        }
        MaxentTagger tagger = new MaxentTagger("taggers/english-left3words-distsim.tagger");
        Scanner in = new Scanner(System.in);
        
        //int str;
        String sample[]=new String[300];
        for(int y=0;y<ct;y++)
        {  // The sample string
        sample[y] =ty[y];
        String type[] = new String[4];
String one=sample[y];        
// The tagged string
        String tagged = tagger.tagString(sample[y]);

        // Output the result
       // jl1.setText(tagged);
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
            one=sample[y].replaceAll(a1[i],dep);//change     
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
            String Query = "INSERT INTO CENTER (SENTENCE,SUBI,CHAPTERNO,CHAPTERNAME,SUBJECT,PREDICATE,ADJECTIVE,OBJECT)VALUES('" +one+"','" +sub1 +"' ,'" +cno +"' ,'" +cname +"' ,'" +type[0] +"' , '" +type[1] +"' ,'" + type[2]+"','" +type[3]+"')";
            stmt.execute(Query);
            //JOptionPane.showMessageDialog(null, "Added to database");

        } catch (Exception ae) {
ae.printStackTrace();
        }       
        }
    
    }//GEN-LAST:event_OkActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
 int j=0;
        String blank = "_________";
        String que="Who";
        String mark="?";
        String sentence[]=new String[300];
        String subj[]=new String[300];
        String adj[]=new String[300];
        String obj[]=new String[300];
        String s1[]=new String[300];
        String cn1[]=new String[300];
        String cna[]=new String[300];
        
        /* String str[i] = "Hello am your 8.7 String.";
        String REGEX = "(\\.(?=[\\s\\n\\r]|$))";
        String x = str[i].replaceAll(REGEX, " ");
        String[] splitStr = x.split("\\s+");*/
        
        try {
            String url = "jdbc:derby://localhost:1527/nlp";
            String username = "nlp";
            String password = "nlp";
            Connection con = DriverManager.getConnection(url, username, password);
            Connection con1 = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            Statement stmt1 = con1.createStatement();
            String sql = "SELECT * FROM CENTER";
            Connection con2 = DriverManager.getConnection(url, username, password);
            Statement stmt2 = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
         //   String Query = "INSERT INTO ONTOLOGY1 (SUBJECT ,PREDICATE,ADJECTIVE,OBJECT,SENTENCE)VALUES('" +type[0] +"' , '" +type[1] +"' ,'" + type[2]+"','" +type[3]+"','" +sample+"')";
        //    stmt.execute(Query);
          //  JOptionPane.showMessageDialog(null, "Added to database");
while(rs.next()){
    s1[j]=rs.getString("SUBI");
cn1[j]=rs.getString("CHAPTERNO");
cna[j]=rs.getString("CHAPTERNAME");
    
sentence[j]=rs.getString("SENTENCE");
subj[j]=rs.getString("SUBJECT");
obj[j]=rs.getString("OBJECT");
adj[j]=rs.getString("ADJECTIVE");
j++;
}
String q1[]=new String[j];
String q2[]=new String[j];
String q3[]=new String[j];
String q4[]=new String[j];
int gag=0;
            for (int i = 0; i < j; i++) {//que
       if(subj[i]!= null || !subj[i].isEmpty())
       {    q1[i]=sentence[i].replaceAll(subj[i],que );
        q1[i]=q1[i].replace(".","?");        
       System.out.println(" que"+q1[i]);
       }
       else q1[i]="nil";
            }
             
                for (int i = 0; i < j; i++) {//subject
        
                if(subj[i]!= null || !subj[i].isEmpty())
       {    q2[i]=sentence[i].replaceAll(subj[i],blank);
                
       System.out.println("sub "+q2[i]);
       }
       else q2[i]="nil";
                
        
            }
                for (int i = 0; i < j; i++) {//object
        
                if(obj[i]!= null || !obj[i].isEmpty())
       {    q3[i]=sentence[i].replaceAll(obj[i],blank);
                
       System.out.println(" obj"+q3[i]);
       }
       else q3[i]="nil";
                
                
     // System.out.println(" "+adj[i]);
            }
                for (int i = 0; i < j; i++) {//adjective
        
                if(adj[i].equals("null")==FALSE && !adj[i].isEmpty())
       {    q4[i]=sentence[i].replaceAll(adj[i],blank);
                
       System.out.println("adj "+q4[i]);
       }
                
       else q4[i]="nil";
                     
                stmt2.executeUpdate("delete from QUE");
      //  System.out.println(" "+adj[i]);
            }                for (int i = 0; i < j; i++) {
            String Query1 = "INSERT INTO QUES (Q1,Q2,Q3,Q4,ANS,SUBI,CNO,NAM)VALUES('" +q1[i] +"' , '" +q2[i] +"' ,'" + q3[i]+"','" +q4[i]+"','" +sentence[i]+"','" +s1[i]+"','" +cn1[i]+"','" +cna[i]+"')";
              stmt1.execute(Query1);
                
            }
            
            
            
        } catch (Exception aep) {

        }













// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(addpargraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addpargraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addpargraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addpargraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addpargraph().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ok;
    private javax.swing.JComboBox chap;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextArea para;
    private javax.swing.JTextField sub;
    // End of variables declaration//GEN-END:variables
}
