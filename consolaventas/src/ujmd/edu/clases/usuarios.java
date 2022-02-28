/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ujmd.edu.clases;

/**
 *
 * @author Rene Salvador Gomez
 */
import java.util.Scanner;

/**
 *
 * @author Rene Gomez
 */

//clase usuarios
public class usuarios {
//iniciamos las variables que contendra la clase usuarios y que sera por medio de entraga al teclado
    private Scanner teclado;
    private String usuario;
    private String clave;
    private String nivel;
    int i;

    public usuarios() {
    }

    public usuarios(String usuario, String clave, String nivel) {
        this.usuario = usuario;
        this.clave = clave;
        this.nivel = nivel;
    }
    //realizamos los constructores por cada variable
    public String getUsuario() {
        return usuario;
    }
//realizamos los constructores por cada variable
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
//realizamos los constructores por cada variable
    public String getClave() {
        return clave;
    }
//realizamos los constructores por cada variable
    public void setClave(String clave) {
        this.clave = clave;
    }
//realizamos los constructores por cada variable
    public String getNivel() {
        return nivel;
    }
//realizamos los constructores por cada variable
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Scanner getTeclado() {
        return teclado;
    }
//realizamos los constructores por cada variable
    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    //validacion y prueba de login de acuerdo a los usuarios creados
    public void inicializar() {
        teclado = new Scanner(System.in);
        System.out.print("Bienvenido al sistema de ventas Don Diego\n");
        System.out.print("Favor ingresar sus credenciales\n");
        do {
            //ingresamos el usuario
            System.out.print("Ingrese su usuario: ");
            usuario = teclado.next();
            //ingresamos la contraseña
            System.out.print("Ingrese su clave: ");
            clave = teclado.next();
            if (usuario.isEmpty() || clave.isEmpty()) {
                System.out.print("Error, Campos sin rellenar");
            } else {
                //evaluacion de los posibles usuarios 
                if (usuario.equals("admin") && clave.equals("admin123")) {
                    System.out.print("Bienvenido " + usuario);
                    int i = 0;
                    menu();
                } else {
                    if (usuario.equals("vendedor") && clave.equals("vendedor123")) {
                        System.out.print("Bienvenido " + usuario);
                        i = 0;
                        menu();
                    } else {
                        if (usuario.equals("invitado") && clave.equals("invitado123")) {
                            System.out.print("Bienvenido " + usuario);
                            i = 0;
                            menu();
                            //si el usuario ingresado no es correcto procedemos a mostrar un error
                        } else {
                            System.out.print("Error, su Usuario o Contraseña son incorrectos");
                        }
                    }
                }
            }
        } while (i > 0);

    }
//////////////////////////////////////////////////////////////////////////////////////////////////////
    //menu de opciones
    public void menu() {
        int seleccion = 0;
        System.out.println("\n!BIENVENIDO AL MENU DE OPCIONES DE RESTAURANTE EZPERANZA!");
        System.out.println("¿Qué desea hacer?");
        System.out.println("1. Venta nueva");
        System.out.println("2. Consultar inventarios");
        System.out.println("3. Cambiar contraseña");
        System.out.println("4. Salir");

        //ciclo while con el menu de opciones
        while (seleccion != 4) {
            try {
                System.out.println("Seleccione el número de la acción a realizar");
                seleccion = teclado.nextInt();
                switch (seleccion) {
                    //case por cada una de las opciones del menu
                    case 1:
                        //case para la venta de producto
                        Catalogo catalogo1 = new Catalogo();
                        catalogo1.imprimir();
                        break;
                        //case para consultar el catalogo
                    case 2:
                        System.out.println("PRODUCTO    CANTIDAD");
                        System.out.println("1- plato de carne       30");
                        System.out.println("2- plato de pollo         5");
                        System.out.println("3- plato de pasta       60");
                        System.out.println("4- plato de costilla    100");
                        System.out.println("5- plato de cerdo      500");
                        System.out.println("6- desayuno tipico    20");
                        System.out.println("7- desayuno americano        25");
                        System.out.println("8- desayuno economico        30");
                        System.out.println("9- plato de mariscos     180");
                        System.out.println("10- entradas varias 50");

                        break;
                    case 3:
                           //case para el cambio de contraseña
                        break;
                    case 4:
                        //case para cerrar sesion
                        System.out.println("Cerrando sesión... ¡Regresa pronto!");
                        break;
                    default:
                        //case para opcion no definida 
                        System.out.println("opcion no valida");
                }
                
            } catch (Exception datoErroneo) {
                System.out.println("Debe seleccionar una acción");
                teclado.next();
            }
        }
    }
}
