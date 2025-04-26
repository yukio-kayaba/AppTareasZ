
package vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import modelo.Archivo;
import modelo.ArchivosDatos;
import modelo.Carpetas;
import modelo.CarpetasMuestra;
import modelo.FileInput;
import modelo.FileMuestra;

public class CuadroArchivos extends javax.swing.JFrame {
    private ArchivosDatos informacion;
    private String nombre;
    private CuadroTareas contenedorMain;
    public CuadroArchivos(ArchivosDatos datos,String nombre){
        this.agregarScroll();
        this.nombre = nombre;
        
        init();
        this.JLabelTitleCarpeta.setText(nombre);
        this.informacion = datos;
    }

   

    public void setContenedorMain(CuadroTareas contenedorMain) {
        this.contenedorMain = contenedorMain;
    }
    

    public void init(){
        this.setUndecorated(true);
        initComponents();
        this.setResizable(true);
        this.setLocationRelativeTo(null);
    }
    public void iniciarDatos(){
        if(this.informacion.cantidadArchivos() == 0 ){
            JLabel valorAux = new JLabel();
            valorAux.setText("No hay carpetas");
            valorAux.setSize(250,430);
            valorAux.setHorizontalAlignment(JLabel.CENTER);
            this.JPanelArchivos.add(valorAux);
            return;
        }
        this.CargarDatos(150);
    }
    
