package Client;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javaapplication9.Server1;
import javaapplication9.intervieweedata;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import org.fife.ui.autocomplete.AutoCompletion;
import org.fife.ui.autocomplete.BasicCompletion;
import org.fife.ui.autocomplete.CompletionProvider;
import org.fife.ui.autocomplete.DefaultCompletionProvider;
import org.fife.ui.autocomplete.ShorthandCompletion;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rsyntaxtextarea.Token;
public class Client1 extends javax.swing.JFrame 
{
    private static Socket s,s2,s3,s5,s6;
    private static DataInputStream din,din2,din3,din4,din5,din6;
    private static DataOutputStream dout,dout2,dout3,dout4,dout5,dout6;
    private final int port1=5002,port2=5005,port3=5011,port4=5020,port5=5025,port6=6000;
    private static String ip="";
    private static int fonts,fontst,focusCount=0;
    private String selectedLanguage="C++";
    private ArrayList<Object> last=new ArrayList<Object>();
    private String id="";
    private static int sendIdCount=0;
    private static String Interviwee2="Interviwee";
    public Client1(String id,String ip) {
        initComponents();
        this.ip=ip;
        this.id=id;
        this.setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        startThreads();
        new AutoCompleteDemo();
        setSyntax(selectedLanguage);
    }

    private Client1() 
    {
        initComponents();
        this.id="20184045";
        this.setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        startThreads();
        new AutoCompleteDemo();
        setSyntax(selectedLanguage);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        editorArea = new org.fife.ui.rsyntaxtextarea.RSyntaxTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        inputTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        rTextScrollPane1 = new org.fife.ui.rtextarea.RTextScrollPane(editorArea);
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        sizecombobox = new javax.swing.JComboBox<>();
        fontcombobox = new javax.swing.JComboBox<>();
        runButton = new javax.swing.JButton();
        findfield = new javax.swing.JTextField();
        findButton = new javax.swing.JButton();
        replacefield = new javax.swing.JTextField();
        replaceButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageArea = new javax.swing.JTextArea();
        sendMessageField = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        editorArea.setColumns(20);
        editorArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                editorAreaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(editorArea);

        inputTextArea.setColumns(20);
        inputTextArea.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        inputTextArea.setRows(5);
        inputTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputTextAreaKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(inputTextArea);

        outputTextArea.setEditable(false);
        outputTextArea.setColumns(20);
        outputTextArea.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        outputTextArea.setRows(5);
        jScrollPane3.setViewportView(outputTextArea);

        rTextScrollPane1.setAlignmentX(0.0F);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, editorArea, org.jdesktop.beansbinding.ELProperty.create("${horizontalScrollBarPolicy}"), rTextScrollPane1, org.jdesktop.beansbinding.BeanProperty.create("horizontalScrollBarPolicy"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, editorArea, org.jdesktop.beansbinding.ELProperty.create("${verticalScrollBarPolicy}"), rTextScrollPane1, org.jdesktop.beansbinding.BeanProperty.create("verticalScrollBarPolicy"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, editorArea, org.jdesktop.beansbinding.ELProperty.create("${horizontalScrollBar}"), rTextScrollPane1, org.jdesktop.beansbinding.BeanProperty.create("horizontalScrollBar"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, editorArea, org.jdesktop.beansbinding.ELProperty.create("${verticalScrollBar}"), rTextScrollPane1, org.jdesktop.beansbinding.BeanProperty.create("verticalScrollBar"));
        bindingGroup.addBinding(binding);

        jLabel1.setText("Client");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C++", "Java", "C" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        sizecombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "14", "16", "18", "20", "22", "24", "26" }));
        sizecombobox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sizecomboboxItemStateChanged(evt);
            }
        });

        fontcombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Consolas", "Georgia", "Calibri ", "Tahoma", "Arial ", "Cambria", "Garamond", "Book Antiqua", "Informal Roman" }));
        fontcombobox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fontcomboboxItemStateChanged(evt);
            }
        });
        fontcombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontcomboboxActionPerformed(evt);
            }
        });

        runButton.setText("RUN");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        findfield.setText("Find");

        findButton.setText("Find");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });

        replacefield.setText("Replace");

        replaceButton.setText("Replace");
        replaceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replaceButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Input");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Output");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sizecombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fontcombobox, 0, 84, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(runButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(findfield, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(replacefield)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(replaceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(rTextScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3))
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(findfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(replacefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sizecombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fontcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(runButton)
                            .addComponent(findButton)
                            .addComponent(replaceButton)))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rTextScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)))
        );

        messageArea.setEditable(false);
        messageArea.setColumns(20);
        messageArea.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        messageArea.setRows(5);
        jScrollPane2.setViewportView(messageArea);

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(sendMessageField)
                        .addGap(18, 18, 18)
                        .addComponent(sendButton)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendMessageField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(191, 191, 191))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Thread clientThread1 = new Thread(new Runnable() {                            //connecting to editor area in client
        @Override
        public void run() 
        {
            String messageIn="";
            try
            {
                s=new Socket(ip,port1);
                din=new DataInputStream(s.getInputStream());
                dout=new DataOutputStream(s.getOutputStream());
                while(true)
                {
                    messageIn=din.readUTF();                                       //reading text from editor area
                    setTextinEditor(messageIn);
                }
            }
            catch(Exception e)
            {
                System.out.println("Exception occured:1" + e);
            }
       }
    });
    Thread clientThread2 = new Thread(new Runnable()                              //connection for chating
    {
        @Override
        public void run() 
        {
            String messageIn="";
            try
            {
                s2=new Socket(ip,port2);
                din2=new DataInputStream(s2.getInputStream());
                dout2=new DataOutputStream(s2.getOutputStream());
                while(true)
                {
                    messageIn=din2.readUTF();
                    messageArea.setText( messageIn );
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    });
    Thread SelectedLang = new Thread(new Runnable()                                //changing language selected
    {
        @Override
        public void run() 
        {
            String messageIn="";
            try{
                s3=new Socket(ip,port3);
                din3=new DataInputStream(s3.getInputStream());
                dout3=new DataOutputStream(s3.getOutputStream());
                while(true)
                {
                    messageIn=din3.readUTF();
                    if(messageIn.equals("C++"))
                        jComboBox1.setSelectedIndex(0);
                    else if(messageIn.equals("Java"))
                        jComboBox1.setSelectedIndex(1);
                    else if(messageIn.equals("C"))
                        jComboBox1.setSelectedIndex(2);
                    else if(messageIn.equals("Python"))
                    jComboBox1.setSelectedIndex(3);
                }
            }
            catch(Exception e)
            {
                System.out.println("Exception occured:2" + e);
            }
        }
    });
     
     
    Thread buildOutput=new Thread(new Runnable()                                  //printing output 
    {
        @Override
        public void run() 
        {
            Socket s4=null;
            String outputMessage=null;
            while(true)
            {
                try
                {
                    s4=new Socket(ip, port4);
                    din4=new DataInputStream(s4.getInputStream());
                    dout4=new DataOutputStream(s4.getOutputStream());
                    while(true)
                    {
                        outputMessage=din4.readUTF();
                        outputTextArea.setText(outputMessage);
                    }
                }
                catch(Exception e)
                {
                    try
                    {
                        s4.close();
                    }
                    catch(IOException e1)
                    {
                        System.out.println("Exception e1");
                        e1.printStackTrace();
                    }
                    System.out.println("Exception 21");
                    e.printStackTrace();
                    
                }
            }
            
        }
    });
    Thread sendInput=new Thread(new Runnable()                                    //taking input
    {
        @Override
        public void run() 
        {
            String inputMessage="";
            s5=null;
            boolean processing=true;
            try
            {
                s5=new Socket(ip,port5);
                din5=new DataInputStream(s5.getInputStream());
                dout5=new DataOutputStream(s5.getOutputStream());
                while(processing)
                {
                    inputMessage=din5.readUTF();
                    if(inputMessage.equals("Endthis12"))
                    {
                       System.exit(0);
                    }
                    else
                    {
                        inputTextArea.setText(inputMessage);
                    }
                    
                }
                
            }
            catch(IOException e)
            {
                System.out.println("Error in receiving input Message");
            }
        }
   });
    
    Thread sendImage=new Thread(new Runnable() {                                 
        @Override
        public void run() 
        {
            try
            {
                s6=new Socket(ip, port6);
                din6=new DataInputStream(s6.getInputStream());
                dout6=new DataOutputStream(s6.getOutputStream());
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    });
      
      
    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        String messageOut="",msout="";
        try
        {
            messageOut=messageArea.getText();
            msout = sendMessageField.getText();
            messageOut = messageOut + "\n" + Interviwee2 +" : "+ msout;
            messageArea.setText(messageOut);
            dout2.writeUTF(messageOut);
            dout2.flush(); 
            sendMessageField.setText("");
        }
        catch(Exception e)
        {
            System.out.println("Exception occured :"+ e);
        }
    }//GEN-LAST:event_sendButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
   
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked

    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        JComboBox<String> combo = (JComboBox<String>) evt.getSource();
        String selectedLang = (String) combo.getSelectedItem();
        try
        {
          
            selectedLanguage=selectedLang;
            setSyntax(selectedLanguage);
            dout3.writeUTF(selectedLang);
            dout3.flush();
            new AutoCompleteDemo();
        }
        catch(Exception e)
        {
            System.out.println("Exception occured :" + e);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        try 
        {
            outputTextArea.setText("");
            String outMessage="run12";
            dout4.writeUTF(outMessage);
            dout4.flush();
        } 
        catch (IOException ex) 
        {
           ex.printStackTrace();
        }
    }//GEN-LAST:event_runButtonActionPerformed

    private void editorAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editorAreaKeyReleased
      
           String messageOut="";
            try
            {
                messageOut=editorArea.getText();
                System.out.println(messageOut);
                dout.writeUTF(messageOut);
                dout.flush();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
    }//GEN-LAST:event_editorAreaKeyReleased

    private void fontcomboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontcomboboxActionPerformed
        
    }//GEN-LAST:event_fontcomboboxActionPerformed

    private void sizecomboboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sizecomboboxItemStateChanged
        fontst = fontcombobox.getSelectedIndex();
        fonts = sizecombobox.getSelectedIndex();
        setFont(editorArea, new Font(findstyle(fontst) , Font.PLAIN , findsize(fonts)) );
        SyntaxScheme scheme = editorArea.getSyntaxScheme();
        scheme.getStyle(Token.DATA_TYPE).foreground = Color.blue;
        scheme.getStyle(Token.LITERAL_STRING_DOUBLE_QUOTE).underline = true;
        scheme.getStyle(Token.COMMENT_EOL).font = new Font("Georgia",Font.ITALIC, 12);
    }//GEN-LAST:event_sizecomboboxItemStateChanged

    private void fontcomboboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fontcomboboxItemStateChanged
        fontst = fontcombobox.getSelectedIndex();
        fonts = sizecombobox.getSelectedIndex();
        setFont(editorArea, new Font(findstyle(fontst) , Font.PLAIN , findsize(fonts)) );
        SyntaxScheme scheme = editorArea.getSyntaxScheme();
        scheme.getStyle(Token.DATA_TYPE).foreground = Color.blue;
        scheme.getStyle(Token.LITERAL_STRING_DOUBLE_QUOTE).underline = true;
        scheme.getStyle(Token.COMMENT_EOL).font = new Font("Georgia",Font.ITALIC, 12);
    }//GEN-LAST:event_fontcomboboxItemStateChanged

    private void inputTextAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTextAreaKeyReleased
        String inputOut="";
        try
        {
            inputOut=inputTextArea.getText();
            dout5.writeUTF(inputOut);
            dout5.flush();
        }
        catch(IOException e)
        {
            System.out.println("Error in writing from Input Area");
        }
    }//GEN-LAST:event_inputTextAreaKeyReleased

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
       if(focusCount==0)
        {
            try
            {
                try 
                {
                    Thread.sleep(2000);
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(Client1.class.getName()).log(Level.SEVERE, null, ex);
                }
                Robot robot=new Robot();
                Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
                BufferedImage Image = robot.createScreenCapture(capture); 
                ImageIO.write(Image, "jpg",dout6);
                System.out.println("Screenshot saved"); 
                dout5.writeUTF("ShowImageOfTheScreenShot123");
                s6.close();
                focusCount++;
            }
            catch(AWTException | IOException e)
            {
                e.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_formWindowLostFocus

    private void replaceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replaceButtonActionPerformed
        editorArea.setText(editorArea.getText().replaceAll("\\b"+findfield.getText()+"\\b", replacefield.getText()));
    }//GEN-LAST:event_replaceButtonActionPerformed

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
        String datatext = editorArea.getText().toLowerCase();
        String tofind = findfield.getText().toLowerCase();
        last.clear();
        Object last1;
        int leng = tofind.length();
        int index =0; 
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.cyan);
        Pattern pattern = Pattern.compile( tofind);
        Matcher m = pattern.matcher(datatext);
        while(m.find())
        {
            try 
            {
                last1 = editorArea.getHighlighter().addHighlight(m.start(), m.end(), painter);
                last.add(last1);
            } 
            catch (BadLocationException ex) 
            {
               Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }     
    }//GEN-LAST:event_findButtonActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(sendIdCount==0)
        {
            try
            {
                String toSend="Idis@#" + this.id;
                dout5.writeUTF(toSend);
                setname();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                sendIdCount++;
            }
       }
    }//GEN-LAST:event_formWindowGainedFocus

    private void setTextinEditor(String str)
    {
        editorArea.setText(str);
    }
    private void setSyntax(String language)
    {
        switch(language)
        {
            case "C":
                editorArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_C);
                break;
            case "Java":
                editorArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
                break;
            case "C++":
                editorArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_C);
                break;
            case "Python":
                editorArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON);
                break;
        }
    }
    public static String findstyle(int n)
    {
        switch(n)
        {
            case 0:
                return "Consolas";
            case 1:
                return "Georgia";
            case 2:
                return "Calibri";
            case 3:
                return "Tahoma";
            case 4:
                return "Arial";
            case 5:
                return "Cambria";
            case 6:
                return "Garamond";
            case 7:
                return "Book Antiqua";
            case 8:
                return "Informal Roman";
        }
        return "Arial";
    }
    public static int findsize(int n){
        switch(n){
            case 0:
                return 14;
            case 1:
                return 16;
            case 2:
                return 18;
            case 3:
                return 20;
            case 4:
                return 22;
            case 5:
                return 24;
            case 6:
                return 26;
        }
        return 12;
    }
    public static void setFont(RSyntaxTextArea textArea, Font font) 
    {
        if (font != null) 
        {
            SyntaxScheme ss = textArea.getSyntaxScheme();
            ss = (SyntaxScheme) ss.clone();
            for (int i = 0; i < ss.getStyleCount(); i++) 
            {
                if (ss.getStyle(i) != null) 
                {
                    ss.getStyle(i).font = font;
                }
            }
            textArea.setSyntaxScheme(ss);
            textArea.setFont(font);
        }
    }
    public class AutoCompleteDemo 
    {
        public AutoCompleteDemo()
        {
            setSyntax(selectedLanguage);
            editorArea.setCodeFoldingEnabled(true);
            System.out.println("i an an");
            CompletionProvider provider = CreateCompletionProvider();
            AutoCompletion ac = new AutoCompletion(provider);
            ac.install(editorArea);
        }
    }
    private CompletionProvider CreateCompletionProvider()
    {
        ArrayList<String> arr=new ArrayList<String>();
        Scanner skey = null;
        switch(selectedLanguage)
        {
            case "C++":
            {
                try 
                {
                    skey = new Scanner(new File("keywordcpp.txt"));   
                } 
                catch (FileNotFoundException ex) 
                {
                    Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
                }    
            }
            break;
            case "Java":
            {
                try 
                {
                    skey = new Scanner(new File("keywordjava.txt"));
                } 
                catch (FileNotFoundException ex) 
                {
                    Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
                break;
            case "C":
            {
                try 
                {
                    skey = new Scanner(new File("keywordc.txt"));
                } 
                catch (FileNotFoundException ex)
                {
                    Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
        }
        arr.clear();
        while(skey.hasNext())
        {
            arr.add(skey.next());
        }
        skey.close();
        DefaultCompletionProvider provider= new DefaultCompletionProvider();
        for(String str : arr)
        {
            provider.addCompletion(new BasicCompletion(provider, str));
        }
        
        provider.addCompletion(new ShorthandCompletion(provider, "sysout","System.out.println(", "System.out.println("));
        provider.addCompletion(new ShorthandCompletion(provider, "syserr","System.err.println(", "System.err.println("));
        return provider;
    }
    private void setname()
    {
        try 
        {
            PreparedStatement st;
            ResultSet rs;
            String query1 = "SELECT * FROM info WHERE id=?";
            st = intervieweedata.getConnection().prepareStatement( query1 ) ;
            st.setString(1, this.id );
            rs = st.executeQuery();
            while(rs.next())
            {
                String nameis = rs.getString("name");
                Interviwee2 = nameis;
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    private void startThreads()
    {
        clientThread1.start();
        clientThread2.start();
        SelectedLang.start();
        buildOutput.start();
        sendInput.start();
        sendImage.start();
    }
  /*  public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client1().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.fife.ui.rsyntaxtextarea.RSyntaxTextArea editorArea;
    private javax.swing.JButton findButton;
    private javax.swing.JTextField findfield;
    private javax.swing.JComboBox<String> fontcombobox;
    private javax.swing.JTextArea inputTextArea;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private static javax.swing.JTextArea messageArea;
    private javax.swing.JTextArea outputTextArea;
    private org.fife.ui.rtextarea.RTextScrollPane rTextScrollPane1;
    private javax.swing.JButton replaceButton;
    private javax.swing.JTextField replacefield;
    private javax.swing.JButton runButton;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField sendMessageField;
    private javax.swing.JComboBox<String> sizecombobox;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
