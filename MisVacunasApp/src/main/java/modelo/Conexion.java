/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private String bd, url, user, pass, driver;
    private Connection cx;

    //CONSTRUCTOR DE LA CLASE
    public Conexion() {
        this.bd = "mi_vacuna_app";
        this.url = "jdbc:mysql://localhost:3306/";
        this.user = "root";
        this.pass = "";
        this.driver = "com.mysql.cj.jdbc.Driver";
    }
    
    //CONECTAR A LA BASE DE DATOS DE MI VACUNA APP
    public void conectar_BD(){
        try {
            Class.forName(driver);
            this.cx = DriverManager.getConnection(url+bd, user, pass);
            System.out.println("se conectó a BD "+bd);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //OBTENER CONEXION A LA BASE DE DATOS DE MI VACUNA APP
    public Connection getConexion(){
        return cx;
    }
    
    //DESCONECTAR DE LA BASE DE DATOS
    public void desconectar_BD(){
        try {
            cx.close();
            System.out.println("se desconectó de BD "+bd);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
