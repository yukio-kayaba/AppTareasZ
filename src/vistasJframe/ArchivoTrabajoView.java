/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistasJframe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vistas.HojaTrabajoArchivo;

/**
 *
 * @author HP
 */
public class ArchivoTrabajoView extends javax.swing.JFrame {
    private ArrayList<HojaTrabajoArchivo> datos;
    
    public ArchivoTrabajoView() {
        this.setUndecorated(true);
        
        initComponents();
        //setResizable(false);
        //setLocationRelativeTo(null);
        this.datos = new ArrayList<>();
        
        
    }
    
    public void addHoja(String direccion,String nombre){
        HojaTrabajoArchivo hojaNueva = new HojaTrabajoArchivo(direccion, nombre,this);
        this.datos.add(hojaNueva);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nombreTarea = new javax.swing.JLabel();
        lblcierre = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(null);

        nombreTarea.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        nombreTarea.setForeground(new java.awt.Color(255, 255, 255));
        nombreTarea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreTarea.setText("HOJA DE TRABAJO DE ARCHIVOS");
        jPanel1.add(nombreTarea);
        nombreTarea.setBounds(110, 0, 330, 40);

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
        lblcierre.setBounds(500, 10, 20, 20);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 40, 530, 10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblcierreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcierreMouseClicked
        // TODO add your handling code here:
        //System.exit(0);
        this.dispose();
    }//GEN-LAST:event_lblcierreMouseClicked

    
    
    public int getCantidadHojas() {
        return this.datos.size();
    }

    

    public void UpdateTablas(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width - 600, 40);
        int x = screenSize.width ;
        int cantidadMax = (screenSize.height / 250);
        if(this.datos.size() > cantidadMax){
            JOptionPane.showMessageDialog(null, "Tienes el limite de hojas en el espacio trabajo");
            return;
        }
        
        int y = (screenSize.height / this.datos.size()) - 60 ;
        this.setSize(523, screenSize.height);
        int y_pos = 60;
        for(HojaTrabajoArchivo hojaAux : this.datos){
            hojaAux.SetPosicionData(500, y, 10, y_pos );
            
            //hojaAux.setComponentZOrder(this, x);
            hojaAux.setVisible(true);
            y_pos +=  10;
            System.out.println(" x :"+ x + " y_pos :"+y_pos + " y:" +y);
            this.add(hojaAux);
            this.setComponentZOrder(hojaAux, 0);
        }
        this.revalidate();
        this.repaint();
    }
    
    private void lblcierreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcierreMouseEntered
        this.lblcierre.setForeground(Color.red);
    }//GEN-LAST:event_lblcierreMouseEntered

    private void lblcierreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcierreMouseExited
        // TODO add your handling code here:
        this.lblcierre.setForeground(new Color(240,192,255));
    }//GEN-LAST:event_lblcierreMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblcierre;
    private javax.swing.JLabel nombreTarea;
    // End of variables declaration//GEN-END:variables
}
