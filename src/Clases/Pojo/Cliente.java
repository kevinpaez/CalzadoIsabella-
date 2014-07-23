/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases.Pojo;

/**
 *
 * @author WINDOWS 7
 */
public class Cliente 
{
    
    private int idCliente;
    public int getidCliente() 
    {
        return idCliente;
    }
    public void setidCliente(int idCliente) 
    {
        this.idCliente = idCliente;
    }

    private String referencia;
    public String getReferencia() 
    {
        return referencia;
    }
    public void setReferencia(String referencia) 
    {
        this.referencia = referencia;
    }

    private String provincia;
    public String getProvincia() 
    {
        return provincia;
    }
    public void setProvincia(String provincia) 
    {
        this.provincia = provincia;
    }
    
    private String canton;
    public String getCanton() 
    {
        return canton;
    }
    public void setCanton(String canton) 
    {
        this.canton = canton;
    }

    private Persona idPersona;
    public Persona getIdPersona() 
    {
        return idPersona;
    }
    public void setIdPersona(Persona idPersona) 
    {
        this.idPersona = idPersona;
    }

    public Cliente(int idCliente, String referencia, String provincia, String canton, Persona idPersona) {
        this.idCliente = idCliente;
        this.referencia = referencia;
        this.provincia = provincia;
        this.canton = canton;
        this.idPersona = idPersona;
    }

}
