
package z.app;

import controller.Archivos;
import java.util.ArrayList;
import modelo.Archivo;
import modelo.ArchivosDatos;
import modelo.Configuraciones;
import vistas.LogoPrincipal;


public class ZApp {

    public static void main(String[] args) {
        //LogoPrincipal principal = new LogoPrincipal();
        //principal.setVisible(true);
        Archivos prueba = new Archivos();
        System.out.println("ruta: "+Configuraciones.RutaArchivo());
        ArrayList<Archivo> valores = prueba.obtenerDatosCarpeta(Configuraciones.RutaArchivo(),true);
        
        ArchivosDatos informacion = new ArchivosDatos(valores);
        
        Inicializador startApp = new Inicializador();
        startApp.iniciarApp(informacion);
        
        if(valores.size() == 0){
            System.out.println("No hay valores");
        }
        for(Archivo nota : valores){
            System.out.println("titulo : "+nota.getNombre());
            System.out.println("direccion : " + nota.getDireccion());
            System.out.println("tipo : "+nota.getTipo());
            String content = nota.isContenido()?"si":"no";
            System.out.println("cotenido : "+content);
            System.out.println("----------------------------------------");
        }
        
        
    }
    
}
