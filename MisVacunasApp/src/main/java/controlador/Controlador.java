/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Administrador;
import modelo.Conexion;
import modelo.Consultas;
import modelo.Enfermero;
import modelo.Vacuna;

public class Controlador {
    
    private Conexion conexion;
    private Consultas consultas;

    //CONSTRUCTOR DE LA CLASE
    public Controlador() {
        this.conexion = new Conexion();
        this.consultas = new Consultas();
    }
    
    //VALIDAR CREDENCIALES PARA INICIAR SESION
    public String validarCredenciales(String usuario, String clave, String tipo){
        String resp = "false";
        if(tipo.equalsIgnoreCase("Administrador")){
            this.conexion.conectar_BD();
            Administrador adm = consultas.buscarAdministrador(conexion.getConexion(), usuario);
            if(adm != null && adm.getClave().equalsIgnoreCase(clave)){
                resp = "admin/"+usuario;            
            }
        }else if(tipo.equalsIgnoreCase("Enfermero")){
            this.conexion.conectar_BD();
            Enfermero enf = consultas.buscarEnfermero(conexion.getConexion(), usuario);
            if(enf != null && enf.getClave().equalsIgnoreCase(clave)){
                resp = enf.getNombre();
            }
        }else{
            resp = "false";
        }
        return resp;
    }
    
    //REGISTRAR ENFERMERO
    public boolean registrarEnfermero(String usuario, String nombre, String telefono, String direccion, int edad, String clave){
        boolean resp = false;
        Enfermero enf = buscarEnfermero(usuario);
        if(enf == null){
           enf = new Enfermero(usuario, nombre, telefono, direccion, clave, edad);
           resp = consultas.registrarEnfermero(conexion.getConexion(), enf);
        }
        return resp;
    }
    
    //BUSCAR ENFERMERO POR USUARIO
    public Enfermero buscarEnfermero(String usuario){
        return consultas.buscarEnfermero(conexion.getConexion(), usuario);
    } 
    
    //MODIFICAR ENFERMERO
    public boolean modificarEnfermero(Enfermero enf){
        boolean resp = false;
        Enfermero consulta = buscarEnfermero(enf.getUsuario());
        if(consulta != null){
           resp = consultas.modificarEnfermero(conexion.getConexion(), enf);
        }
        return resp;
    }
    
    //ELIMINAR ENFERMERO
    public boolean eliminarEnfermero(String usuario){
        boolean resp = false;
        Enfermero consulta = buscarEnfermero(usuario);
        if(consulta != null){
           resp = consultas.eliminarEnfermero(conexion.getConexion(), usuario);
        }
        return resp;
    }
    
    
    //REGISTRAR VACUNA
    public boolean registrarVacuna(String nombre, int cantidad, String dosis){
        boolean resp = false;
        Vacuna vac = buscarVacuna(nombre);
        if(vac == null){
           vac = new Vacuna(nombre, dosis, cantidad);
           resp = consultas.registrarVacuna(conexion.getConexion(), vac);
        }
        return resp;
    }
    
    //BUSCAR VACUNA POR NOMBRE
    public Vacuna buscarVacuna(String nombre){
        return consultas.buscarVacuna(conexion.getConexion(), nombre);
    } 
    
    //MODIFICAR VACUNA
    public boolean modificarVacuna(Vacuna vac){
        boolean resp = false;
        Vacuna consulta = buscarVacuna(vac.getNombre());
        if(consulta != null){
           resp = consultas.modificarVacuna(conexion.getConexion(), consulta);
        }
        return resp;
    }
    
    //ELIMINAR VACUNA
    public boolean eliminarVacuna(String nombre){
        boolean resp = false;
        Vacuna consulta = buscarVacuna(nombre);
        if(consulta != null){
           resp = consultas.eliminarVacuna(conexion.getConexion(), ""+consulta.getId());
        }
        return resp;
    }
    
    //DESCONECTAR DE LA BASE DE DATOS
    public void desconectar_BD(){
        this.conexion.desconectar_BD();
    }
    
}
