/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestion.Clases.Pojo;

import Clases.Pojo.Calzado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author WINDOWS 7
 */
public class busquedaPagina 
{
    private static final String URL = "jdbc:sqlserver://SHEFJSHENCKKO:1433;databaseName=Isabella";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";
    private Connection connection = null;
    private PreparedStatement seleccionarTodaPagina = null;
//    private PreparedStatement selectPeopleByLastName = null;
//    private PreparedStatement selectPeopleByFecha = null;
//    private PreparedStatement insertNewPerson = null;
    private String selectTodo = "select * from Calzado ";
//    private String selectByLastName = "SELECT * FROM vuelos_disponibles WHERE destino=?";
    private String selectPágina = "SELECT * FROM Calzado WHERE Página=?";

//    private String insertPerson = "INSERT INTO horarios_vuelo "
//            + "(destino, fecha, valor_vuelo, numero_vuelo,origen)" + " VALUES(?,?,?,?,?)";
    public busquedaPagina() 
    {
        try 
        {
            Class.forName("org.sql.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //connection.setSchema("ADMINI");
            System.out.println("Conexion realizada satisfactoriamente");
        }
        catch (Exception ex) {System.out.println("error en conexion : " + ex.getMessage());}
    }
    
    public List<Calzado> ConsultaCalzado() 
    {
        List<Calzado> listaCalzado = null;
        ResultSet rs = null;
        try
        {
            seleccionarTodaPagina = connection.prepareStatement(selectTodo);
            rs=seleccionarTodaPagina.executeQuery();
            listaCalzado = new ArrayList<Calzado>();
            while(rs.next())
            {
                Calzado cl = new Calzado();
                rs.getString("Página");
                rs.getString("Código");
                rs.getString("Talla");
                rs.getString("Color");
                rs.getString("Precio");
                rs.getString("Existencia");
                listaCalzado.add(cl);
            }
        }
        catch(SQLException ex) { JOptionPane.showInputDialog(null, ex.getMessage());}
        return listaCalzado;
    }
}