    private void agregarScroll(){
        JScrollPane scroll = new JScrollPane(this.JPanelArchivos);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(520, 300));
        this.add(scroll);
    }
    
    public void CargarDatos(){
        this.JPanelArchivos.removeAll();
        ArrayList<Archivo> valoresAux =this.informacion.getDatos();
        int margen = 7;
        int widthX = this.JPanelArchivos.getWidth() - margen;
        int heigthY = this.JPanelArchivos.getHeight() - margen;
        int X = margen,Y = margen + 30;
        this.JPanelArchivos.setLayout(null);
        
        int posicion = 0;
        for(Archivo dato : valoresAux){
            if( dato.getTipo() == null || !dato.isContenido()){
                this.crearCarpeta(widthX, heigthY, margen, posicion, dato, Y);
                Y += ( 30 + margen);
                posicion ++;
                this.JPanelArchivos.revalidate();
                this.JPanelArchivos.repaint();
            }
        }
    }
    
    public void CargarDatos(int tiempo){
        this.JPanelArchivos.removeAll();
        
        ArrayList<Archivo> valoresAux = this.informacion.getDatos();
        int margen = 7;
        int widthX = this.JPanelArchivos.getWidth() - margen;
        int heigthY = this.JPanelArchivos.getHeight() - margen;
        int X = margen,Y = 30 + margen;
        this.JPanelArchivos.setLayout(null);
        
        int posicion = 0;
        final int[] index = {0};
        Timer timer = new Timer(tiempo, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(index[0] < valoresAux.size()){
                    Archivo dato = valoresAux.get(index[0]);
                    if( dato.getTipo() == null || !dato.isContenido()){
                        crearCarpeta(widthX, heigthY, margen, posicion, dato, (index[0] + 1) * (Y) );
                        JPanelArchivos.revalidate();
                        JPanelArchivos.repaint();
                        index[0]++;
                    }
                }else{
                    ((Timer) e.getSource()).stop();
                }
            
            }
        });
        timer.start();
    }
    
    private void crearCarpeta(int widthX,int heigthY,int margen,int posicion,Archivo dato,int Y){
        FileMuestra carpeta = new FileMuestra(dato.getNombre(),this.informacion);
                
        carpeta.setDireccion( dato.getDireccion());
        carpeta.setSize(widthX,heigthY);
        carpeta.setPosicion(posicion);
        carpeta.setLocation(margen, Y);
        carpeta.setVisible(true);
        carpeta.setPadreComponente(this);
        carpeta.repaint();
        this.JPanelArchivos.add(carpeta);
        this.JPanelArchivos.setComponentZOrder(carpeta, 0);
    }
    public void CrearInputAcceso(int margen,int widthX,int heigthY){
        FileInput carpeta = new FileInput();
        carpeta.setLocation(margen, margen);
        
        carpeta.setSize(widthX , heigthY);
        this.JPanelArchivos.add(carpeta);
        carpeta.setVisible(true);
        carpeta.focusText(this ,this.informacion);
        this.JPanelArchivos.revalidate();
        this.JPanelArchivos.repaint();
    }
    public void CrearInputAcceso(int margen,int widthX,int heigthY,int posX,int posY,int opcion ,int indice){
        FileInput carpeta = new FileInput(opcion,indice);
        carpeta.setLocation(posX, posY);
        
        carpeta.setSize(widthX , heigthY);
        this.JPanelArchivos.add(carpeta);
        carpeta.setVisible(true);
        carpeta.focusText(this ,this.informacion);
        this.JPanelArchivos.revalidate();
        this.JPanelArchivos.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPrincipal = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        JLabelTitleCarpeta = new javax.swing.JLabel();
        imagen1 = new com.mycompany.pruebas.Imagen();
        crearCarpetaNueva = new com.mycompany.pruebas.Imagen();
        lblcierre = new javax.swing.JLabel();
        JPanelArchivos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelPrincipal.setBackground(new java.awt.Color(60, 34, 176));
        labelPrincipal.setPreferredSize(new java.awt.Dimension(416, 315));
        labelPrincipal.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(null);

        JLabelTitleCarpeta.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        JLabelTitleCarpeta.setForeground(new java.awt.Color(0, 0, 153));
        JLabelTitleCarpeta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelTitleCarpeta.setText("Z APP TAREAS");
        jPanel2.add(JLabelTitleCarpeta);
        JLabelTitleCarpeta.setBounds(30, 0, 170, 40);

        imagen1.setText("imagen1");
        imagen1.setRuta("/recursos/lupaCarpeta.png");
        jPanel2.add(imagen1);
        imagen1.setBounds(240, 10, 20, 20);

        crearCarpetaNueva.setText("imagen1");
        crearCarpetaNueva.setRuta("/recursos/addCarpetas.png");
        crearCarpetaNueva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crearCarpetaNuevaMouseClicked(evt);
            }
        });
        jPanel2.add(crearCarpetaNueva);
        crearCarpetaNueva.setBounds(210, 10, 20, 20);

        lblcierre.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lblcierre.setForeground(new java.awt.Color(0, 0, 102));
        lblcierre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
        jPanel2.add(lblcierre);
        lblcierre.setBounds(0, 0, 20, 40);

        labelPrincipal.add(jPanel2);
        jPanel2.setBounds(0, 0, 270, 40);

        JPanelArchivos.setLayout(null);
        labelPrincipal.add(JPanelArchivos);
        JPanelArchivos.setBounds(10, 50, 250, 430);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearCarpetaNuevaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearCarpetaNuevaMouseClicked
        System.out.println("Se realizo un click");
        int margen = 3;
        int widthX = this.JPanelArchivos.getWidth() - margen;
        int heigthY = this.JPanelArchivos.getHeight() - margen;
        
        this.CrearInputAcceso(margen, widthX, heigthY);
        
    }//GEN-LAST:event_crearCarpetaNuevaMouseClicked

    private void lblcierreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcierreMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblcierreMouseClicked

    private void lblcierreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcierreMouseEntered
        this.lblcierre.setForeground(Color.red);
    }//GEN-LAST:event_lblcierreMouseEntered

    private void lblcierreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcierreMouseExited
        // TODO add your handling code here:
        this.lblcierre.setForeground(new Color(0,0,102));
    }//GEN-LAST:event_lblcierreMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelTitleCarpeta;
    private javax.swing.JPanel JPanelArchivos;
    private com.mycompany.pruebas.Imagen crearCarpetaNueva;
    private com.mycompany.pruebas.Imagen imagen1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel labelPrincipal;
    private javax.swing.JLabel lblcierre;
    // End of variables declaration//GEN-END:variables
}
