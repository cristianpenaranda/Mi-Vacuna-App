/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Administrador;
import modelo.Conexion;
import modelo.Consultas;
import modelo.Enfermero;
import modelo.Paciente;
import modelo.Paciente_vacuna;
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
                resp = enf.getUsuario();
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
    
    //BUSCAR VACUNA POR ID
    public Vacuna buscarVacunaID(String id){
        return consultas.buscarVacunaID(conexion.getConexion(), id);
    } 
    
    //MODIFICAR VACUNA
    public boolean modificarVacuna(Vacuna vac){
        boolean resp = false;
        Vacuna consulta = buscarVacuna(vac.getNombre());
        if(consulta != null){
            vac.setId(consulta.getId());
           resp = consultas.modificarVacuna(conexion.getConexion(), vac);
        }
        return resp;
    }
    
    //REGISTRAR PACIENTE
    public boolean registrarPaciente(Paciente pac){
        boolean resp = false;
        if(buscarPaciente(pac.getCedula()) == null){
           resp = consultas.registrarPaciente(conexion.getConexion(), pac);
        }
        return resp;
    }
    
    //BUSCAR PACIENTE POR CEDULA
    public Paciente buscarPaciente(String cedula){
        return consultas.buscarPaciente(conexion.getConexion(), cedula);
    } 
    
    //MODIFICAR PACIENTE
    public boolean modificarPaciente(Paciente pac){
        boolean resp = false;
        if(buscarPaciente(pac.getCedula()) != null){
           resp = consultas.modificarPaciente(conexion.getConexion(), pac);
        }
        return resp;
    }
    
    //DESCONECTAR DE LA BASE DE DATOS
    public void desconectar_BD(){
        this.conexion.desconectar_BD();
    }

    //BUSCAR PACIENTE_VACUNA
    public ArrayList<Paciente_vacuna> buscarPacienteVacuna(String cedula) {
        return consultas.buscarPacienteVacuna(conexion.getConexion(), cedula);
    }
    
    //LISTAR TODAS LAS VACUNAS REGISTRADAS
    public ArrayList<Vacuna> listarVacunas(){
        return consultas.listarVacunas(conexion.getConexion());
    }
    
    //REGISTRAR NUEVA VACUNA PUESTA
    public boolean registrarVacunaPuesta(Paciente_vacuna pv){
        return consultas.registrarVacunaPuesta(conexion.getConexion(), pv);
    }
}
