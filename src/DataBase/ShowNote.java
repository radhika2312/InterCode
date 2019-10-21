
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShowNote extends javax.swing.JFrame {

    private String user="root";
    private String pass="neeraj@17";
    private String conn_str="jdbc:mysql://localhost:3306/logininfo2";
    private String id="20184045";
    
    public ShowNote() 
    {
        initComponents();
         idField.setText(this.id);
        displayNote();
    }
    public ShowNote(String id,String user,String pass,String conn_str)
    {
        this.id=id;
        this.user=user;
        this.pass=pass;
        this.conn_str=conn_str;
        initComponents();
        idField.setText(this.id);
        displayNote();
        
    }
    private void displayNote()
    {
        Connection connection=null;
        Statement statement=null;
        PreparedStatement preparedStatement=null;
        String currentId=null;
        String toShow=null;
        boolean success=false;
        try
        {
            connection=DriverManager.getConnection(conn_str,user,pass);
            System.out.println("connection established in addNote");
            String query="SELECT * FROM info";
            preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next())
            {
                currentId=resultSet.getString("id");
                if(currentId.equals(this.id))
                {
                    toShow=resultSet.getString("note");
                    showNoteArea.setText(toShow);
                    success=true;
                    break;
                }
            }
            if(!success)
            {
                showNoteArea.setText("\tGiven ID is not found\n");
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                connection.close();
                preparedStatement.close();
            }
            catch (SQLException ex) 
            {
                Logger.getLogger(ShowNote.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        showNotePanel = new javax.swing.JPanel();
        showNoteScrollPane = new javax.swing.JScrollPane();
        showNoteArea = new javax.swing.JTextArea();
        userLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        showNotePanel.setBackground(java.awt.Color.decode("#bdb76b")
        );

        showNoteArea.setEditable(false);
        showNoteArea.setColumns(20);
        showNoteArea.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        showNoteArea.setRows(5);
        showNoteScrollPane.setViewportView(showNoteArea);

        userLabel.setBackground(new java.awt.Color(0, 255, 204));
        userLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        userLabel.setForeground(new java.awt.Color(255, 0, 0));
        userLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userLabel.setText("ID");

        idField.setEditable(false);
        idField.setBackground(new java.awt.Color(255, 255, 204));
        idField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        idField.setForeground(new java.awt.Color(204, 0, 204));
        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout showNotePanelLayout = new javax.swing.GroupLayout(showNotePanel);
        showNotePanel.setLayout(showNotePanelLayout);
        showNotePanelLayout.setHorizontalGroup(
            showNotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(showNoteScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
            .addGroup(showNotePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        showNotePanelLayout.setVerticalGroup(
            showNotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showNotePanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(showNotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(idField))
                .addGap(18, 18, 18)
                .addComponent(showNoteScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(showNotePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(showNotePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
    
    }//GEN-LAST:event_idFieldActionPerformed

   /* public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowNote().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idField;
    private javax.swing.JTextArea showNoteArea;
    private javax.swing.JPanel showNotePanel;
    private javax.swing.JScrollPane showNoteScrollPane;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
