/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Vacuna {
    private String nombre, dosis;
    private int id, cantidad;

    //CONSTRUCTOR VACIO DE LA CLASE
    public Vacuna() {}

    //CONSTRUCTOR DE LA CLASE
    public Vacuna(String nombre, String dosis, int cantidad) {
        this.id = 0;
        this.nombre = nombre;
        this.dosis = dosis;
        this.cantidad = cantidad;
    }

    //METODOS GET Y SET DE LA CLASE
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
