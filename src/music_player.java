
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Music_player extends javax.swing.JFrame {
    
    String selection_ringtone, name_music;
    FileInputStream fileInputStream;
    BufferedInputStream bufferedInputStream;
    Player player;
    long all;
    long pouse;
    
    public Music_player() {
        initComponents();
        
        play_button.setVisible(false);
        stop_button.setVisible(false);
        reset_button.setVisible(false);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons8-play-32.png"));
        setIconImage(icon.getImage());
        
    }

    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        stop_button = new javax.swing.JToggleButton();
        choose_song_button = new javax.swing.JToggleButton();
        play_button = new javax.swing.JToggleButton();
        reset_button = new javax.swing.JToggleButton();
        name_music_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Beat Drop Music Player");
        setBackground(new java.awt.Color(26, 26, 26));
        setPreferredSize(new java.awt.Dimension(360, 150));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(26, 26, 26));

        stop_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-pause-50.png"))); 
        stop_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stop_buttonActionPerformed(evt);
            }
        });

        choose_song_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-plus-24.png")));
        choose_song_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choose_song_buttonActionPerformed(evt);
            }
        });

        play_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-play-32.png"))); 
        play_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                play_buttonActionPerformed(evt);
            }
        });

        reset_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-play-32.png"))); 
        reset_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_buttonActionPerformed(evt);
            }
        });

        name_music_label.setForeground(new java.awt.Color(200, 200, 200));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(choose_song_button, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(reset_button, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(play_button, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stop_button, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(name_music_label, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(play_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stop_button, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(49, 49, 49)
                        .addComponent(name_music_label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(choose_song_button)
                            .addComponent(reset_button, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(191, Short.MAX_VALUE))
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
    }

    private void stop_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (player != null){

            try {
                pouse = fileInputStream.available();
                System.out.println(pouse);
                player.close();
            } catch (IOException ex) {
                Logger.getLogger(music_player.class.getName()).log(Level.SEVERE, null, ex);
            }

            
        }
    }

    private void choose_song_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        
        System.out.println(selection_ringtone);

        JFileChooser jfc = new JFileChooser();
        int selection_ringtone_int = jfc.showOpenDialog(null); 
        
       if (selection_ringtone_int==JFileChooser.APPROVE_OPTION) {
        File ringtone = jfc.getSelectedFile();
        
        selection_ringtone = ringtone.getAbsolutePath();
        name_music = jfc.getSelectedFile().getName();

        System.out.println(name_music);  
        name_music_label.setText(name_music);
        
        reset_button.setVisible(true);

       } else if (selection_ringtone_int==JFileChooser.CANCEL_OPTION) {
           JOptionPane.showMessageDialog(null, "You didn't choose ringtone");
       }
       
        if (!selection_ringtone.equals(null)){
            try {
                playing_ringtone();
                player.close();
            } catch (IOException ex) {
                Logger.getLogger(music_player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
       
        if (!selection_ringtone.equals(null)){
            name_music_label.setText(name_music);
            
        }
        
        
    }

    private synchronized void play_buttonActionPerformed(java.awt.event.ActionEvent evt) {
            
        try {
            fileInputStream = new FileInputStream(new File(selection_ringtone));
             bufferedInputStream = new BufferedInputStream(fileInputStream);
             player = new Player(bufferedInputStream);
             fileInputStream.skip(all -pouse);
             
             
                     new Thread(){
            
            public void run(){
                try {
                    player.play();
                } catch (JavaLayerException ex) {
                    Logger.getLogger(music_player.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }   
        }.start();
                     
        } catch (FileNotFoundException ex) {
            Logger.getLogger(music_player.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(music_player.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JavaLayerException ex) {
            Logger.getLogger(music_player.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    private void reset_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (selection_ringtone == null){
             try {
                play_button.setVisible(true);
                stop_button.setVisible(true);
                player.close();
                playing_ringtone();
                reset_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons8-reset-24.png")));
            } catch (IOException ex) {
                Logger.getLogger(music_player.class.getName()).log(Level.SEVERE, null, ex);
            }
            
       
            } else {
                name_music_label.setText(name_music);
                play_button.setVisible(true);
                stop_button.setVisible(true);
                reset_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons8-reset-24.png")));
                        try {
                            player.close();
                            playing_ringtone();
                       
                        } catch (IOException ex) {
                            Logger.getLogger(music_player.class.getName()).log(Level.SEVERE, null, ex);
                        }
            }
                    
       
        
    }

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(music_player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(music_player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(music_player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(music_player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new music_player().setVisible(true);
            }
        });
    }
    
        public synchronized void playing_ringtone() throws IOException{

        try {
            fileInputStream = new FileInputStream(new File(selection_ringtone));
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            player = new Player(bufferedInputStream);
            all = fileInputStream.available();

            new Thread(){
            public void run(){
                try {
                   
                    player.play();
                } catch (JavaLayerException ex) {
                    Logger.getLogger(music_player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }.start();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(music_player.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JavaLayerException ex) {
            Logger.getLogger(music_player.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
        
    
    private javax.swing.JToggleButton choose_song_button;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel name_music_label;
    private javax.swing.JToggleButton play_button;
    private javax.swing.JToggleButton reset_button;
    private javax.swing.JToggleButton stop_button;
}
