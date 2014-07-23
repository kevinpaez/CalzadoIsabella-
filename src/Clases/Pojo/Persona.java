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
public class Persona 
{
    
    private int idPersona;
    public int getidPersona() 
    {
        return idPersona;
    }
    public void setidPersona(int idPersona) 
    {
        this.idPersona = idPersona;
    }

    private String nombres;
    public String getNombres() 
    {
        return nombres;
    }
    public void setNombres(String nombres) 
    {
        this.nombres = nombres;
    }

    private String apellidos;
    public String getApellidos() 
    {
        return apellidos;
    }
    public void setApellidos(String apellidos) 
    {
        this.apellidos = apellidos;
    }

    private String telefonoCelular;
    public String getTelefonoCelular() 
    {
        return telefonoCelular;
    }
    public void setTelefonoCelular(String telefonoCelular) 
    {
        this.telefonoCelular = telefonoCelular;
    }

    private String telefonoConvencional;
    public String getTelefonoConvencional() 
    {
        return telefonoConvencional;
    }
    public void setTelefonoConvencional(String telefonoConvencional) 
    {
        this.telefonoConvencional = telefonoConvencional;
    }

    private String direccion;
    public String getDireccion() 
    {
        return direccion;
    }
    public void setDireccion(String direccion) 
    {
        this.direccion = direccion;
    }

    private String cedula;
    public String getCedula() 
    {
        return cedula;
    }
    public void setCedula(String cedula) 
    {
        this.cedula = cedula;
    }

    private String tipo;
    public String getTipo() 
    {
        return tipo;
    }
    public void setTipo(String tipo) 
    {
        this.tipo = tipo;
    }

    public Persona(int idPersona, String nombres, String apellidos, String telefonoCelular, String telefonoConvencional, String direccion, String cedula, String tipo) {
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefonoCelular = telefonoCelular;
        this.telefonoConvencional = telefonoConvencional;
        this.direccion = direccion;
        this.cedula = cedula;
        this.tipo = tipo;
    }

}
