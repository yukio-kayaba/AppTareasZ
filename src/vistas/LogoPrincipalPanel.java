
package vistas;

import java.awt.Point;
import javax.swing.JWindow;
import modelo.ArchivosDatos;
import modelo.Configuraciones;

public class LogoPrincipalPanel extends javax.swing.JPanel {
    private CuadroCarpetasPanel cuadroTareas;
    private CuadroArchivosPanel cuadroArchivosData;
    private ArchivosDatos valores;
    private ArchivosDatos archivosData;
    private JWindow principalMolde;
    private int x_inicial,y_inicial,x_inicio = 10,y_inicio = 10;
    private int Winicial,Hinicial;
    private int largoTamanio;
    private boolean activo = false;
    private boolean fileActive = false;
    
    public LogoPrincipalPanel(ArchivosDatos informacion,JWindow molde ) {
        init();
        this.valores = informacion;
        this.cuadroTareas = new CuadroCarpetasPanel(informacion,this);
        this.cuadroArchivosData = new CuadroArchivosPanel(this);
        
        //this.cuadroTareas.setLayout(null);
        this.cuadroTareas.setSize(55,400);
        this.cuadroTareas.setVisible(false);
        this.cuadroTareas.setMoldePrincipal(molde);
        this.principalMolde = molde;
        this.principalMolde.add(cuadroTareas);
        
        this.cuadroArchivosData.setSize(55,400);
        this.cuadroArchivosData.setVisible(false);
        this.cuadroArchivosData.setMoldePrincipal(molde);
        this.principalMolde.add(cuadroArchivosData);
    }

    private void init(){
        this.setLayout(null);
        initComponents();
        this.setBackground( Configuraciones.fondoPrincipal);
    }
    
    public void iniciarArchivoData(ArchivosDatos datosArchivos){
        this.archivosData = datosArchivos;
        this.fileActive = true;
    }
    
    public void valoresIniciales(int width,int height){
        this.Winicial = width;
        this.Hinicial = height;
    }
    
    public void setCoordenadasPricipales(int x,int y){
        this.x_inicio = x;
        this.y_inicio = y;
    }

    public boolean isFileActive() {
        return fileActive;
    }

    public void setFileActive(boolean fileActive) {
        this.fileActive = fileActive;
    }
    
    public int getLargoTamanio() {
        return largoTamanio;
    }

    public void setLargoTamanio(int largoTamanio) {
        this.largoTamanio = largoTamanio;
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLabelPrincipal = new javax.swing.JPanel();
        imagen1 = new controller.Imagen();

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

        imagen1.setText("imagen1");
        imagen1.setRuta("/recursos/2.png");

        javax.swing.GroupLayout JLabelPrincipalLayout = new javax.swing.GroupLayout(JLabelPrincipal);
        JLabelPrincipal.setLayout(JLabelPrincipalLayout);
        JLabelPrincipalLayout.setHorizontalGroup(
            JLabelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagen1, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );
        JLabelPrincipalLayout.setVerticalGroup(
            JLabelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagen1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JLabelPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabelPrincipalMouseClicked
        System.out.println("x: "+this.principalMolde.getX()+"  y:"+this.principalMolde.getY());
        if(!this.activo ){
            Point puntoPantalla = this.principalMolde.getLocationOnScreen();
            this.x_inicial = this.principalMolde.getX();
            this.y_inicial = this.principalMolde.getY();
            this.principalMolde.setLocation(this.x_inicio, this.y_inicio);
            this.principalMolde.setSize(60, this.largoTamanio - 3);
            if( this.fileActive){
               this.cuadroArchivosData.configurarDimensiones(60, this.largoTamanio, 3);
               this.cuadroArchivosData.setLocation(0, 65);
               this.cuadroArchivosData.setVisible(true);
               this.cuadroArchivosData.iniciarDatos(this.archivosData);
            }else{
                this.cuadroTareas.configurarDimensiones(60, this.largoTamanio - 60, 3);
                this.cuadroTareas.setLocation(0, 65);
                this.cuadroTareas.setVisible(true);
                this.cuadroTareas.iniciarDatos();
            }

            this.activo = true;
        }else{
            this.principalMolde.setLocation(this.x_inicial, this.y_inicial);
            this.principalMolde.setSize(60, 60);
            this.JLabelPrincipal.setSize(60, 60);
            
            this.activo = false;
        }
        this.setLocation(0, 0);
        this.cuadroTareas.setVisible(this.activo);
        //this.cuadroTareas.iniciarDatos();
    }//GEN-LAST:event_JLabelPrincipalMouseClicked
    
    public void updateCuadros(){
        String valorFile = this.fileActive ? "si":"no";
        System.out.println("Activo : "+ valorFile);
        if( this.fileActive){
           this.cuadroArchivosData.configurarDimensiones(60, this.largoTamanio, 3);
           this.cuadroArchivosData.setLocation(0, 65);
           this.cuadroArchivosData.setVisible(true);
           this.cuadroArchivosData.iniciarDatos(this.archivosData);
           
           this.cuadroTareas.setVisible(false);
        }else{
            this.cuadroTareas.configurarDimensiones(60, this.largoTamanio - 60, 3);
            this.cuadroTareas.setLocation(0, 65);
            this.cuadroTareas.setVisible(true);
            this.cuadroTareas.iniciarDatos();
            
            this.cuadroArchivosData.setVisible(false);
                    
        }
    }
    
    
    public void modificarDimensionMolde(int ancho,int largo){
        this.principalMolde.setSize(ancho, largo);
        int x = this.principalMolde.getX() - ancho + 60;
        int y = this.principalMolde.getY();
        this.principalMolde.setLocation(x, y);
        this.cuadroTareas.setLocation(ancho - 60, 65);
        this.setLocation(ancho - 60, 0);
        this.repaint();
    }
    
    public void reestablecerSizeMolde(){
        this.principalMolde.setSize(this.Winicial,this.Hinicial);
    }
    
    private void JLabelPrincipalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabelPrincipalMouseEntered
        this.cuadroTareas.setBackground(Configuraciones.fondoNoPrincipal);
        this.repaint();
    }//GEN-LAST:event_JLabelPrincipalMouseEntered

    private void JLabelPrincipalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabelPrincipalMouseExited
        this.cuadroTareas.setBackground(Configuraciones.fondoPrincipal);
    }//GEN-LAST:event_JLabelPrincipalMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JLabelPrincipal;
    private controller.Imagen imagen1;
    // End of variables declaration//GEN-END:variables
}
