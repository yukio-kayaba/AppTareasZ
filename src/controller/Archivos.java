package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Archivo;


public class Archivos {
    
    public Archivos(){
        
    }

    
    public ArrayList<Archivo> obtenerDatosCarpeta(String direccionArchivos,boolean valor){
        
        ArrayList<Archivo> datos = new ArrayList<Archivo>();
        
        File directorio = new File(direccionArchivos);
        
        if(directorio.exists() && directorio.isDirectory() ){
            File[] archivos = directorio.listFiles();
            if(archivos != null){
                for(File archivo1 :  archivos){
                    Archivo auxiliar = new Archivo();
                    
                    if(archivo1.isDirectory()){
                        auxiliar.addDatos( archivo1.getName(), null,direccionArchivos);
                    }else if(archivo1.isFile() && valor ){
                        String nombre = archivo1.getName();
                        int punto = nombre.lastIndexOf('.');
                        String extension = (punto > 0) ? nombre.substring(punto + 1).toLowerCase() : "sin extensión";
                        try (BufferedReader br = new BufferedReader(new FileReader(archivo1))) {
                            String linea,contenido = "";
                            while ((linea = br.readLine()) != null) {
                                contenido += linea;
                            }
                            auxiliar.setContenidoTexto(contenido);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        auxiliar.addDatos(archivo1.getName(),extension,direccionArchivos);
                    }
                    datos.add(auxiliar);
                }
            }else{
                System.out.println("La ruta no existe");
            }
        }
        

        return datos;
    }
    public boolean crearCarpeta(String NombreCarpeta,String direccion){
        File carpeta = new File(direccion,NombreCarpeta);
        
        if(!carpeta.exists()){
            
            carpeta.mkdir();
            return true;
        }
        return false;
    }
    
    public static boolean EliminarCarpeta(String ruta){
        File carpetaEliminar = new File(ruta);
        
        if( carpetaEliminar.exists() && carpetaEliminar.isDirectory()){
            boolean resultado = carpetaEliminar.delete();
            if(resultado){
                System.out.println("Carpeta eliminada");
                return true;
            }
        }
        System.out.println("No se pudo eliminar , no es un directorio o no existe en la ruta");
        return false;
    }
    
    /***
     * @param ruta -Direccion
     * @param nombreActual -nombre Actual del archivo
     * @param nuevoNombre  -nombre nuevo
     */
    public static boolean UpdateCarpeta(String ruta,String nombreActual,String nuevoNombre){
        File carpetaActual = new File(ruta+nombreActual);
        File carpetaNueva = new File(ruta + nuevoNombre);

        if(carpetaActual.exists()){
            boolean nuevo = carpetaActual.renameTo(carpetaNueva);
            return nuevo;
        }
        return false;
    }
    
}
