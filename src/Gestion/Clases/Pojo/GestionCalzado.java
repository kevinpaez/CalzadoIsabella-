/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestion.Clases.Pojo;

import Clases.Pojo.Calzado;
import Datos.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author WINDOWS 7
 */
public class GestionCalzado implements IIsabella
{
    
    ResultSet rs=null;
    
    private Calzado objCalzado;
    public Calzado getObjCalzado() {
        return objCalzado;
    }
    public void setObjCalzado(Calzado objCalzado) {
        this.objCalzado = objCalzado;
    }


    public GestionCalzado() 
    {
        objCalzado = new Calzado(0, 0, "", 0, "", 0, 0);
        Conexion.setUsuario("sa");
        Conexion.setClave("123");
        Conexion.setCadenaConexion("jdbc:sqlserver://kenan-pc:1433;databaseName=Isabella");
    }

    @Override
    public void insertar() throws SQLException 
    {
        try
        {
            Conexion.GetInstancia().conectar();
            Conexion.GetInstancia().ejecutar(
                    "INSERT INTO [dbo].[Calzado] ([Página],[Código],[Talla],[Color],[Precio],[Existencia])"
                            + "VALUES('"+objCalzado.getPagina()+"','"+objCalzado.getCodigo()+"','"+objCalzado.getTalla()+"','"+objCalzado.getColor()+"',"
                            + "'"+objCalzado.getPrecio()+"','"+objCalzado.getExistencia()+"')");
        }
        catch(SQLException ex)
        {
                    throw ex;
        }
        finally{Conexion.GetInstancia().desconectar();}
    }

    @Override
    public void eliminar() throws SQLException 
    {
        try
        {
            Conexion.GetInstancia().conectar();
            Conexion.GetInstancia().ejecutar("DELETE FROM [dbo].[Calzado] WHERE Código='"+this.objCalzado.getCodigo()+"'");
        }
        catch(SQLException ex){throw ex;}
        finally{Conexion.GetInstancia().desconectar();}
    }

    @Override
    public void actualizar() throws SQLException 
    {
        try
        {
            Conexion.GetInstancia().conectar();
            Conexion.GetInstancia().ejecutar("UPDATE [dbo].[Calzado] SET "
                    + "[Página] = "+this.objCalzado.getPagina()+",[Código] = '"+this.objCalzado.getCodigo()+"',"
                    + "[Talla] = "+this.objCalzado.getTalla()+",[Color] = '"+this.objCalzado.getColor()+"',"
                    + "[Precio] = "+this.objCalzado.getPrecio()+",[Existencia] = "+this
                    .objCalzado.getExistencia()+" WHERE Código='"+this.objCalzado.getCodigo()+"'");
        }
        catch(SQLException ex){throw ex;}
        finally{Conexion.GetInstancia().desconectar();}
    }

    @Override
    public void consultar() throws SQLException 
    {
        try
        {
            Conexion.GetInstancia().conectar();
            rs = Conexion.GetInstancia().consultar("SELECT [Página],[Código],[Talla],[Color],[Precio],[Existencia]"
                    + "FROM [dbo].[Calzado] WHERE Código='"+this.objCalzado.getCodigo()+"'");
            rs.next();
            //while(rs.next())
            //{
                this.objCalzado.setPagina(Integer.parseInt(rs.getString(1)));
                this.objCalzado.setCodigo(rs.getString(2));
                this.objCalzado.setTalla(Integer.parseInt(rs.getString(3)));
                this.objCalzado.setColor(rs.getString(4));
                this.objCalzado.setPrecio(Double.parseDouble(rs.getString(5)));
                this.objCalzado.setExistencia(Integer.parseInt(rs.getString(6)));
            //}
        }
        catch(SQLException ex){throw ex;}
        finally{Conexion.GetInstancia().desconectar();}
    }
    
    public void ConsultaPagina() throws SQLException
    {
        try
        {
            Conexion.GetInstancia().conectar();
            rs = Conexion.GetInstancia().consultar("SELECT [Página],[Código],[Talla],[Color],[Precio],[Existencia]"
                    + "FROM [dbo].[Calzado] WHERE Página='"+this.objCalzado.getPagina()+"'");
            rs.next();
            //while(rs.next())
            //{
                this.objCalzado.setPagina(Integer.parseInt(rs.getString(1)));
                this.objCalzado.setCodigo(rs.getString(2));
                this.objCalzado.setTalla(Integer.parseInt(rs.getString(3)));
                this.objCalzado.setColor(rs.getString(4));
                this.objCalzado.setPrecio(Double.parseDouble(rs.getString(5)));
                this.objCalzado.setExistencia(Integer.parseInt(rs.getString(6)));
        }
        catch(SQLException ex)
                {
                    throw ex;
                }
        finally{Conexion.GetInstancia().desconectar();}
    }
}

    

    