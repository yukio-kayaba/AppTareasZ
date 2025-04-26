
package modelo;

public class Archivo {
    private String tipo;
    private String nombre;
    private boolean contenido;
    private String contenidoTexto;
    private String direccion;

    public Archivo(){
        this.contenido = false;
    }
    
    public void addDatos(String nombre, String tipo,String direccion){
        this.nombre = nombre;
        this.tipo = tipo;
        this.contenidoTexto = null;
        this.direccion = direccion + "/"+this.nombre;
    }
    public void addDatos(String nombre, String tipo,String contenido,String direccion ){
        this.nombre = nombre;
        this.tipo = tipo;
        this.contenidoTexto = contenido;
        if( this.contenidoTexto.length() > 0){
            this.contenido = true;
        }
        this.direccion = direccion+"/"+this.nombre;
    }
    
    public String getContenidoTexto() {
        return contenidoTexto;
    }

    public void setContenidoTexto(String contenidoTexto) {
        this.contenidoTexto = contenidoTexto;
        if(this.contenidoTexto.length() > 0){
            this.contenido = true;
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isContenido() {
        return contenido;
    }

    public void setContenido(boolean contenido) {
        this.contenido = contenido;
    }
    
    
    
    
    
}
