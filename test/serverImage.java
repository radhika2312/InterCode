
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;



public class serverImage extends javax.swing.JFrame {
    private int port6=6000;
    private DataInputStream din6;
    private DataOutputStream dout6;
    private String direc=null;
    public serverImage() throws IOException {
        initComponents();
        this.direc= new java.io.File( "." ).getCanonicalPath();
        receiveImage.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    Thread receiveImage=new Thread(new Runnable() {
        @Override
        public void run() 
        {
            ServerSocket ss=null;
            Socket s=null;
            try
            {
                ss=new ServerSocket(port6);
                s=ss.accept();
                System.out.println("COnnection in Server");
                din6=new DataInputStream(s.getInputStream());
                dout6=new DataOutputStream(s.getOutputStream());
                while(true)
                {
                    File output=new File(direc + "\\image2.jpg");
                    BufferedImage img=ImageIO.read(ImageIO.createImageInputStream(s.getInputStream()));
                ImageIO.write(img ,"jpg", output);
                System.out.println("Screenshot saved");
                }
                
                
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            
        }
    });
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new serverImage().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(serverImage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
