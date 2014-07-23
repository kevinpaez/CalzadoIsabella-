/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestion.Clases.Pojo;

import Clases.Pojo.Cliente;
import Clases.Pojo.Persona;
import Datos.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author WINDOWS 7
 */
public class GestionCliente implements IIsabella
{
    
    ResultSet rs=null;
    
    private int numRegistros ;
    
    
    private Persona objPersona;
    public Persona getObjPersona() 
    {
        return objPersona;
    }
    public void setObjPersona(Persona objPersona) 
    {
        this.objPersona = objPersona;
    }

    private Cliente objCliente;
    public Cliente getObjCliente() 
    {
        return objCliente;
    }
    public void setObjCliente(Cliente objCliente) 
    {
        this.objCliente = objCliente;
    }

//    public GestionCliente() 
//    {
//        objCliente = new Cliente(0, null, null, null, null);
//        Conexion.setUsuario("sa");
//        Conexion.setClave("123");
//        Conexion.setCadenaConexion("jdbc:sqlserver://SHEFJSHENCKKO:1433;databaseName=Isabella");
//    }
//    public GestionCliente(int num_registros, Persona objPersona, Cliente objCliente) 
//    {
//        Conexion.setUsuario("sa");
//        Conexion.setClave("123");
//        Conexion.setCadenaConexion("jdbc:sqlserver://SHEFJSHENCKKO:1433;databaseName=Isabella");
//        this.num_registros = num_registros;
//        this.objPersona = objPersona;
//        this.objCliente = objCliente;
//    }
    public GestionCliente() 
    {
        objCliente = new Cliente(0,"","","",objPersona);
        objPersona = new Persona(0,"","","","","","","");
        Conexion.setUsuario("sa");
        Conexion.setClave("123");
        Conexion.setCadenaConexion("jdbc:sqlserver://kenan-pc:1433;databaseName=Isabella");
    }
    
    


    @Override
    public void insertar() throws SQLException 
    {
        try
        {
            //for (int i = 0; i < numRegistros; i++) 
            //{
                Conexion.GetInstancia().conectar();
                Conexion.GetInstancia().ejecutar("INSERT INTO [dbo].[Persona]([Nombres],[Apellidos],[Teléfono Celular],[Convencional],[Dirección],[Cédula],[Tipo])"
                        + "VALUES('"+this.objPersona.getNombres()+"','"+this.objPersona.getApellidos()+"','"+this.objPersona.getTelefonoCelular()+"',"
                        + "'"+this.objPersona.getTelefonoConvencional()+"','"+this.objPersona.getDireccion()+"','"+this.objPersona.getCedula()+"','"+this.objPersona.getTipo()+"')");

                rs = Conexion.GetInstancia().consultar("select MAX(ID_Persona)as dato from Persona");
                
                rs.next();
                Integer x=rs.getInt("dato");
//                {
//                    this.objPersona.setidPersona(Integer.parseInt(rs.getString(0)));
//                }
            //}
//            for (int i = 0; i < numRegistros; i++) 
//            {
                //Conexion.GetInstancia().conectar();
                String Cadena = "INSERT INTO [dbo].[Clientes] ([Referencia],[Provincia],[Cantón],[ID_Persona])"
                    + "VALUES('"+this.objCliente.getReferencia()+"','"+this.objCliente.getProvincia()+"',"
                    + "'"+this.objCliente.getCanton()+"',"+Integer.toString(x)+")";
                Conexion.GetInstancia().ejecutar(Cadena);
//            }
            
        }
        catch(SQLException ex){throw ex;}
        finally{Conexion.GetInstancia().desconectar();}
    }

    @Override
    public void eliminar() throws SQLException 
    {
    
    }

    @Override
    public void actualizar() throws SQLException 
    {
    
    }

    @Override
    public void consultar() throws SQLException 
    {
        try
        {
            Conexion.GetInstancia().conectar();
            String sql;
             rs = Conexion.GetInstancia().consultar("Select Persona.ID_Persona, ID_Cliente, Nombres,Apellidos,"
                     + "[Teléfono Celular],Convencional,Dirección,Referencia,Cédula,Provincia,Cantón "
                     + "from Persona Inner Join Clientes on Persona.ID_Persona=Clientes.ID_Persona "
                     + "where Cédula='"+this.objPersona.getCedula()+"'");
             
             rs.next();
                
                this.objPersona.setNombres(rs.getString(3));
                this.objPersona.setApellidos(rs.getString(4));
                this.objPersona.setTelefonoCelular(rs.getString(5));
                this.objPersona.setTelefonoConvencional(rs.getString(6));
                this.objPersona.setDireccion(rs.getString(7));
                this.objCliente.setReferencia(rs.getString(8));
                //this.objPersona.setCedula(rs.getString(7));
                this.objCliente.setProvincia(rs.getString(9));
                this.objCliente.setCanton(rs.getString(10));
            
        }
        catch(SQLException ex){throw ex;}
        finally{Conexion.GetInstancia().desconectar();}
    }
    
}
