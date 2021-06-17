package com.gioco;

import com.gioco.service.Service;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gioco extends javax.swing.JFrame {

    private Service ser;
    private String testo;
    private Engine en;
    private String testo_display;

    public Gioco() {
        initComponents();
        init();
    }

    private void init() {
        ser = new Service();
        jScrollPane1.setBorder(null);
        textArea1.setEditable(false);
        try {
            en = new Engine();
        } catch (InterruptedException ex) {
            Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
        }
        textArea1.append(en.getTesto_display());
        //time.schedule(new UpdateTime(), 0, 1000);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea1 = new javax.swing.JTextArea();
        textField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 370));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        textArea1.setBackground(new java.awt.Color(0, 0, 0));
        textArea1.setColumns(20);
        textArea1.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        textArea1.setForeground(new java.awt.Color(255, 255, 255));
        textArea1.setRows(5);
        textArea1.setBorder(null);
        textArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textArea1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(textArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        textField1.setBackground(new java.awt.Color(40, 40, 40));
        textField1.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        textField1.setForeground(new java.awt.Color(255, 255, 255));
        textField1.setBorder(null);
        textField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
            .addComponent(textField1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textArea1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textArea1KeyReleased

        testo = textField1.getText();
        testo_display = en.getTesto_display();
        
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                
                if (!"".equals(testo)) {
                    textField1.setText("");
                    try {
                        en.getWord(testo, testo_display, textArea1, textField1);
                    } catch (SQLException | IOException | InterruptedException ex) {
                        Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    testo = en.getTesto();
                    testo_display = en.getTesto_display();

                    if ("".equals(testo)) {
                        textArea1.append(testo_display);
                    } else {
                        textArea1.append(testo + "\n" + testo_display);
                    }
                }
                
                break;
            case KeyEvent.VK_BACK_SPACE:
                testo = ser.cancella_ultimo(testo);
                textField1.setText(testo);
                break;
            default:
                char c = evt.getKeyChar();
                if (Character.isLetter(c) || Character.isWhitespace(c) || c == '/' || c =='.') {
                    testo = testo + c;
                    textField1.setText(testo);
                }
                break;
        }
    }//GEN-LAST:event_textArea1KeyReleased

    private void textField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField1KeyReleased

        testo = textField1.getText();
        testo_display = en.getTesto_display();

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            textField1.setText("");
            try {
                en.getWord(testo, testo_display, textArea1, textField1);
            } catch (SQLException | IOException | InterruptedException ex) {
                Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
            }
            testo_display = en.getTesto_display();
            textArea1.append(testo + "\n" + testo_display);
        }
    }//GEN-LAST:event_textField1KeyReleased

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String args[]) throws SQLException {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Gioco().setVisible(true);
        });

    }

    /*private class UpdateTime extends TimerTask {
        int second = 0;
        @Override
        public void run() {
            EventQueue.invokeLater(() -> {
                //textField2.setText(String.valueOf(1000 - second++));
            });
        }
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea1;
    private javax.swing.JTextField textField1;
    // End of variables declaration//GEN-END:variables
}
