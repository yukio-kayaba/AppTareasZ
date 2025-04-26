
package modelo;

import java.util.ArrayList;

import controller.Archivos;

public class ArchivosDatos {
    private ArrayList<Archivo> datos;
    public ArchivosDatos(ArrayList<Archivo> datos){
        this.datos = datos;
    }

    public ArrayList<Archivo> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Archivo> datos) {
        this.datos = datos;
    }
    
    public int cantidadArchivos(){
        return datos.size();
    }
    
    public void AgregarDatos(Archivo valor){
        this.datos.add(valor);
    }
    public void AgregarDatos(ArrayList<Archivo> valores){
        if(valores.size() != 0){
            for(Archivo dato : valores){
                this.datos.add(dato);
            }
        }
    }
    
    public Archivo setDato(int indice){
        return this.datos.get(indice);
    }
    
    
    public boolean UpdateDato(Archivo dato,int indice){
        String nombre = this.datos.get(indice).getNombre();
        boolean resultadoUpdate = Archivos.UpdateCarpeta(dato.getDireccion(), dato.getNombre(),nombre);
        
        if(resultadoUpdate){
            this.datos.set(indice, dato);
            System.out.println("Actualizado");
            return true;
        }
        return false;
    }
    
    public boolean DeleteDato(int posicion){
        //Archivos archivocontroller = new Archivos();
        Archivo auxiliar = this.datos.get(posicion);
        boolean eliminado = Archivos.EliminarCarpeta(auxiliar.getDireccion());
        if(eliminado){
            System.out.println("Se ha eliminado la carpeta");
            this.datos.remove(posicion);
            return true;
        }
        System.out.println("Ocurrio un error al eliminar");
        return false;
    }
    
    
}
