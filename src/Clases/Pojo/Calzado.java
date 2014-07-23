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
public class Calzado 
{
    
    private int idCalzado;

    public Calzado() 
    {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int getIdCalzado() {
        return idCalzado;
    }
    public void setIdCalzado(int idCalzado) {
        this.idCalzado = idCalzado;
    }

    private int pagina;
    public int getPagina() {
        return pagina;
    }
    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    private String codigo;
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    private int talla;
    public int getTalla() {
        return talla;
    }
    public void setTalla(int talla) {
        this.talla = talla;
    }

    private String color;
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    private double precio;
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    private int existencia;
    public int getExistencia() {
        return existencia;
    }
    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public Calzado(int idCalzado, int pagina, String codigo, int talla, String color, double precio, int existencia) 
    {
        this.idCalzado = idCalzado;
        this.pagina = pagina;
        this.codigo = codigo;
        this.talla = talla;
        this.color = color;
        this.precio = precio;
        this.existencia = existencia;
    }

}
