
package modelo;

import controller.Archivos;
import java.awt.Color;

public class Configuraciones {
    public static Color fondoPrincipal = new Color(1,6,82);
    public static Color fondoNoPrincipal = new Color(5,6,82);
    
    public static String RutaArchivo(){
        String rutaUsuario = System.getProperty("user.home");
        String Ruta = rutaUsuario + "/documents";
        
        Archivos datos = new Archivos();
        
        boolean resultado = datos.crearCarpeta("archivosZ", Ruta);
        
        Ruta += "/archivosZ";
        
        return Ruta;
    }
    
}
