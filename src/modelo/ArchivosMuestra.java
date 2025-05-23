
package modelo;

import controller.Archivos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import vistas.CuadroArchivosPanel;
import vistas.CuadroCarpetasPanel;
import vistas.HojaTrabajoArchivo;
import vistasJframe.ArchivoTrabajoView;

public class ArchivosMuestra extends javax.swing.JPanel {
    private String nombre;
    private String direccion;
    private ArchivosDatos informacion;
    private int posicion;
    private CuadroArchivosPanel padreComponente;
    private ArchivoTrabajoView JFramevista;
    
    public ArchivosMuestra(String nombre,ArchivosDatos datos){
        this.nombre = nombre;
        init();
        this.informacion = datos;
        this.JLabelNombreCarpeta.setText(this.nombre);
        this.JFramevista =  new ArchivoTrabajoView();
    }
    public ArchivosMuestra(){
        init();
    }

    public void setPadreComponente(CuadroArchivosPanel padreComponente) {
        this.padreComponente = padreComponente;
    }

    
    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion + "/"+this.nombre;
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

        PanelArchivo = new javax.swing.JPanel();
        JLabelNombreCarpeta = new javax.swing.JLabel();
        imagen1 = new controller.Imagen();

        PanelArchivo.setBackground(new java.awt.Color(204, 204, 204));
        PanelArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelArchivoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelArchivoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelArchivoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelArchivoMousePressed(evt);
            }
        });
        PanelArchivo.setLayout(null);

        JLabelNombreCarpeta.setFont(new java.awt.Font("Yu Gothic UI", 0, 8)); // NOI18N
        JLabelNombreCarpeta.setForeground(new java.awt.Color(0, 0, 0));
        JLabelNombreCarpeta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelNombreCarpeta.setText("jLabel1");
        PanelArchivo.add(JLabelNombreCarpeta);
        JLabelNombreCarpeta.setBounds(0, 20, 50, 30);

        imagen1.setText("imagen1");
        imagen1.setRuta("/recursos/arhivos.png");
        PanelArchivo.add(imagen1);
        imagen1.setBounds(12, 2, 27, 27);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PanelArchivoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelArchivoMouseEntered
        Border borde = BorderFactory.createLineBorder(Configuraciones.fondoPrincipal,2);
        this.PanelArchivo.setBorder(borde);

    }//GEN-LAST:event_PanelArchivoMouseEntered

    private void PanelArchivoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelArchivoMouseExited
        // TODO add your handling code here:
        this.PanelArchivo.setBorder(null);
    }//GEN-LAST:event_PanelArchivoMouseExited

    private void PanelArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelArchivoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelArchivoMouseClicked

    private void AgregarMenuIzquierdo(java.awt.event.MouseEvent e){
        JPopupMenu menu = new JPopupMenu();
        JMenuItem delete = new JMenuItem("Eliminar");
        JMenuItem update = new JMenuItem("Update");
        JMenuItem doblePage = new JMenuItem("2 HOJA");
        delete.addActionListener(ev ->{
            boolean resultado = this.informacion.DeleteDato(this.posicion);
            if(resultado){
                this.padreComponente.CargarDatos();
            } 
        });
        update.addActionListener(ev ->{
            
            this.padreComponente.CrearInputAcceso(3, this.getWidth(), this.getHeight(), this.getX(), this.getY(), 2, this.posicion);
        });
        
        
        
        if( this.padreComponente.isCuadroInicio()){
            menu.add(doblePage);
        }
        menu.add(delete);
        menu.add(update);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
    
    private void crearVentanaTrabajo(){
        String rutaAux = this.direccion+"/"+this.nombre;

        this.JFramevista.addHoja(direccion, nombre);
        
        this.JFramevista.UpdateTablas();
        this.JFramevista.setSize(525, 400);
        this.JFramevista.setVisible(true);
        System.out.println(" hojas : "+ this.JFramevista.getCantidadHojas());
        
    }
    
    private void PanelArchivoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelArchivoMousePressed
        // TODO add your handling code here:
        if(SwingUtilities.isRightMouseButton(evt)){
            System.out.println("Click izquierdo");
            AgregarMenuIzquierdo(evt);
            return;
        }
        this.crearVentanaTrabajo();
        System.out.println("click derecho");
    }//GEN-LAST:event_PanelArchivoMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelNombreCarpeta;
    private javax.swing.JPanel PanelArchivo;
    private controller.Imagen imagen1;
    // End of variables declaration//GEN-END:variables
}
