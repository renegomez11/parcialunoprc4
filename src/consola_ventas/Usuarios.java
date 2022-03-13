/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consola_ventas;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.*;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author BRIAN,MADELINE, RENE,ALBERTO
 */
public class Usuarios extends Personas 
{
    private Personas personas;
    private int codusuario;
    private String nombusuario;
    private String contrasena;
    private String tipousuario;

    public Usuarios() 
    {
    }

    public Usuarios(Personas personas, int codusuario, String nombusuario, String contrasena, String tipousuario) {
        this.personas = personas;
        this.codusuario = codusuario;
        this.nombusuario = nombusuario;
        this.contrasena = contrasena;
        this.tipousuario = tipousuario;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    public int getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(int codusuario) {
        this.codusuario = codusuario;
    }

    public String getNombusuario() {
        return nombusuario;
    }

    public void setNombusuario(String nombusuario) {
        this.nombusuario = nombusuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }

    
    //Creamos un metodo para agregar usuarios 
    //donde requerimos como paramtero una lista y un string

    public boolean loguearse(List<Usuarios> lstusuarios, String nombusuario, String contrasena)
    {
        String entradausuarios = "",dirrecionbitacora ="",dirrecionlog = "";
        File f;
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Path dirrecionactualsistema = Paths.get("");
        dirrecionbitacora = dirrecionactualsistema.toAbsolutePath().toString() +"/Bitacora/bitacora.txt";
        dirrecionlog = dirrecionactualsistema.toAbsolutePath().toString() + "/Log/log.txt" ;
        f = new File(dirrecionbitacora);
        for (Usuarios lstusuario : lstusuarios) 
        {
            if (lstusuario.nombusuario.equals(nombusuario) && lstusuario.contrasena.equals(contrasena)) 
            {

                try
                {
                    entradausuarios = "Entrada "+"Cod usuario : " + lstusuario.getCodusuario() + " Nombre de usuario : "+
                                      lstusuario.getNombusuario() + " Nombre de persona : " + lstusuario.personas.getPrNombre()
                                      +" " +lstusuario.personas.getPrApellido() + " Hora,fecha de entrada: " + hourdateFormat.format(date)+"\r" +"\n";
                    FileWriter w = new FileWriter(f,true);
                    BufferedWriter bw = new BufferedWriter(w);
                    PrintWriter wr = new PrintWriter(bw);  
                    wr.write(entradausuarios);
                    wr.close();
                    bw.close();

                    
                }
                catch (Exception e)
                {
                    try
                     {
                        FileWriter w = new FileWriter(dirrecionlog,true);
                        BufferedWriter bw = new BufferedWriter(w);
                        PrintWriter wr = new PrintWriter(bw); 
                        wr.write( hourdateFormat.format(date) + " " + e.toString() + "\r\n");
                        wr.close();
                        bw.close();
                        System.out.println(e);
                       }
                       catch(Exception ex)
                       {
                           System.out.println(ex);
                       }
                    
                }
                return true;
            }
        }

        return false;
    }
    public void cambiarContrasena(List<Usuarios> lstusuarios)
    {
        Scanner read = new Scanner(System.in);
        String  informacion = "",codusustrg,contrasena;
        int codusuarint = 0, posicion = 0;
        System.out.print("Ingrese codigo de usuario, constrseña actual , nuevo contraseña: ");
        informacion = read.nextLine();
        String [] vector = informacion.split(",");
        codusustrg = vector[0];
        codusuarint = Integer.parseInt(codusustrg);
        if(codusuarint < 0)
        {
            codusuarint = codusuarint * -1;
        }
        contrasena = vector[1];
        for  (int i = 0; i < lstusuarios.size(); i++) 
        {
            if (codusuarint== lstusuarios.get(i).codusuario)
            {
                posicion = i;
            }
        }
        if(lstusuarios.get(posicion).getContrasena().equals(contrasena))
        {
                lstusuarios.get(posicion).setContrasena(contrasena);
                System.out.println("Exito al cambiar contraseña" + "\n");
        }
        else
        {
            System.out.println("Error al cambiar contraseña,revise sus datos" + "\n" );
        }
    }
    public void imprimirUsuarios(List<Usuarios> lstusuario)
    {
        Personas per = new Personas();
         for (int i = 0; i < lstusuario.size(); i++) 
        {
            System.out.print("\n"+"Cod de usuairo: " + lstusuario.get(i).codusuario +
                             " " + "Nombre de usuario : "+lstusuario.get(i).nombusuario +
                             " " + "Nombre de persona: "+lstusuario.get(i).personas.getPrNombre()+" "+lstusuario.get(i).personas.getPrApellido()+
                             " " +"Tipo de usuario: "+lstusuario.get(i).tipousuario );
                
        }
         System.out.print("\n");
         System.out.print("\n");

    }
    public void  menu(List<Usuarios> lstusuarios,List<Inventarios> lstinventario,String contrasena , String nombusuairo)
    {
        int opc = 0, posicion = 0;
        Scanner read = new Scanner (System.in);
        Inventarios inventarios = new Inventarios();
        Usuarios usuarios = new Usuarios();
        Ventas ventas = new Ventas();
        String tipousuairos ="",salidausuarios = "",dirrecionarchivo;
        File f;
        Path dirrecionactualsistema = Paths.get("");
        dirrecionarchivo = dirrecionactualsistema.toAbsolutePath().toString();
        f = new File(dirrecionarchivo+"/Bitacora/bitacora.txt");

        for (int i = 0 ;i< lstusuarios.size();i++)
        {
            if (contrasena.equals(lstusuarios.get(i).getContrasena()) && nombusuairo.equals(lstusuarios.get(i).getNombusuario())) 
            {
                posicion = i;
                tipousuairos = lstusuarios.get(i).getTipousuario();
                salidausuarios = "Salida "+"Cod usuario : " + lstusuarios.get(i).getCodusuario() + " Nombre de usuario : "+
                                  lstusuarios.get(i).getNombusuario() + " Nombre de persona : " + lstusuarios.get(i).personas.getPrNombre()
                                  +" " +lstusuarios.get(i).personas.getPrApellido() + " Hora,fecha de salida: ";
            }
        }
       if("Administrador".equals(tipousuairos) )
       {
       while (opc != 4)
        {
             System.out.print(
                     "\n "
                     +"Bienvenido "+ lstusuarios.get(posicion).getPersonas().getPrNombre() +" " 
                     + lstusuarios.get(posicion).getPersonas().getPrApellido() +"\n Usuario "
                     + lstusuarios.get(posicion).getNombusuario() + " del tipo " 
                     + lstusuarios.get(posicion).getTipousuario()+ "\n"
                     +"\t"+"¿Que desea hacer?" + "\n"
                     + "1.Venta nueva. \n"
                     + "2.Consultar inventarios." + "\n" 
                     + "3.Cambiar contraseña ." + "\n"
                     + "4.Regresar menu Principal" + "\n"
                     + "Ingrese opcion : ");
             opc = read.nextInt();
             switch (opc)
             {
                 case 1:
                 {
                     inventarios.imprimirListaProductos(lstinventario);
                     ventas.Facturacion(lstinventario);
                 }
                 break;
                 case 2:
                 {
                     inventarios.buscarProducto(lstinventario);

                 }
                 break;
                 case 3:
                 {
                     usuarios.cambiarContrasena(lstusuarios);
                 }
                 break;
                 case 4:
                 {
                    Date date = new Date();
                    DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
                    try
                    {
                    FileWriter w = new FileWriter(f,true);
                    BufferedWriter bw = new BufferedWriter(w);
                    PrintWriter wr = new PrintWriter(bw); 

                    wr.write(salidausuarios + hourdateFormat.format(date)+"\r" +"\n");
                    wr.close();
                    bw.close();
                    }
                    catch(Exception e)
                    {
                        System.out.print(e);
                    }
                    System.out.println("Regreso al menu principal\n");
                 }
                 break;
                 default:
                     System.out.print("Error,opcion no valida");
                 break;
             }
         }

       }
       if("Vendedor".equals(tipousuairos))
       {
        while (opc != 3)
        {
             System.out.print(
                     "\n "
                     +"Bienvenido "+ lstusuarios.get(posicion).getPersonas().getPrNombre() +" " 
                     + lstusuarios.get(posicion).getPersonas().getPrApellido() +"\n Usuario "
                     + lstusuarios.get(posicion).getNombusuario() + " del tipo " 
                     + lstusuarios.get(posicion).getTipousuario()+ "\n"
                     +"\t"+"¿Que desea hacer?" + "\n"
                     + "1.Venta nueva. \n"
                     + "2.Consultar inventarios." + "\n" 
                     + "3.Regresar menu Principal" + "\n"
                     + "Ingrese opcion : ");
             opc = read.nextInt();
             switch (opc)
             {
                 case 1:
                 {
                    inventarios.imprimirListaProductos(lstinventario);
                    ventas.Facturacion(lstinventario);
                 }
                 break;
                 case 2:
                 {
                     inventarios.buscarProducto(lstinventario);

                 }
                 break;
                 case 3:
                 {
                    Date date = new Date();
                    DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
                    try
                    {
                    FileWriter w = new FileWriter(f,true);
                    BufferedWriter bw = new BufferedWriter(w);
                    PrintWriter wr = new PrintWriter(bw); 

                    wr.write(salidausuarios  + hourdateFormat.format(date)+"\r" +"\n");
                    wr.close();
                    bw.close();
                    }
                    catch(Exception e)
                    {
                        System.out.print(e);
                    }
                    System.out.println("Regreso al menu principal\n");
                 }
                 break;
                 default:
                     System.out.print("Error,opcion no valida\n");
                 break;
             }
         }
           
       }
       if("Invitado".equals(tipousuairos))
       {
        while (opc != 2)
        {
             System.out.print(
                     "\n "
                     +"Bienvenido "+ lstusuarios.get(posicion).getPersonas().getPrNombre() +" " 
                     + lstusuarios.get(posicion).getPersonas().getPrApellido() +"\n Usuario "
                     + lstusuarios.get(posicion).getNombusuario() + " del tipo  " 
                     + lstusuarios.get(posicion).getTipousuario()+ "\n"
                     +"\t"+"¿Que desea hacer?" + "\n"
                     + "1.Consultar inventarios." + "\n" 
                     + "2.Regresar menu Principal" + "\n"
                     + "Ingrese opcion : ");
             opc = read.nextInt();
             switch (opc)
             {
                 case 1:
                 {
                     inventarios.imprimirListaProductos(lstinventario);    
                 }
                 break;

                 case 2:
                 {
                    Date date = new Date();
                    DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
                    try
                    {
                    FileWriter w = new FileWriter(f,true);
                    BufferedWriter bw = new BufferedWriter(w);
                    PrintWriter wr = new PrintWriter(bw); 

                    wr.write(salidausuarios + hourdateFormat.format(date)+"\r" +"\n");
                    wr.close();
                    bw.close();
                    }
                    catch(Exception e)
                    {
                        System.out.print(e);
                    }
                    System.out.println("Regreso al menu principal\n");
                 }
                 break;
                 default:
                     System.out.print("Error,opcion no valida\n");
                 break;
             }
         }
           
       }
    }
    public static void menuPrincipal(List<Usuarios> lstusuarios,List<Inventarios> lstinventario)
    {
       int opc = 0;
       String nombreusuario ="",contrasena ="";
       Usuarios usuario = new Usuarios();
       Scanner read = new Scanner (System.in);
       String tipousuairos ="",salidausuarios = "",dirrecionbitacora,dirrecionlog;
       File f;
       Path dirrecionactualsistema = Paths.get("");
       dirrecionbitacora = dirrecionactualsistema.toAbsolutePath().toString() + "/Bitacora/bitacora.txt";
       dirrecionlog = dirrecionactualsistema.toAbsolutePath().toString() + "/Log/log.txt";
       f = new File(dirrecionbitacora);
       try
       {
        while (opc !=  2)
        {
            System.out.print(
                    "Bienvenido al sistema de restaurante2 Esperanza\n" 
                    +"\t"+"Favor ingresar credenciales \n"
                    +"1.Ingresar. \n"
                    + "2.Salir." + "\n"
                    + "Ingrese opcion : ");
            opc = read.nextInt();
            switch(opc)
            {
                case 1:
                {
                    System.out.print("\nIngrse nombre de usuario: ");
                    nombreusuario = read.nextLine();
                    nombreusuario = read.nextLine();
                    System.out.print("Ingrese contraseña: ");
                    contrasena = read.nextLine();
                    if(usuario.loguearse(lstusuarios,nombreusuario, contrasena)== true)
                    {
                        try
                        {
                            usuario.menu(lstusuarios, lstinventario,contrasena,nombreusuario);
                            
                        }
                        catch(Exception e)
                        {
                            for (int i = 0 ;i< lstusuarios.size();i++)
                            {
                                if (contrasena.equals(lstusuarios.get(i).getContrasena()) && nombreusuario.equals(lstusuarios.get(i).getNombusuario())) 
                                {
                                    tipousuairos = lstusuarios.get(i).getTipousuario();
                                    salidausuarios = "Salida "+"Cod usuario : " + lstusuarios.get(i).getCodusuario() + " Nombre de usuario : "+
                                                      lstusuarios.get(i).getNombusuario() + " Nombre de persona : " + lstusuarios.get(i).personas.getPrNombre()
                                                      +" " +lstusuarios.get(i).personas.getPrApellido() + " Hora,fecha de salida: ";
                                }
                            }
                            Date date = new Date();
                            DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
                            FileWriter w = new FileWriter(f,true);
                            BufferedWriter bw = new BufferedWriter(w);
                            PrintWriter wr = new PrintWriter(bw); 
                            wr.write(salidausuarios + hourdateFormat.format(date)+"\r" +"\n");
                            wr.close();
                            bw.close();
                            System.out.println(e + "\n");
                        }
                    }
                    else
                    {
                        System.out.print("Contraseña o Usuario , Incorrecto\n\n");
                    }
                    
                }
                break;

                case 2:
                {
                    System.out.print("Esta saliendo del programa\n");
                }
                break;
                default:
                    System.out.print("Error,opcion no valida");
                break;
            }

        } 
           
       }
       catch(Exception e)
       {
           try
           {
                Date date = new Date();
                DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
                FileWriter w = new FileWriter(dirrecionlog,true);
                BufferedWriter bw = new BufferedWriter(w);
                PrintWriter wr = new PrintWriter(bw); 
                wr.write( hourdateFormat.format(date) + " " + e.toString() + "\r\n");
                wr.close();
                bw.close();
                System.out.println(e);
           }
           catch(Exception ex)
           {
               System.out.println(ex);
           }
               
       }
        
    }
}
