/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WINDOWS 7
 */
public class Conexion 
{
    private Connection conex = null;
    private PreparedStatement preStat = null;
    private ResultSet resul = null;
    
    private static Conexion instancia;
    public static Conexion GetInstancia()
    {
        if (instancia==null) 
        {
            instancia=new Conexion();
        }
        return instancia;
    }
    
    
    private static String usuario;
    public static String getUsuario() 
    {
        return usuario;
    }
    public static void setUsuario(String usuario) 
    {
        Conexion.usuario = usuario;
    }

    private static String clave;
    public static String getClave() 
    {
        return clave;
    }
    public static void setClave(String clave) 
    {
        Conexion.clave = clave;
    }

    private static String cadenaConexion;
    public static String getCadenaConexion() 
    {
        return cadenaConexion;
    }
    public static void setCadenaConexion(String cadenaConexion) {
        Conexion.cadenaConexion = cadenaConexion;
    }
    public void conectar()
    {
        try {
            conex = (Connection) DriverManager.getConnection(cadenaConexion, usuario,clave );
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void desconectar()
    {
        try {
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ejecutar(String instruccion) throws SQLException
    {
        try
        {
            preStat=(PreparedStatement) conex.prepareStatement(instruccion);
            
            preStat.executeUpdate();
        }
        catch(SQLException ex)
        {
            throw ex;
        }
    }
    
    public ResultSet consultar(String instruccion) throws SQLException
     {
        try
        {
            preStat=(PreparedStatement) conex.prepareStatement(instruccion);
            ResultSet rs=preStat.executeQuery();
            return rs;
        }
        catch(SQLException ex)
        {
            throw ex;
        }
     }
}
