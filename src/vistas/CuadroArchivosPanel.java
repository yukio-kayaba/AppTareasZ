
package vistas;

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
import modelo.ArchivosMuestra;
import modelo.Carpetas;
import modelo.CarpetasMuestra;
import modelo.Configuraciones;
import vistasJframe.InputFile;

public class CuadroArchivosPanel extends javax.swing.JPanel {
    private ArchivosDatos informacion;
    private JWindow moldePrincipal;
    private LogoPrincipalPanel cuadroInicio;
    private boolean UsoArchivo = false;
    public CuadroArchivosPanel(ArchivosDatos valores,LogoPrincipalPanel cuadro) {
        this.init();
        this.informacion = valores;
        this.cuadroInicio = cuadro;
    }
    public CuadroArchivosPanel(LogoPrincipalPanel cuadro){
        this.init();
        this.cuadroInicio = cuadro;
    }

    public ArchivosDatos getInformacion() {
        return informacion;
    }

    public void setInformacion(ArchivosDatos informacion) {
        this.informacion = informacion;
    }
    public boolean isCuadroInicio(){
        return this.UsoArchivo;
    }
    public void CambiarEstadoArchivo(){
        this.UsoArchivo = ( this.UsoArchivo) ? false:true;
    }
    
    
    private void init(){
       
       initComponents();
       
       //this.agregarScroll();
       //this.JPanelArchivos.setPreferredSize(new Dimension(100,1000));
    }

    public JWindow getMoldePrincipal() {
        return moldePrincipal;
    }

    public void setMoldePrincipal(JWindow moldePrincipal) {
        this.moldePrincipal = moldePrincipal;
    }
    
    
    
    public void iniciarDatos(){
        System.out.println("llegando aqui :");
        
        if(this.informacion.cantidadArchivos() == 0 ){
            //this.JPanelArchivos.removeAll();
            JLabel valorAux = new JLabel();
            valorAux.setText("0");
            System.out.println("No hay datos ");
            //valorAux.setSize(WIDTH,HEIGHT);
            valorAux.setHorizontalAlignment(JLabel.CENTER);
            //this.JPanelArchivos.setLayout(null);
            
            this.JPanelArchivos.add(valorAux);
            this.JPanelArchivos.revalidate();
            this.JPanelArchivos.repaint();
            return;
        }
        this.CargarDatos(150);
    }
    private void agregarScroll(){
        JScrollPane scroll = new JScrollPane(this.JPanelArchivos);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(2, 2));
        scroll.setBounds(5, this.JPanelArchivos.getHeight(), 5, HEIGHT);
        this.add(scroll);
    }
    
    private void crearCarpeta(int widthX,int heigthY,int margen,int posicion,Archivo dato,int Y){
        ArchivosMuestra carpeta = new ArchivosMuestra(dato.getNombre(),this.informacion);
                
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
        this.moldePrincipal.revalidate();
        this.moldePrincipal.repaint();
        //this.JPanelArchivos.revalidate();
        //this.JPanelArchivos.repaint();
    }
    public void CrearInputAcceso(int margen,int widthX,int heigthY,int posX,int posY,int opcion ,int indice){
        Carpetas carpeta = new Carpetas(opcion,indice);
        carpeta.setLocation(posX, posY);
        
        carpeta.setSize(widthX , heigthY);
        //this.JPanelArchivos.add(carpeta);
        carpeta.setVisible(true);
        //carpeta.focusText(this,this.informacion);
        this.JPanelArchivos.revalidate();
        this.JPanelArchivos.repaint();
    }
    
    public void CargarDatos(){
        
        this.JPanelArchivos.removeAll();
        
        ArrayList<Archivo> valoresAux =this.informacion.getDatos();
        int margen = 7;
        int widthX = this.JPanelArchivos.getWidth() - margen;
        int heigthY = this.JPanelArchivos.getHeight() - margen;
        int X = margen,Y = margen;
        
        int posicion = 0;
        for(Archivo dato : valoresAux){
            if( dato.getTipo() == null || !dato.isContenido()){
                
                this.crearCarpeta(widthX, heigthY, 1, posicion, dato, Y);
                Y += ( 50 + margen);
                posicion ++;
            }
            
        }
        this.JPanelArchivos.revalidate();
        this.JPanelArchivos.repaint();
        
    }
    
    public void CargarDatos(int tiempo){
        this.JPanelArchivos.removeAll();
        
        ArrayList<Archivo> valoresAux = this.informacion.getDatos();
        int margen = 7;
        int widthX = this.JPanelArchivos.getWidth() - margen;
        int heigthY = this.JPanelArchivos.getHeight() - margen;
        int X = margen,Y = margen;
        
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
    private void agregarMenuInterno(java.awt.event.MouseEvent e){
        JPopupMenu nuevoMenu = new JPopupMenu();
        JMenuItem agregar = new JMenuItem("crear");
        JMenuItem update = new JMenuItem("Buscar");
        JMenuItem eliminar = new JMenuItem("Cerrar");
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
        int largoCuadro = this.backOption.getHeight();
        this.setSize(ancho,largo);
        //this.jPanel1.setSize(100, 378);
        if(this.informacion.cantidadArchivos() != 0){
            this.JPanelArchivos.setPreferredSize(new Dimension(ancho - margen * 2,this.informacion.cantidadArchivos() * 65 ));
        }
        this.setBackground(Configuraciones.fondoPrincipal );
        //this.labelPrincipal.setBackground(Configuraciones.fondoNoPrincipal );
        //this.JPanelArchivos.revalidate();
        //this.JPanelArchivos.setLocation(margen , margen +  largoCuadro );
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPrincipal = new javax.swing.JPanel();
        backOption = new controller.Imagen();
        JPanelArchivos = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        labelPrincipal.setBackground(new java.awt.Color(51, 0, 204));
        labelPrincipal.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 102)));
        labelPrincipal.setPreferredSize(new java.awt.Dimension(416, 315));
        labelPrincipal.setLayout(null);

        backOption.setText("imagen1");
        backOption.setRuta("/recursos/back.png");
        backOption.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backOptionMousePressed(evt);
            }
        });
        labelPrincipal.add(backOption);
        backOption.setBounds(20, 5, 50, 30);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
        );

        JPanelArchivos.setViewportView(jPanel1);

        labelPrincipal.add(JPanelArchivos);
        JPanelArchivos.setBounds(10, 40, 80, 310);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(labelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void backOptionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backOptionMousePressed
        // TODO add your handling code here:
        this.JPanelArchivos.removeAll();
        this.cuadroInicio.setFileActive(false);
        this.cuadroInicio.updateCuadros();
    }//GEN-LAST:event_backOptionMousePressed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        if(SwingUtilities.isRightMouseButton(evt)){
            this.agregarMenuInterno(evt);
        }
    }//GEN-LAST:event_jPanel1MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JPanelArchivos;
    private controller.Imagen backOption;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel labelPrincipal;
    // End of variables declaration//GEN-END:variables
}
