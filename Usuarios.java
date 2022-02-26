/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class Usuarios {

    private Scanner Producto;
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

    public Scanner getProducto() {
        return Producto;
    }
//realizamos los constructores por cada variable
    public void setProducto(Scanner Producto) {
        this.Producto = Producto;
    }

    //validacion y prueba de login de acuerdo a los usuarios creados
    public void inicializar() {
        Producto = new Scanner(System.in);
        System.out.print("Bienvenido al sistema de Restaurante Esperanza\n");
        System.out.print("Favor ingresar sus credenciales\n");
        do {
            //ingresamos el usuario
            System.out.print("Ingrese su usuario: ");
            usuario = Producto.next();
            //ingresamos la contraseña
            System.out.print("Ingrese su clave: ");
            clave = Producto.next();
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
}
