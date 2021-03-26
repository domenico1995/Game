package com.client;

import java.awt.event.KeyEvent;
import com.client.dati.testi;
import com.client.service.service;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class terminal extends javax.swing.JFrame{

    public String testo_display, risposta, percorso = "", comando = "";

    public Engine en;

    public service ser;

    public terminal() throws IOException {
        initComponents();
        init();
    }

    private void init() throws IOException {

        jScrollPane1.setBorder(null);
        setResizable(false);
        en = new Engine();
        ser = new service();
        percorso = ser.terminal("cd") + "> ";
        textArea1.setText(testi.testo_introduttivo.testo() + percorso);
        testo_display = en.getTesto_display();
        testo_display = textArea1.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textArea1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(textArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textArea1KeyPressed

        testo_display = textArea1.getText();
        risposta = en.getRisposta();

        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                if (!"".equals(testo_display)) {
                    try {
                        if (!"".equals(comando)) {
                            en.getWord(testo_display, comando, percorso);
                            testo_display = en.getTesto_display();
                            risposta = en.getRisposta();
                            if (!"".equals(risposta)) {
                                textArea1.append(testo_display + "\n" + risposta + "\n" + percorso);
                            } else {
                                textArea1.append(testo_display + "\n" + percorso);
                            }
                            comando = "";
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(terminal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

            case KeyEvent.VK_BACK_SPACE:
                //correggere difetto cancellazione
                if (!"".equals(comando)) {
                    testo_display = ser.cancella_ultimo(testo_display);
                    comando = ser.cancella_ultimo(comando);
                    textArea1.setText(testo_display);
                } else {
                }
                break;
            default:
                char c = evt.getKeyChar();
                if (Character.isLetter(c) || Character.isWhitespace(c) || c == '.' || c == ';') {
                    comando = comando + c;
                }
                break;
        }
    }//GEN-LAST:event_textArea1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(terminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new terminal().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(terminal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
