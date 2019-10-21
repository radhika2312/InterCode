
package javaapplication9;


import DataBase.ShowDatabase;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import org.fife.ui.rsyntaxtextarea.*;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.autocomplete.*;

public class Server1 extends javax.swing.JFrame {
    
    
    private static String user="root";
    private static String pass="neeraj@17";
    private static String conn_str="jdbc:mysql://localhost:3306/logininfo2";
    private static String direc;
    private static DataInputStream din1,din2,din3,din4,din5,din6,din7;
    private static DataOutputStream dout1,dout2,dout3,dout4,dout5,dout6,dout7;
    private int port1=5002,port2=5005,port3=5011,port4=5020,port5=5025,port6=6000,port7 = 5030;
    private int cnt=1;
    private String selectedLanguage="C++";
    private static String success="";
    private static String id=null;
    private static int fonts,fontst;
    private int second=0;
    private int minute = 0;
    private boolean state = true;
    private AutoCompleteDemo autocompletetest = null;
    private boolean bclick = true;
    private int index=0;
    private ArrayList<Object> last=new ArrayList<Object>();
    private static String id1 = "";
    
    
    public Server1() throws IOException 
    {
        this.direc = new java.io.File( "." ).getCanonicalPath();
        initComponents();
        this.setVisible(true);
        startThreads();
        setSyntax(selectedLanguage);
        new AutoCompleteDemo();
    
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        addScoreButton = new javax.swing.JButton();
        viewResultButton = new javax.swing.JButton();
        addNoteButton = new javax.swing.JButton();
        endButton = new javax.swing.JButton();
        timer = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        intervieweename = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        rSyntaxTextArea1 = new org.fife.ui.rsyntaxtextarea.RSyntaxTextArea();
        fontcombobox = new javax.swing.JComboBox<>();
        sizecombobox = new javax.swing.JComboBox<>();
        ComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        rTextScrollPane1 = new org.fife.ui.rtextarea.RTextScrollPane(rSyntaxTextArea1);
        jScrollPane3 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputTextArea = new javax.swing.JTextArea();
        jButton7 = new javax.swing.JButton();
        replacefield = new javax.swing.JTextField();
        findfield = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));

        TextArea1.setEditable(false);
        TextArea1.setColumns(20);
        TextArea1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        TextArea1.setRows(5);
        TextArea1.setTabSize(10);
        jScrollPane2.setViewportView(TextArea1);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        addScoreButton.setText("Add Score");
        addScoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addScoreButtonActionPerformed(evt);
            }
        });

        viewResultButton.setText("View Result");
        viewResultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewResultButtonActionPerformed(evt);
            }
        });

        addNoteButton.setText("Add Note");
        addNoteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNoteButtonActionPerformed(evt);
            }
        });

        endButton.setText("End this Interview");
        endButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endButtonActionPerformed(evt);
            }
        });

        timer.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        timer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        timer.setText("00:00");
        timer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timerActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Start");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("INTERVIEWEE : ");

        intervieweename.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        intervieweename.setText("name");

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("Stop");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(timer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addScoreButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewResultButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addNoteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(intervieweename, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                        .addGap(152, 152, 152))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(intervieweename, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addScoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewResultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addNoteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(endButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );

        rSyntaxTextArea1.setColumns(20);
        rSyntaxTextArea1.setRows(10);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, rTextScrollPane1, org.jdesktop.beansbinding.ELProperty.create("${alignmentX}"), rSyntaxTextArea1, org.jdesktop.beansbinding.BeanProperty.create("alignmentX"));
        bindingGroup.addBinding(binding);

        rSyntaxTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rSyntaxTextArea1KeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(rSyntaxTextArea1);

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

        sizecombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "14", "16", "18", "20", "22", "24", "26" }));
        sizecombobox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sizecomboboxItemStateChanged(evt);
            }
        });
        sizecombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizecomboboxActionPerformed(evt);
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

        jLabel1.setText("Server");

        jButton2.setText("Run");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        outputTextArea.setEditable(false);
        outputTextArea.setColumns(20);
        outputTextArea.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        outputTextArea.setRows(5);
        jScrollPane3.setViewportView(outputTextArea);

        inputTextArea.setColumns(20);
        inputTextArea.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        inputTextArea.setRows(5);
        inputTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputTextAreaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(inputTextArea);

        jButton7.setText("Replace");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        replacefield.setText("Replace");

        findfield.setText("Find");

        jButton6.setText("Find");
        jButton6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jButton6FocusLost(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sizecombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fontcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(findfield)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(replacefield)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(rTextScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)))
                        .addGap(2, 2, 2)))
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sizecombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fontcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(findfield, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(replacefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton7)
                        .addComponent(jButton2)))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rTextScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Thread serverThread1 = new Thread(new Runnable() 
    {
        @Override
        public void run() 
        {
           ServerSocket ss1 = null;
           String msin = "";
           while(true)
           {
              try
              {
                  ss1 = new ServerSocket(port1);
                  Socket s1 = ss1.accept();
                  System.out.println("connection established");
                  din1 = new DataInputStream(s1.getInputStream());
                  dout1 = new DataOutputStream(s1.getOutputStream());
                  while(true)
                  {
                      msin = din1.readUTF();
                      setTextinEditor(msin);
                  }
                  
              } 
              catch (IOException e)
              {
                    try
                    {
                         ss1.close();
                    }
                    catch(IOException e1)
                    {
                      System.out.println("exception 1");
                      e1.printStackTrace();
                    }
                  System.out.println("exception 2");
                  e.printStackTrace();
              }
           }
           
        }
    });
    Thread serverThread2 = new Thread(new Runnable() 
    {
        @Override
        public void run() 
        {
            ServerSocket ss2 = null;
             String msin = "";
            while(true)
            {
                try
                {
                    ss2 = new ServerSocket(port2);
                    Socket s2 = ss2.accept();
                    System.out.println("connection established");
                    din2 = new DataInputStream(s2.getInputStream());
                    dout2 = new DataOutputStream(s2.getOutputStream());
                    while(true)
                    {
                        msin = din2.readUTF();
                        TextArea1.setText(msin);
                    }
                  
                } 
                catch (IOException e)
                {
                  try{
                      ss2.close();
                  }
                  catch(IOException e1)
                  {
                      System.out.println("exception 11");
                      e1.printStackTrace();
                  }
                  System.out.println("exception 21");
                  e.printStackTrace();
              }
           }
           
        }
    });
    Thread SelectedLang = new Thread(new Runnable() 
    {
        
        @Override
        public void run() 
        {
            String msin3="";
            ServerSocket ss3 = null;
          
            while(true)
            {
                try
                {
                    ss3 = new ServerSocket(port3);
                    Socket s3 = ss3.accept();
                    System.out.println("connection established");
                    din3 = new DataInputStream(s3.getInputStream());
                    dout3 = new DataOutputStream(s3.getOutputStream());
                    while(true)
                    {
                        msin3 = din3.readUTF();
                        System.out.println(msin3);
                        if(msin3.equals("C++"))
                             ComboBox1.setSelectedIndex(0);
                         else if(msin3.equals("Java"))
                            ComboBox1.setSelectedIndex(1);
                        else if(msin3.equals("C"))
                            ComboBox1.setSelectedIndex(2);
                        else if(msin3.equals("Python"))
                            ComboBox1.setSelectedIndex(3);
                    }
                  
                } 
                catch (IOException e)
                {
                    try
                    {
                      ss3.close();
                    }
                    catch(IOException e1)
                    {
                        System.out.println("exception 11");
                        e1.printStackTrace();
                    }
                    System.out.println("exception 21");
                    e.printStackTrace();
                }
           }
           
        }
    });
    Thread buildOutput=new Thread(new Runnable() 
    {
        @Override
        public void run() 
        {
            ServerSocket ss4=null;
            String outputMessage=null;
            while(true)
            {
                try{
                    ss4=new ServerSocket(port4);
                    Socket s4=ss4.accept();
                   // System.out.println("Connection established in output");
                    din4=new DataInputStream(s4.getInputStream());
                    dout4=new DataOutputStream(s4.getOutputStream());
                    while(true){
                        outputMessage=din4.readUTF();
                        if(outputMessage.equals("run12"))
                            runningoutput();
                       
                                }
                    
                    }
                catch(Exception e)
                {
                    try{
                        ss4.close();
                        
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
    Thread sendInput=new Thread(new Runnable() 
    {
        @Override
        public void run() 
        {
            
            ServerSocket ss5=null; 
            while(true)
            { 
                try 
                {
                    ss5=new ServerSocket(port5);
                    Socket s5=ss5.accept();
                    System.out.println("Connection established in SendInput Thread");
                    din5=new DataInputStream(s5.getInputStream());
                    dout5=new DataOutputStream(s5.getOutputStream());
                    String input=null;
                    while(true)
                    {
                        input=din5.readUTF();
                        if(input.contains("Idis@#"))
                        {
                            int tempCount=0;
                            for(String line:input.split("@#"))
                            {
                                if(tempCount==1)
                                {
                                    id1 = line;
                                    setname();
                                }
                                tempCount++;
                            }
                        }
                        else if(input.equals("ShowImageOfTheScreenShot123"))
                        {
                            showScreenshot();
                            endInterview();
                        }
                        else 
                        {
                            inputTextArea.setText(input);
                        }
                        
                    }
                } 
                catch (IOException ex) 
                {
                    try 
                    {
                      ss5.close();
                    }   
                    catch (IOException ex1) 
                    {
                      Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    });
    Thread receiveImage=new Thread(new Runnable() 
    {
        @Override
        public void run() 
        {
            ServerSocket ss6=null;
            Socket s6=null;
            try
            {
                ss6=new ServerSocket(port6);
                s6=ss6.accept();
                System.out.println("COnnection in Server");
                din6=new DataInputStream(s6.getInputStream());
                dout6=new DataOutputStream(s6.getOutputStream());
                File output=new File(direc + "\\image2.jpg");
                BufferedImage img=ImageIO.read(ImageIO.createImageInputStream(s6.getInputStream()));
                ImageIO.write(img ,"jpg", output);
                System.out.println("Screenshot saved");
              
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            
        }
    });
    private String Che = "";
    Thread logincheck=new Thread(new Runnable() 
    {
        @Override
        public void run() 
        {
            ServerSocket ss7=null;
            Socket s7=null;
            String uname="";
            String pass="";
             
            while(true){
            try
            {
           
                ss7=new ServerSocket(port7);
                s7=ss7.accept();
                
                System.out.println("Connection in Server");
                din7=new DataInputStream(s7.getInputStream());
                dout7=new DataOutputStream(s7.getOutputStream());
              while(true)
              {
                uname = din7.readUTF();
                pass = din7.readUTF();
                PreparedStatement st;
                ResultSet rs;
                String query = "SELECT * FROM info WHERE id=? AND pass=? ";
              try{
                st = intervieweedata.getConnection().prepareStatement(query);
                st.setString(1, uname);
                st.setString(2, pass);
                rs = st.executeQuery();
                if(rs.next())
                {
                    dout7.writeUTF("valid");
                    break;
                    
                }
                else
                {
                    dout7.writeUTF("invalid");
                }
            }catch(Exception e)
                {
                System.out.println("Exception :" + e);
                }
            }
              
            }
            catch(Exception e)
            {
                    try{
                        ss7.close();
                        
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
    
    private Connection getConnection(){
        Connection connection=null;
        PreparedStatement ps=null;
       
          try{
            connection=DriverManager.getConnection(conn_str,user,pass);
          }
          catch(SQLException e){
              e.printStackTrace();
          }
        return connection;
    }
    public class AutoCompleteDemo {
        public AutoCompleteDemo(){
            setSyntax(selectedLanguage);
            rSyntaxTextArea1.setCodeFoldingEnabled(true);
            CompletionProvider provider = CreateCompletionProvider();
            AutoCompletion ac = new AutoCompletion(provider);
            ac.install(rSyntaxTextArea1);
        }
    }
    private CompletionProvider CreateCompletionProvider(){
        
        ArrayList<String> arr=new ArrayList<String>();
        Scanner skey = null;
        switch(selectedLanguage){
            case "C++":
            {
            try {
                skey = new Scanner(new File("keywordcpp.txt"));   
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
            }    
            }
            break;
            case "Java":
                {
            try {
                 skey = new Scanner(new File("keywordjava.txt"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
            }   
            }
                break;
            case "C":
                {
            try {
                 skey = new Scanner(new File("keywordc.txt"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
                break;
        }
        arr.clear();
        //System.out.println("i was here");
         while(skey.hasNext()){
               arr.add(skey.next());
            }
         skey.close();
        DefaultCompletionProvider provider= new DefaultCompletionProvider();
        for(String str : arr)
        {provider.addCompletion(new BasicCompletion(provider, str));
           // System.out.println(str);
        }
        
       provider.addCompletion(new ShorthandCompletion(provider, "sysout",
            "System.out.println(", "System.out.println("));
      provider.addCompletion(new ShorthandCompletion(provider, "syserr",
            "System.err.println(", "System.err.println("));
       return provider;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String msouta = "",msoutf="";
        try{
            msouta = TextArea1.getText();
            msoutf = jTextField1.getText();
            msouta = msouta + "\n" +"Interviewer:" + msoutf;
            TextArea1.setText(msouta);
            jTextField1.setText("");
            dout2.writeUTF(msouta);
            
            dout2.flush();
            
            
        }
        catch(Exception e){
            System.out.println("exception in output");
            System.out.println("exception occured :" + e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
                  
    }//GEN-LAST:event_jTextField1ActionPerformed

                              
    private void ComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox1ActionPerformed
     
    }//GEN-LAST:event_ComboBox1ActionPerformed

    private void ComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBox1MouseClicked
  
    }//GEN-LAST:event_ComboBox1MouseClicked

    private void ComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBox1ItemStateChanged
        JComboBox<String> combo = (JComboBox<String>) evt.getSource();
        String selectedLang = (String) combo.getSelectedItem();
        try{
            rSyntaxTextArea1.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_C);
            selectedLanguage=selectedLang;
            setSyntax(selectedLanguage);
           // System.out.println("tested here 2");
            new AutoCompleteDemo();
            dout3.writeUTF(selectedLang);
            dout3.flush();
           // System.out.println(selectedLang);
        }
        catch(Exception e){
            System.out.println("Exception occured :" + e);
        }
    }//GEN-LAST:event_ComboBox1ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try 
        {
            saveInput();
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
            }
            runningoutput();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void saveInput()
    {
        File file=new File(this.direc + "\\input.txt");
        FileOutputStream fout=null;
        BufferedWriter bw=null;
        try
        {
            fout=new FileOutputStream(file);
            bw=new BufferedWriter(new OutputStreamWriter(fout));
            for(String line:inputTextArea.getText().split(" |\\n"))
            {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            fout.close();
            
        }
        catch(Exception e)
        {
            System.out.println("ksdjksdjfkds");
        }
    }
    private void rSyntaxTextArea1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rSyntaxTextArea1KeyReleased
            
           String messageOut="";
        try{
            messageOut=rSyntaxTextArea1.getText();
            //System.out.println(messageOut);
            dout1.writeUTF(messageOut);
            dout1.flush();
        }
        catch(Exception e){
           // System.out.println("exception sdasdasd1");
            System.out.println("exception occured :" + e);
        }
        
        
        
        
    }//GEN-LAST:event_rSyntaxTextArea1KeyReleased

    private void addNoteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNoteButtonActionPerformed
         new addNoteForm(this.id1,user,pass,conn_str).setVisible(true);
    }//GEN-LAST:event_addNoteButtonActionPerformed

    private void addScoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addScoreButtonActionPerformed
       
        new addScore(this.id1, user, pass, conn_str).setVisible(true);
        
    }//GEN-LAST:event_addScoreButtonActionPerformed

    private void sizecomboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizecomboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizecomboboxActionPerformed

    private void sizecomboboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sizecomboboxItemStateChanged
                 fontst = fontcombobox.getSelectedIndex();
                 fonts = sizecombobox.getSelectedIndex();
                 setFont(rSyntaxTextArea1, new Font(findstyle(fontst) , Font.PLAIN , findsize(fonts)) );
                 SyntaxScheme scheme = rSyntaxTextArea1.getSyntaxScheme();
      //scheme.getStyle(Token.RESERVED_WORD).background = Color.pink;
      scheme.getStyle(Token.DATA_TYPE).foreground = Color.blue;
      scheme.getStyle(Token.LITERAL_STRING_DOUBLE_QUOTE).underline = true;
      scheme.getStyle(Token.COMMENT_EOL).font = new Font("Georgia",
            Font.ITALIC, 12);

     rSyntaxTextArea1.revalidate();
    }//GEN-LAST:event_sizecomboboxItemStateChanged

    private void fontcomboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontcomboboxActionPerformed
      
    }//GEN-LAST:event_fontcomboboxActionPerformed

    private void fontcomboboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fontcomboboxItemStateChanged
        fontst = fontcombobox.getSelectedIndex();
                 fonts = sizecombobox.getSelectedIndex();
                 setFont(rSyntaxTextArea1, new Font(findstyle(fontst) , Font.PLAIN , findsize(fonts)) );
                 SyntaxScheme scheme = rSyntaxTextArea1.getSyntaxScheme();
     // scheme.getStyle(Token.RESERVED_WORD).background = Color.pink;
      scheme.getStyle(Token.DATA_TYPE).foreground = Color.blue;
      scheme.getStyle(Token.LITERAL_STRING_DOUBLE_QUOTE).underline = true;
      scheme.getStyle(Token.COMMENT_EOL).font = new Font("Georgia",
            Font.ITALIC, 12);
    }//GEN-LAST:event_fontcomboboxItemStateChanged

    private void timerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timerActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     if(bclick == true){
         bclick = false;
        state = true;
           Thread t = new Thread(){
               public void run(){
                   while(true){
                       if(state==true){
                           try{
                               sleep(1000);
                               if(second > 58){
                                   minute += 1;
                                   second=-1;
                               }
                               second +=1;
                               timer.setText(minute +" : " +second);
                           }
                           catch(Exception e){
                               
                           }
                       }
                       else 
                           break;
                   }
               }
           };
           t.start();
     }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        state = false;
        bclick = true;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        state = false;
        bclick = true;
        timer.setText("00:00");
        minute = 0;
        second = 0;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
          String datatext = rSyntaxTextArea1.getText().toLowerCase();
            String tofind = findfield.getText().toLowerCase();
          
           last.clear();
            Object last1;
            int leng = tofind.length();
            int index =0; 
            Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.cyan);
           
                Pattern pattern = Pattern.compile( tofind);
                Matcher m = pattern.matcher(datatext);
            
            while(m.find()){
            try {
                last1 = rSyntaxTextArea1.getHighlighter().addHighlight(m.start(), m.end(), painter);
               last.add(last1);
               
            } catch (BadLocationException ex) {
                   Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
                   }
            }     
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

       rSyntaxTextArea1.setText(rSyntaxTextArea1.getText().replaceAll("\\b"+findfield.getText()+"\\b", replacefield.getText()));
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton6FocusLost
        if(!last.isEmpty()){
            for(Object last1:last)
              rSyntaxTextArea1.getHighlighter().removeHighlight(last1);
        }
    }//GEN-LAST:event_jButton6FocusLost

    private void inputTextAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTextAreaKeyReleased
        String inputOut=null;
        try{
            inputOut=inputTextArea.getText();
            dout5.writeUTF(inputOut);
            dout5.flush();
        }
        catch(Exception e)
        {
            System.out.println("Error in receiving in Input Area");
        }
    }//GEN-LAST:event_inputTextAreaKeyReleased

    private void viewResultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewResultButtonActionPerformed
         new ShowDatabase(user, pass, conn_str).setVisible(true);
    }//GEN-LAST:event_viewResultButtonActionPerformed

    private void endButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endButtonActionPerformed
           endInterview();
           setclear();
    }//GEN-LAST:event_endButtonActionPerformed
    private void runningoutput() throws IOException{
        FileWriter fileWriter=null;
        outputTextArea.setText("");
        File file=null;
        switch(selectedLanguage){
            case "C++":
            {
                file=new File( direc+"\\testcpp.cpp");
                break;
            }
            case "Java":
            {
                file=new File( direc+"\\testjava.java");
                break;
            }
            case "C":
            {
                file=new File( direc+"\\testc.c");
                break;
            }
            
                
        }
        try{
            fileWriter=new FileWriter(file);
            fileWriter.write(rSyntaxTextArea1.getText());
            fileWriter.close();
        }
        catch(Exception e){
            System.out.println("Exception in writing file");
            e.printStackTrace();
        }
       success = new CheckOutput(selectedLanguage).checkOutput();
        System.out.println("Result of output is " + success);
        Thread t2=Thread.currentThread();
        try{
            t2.sleep(1000);
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
            if(success == "CompileSuccessful"){
              reader=new BufferedReader(new FileReader(direc+"\\output.txt"));
              line=reader.readLine();
              while(line!=null){
                  toDisplay=outputTextArea.getText() + "\n" + line;
                  outputTextArea.setText(toDisplay);
                   line=reader.readLine();
                }
            }
            else{
                outputTextArea.setText(success);
            }
              try{
                  String tocl= outputTextArea.getText();
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
   
    private void setSyntax(String language){
        switch(language){
            case "C":
                rSyntaxTextArea1.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_C);
                break;
            case "Java":
                rSyntaxTextArea1.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
                break;
            case "C++":
                rSyntaxTextArea1.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_C);
                break;
            case "Python":
                rSyntaxTextArea1.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON);
                break;
        }
    }
    
    private void setTextinEditor(String str){
        rSyntaxTextArea1.setText(str);
    }
    public static String findstyle(int n){
        switch(n){
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
    public static void setFont(RSyntaxTextArea textArea, Font font) {
      if (font != null) {
         SyntaxScheme ss = textArea.getSyntaxScheme();
         ss = (SyntaxScheme) ss.clone();
         for (int i = 0; i < ss.getStyleCount(); i++) {
            if (ss.getStyle(i) != null) {
               ss.getStyle(i).font = font;
            }
         }
         textArea.setSyntaxScheme(ss);
         textArea.setFont(font);
      }
   }
    private void startThreads()
    {
        logincheck.start();
        serverThread1.start();
        serverThread2.start();
        SelectedLang.start();
        buildOutput.start();
        sendInput.start();
        receiveImage.start();
        
    }
    private void setname(){
        try {
            PreparedStatement st;
            ResultSet rs;
            String query1 = "SELECT * FROM info WHERE id=?";
            st = intervieweedata.getConnection().prepareStatement( query1 ) ;
            st.setString(1, this.id1 );
            rs = st.executeQuery();
            while(rs.next())
            {String nameis = rs.getString("name");
            System.out.println(nameis);
            intervieweename.setText(nameis);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    private void showScreenshot()
    {
        new asktoDisplay().setVisible(true);
    }
    private void setclear(){
        rSyntaxTextArea1.setText(" ");
        inputTextArea.setText(" ");
        outputTextArea.setText(" ");
        TextArea1.setText(" ");
        timer.setText("00:00");
        
    }
    private void endInterview()
    {
        try 
        {
            dout5.writeUTF("Endthis12");
        }
        catch (IOException ex) 
        {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
   /* public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Loginform.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Loginform.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Loginform.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Loginform.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                try {
                    new Server1().setVisible(true);
                  
                } catch (IOException ex) {
                    Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }*/
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox1;
    private static javax.swing.JTextArea TextArea1;
    private javax.swing.JButton addNoteButton;
    private javax.swing.JButton addScoreButton;
    private javax.swing.JButton endButton;
    private javax.swing.JTextField findfield;
    private javax.swing.JComboBox<String> fontcombobox;
    private javax.swing.JTextArea inputTextArea;
    private javax.swing.JLabel intervieweename;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea outputTextArea;
    private org.fife.ui.rsyntaxtextarea.RSyntaxTextArea rSyntaxTextArea1;
    private org.fife.ui.rtextarea.RTextScrollPane rTextScrollPane1;
    private javax.swing.JTextField replacefield;
    private javax.swing.JComboBox<String> sizecombobox;
    private javax.swing.JTextField timer;
    private javax.swing.JButton viewResultButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
