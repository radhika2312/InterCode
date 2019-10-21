package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

public class ShowDatabase extends javax.swing.JFrame {
    
    
  
    private String user="root";
    private String pass="neeraj@17";
    private String conn_str="jdbc:mysql://localhost:3306/logininfo2";
 
    
    public ShowDatabase() {
        initComponents();
        displayDatabase();
    }
    public ShowDatabase(String user,String pass,String conn_str)
    {
       this.user=user;
       this.pass=pass;
       this.conn_str=conn_str;
       initComponents();
       displayDatabase();
        
       
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        showLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        databaseTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.decode("#41b3a3")
        );

        showLabel.setBackground(new java.awt.Color(255, 153, 255));
        showLabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        showLabel.setText("Click on any row to view the note");

        databaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "Score"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        databaseTable.getTableHeader().setReorderingAllowed(false);
        databaseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                databaseTableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(databaseTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(showLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(211, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
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

    private void databaseTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_databaseTableMousePressed
      JTable source = (JTable)evt.getSource();
        int row = source.rowAtPoint( evt.getPoint() );
      
        String id=(String) source.getValueAt(row,0);
        System.out.println(id);
        new ShowNote(id, user, pass, conn_str).setVisible(true);
     
    
        
        
    }//GEN-LAST:event_databaseTableMousePressed
    private void displayDatabase()
    {
        Connection connection=null;
        Statement statement=null;
        PreparedStatement preparedStatement=null;
        try
        {
            connection=DriverManager.getConnection(conn_str,user,pass);
            System.out.println("connection established in addNote");
            String query="SELECT * FROM info  ORDER by score DESC";
            preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            DefaultTableModel dm=(DefaultTableModel)databaseTable.getModel();
            dm.setRowCount(0);
            while(resultSet.next())
            {
                Object o[]={resultSet.getString("id"),resultSet.getString("name"),resultSet.getInt("score")};
                dm.addRow(o);
                System.out.println(resultSet.getString("id"));
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
                preparedStatement.close();
                connection.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ShowDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowDatabase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable databaseTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel showLabel;
    // End of variables declaration//GEN-END:variables
}
