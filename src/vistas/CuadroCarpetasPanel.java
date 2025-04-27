
package vistas;

import controller.Archivos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import modelo.Archivo;
import modelo.ArchivosDatos;
import modelo.Carpetas;
import modelo.CarpetasMuestra;
import modelo.Configuraciones;
import vistasJframe.InputFile;

public class CuadroCarpetasPanel extends javax.swing.JPanel {
    private ArchivosDatos informacion;
    private JWindow moldePrincipal;
    private LogoPrincipalPanel cuadroInicio;
    public CuadroCarpetasPanel(ArchivosDatos valores,LogoPrincipalPanel cuadro) {
        this.init();
        this.informacion = valores;
        this.cuadroInicio = cuadro;
    }
    
    private void init(){
       
       initComponents();
       
       //this.agregarScroll();
       //this.JPanelArchivos.setPreferredSize(new Dimension(100,1000));
    }

    public JWindow getMoldePrincipal() {
        return moldePrincipal;
    }

    public LogoPrincipalPanel getCuadroInicio() {
        return cuadroInicio;
    }

    public void setCuadroInicio(LogoPrincipalPanel cuadroInicio) {
        this.cuadroInicio = cuadroInicio;
    }

    
    
    public void setMoldePrincipal(JWindow moldePrincipal) {
        this.moldePrincipal = moldePrincipal;
    }
    
    
    
