/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consola_ventas;

import java.util.*;

/**
 *
 * @author BRIAN,MADELINE, RENE,ALBERTO
 */
public class Personas extends Fecha
{
    private String prNombre;
    private String sdNomnbre;
    private String prApellido;
    private String sdApellido;
    private String genero;
    private Fecha fechaNacimiento;
    

    public Personas() 
    {
        
    }

    public Personas(String prNombre, String sdNomnbre, String prApellido, String sdApellido, String genero, Fecha fechaNacimiento) 
    {
        this.prNombre = prNombre;
        this.sdNomnbre = sdNomnbre;
        this.prApellido = prApellido;
        this.sdApellido = sdApellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Personas(String prNombre, String prApellido, String sdApellido, String genero, Fecha fechaNacimiento)
    {
        this.prNombre = prNombre;
        this.prApellido = prApellido;
        this.sdApellido = sdApellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Personas(String prNombre, String prApellido, String genero, Fecha fechaNacimiento) 
    {
        this.prNombre = prNombre;
        this.prApellido = prApellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPrNombre() {
        return prNombre;
    }

    public void setPrNombre(String prNombre) {
        this.prNombre = prNombre;
    }

    public String getSdNomnbre() {
        return sdNomnbre;
    }

    public void setSdNomnbre(String sdNomnbre) {
        this.sdNomnbre = sdNomnbre;
    }

    public String getPrApellido() {
        return prApellido;
    }

    public void setPrApellido(String prApellido) {
        this.prApellido = prApellido;
    }

    public String getSdApellido() {
        return sdApellido;
    }

    public void setSdApellido(String sdApellido) {
        this.sdApellido = sdApellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) 
    {
        this.fechaNacimiento = fechaNacimiento;
    }

    
 
    
}