/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ankit Raj
 */
public class addNoteForm extends javax.swing.JFrame {
    private static String id=null;
    private static String user=null;
      private static String pass=null;
   private static String conn_str=null;
   
    public addNoteForm() {
        initComponents();
    }

   public addNoteForm(String id,String user,String pass,String conn_str)
   {
       this.id=id;
       this.user=user;
       this.pass=pass;
       this.conn_str=conn_str;
       initComponents();
       
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        noteArea = new javax.swing.JTextArea();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        noteArea.setColumns(20);
        noteArea.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        noteArea.setRows(5);
        jScrollPane1.setViewportView(noteArea);

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
       
        Connection connection=null;
        String existingNote=null;
        Statement statement=null;
        try{
              boolean success=false;
              
              connection=DriverManager.getConnection(conn_str,user,pass);
              System.out.println("connection established in addNote");
              statement=connection.createStatement();
              String query="SELECT * FROM info";
              ResultSet rs=statement.executeQuery(query);
              while(rs.next()){
                  String idd=rs.getString("id");
                   if(idd.equals(this.id))
                   {
                       success=true;
                       existingNote=rs.getString("note");
                       break;
                   }
                //  String note=rs.getString("note");
                //  System.out.println("id=" + idd + " note=" + note);
              }
              if(success){
                  System.out.println("Successfully received the information");
              }
              String toAdd=noteArea.getText();
              existingNote=existingNote + "\n" + toAdd;
              String update="UPDATE info SET note = ? WHERE id = ?";
              PreparedStatement preparedStatement=connection.prepareStatement(update);
              preparedStatement.setString(1,existingNote);
              preparedStatement.setString(2, id);
              int row=preparedStatement.executeUpdate();
              System.out.println("Update completed " + row);
              
              
              
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try {
                connection.close();
                statement.close();
                }
                
            catch (SQLException ex) 
            {
                Logger.getLogger(addNoteForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                this.dispose();
            }
            
        }
        
    }//GEN-LAST:event_saveButtonActionPerformed

 /*  public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addNoteForm().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea noteArea;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
