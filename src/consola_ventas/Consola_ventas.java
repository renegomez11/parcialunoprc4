/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consola_ventas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author BRIAN,MADELINE, RENE,ALBERTO
 */
public class Consola_ventas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {  
        //declaracion de variables
       int opc = 0;
       String nombreusuario ="",constrasena ="";
       Usuarios usuario = new Usuarios();
       Scanner read = new Scanner (System.in);
       //declaracion de listas
       List<Inventarios> lstinventarios = new ArrayList<>();
       List<Usuarios> lstusuarios = new ArrayList<>();
       //contenido de las listas de productos
       lstinventarios.add( new Inventarios(1,"Plato de carne",5,30));
       lstinventarios.add( new Inventarios(2,"Plato de pollo",5.0,5));
       lstinventarios.add( new Inventarios(3,"Plato de costilla",3.0,60));
       lstinventarios.add( new Inventarios(4,"Plato de sopa",5.0,100));
       lstinventarios.add( new Inventarios(5,"Plato de bocas",5.0,500));
       lstinventarios.add( new Inventarios(6,"Coctel mixto",2.0,20));
       lstinventarios.add( new Inventarios(7,"Tacos",2.25,25));
       lstinventarios.add( new Inventarios(8,"Burritos",2.75,30));
       lstinventarios.add( new Inventarios(9,"Gaseosa",0.60,180));
       lstinventarios.add( new Inventarios(10,"cerveza",1.25,50));
       //lista de usuarios
       lstusuarios.add(new Usuarios(new Personas("Rene","Salvador","Gomez","Renderos","Masculino",new Fecha(12,27,1996)),1,"admin","admin","Administrador"));
       lstusuarios.add(new Usuarios(new Personas("Madeline","Alonso","Arteaga","Agiuilar","Femenino",new Fecha(29,11,1995)),2,"vendedor","vendedor123","Vendedor"));
       lstusuarios.add(new Usuarios(new Personas("Alberto","Herrera","Ruiz","Ugarte","Masculino",new Fecha(11,10,1995)),3,"invitado","invitado123","Invitado"));
       Usuarios.menuPrincipal(lstusuarios,lstinventarios);

    }
    
    
}
