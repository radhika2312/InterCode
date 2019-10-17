/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JComboBox;
/**
 *
 * @author Ankit Raj
 */
public class Server extends javax.swing.JFrame {

    public Server() {
        initComponents();
        serverThread1.start();
        serverThread2.start();
        SelectedLang.start();
        buildOutput.start();
    }
    static DataInputStream din1,din2,din3,din4;
    static DataOutputStream dout1,dout2,dout3,dout4;
    private int port1=5002,port2=5005;
    private int cnt=1;
    String selectedLanguage="C++";
    String direc="C:\\Users\\Ankit Raj\\Documents\\NetBeansProjects\\InterCode-myfeature";
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        ComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textArea.setColumns(20);
        textArea.setRows(5);
        textArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textAreaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textAreaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(textArea);

        jButton1.setText("send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Server");

        TextArea1.setEditable(false);
        TextArea1.setColumns(20);
        TextArea1.setRows(5);
        TextArea1.setTabSize(10);
        jScrollPane2.setViewportView(TextArea1);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        ComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C++", "Java", "C" }));
        ComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBox1ItemStateChanged(evt);
            }
        });
        ComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBox1MouseClicked(evt);
            }
        });
        ComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox1ActionPerformed(evt);
            }
        });

        jButton2.setText("Run");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        output.setColumns(20);
        output.setRows(5);
        jScrollPane3.setViewportView(output);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(0, 13, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Thread serverThread1 = new Thread(new Runnable() {
        @Override
        public void run() {
           ServerSocket ss1 = null;
           String msin = "";
           while(true){
              try{
                  ss1 = new ServerSocket(port1);
                  //textArea.setEditable(false);
                  Socket s1 = ss1.accept();
                  System.out.println("connection established");
                  textArea.setEditable(true);
                  din1 = new DataInputStream(s1.getInputStream());
                  dout1 = new DataOutputStream(s1.getOutputStream());
                  while(true){
                      msin = din1.readUTF();
                      textArea.setText(msin);
                  }
                  //s1.close();
              } catch (IOException e){
                  try{
                      
                      ss1.close();
                  }
                  catch(IOException e1){
                      System.out.println("exception 1");
                      e1.printStackTrace();
                  }
                  System.out.println("exception 2");
                  e.printStackTrace();
              }
           }
           
        }
    });
    Thread serverThread2 = new Thread(new Runnable() {
        @Override
        public void run() {
           ServerSocket ss2 = null;
           String msin = "";
           while(true){
              try{
                  ss2 = new ServerSocket(port2);
                  Socket s2 = ss2.accept();
                  System.out.println("connection established");
                  din2 = new DataInputStream(s2.getInputStream());
                  dout2 = new DataOutputStream(s2.getOutputStream());
                  while(true){
                      msin = din2.readUTF();
                      TextArea1.setText(msin);
                  }
                  //s2.close();
              } catch (IOException e){
                  try{
                      ss2.close();
                  }
                  catch(IOException e1){
                      System.out.println("exception 11");
                      e1.printStackTrace();
                  }
                  System.out.println("exception 21");
                  e.printStackTrace();
              }
           }
           
        }
    });
    Thread SelectedLang = new Thread(new Runnable() {
        
        @Override
        public void run() {
            String msin3="";
           ServerSocket ss3 = null;
          
           while(true){
              try{
                  ss3 = new ServerSocket(5011);
                  Socket s3 = ss3.accept();
                  System.out.println("connection established");
                  din3 = new DataInputStream(s3.getInputStream());
                  dout3 = new DataOutputStream(s3.getOutputStream());
                  while(true){
                      msin3 = din3.readUTF();
                      System.out.println(msin3);
                      if(msin3.equals("C++"))
                       ComboBox1.setSelectedIndex(0);
                      else if(msin3.equals("Java"))
                          ComboBox1.setSelectedIndex(1);
                      else if(msin3.equals("C"))
                          ComboBox1.setSelectedIndex(2);
                  }
                  //s2.close();
              } catch (IOException e){
                  try{
                      ss3.close();
                  }
                  catch(IOException e1){
                      System.out.println("exception 11");
                      e1.printStackTrace();
                  }
                  System.out.println("exception 21");
                  e.printStackTrace();
              }
           }
           
        }
    });
    Thread buildOutput=new Thread(new Runnable() {
        @Override
        public void run() {
            ServerSocket ss4=null;
            String outputMessage=null;
            while(true){
                try{
                    ss4=new ServerSocket(5020);
                    Socket s4=ss4.accept();
                    System.out.println("Connection established in output");
                    din4=new DataInputStream(s4.getInputStream());
                    dout4=new DataOutputStream(s4.getOutputStream());
                    while(true){
                        outputMessage=din4.readUTF();
                        output.setText(outputMessage);
                    }
                    
                }
                catch(Exception e){
                    try{
                        ss4.close();
                        
                    }
                    catch(IOException e1){
                        System.out.println("Exception e1");
                        e1.printStackTrace();
                    }
                    System.out.println("Exception 21");
                    e.printStackTrace();
                    
                }
            }
            
        }
    });
    

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String msouta = "",msoutf="";
        try{
            msouta = TextArea1.getText();
            msoutf = jTextField1.getText();
            msouta = msouta + "\n" +"Interviwer:" + msoutf;
            TextArea1.setText(msouta);
            dout2.writeUTF(msouta);
            dout2.flush();
            jTextField1.setText("");
        }
        catch(Exception e){
            System.out.println("exception in output");
            System.out.println("exception occured :" + e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAreaKeyPressed
 
    }//GEN-LAST:event_textAreaKeyPressed

    private void textAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAreaKeyReleased
       String messageOut="";
        try{
            messageOut=textArea.getText();
            //System.out.println(messageOut);
            dout1.writeUTF(messageOut);
            dout1.flush();
        }
        catch(Exception e){
            System.out.println("exception sdasdasd1");
            System.out.println("exception occured :" + e);
        }
    }//GEN-LAST:event_textAreaKeyReleased

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
                  
    }//GEN-LAST:event_jTextField1ActionPerformed

                              
    private void ComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox1ActionPerformed
       /* JComboBox<String> combo = (JComboBox<String>) evt.getSource();
        String selectedLang = (String) combo.getSelectedItem();
        try{
        dout3.writeUTF(selectedLang);
        dout3.flush();
         System.out.println(selectedLang);
        }
        catch(Exception e){
            System.out.println("Exception occured :" + e);
        */
    }//GEN-LAST:event_ComboBox1ActionPerformed

    private void ComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBox1MouseClicked
        /* JComboBox<String> combo = (JComboBox<String>) evt.getSource();
        String selectedLang = (String) combo.getSelectedItem();
        try{
        dout3.writeUTF(selectedLang);
        dout3.flush();
         System.out.println(selectedLang);
        }
        catch(Exception e){
            System.out.println("Exception occured :" + e);
        }*/
    }//GEN-LAST:event_ComboBox1MouseClicked

    private void ComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBox1ItemStateChanged
        JComboBox<String> combo = (JComboBox<String>) evt.getSource();
        String selectedLang = (String) combo.getSelectedItem();
        try{
            selectedLanguage=selectedLang;
        dout3.writeUTF(selectedLang);
        dout3.flush();
         System.out.println(selectedLang);
        }
        catch(Exception e){
            System.out.println("Exception occured :" + e);
        }
    }//GEN-LAST:event_ComboBox1ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       runningoutput();
       // System.out.println(selectedLanguage + "Ankit");
        /*FileWriter fileWriter=null;
        File file=null;
        switch(selectedLanguage){
            case "C++":
            {
                file=new File(direc + "\\testcpp.cpp");
                break;
            }
            case "Java":
            {
                file=new File(direc + "\\testjava.java");
                break;
            }
            case "C":
            {
                file=new File(direc + "\\testc.c");
                break;
            }
                
        }
        try{
            fileWriter=new FileWriter(file);
            fileWriter.write(textArea.getText());
            fileWriter.close();
        }
        catch(Exception e){
            System.out.println("Exception in writing file");
            e.printStackTrace();
        }
        new CheckOutput(selectedLanguage);
        Thread t2=Thread.currentThread();
        try{
            t2.sleep(2000);
        }
        catch(Exception e){
            System.out.println("Error in sleeping");
            e.printStackTrace();
        }
        //File outputFile=new File(direc + "\\output.txt");
        BufferedReader reader=null;
        String line;
        String toDisplay=null;
        try{
              reader=new BufferedReader(new FileReader(direc + "\\output.txt"));
              line=reader.readLine();
              while(line!=null){
                  toDisplay=output.getText() + "\n" + line;
                  output.setText(toDisplay);
                   line=reader.readLine();
                }
              try{
                  String tocl= output.getText();
                  dout4.writeUTF(tocl);
                  dout4.flush();
              }catch(Exception e){
                  System.out.println("exception occured :" + e);
              }
              reader.close();
              
        }
        catch(Exception e){
            System.out.println("Error in reading output" + e);
        }*/
        
        
    }//GEN-LAST:event_jButton2ActionPerformed
    private void runningoutput(){
        FileWriter fileWriter=null;
        File file=null;
        switch(selectedLanguage){
            case "C++":
            {
                file=new File(direc + "\\testcpp.cpp");
                break;
            }
            case "Java":
            {
                file=new File(direc + "\\testjava.java");
                break;
            }
            case "C":
            {
                file=new File(direc + "\\testc.c");
                break;
            }
                
        }
        try{
            fileWriter=new FileWriter(file);
            fileWriter.write(textArea.getText());
            fileWriter.close();
        }
        catch(Exception e){
            System.out.println("Exception in writing file");
            e.printStackTrace();
        }
        new CheckOutput(selectedLanguage);
        Thread t2=Thread.currentThread();
        try{
            t2.sleep(2000);
        }
        catch(Exception e){
            System.out.println("Error in sleeping");
            e.printStackTrace();
        }
        //File outputFile=new File(direc + "\\output.txt");
        BufferedReader reader=null;
        String line;
        String toDisplay=null;
        try{
              reader=new BufferedReader(new FileReader(direc + "\\output.txt"));
              line=reader.readLine();
              while(line!=null){
                  toDisplay=output.getText() + "\n" + line;
                  output.setText(toDisplay);
                   line=reader.readLine();
                }
              try{
                  String tocl= output.getText();
                  dout4.writeUTF(tocl);
                  dout4.flush();
              }catch(Exception e){
                  System.out.println("exception occured :" + e);
              }
              reader.close();
              
        }
        catch(Exception e){
            System.out.println("Error in reading output" + e);
        }
        
    }
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
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
                /*serverThread2.start();
                serverThread1.start();*/
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox1;
    private static javax.swing.JTextArea TextArea1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea output;
    private static javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
