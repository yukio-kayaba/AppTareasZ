/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import java.awt.Color;
import vistasJframe.ArchivoTrabajoView;

/**
 *
 * @author HP
 */
public class HojaTrabajoArchivo extends javax.swing.JPanel {
    
    private String direccion;
    private String nombre;
    private ArchivoTrabajoView padreComponente;
    
    public HojaTrabajoArchivo( String direccion,String nombre ,ArchivoTrabajoView padreComponente){
        iniciar();
        this.direccion = direccion;
        this.nombre = nombre;
        this.padreComponente = padreComponente;
    }

    public void iniciar(){
        initComponents();
    }
    public void SetPosicionData(int width,int height,int x,int y){
        this.setSize(width, height);
        this.setLocation(x, y);
        this.jTextArea1.setSize( width - 10 * 2, height - 10);
        this.jTextArea1.setLocation(10, 75);
        //this.revalidate();
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        tituloHoja = new javax.swing.JLabel();
        lblcierre = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 60, 480, 480);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 30, 500, 10);

        tituloHoja.setForeground(new java.awt.Color(255, 255, 255));
        tituloHoja.setText("jLabel1");
        jPanel1.add(tituloHoja);
        tituloHoja.setBounds(10, 0, 440, 30);

        lblcierre.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        lblcierre.setForeground(new java.awt.Color(240, 192, 255));
        lblcierre.setText("X");
        lblcierre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblcierre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcierreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblcierreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblcierreMouseExited(evt);
            }
        });
        jPanel1.add(lblcierre);
        lblcierre.setBounds(475, 5, 20, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblcierreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcierreMouseClicked
        // TODO add your handling code here:
        //System.exit(0);
        this.setVisible(false);
    }//GEN-LAST:event_lblcierreMouseClicked

    private void lblcierreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcierreMouseEntered
        this.lblcierre.setForeground(Color.red);
    }//GEN-LAST:event_lblcierreMouseEntered

    private void lblcierreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcierreMouseExited
        // TODO add your handling code here:
        this.lblcierre.setForeground(new Color(240,192,255));
    }//GEN-LAST:event_lblcierreMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblcierre;
    private javax.swing.JLabel tituloHoja;
    // End of variables declaration//GEN-END:variables
}