    public void iniciarDatos(){
        if(this.informacion.cantidadArchivos() == 0 ){
            JLabel valorAux = new JLabel();
            valorAux.setText("0");
            valorAux.setSize(WIDTH,HEIGHT);
            valorAux.setHorizontalAlignment(JLabel.CENTER);
            this.jScrollPane1.add(valorAux);
            return;
        }
        this.CargarDatos();
    }
    private void agregarScroll(){
        JScrollPane scroll = new JScrollPane(this.jScrollPane1);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(2, 2));
        scroll.setBounds(5, this.jScrollPane1.getHeight(), 5, HEIGHT);
        this.add(scroll);
    }
    
    private void crearCarpeta(int widthX,int heigthY,int margen,int posicion,Archivo dato,int Y){
        CarpetasMuestra carpeta = new CarpetasMuestra(dato.getNombre(),this.informacion);
                
        carpeta.setDireccion( dato.getDireccion());
        carpeta.setSize(widthX,heigthY);
        carpeta.setPosicion(posicion);
        carpeta.setLocation(margen, Y);
        carpeta.setVisible(true);
        carpeta.setPadreComponente(this);
        carpeta.repaint();
        this.jScrollPane1.add(carpeta);
        this.jScrollPane1.setComponentZOrder(carpeta, 0);
    }
    public void CrearInputAcceso(int posY){
        //this.cuadroInicio.modificarDimensionMolde(250, this.JPanelArchivos.getHeight());
        InputFile carpeta = new InputFile();
        //[206, 31]
        //carpeta.setLayout(null);
        carpeta.setSize(240 , 40);
        int posX = this.moldePrincipal.getX() - 230;
        carpeta.setLocation(  posX, posY);
        carpeta.setVisible(true);
        //this.moldePrincipal.add(carpeta);
        
        
        carpeta.focusText(this,this.informacion);
        this.jScrollPane1.revalidate();
        this.jScrollPane1.repaint();
        //this.moldePrincipal.revalidate();
        //this.moldePrincipal.repaint();
        //this.JPanelArchivos.revalidate();
        //this.JPanelArchivos.repaint();
    }
    public void CrearInputAcceso(int margen,int widthX,int heigthY,int posX,int posY,int opcion ,int indice){
        Carpetas carpeta = new Carpetas(opcion,indice);
        carpeta.setLocation(posX, posY);
        
        carpeta.setSize(widthX , heigthY);
        //this.JPanelArchivos.add(carpeta);
        carpeta.setVisible(true);
        carpeta.focusText(this,this.informacion);
        this.jScrollPane1.revalidate();
        this.jScrollPane1.repaint();
    }
    
    public void CargarDatos(){
        
        this.jScrollPane1.removeAll();
        
        ArrayList<Archivo> valoresAux =this.informacion.getDatos();
        int margen = 7;
        int widthX = this.jScrollPane1.getWidth() - margen;
        int heigthY = this.jScrollPane1.getHeight() - margen;
        int X = margen,Y = margen;
        this.jScrollPane1.setLayout(null);
        
        int posicion = 0;
        for(Archivo dato : valoresAux){
            if( dato.getTipo() == null || !dato.isContenido()){
                
                this.crearCarpeta(widthX, heigthY, 1, posicion, dato, Y);
                Y += ( 50 + margen);
                posicion ++;
            }
            
        }
        this.jScrollPane1.revalidate();
        this.jScrollPane1.repaint();
        
    }
    
    public void CargarDatos(int tiempo){
        this.jScrollPane1.removeAll();
        
        ArrayList<Archivo> valoresAux = this.informacion.getDatos();
        int margen = 7;
        int widthX = this.jScrollPane1.getWidth() - margen;
        int heigthY = this.jScrollPane1.getHeight() - margen;
        int X = margen,Y = margen;
        //this.jScrollPane1.setLayout(null);
        
        int posicion = 0;
        final int[] index = {0};
        Timer timer = new Timer(tiempo, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(index[0] < valoresAux.size()){
                    Archivo dato = valoresAux.get(index[0]);
                    if( dato.getTipo() == null || !dato.isContenido()){
                        crearCarpeta(widthX, heigthY, 1, posicion, dato, (index[0] * 60 ) + (Y));
                        jScrollPane1.revalidate();
                        jScrollPane1.repaint();
                        index[0]++;
                    }
                }else{
                    ((Timer) e.getSource()).stop();
                }
            
            }
        });
        timer.start();
    }
    private void agregarMenuInterno(java.awt.event.MouseEvent e){
        JPopupMenu nuevoMenu = new JPopupMenu();
        JMenuItem agregar = new JMenuItem("crear");
        JMenuItem update = new JMenuItem("Buscar");
        JMenuItem eliminar = new JMenuItem("Cerrar");
        JMenuItem salir = new JMenuItem("Exit");
        int posY = this.moldePrincipal.getY();
        agregar.addActionListener(ev->{
            System.out.println("agregar");
           
            
            this.CrearInputAcceso(posY);
            //cuadroInicio.modificarDimensionMolde(400, 400);
        });
        
        update.addActionListener(ev->{
            System.out.println("buscar");
        });
        
        eliminar.addActionListener(ev ->{
            System.out.println("cerrar");
        });
        
        nuevoMenu.add(agregar);
        nuevoMenu.add(update);
        nuevoMenu.add(eliminar);
        nuevoMenu.show(e.getComponent(), e.getX(), e.getY());;
    }
    public void configurarDimensiones(int ancho,int largo,int margen){
        this.setSize(ancho,largo);
        //this.jScrollPane1.setSize(ancho - margen * 2, largo - margen);
        
        this.jScrollPane1.setPreferredSize(new Dimension(ancho - margen * 2,this.informacion.cantidadArchivos() * 65 ));
        this.jScrollPane1.setLocation(margen , margen);
        this.jScrollPane1.revalidate();
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPrincipal = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JPanel();

        labelPrincipal.setBackground(new java.awt.Color(60, 34, 176));
        labelPrincipal.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 102)));
        labelPrincipal.setPreferredSize(new java.awt.Dimension(416, 315));
        labelPrincipal.setLayout(null);

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jScrollPane1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jScrollPane1Layout = new javax.swing.GroupLayout(jScrollPane1);
        jScrollPane1.setLayout(jScrollPane1Layout);
        jScrollPane1Layout.setHorizontalGroup(
            jScrollPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jScrollPane1Layout.setVerticalGroup(
            jScrollPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jScrollPane1);

        labelPrincipal.add(jScrollPane2);
        jScrollPane2.setBounds(10, 10, 90, 370);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jScrollPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MousePressed
        // TODO add your handling code here:
        if(SwingUtilities.isRightMouseButton(evt)){
            this.agregarMenuInterno(evt);
        }
    }//GEN-LAST:event_jScrollPane1MousePressed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel labelPrincipal;
    // End of variables declaration//GEN-END:variables
}
