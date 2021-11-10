/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    //ELIMINAR ENFERMERO
    public boolean eliminarEnfermero(Connection cx, String usuario) {
        boolean resp = false;
        String sql = "DELETE FROM enfermeros WHERE usuario='"+usuario+"'";
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

    //ELIMINAR VACUNA
    public boolean eliminarVacuna(Connection cx, String id) {
        boolean resp = false;
        String sql = "DELETE FROM vacuna WHERE id='"+id+"'";
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
