/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consultas {

    private Statement st;
    private ResultSet rs;

    //CONSTRUCTOR DE LA CLASE
    public Consultas() {
    }
    
    //BUSCAR ADMINISTRADOR
    public Administrador buscarAdministrador(Connection cx, String usuario) {
        String sql = "SELECT * FROM administradores WHERE usuario='" + usuario + "'";
        Administrador adm = null;
        try {
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                adm = new Administrador();
                adm.setUsuario(rs.getString("usuario"));
                adm.setClave(rs.getString("clave"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adm;
    }

    //REGISTRAR ENFERMERO
    public boolean registrarEnfermero(Connection cx, Enfermero enf) {
        boolean resp = false;
        String usu = enf.getUsuario();
        String nom = enf.getNombre();
        String tel = enf.getTelefono();
        String dir = enf.getDireccion();
        String edad = ""+enf.getEdad();
        String pass = enf.getClave();
        String sql = "INSERT INTO enfermeros (usuario, nombre, telefono, direccion, edad, clave) VALUES('"+usu+"','"+nom+"','"+tel+"','"+dir+"','"+edad+"','"+pass+"')";
        try {
            st = cx.createStatement();
            st.executeUpdate(sql);
            resp = true;
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    //BUSCAR ENFERMERO POR USUARIO
    public Enfermero buscarEnfermero(Connection cx, String usuario) {
        String sql = "SELECT * FROM enfermeros WHERE usuario='" + usuario + "'";
        Enfermero enf = null;
        try {
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                enf = new Enfermero();
                enf.setUsuario(rs.getString("usuario"));
                enf.setNombre(rs.getString("nombre"));
                enf.setTelefono(rs.getString("telefono"));
                enf.setDireccion(rs.getString("direccion"));
                enf.setEdad(rs.getInt("edad"));
                enf.setClave(rs.getString("clave"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enf;
    }

    //MODIFICAR ENFERMERO
    public boolean modificarEnfermero(Connection cx, Enfermero enf) {
        boolean resp = false;
        String usu = enf.getUsuario();
        String nom = enf.getNombre();
        String tel = enf.getTelefono();
        String dir = enf.getDireccion();
        String edad = ""+enf.getEdad();
        String pass = enf.getClave();
        String sql = "UPDATE enfermeros SET nombre='"+nom+"',telefono='"+tel+"',direccion='"+dir+"',edad='"+edad+"',clave='"+pass+"' WHERE usuario='"+usu+"'";
        try {
            st = cx.createStatement();
            st.executeUpdate(sql);
            resp = true;
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }
    
    //REGISTRAR VACUNA
    public boolean registrarVacuna(Connection cx, Vacuna vac) {
        boolean resp = false;
        String nom = vac.getNombre();
        String dosis = vac.getDosis();
        String cant = ""+vac.getCantidad();
        String sql = "INSERT INTO vacuna (nombre, dosis, cantidad) VALUES('"+nom+"','"+dosis+"','"+cant+"')";
        try {
            st = cx.createStatement();
            st.executeUpdate(sql);
            resp = true;
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    //BUSCAR VACUNA POR NOMBRE
    public Vacuna buscarVacuna(Connection cx, String nombre) {
        String sql = "SELECT * FROM vacuna WHERE nombre='" + nombre + "'";
        Vacuna vac = null;
        try {
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                vac = new Vacuna();
                vac.setId(rs.getInt("id"));
                vac.setNombre(rs.getString("nombre"));
                vac.setDosis(rs.getString("dosis"));
                vac.setCantidad(rs.getInt("cantidad"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vac;
    }
    //BUSCAR VACUNA POR ID
    public Vacuna buscarVacunaID(Connection cx, String id) {
        String sql = "SELECT * FROM vacuna WHERE id='" + id + "'";
        Vacuna vac = null;
        try {
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                vac = new Vacuna();
                vac.setId(rs.getInt("id"));
                vac.setNombre(rs.getString("nombre"));
                vac.setDosis(rs.getString("dosis"));
                vac.setCantidad(rs.getInt("cantidad"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vac;
    }

    //MODIFICAR VACUNA
    public boolean modificarVacuna(Connection cx, Vacuna vac) {
        boolean resp = false;
        String id = ""+vac.getId();
        String nom = vac.getNombre();
        String dosis = vac.getDosis();
        String cant = ""+vac.getCantidad();
        String sql = "UPDATE vacuna SET nombre='"+nom+"',dosis='"+dosis+"',cantidad='"+cant+"' WHERE id='"+id+"'";
        try {
            st = cx.createStatement();
            st.executeUpdate(sql);
            resp = true;
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }
    
    //REGISTRAR PACIENTE
    public boolean registrarPaciente(Connection cx, Paciente pac) {
        boolean resp = false;
        String ced = pac.getCedula();
        String nom = pac.getNombre();
        String tel = pac.getTelefono();
        String dir = pac.getDireccion();
        String edad = ""+pac.getEdad();
        String sql = "INSERT INTO paciente (cedula, nombre, telefono, direccion, edad) VALUES('"+ced+"','"+nom+"','"+tel+"','"+dir+"','"+edad+"')";
        try {
            st = cx.createStatement();
            st.executeUpdate(sql);
            resp = true;
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    //BUSCAR PACIENTE POR CEDULA
    public Paciente buscarPaciente(Connection cx, String cedula) {
        String sql = "SELECT * FROM paciente WHERE cedula='" + cedula + "'";
        Paciente pac = null;
        try {
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                pac = new Paciente();
                pac.setCedula(rs.getString("cedula"));
                pac.setNombre(rs.getString("nombre"));
                pac.setTelefono(rs.getString("telefono"));
                pac.setDireccion(rs.getString("direccion"));
                pac.setEdad(rs.getInt("edad"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pac;
    }

    //MODIFICAR PACIENTE
    public boolean modificarPaciente(Connection cx, Paciente pac) {
        boolean resp = false;
        String ced = pac.getCedula();
        String nom = pac.getNombre();
        String tel = pac.getTelefono();
        String dir = pac.getDireccion();
        String edad = ""+pac.getEdad();
        String sql = "UPDATE paciente SET nombre='"+nom+"',telefono='"+tel+"',direccion='"+dir+"',edad='"+edad+"' WHERE cedula='"+ced+"'";
        try {
            st = cx.createStatement();
            st.executeUpdate(sql);
            resp = true;
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    //BUSCAR PACIENTE_VACUNA POR CEDULA
    public ArrayList<Paciente_vacuna> buscarPacienteVacuna(Connection cx, String cedula) {
        String sql = "SELECT * FROM paciente_vacuna WHERE paciente='" + cedula + "'";
        ArrayList<Paciente_vacuna> listado = new ArrayList<>();
        Paciente_vacuna pv = null;
        try {
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                pv = new Paciente_vacuna();
                pv.setPaciente(rs.getString("paciente"));
                pv.setVacuna(rs.getString("vacuna"));
                pv.setEnfermero(rs.getString("enfermero"));
                pv.setFecha(rs.getString("fecha"));
                listado.add(pv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
    }

    //LISTAR TODAS LAS VACUNAS REGISTRADAS
    public ArrayList<Vacuna> listarVacunas(Connection cx){
        String sql = "SELECT * FROM vacuna";
        ArrayList<Vacuna> listado = new ArrayList<Vacuna>();
        try {
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Vacuna vac = new Vacuna();
                vac.setId(rs.getInt("id"));
                vac.setNombre(rs.getString("nombre"));
                vac.setDosis(rs.getString("dosis"));
                vac.setCantidad(rs.getInt("cantidad"));
                listado.add(vac);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
    }
    
    //REGISTRAR NUEVA VACUNA PUESTA
    public boolean registrarVacunaPuesta(Connection cx, Paciente_vacuna pv) {
        boolean resp = false;
        String pac = pv.getPaciente();
        String vac = ""+pv.getVacuna();
        String enf = pv.getEnfermero();
        String fecha = pv.getFecha();
        String sql = "INSERT INTO paciente_vacuna (paciente, vacuna, enfermero, fecha) VALUES('"+pac+"','"+vac+"','"+enf+"','"+fecha+"')";
        try {
            st = cx.createStatement();
            st.executeUpdate(sql);
            resp = true;
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }
}
