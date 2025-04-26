
package modelo;

import controller.Archivos;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import vistas.CuadroArchivos;
import vistas.CuadroTareas;

public class FileInput extends javax.swing.JPanel {
    private String nombre;
    private int opcionCuadro = 1;
    private int indice;
    private boolean activo=true;
    public FileInput(String nombre){
        this.nombre = nombre;
        init();
    }
    public FileInput(int opcion,int indice){
        this.opcionCuadro = opcion;
        this.indice = indice;
        init();
    }
    public FileInput(){
        init();
    }
    
    public void focusText(CuadroArchivos padreObjeto,ArchivosDatos datos){
        this.txtJugador2.setVisible(true);
        this.txtJugador2.requestFocusInWindow();
        FileInput acceso = this;
        this.txtJugador2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                System.out.println("valores : "+txtJugador2.getText());
                String nombre = txtJugador2.getText();
                if(nombre.length() == 0 || nombre.equals("nombre Carpeta") || !activo ){
                    padreObjeto.CargarDatos();
                    return;
                }
                activo = false;
                if(opcionCuadro == 1){
                    Archivos archivoCreate = new Archivos();
                    archivoCreate.crearCarpeta(nombre,Configuraciones.RutaArchivo());
                    Archivo carpetaaux = new Archivo();
                    carpetaaux.addDatos(nombre, null, Configuraciones.RutaArchivo() );
                    datos.AgregarDatos(carpetaaux);
                    padreObjeto.CargarDatos();
                }else if(opcionCuadro == 2){
                    Archivo updateValor = datos.setDato(indice);
                    updateValor.setNombre(nombre);
                    datos.UpdateDato(updateValor , indice);
                    padreObjeto.CargarDatos();
                }
            }
        });
        
        this.txtJugador2.addFocusListener(new FocusAdapter(){
            @Override
            public void focusLost(FocusEvent e){
                System.out.println("valores : "+txtJugador2.getText());
                String nombre = txtJugador2.getText();
                if(nombre.length() == 0 || nombre.equals("nombre Carpeta") || !activo){
                    padreObjeto.CargarDatos();
                    return;
                }
                activo = false;
                if(opcionCuadro == 1){
                    Archivos archivoCreate = new Archivos();
                    archivoCreate.crearCarpeta(nombre,Configuraciones.RutaArchivo());
                    Archivo carpetaaux = new Archivo();
                    carpetaaux.addDatos(nombre, null, Configuraciones.RutaArchivo() );
                    datos.AgregarDatos(carpetaaux);
                    System.out.println("Actualizado xd");
                    padreObjeto.CargarDatos();
                }else if(opcionCuadro == 2){
                    Archivo updateValor = datos.setDato(indice);
                    updateValor.setNombre(nombre);
                    datos.UpdateDato(updateValor , indice);
                    padreObjeto.CargarDatos();
                }
                
            }
        });
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void init(){
        initComponents();
        //this.JLabelNombreCarpeta.setText(this.nombre);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        imagen1 = new com.mycompany.pruebas.Imagen();
        txtJugador2 = new javax.swing.JTextField();

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(null);

        imagen1.setText("imagen1");
        imagen1.setRuta("/recursos/carpetasImagen.png");
        jPanel2.add(imagen1);
        imagen1.setBounds(10, 0, 30, 30);

        txtJugador2.setBackground(new java.awt.Color(204, 204, 204));
        txtJugador2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtJugador2.setForeground(new java.awt.Color(0, 0, 102));
        txtJugador2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtJugador2.setText("nombre Carpeta");
        txtJugador2.setBorder(null);
        txtJugador2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtJugador2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtJugador2FocusLost(evt);
            }
        });
        txtJugador2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtJugador2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtJugador2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtJugador2MouseExited(evt);
            }
        });
        txtJugador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJugador2ActionPerformed(evt);
            }
        });
        txtJugador2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJugador2KeyTyped(evt);
            }
        });
        jPanel2.add(txtJugador2);
        txtJugador2.setBounds(60, 0, 170, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtJugador2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJugador2FocusGained
        // TODO add your handling code here:
        if( this.txtJugador2.getText().equals("nombre Carpeta")){
            this.txtJugador2.setText("");
        }
    }//GEN-LAST:event_txtJugador2FocusGained

    private void txtJugador2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJugador2FocusLost
        if( this.txtJugador2.getText().length() == 0){
            this.txtJugador2.setText("nombre Carpeta");
        }
    }//GEN-LAST:event_txtJugador2FocusLost

    private void txtJugador2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtJugador2MouseClicked

        Border borde = BorderFactory.createLineBorder(new Color(165,40,174),2);
        this.txtJugador2.setBorder(borde);

    }//GEN-LAST:event_txtJugador2MouseClicked

    private void txtJugador2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtJugador2MouseEntered
        Border borde = BorderFactory.createLineBorder(new Color(165,40,174),2);
        this.txtJugador2.setBorder(borde);
    }//GEN-LAST:event_txtJugador2MouseEntered

    private void txtJugador2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtJugador2MouseExited
        this.txtJugador2.setBorder(null);
    }//GEN-LAST:event_txtJugador2MouseExited

    private void txtJugador2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJugador2KeyTyped
        if( this.txtJugador2.getText().length() <= 8){
            char caracter = Character.toUpperCase( evt.getKeyChar());
            evt.setKeyChar(caracter);
            return;
        }
        evt.consume();
    }//GEN-LAST:event_txtJugador2KeyTyped

    private void txtJugador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJugador2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJugador2ActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
        System.out.println("Se hizo un clik en "+this.nombre);
    }//GEN-LAST:event_jPanel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.pruebas.Imagen imagen1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtJugador2;
    // End of variables declaration//GEN-END:variables
}
