
package vistas;

import modelo.ArchivosDatos;
import modelo.Configuraciones;


public class LogoPrincipal extends javax.swing.JFrame {
    private CuadroTareas cuadroTareas;
    private ArchivosDatos valores;
    public LogoPrincipal(ArchivosDatos informacion) {
        init();
        this.valores = informacion;
        this.cuadroTareas = new CuadroTareas(this.valores);
    }
    
    private void init(){
        this.setUndecorated(true);
        initComponents();
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setBackground( Configuraciones.fondoPrincipal);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JLabelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        JLabelPrincipal.setBackground(new java.awt.Color(1, 6, 82));
        JLabelPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JLabelPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLabelPrincipalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JLabelPrincipalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JLabelPrincipalMouseExited(evt);
            }
        });

        javax.swing.GroupLayout JLabelPrincipalLayout = new javax.swing.GroupLayout(JLabelPrincipal);
        JLabelPrincipal.setLayout(JLabelPrincipalLayout);
        JLabelPrincipalLayout.setHorizontalGroup(
            JLabelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );
        JLabelPrincipalLayout.setVerticalGroup(
            JLabelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JLabelPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabelPrincipalMouseClicked
        this.cuadroTareas.setVisible(true);
        this.cuadroTareas.iniciarDatos();
    }//GEN-LAST:event_JLabelPrincipalMouseClicked

    private void JLabelPrincipalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabelPrincipalMouseEntered
        this.cuadroTareas.setBackground(Configuraciones.fondoNoPrincipal);
        this.repaint();
    }//GEN-LAST:event_JLabelPrincipalMouseEntered

    private void JLabelPrincipalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabelPrincipalMouseExited
        this.cuadroTareas.setBackground(Configuraciones.fondoPrincipal);
    }//GEN-LAST:event_JLabelPrincipalMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JLabelPrincipal;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
