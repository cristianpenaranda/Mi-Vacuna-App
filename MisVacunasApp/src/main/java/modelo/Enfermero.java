/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Enfermero {
    private String usuario, nombre, telefono, direccion, clave;
    private int edad;

    //CONSTRUCTOR VACIO DE LA CLASE
    public Enfermero() {}
    
    //CONSTRUCTOR DE LA CLASE
    public Enfermero(String usuario, String nombre, String telefono, String direccion, String clave, int edad) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.clave = clave;
        this.edad = edad;
    }

    //METODOS GET Y SET DE LA CLASE
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
