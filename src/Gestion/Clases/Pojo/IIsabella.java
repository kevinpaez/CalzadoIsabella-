/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestion.Clases.Pojo;

import java.sql.SQLException;



/**
 *
 * @author WINDOWS 7
 */
public interface IIsabella 
{
    public  void insertar() throws SQLException;
    public  void eliminar() throws SQLException; 
    public  void actualizar()   throws SQLException;
    public  void consultar() throws SQLException;
}
