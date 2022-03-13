/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consola_ventas;

import  java.util.*;

/**
 *
 * @author BRIAN,MADELINE, RENE,ALBERTO
 */

//definiendo la clase inventarios
public class Inventarios 
{
    private int codInventario;
    private String nombInventario;
    private double precio;
    private int cantidad;
    private List existencias;

    public Inventarios() {
    }

    public Inventarios(int codInventario, String nombInventario, double precio, int cantidad) {
        this.codInventario = codInventario;
        this.nombInventario = nombInventario;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    //metodos get de codigo inventario
    public int getCodInventario() {
        return codInventario;
    }
 //metodos set de codigo inventario
    public void setCodInventario(int codInventario) {
        this.codInventario = codInventario;
    }

 //metodos get de nombre inventario
    public String getNombInventario() {
        return nombInventario;
    }
 //metodos set de nombre inventario
    public void setNombInventario(String nombInventario) {
        this.nombInventario = nombInventario;
    }
 //metodos get de precio inventario
    public double getPrecio() {
        return precio;
    }
 //metodos set de precio inventario
    public void setPrecio(double precio) {
        this.precio = precio;
    }
 //metodos get de cantidad inventario
    public int getCantidad() {
        return cantidad;
    }
 //metodos set de cantidad inventario
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
 //metodos get de existencias inventario
    public List getExistencias() {
        return existencias;
    }
 //metodos set de existencias inventario
    public void setExistencias(List existencias) {
        this.existencias = existencias;
    }
    
    //agregar
    public void agregarInventario(List<Inventarios> invt)
    {
       Scanner read = new Scanner(System.in);
       String nomb = "",com = "s";
       int cod = 10,cant = 0;
       double prec = 0.00;
       
       setCodInventario(cod);
       setNombInventario(nomb);
       setPrecio(prec);
       setCantidad(cant);
       
       while("s".equals(com)||"S".equals(com)){
           System.out.print("Nombre del producto : ");
           nomb = read.nextLine();
           System.out.print("Precio del producto : ");
           prec = read.nextDouble();
           System.out.print("Cantidad del producto :");
           cant = read.nextInt();
           cod++;
           invt.add(new Inventarios(cod,nomb,prec,cant));
           System.out.print("¿Desea agregar producto al inventario S/N?: ");
           com = read.nextLine();
           com = read.nextLine();
          }
       setExistencias(invt);
    }
    
    //imprimir invetario
    public void imprimirListaProductos(List<Inventarios> invt)
    {
        for (Inventarios invt1 : invt) {
            System.out.println("Cod: " + invt1.codInventario + " Nombre: " + invt1.nombInventario + " Precio: $ " + invt1.precio);
        }
      
    }
    
    //busqueda de producto
    public void buscarProducto( List<Inventarios> invt)
    {
        Scanner read = new Scanner(System.in);
        String teclado = "";
        int tecladon = 0,pos = 0,opc = 0;
        boolean t = false;
        
        // menu de opciones
        System.out.print("\nTipo de busqueda deseada  " +
                         "\n" + "1.Por codigo" +
                         "\n" + "2.Por nombre" +
                         "\n" + "3.Mostrar todos" + 
                         "\n" + "Ingrese opcion: ");
        opc = read.nextInt();
        switch(opc)
        {
            //busqueda por codigo de producto
            case 1 :
            {
                System.out.print("Ingrese codigo del producto : ");
                tecladon = read.nextInt();
                 for (int i = 0; i <invt.size(); i++)
                 {
                     if (tecladon == invt.get(i).codInventario)
                     {
                        pos = i;
                        t = true;
                     }
                 }
                 if (t == true)
                 {
                     System.out.println("La cantidad del producto " +invt.get(pos).nombInventario+" es de : " +""+ invt.get(pos).cantidad);
                 }
                 else 
                 {
                     System.out.println("El producto no ha sido encontrado");
                 }
                
            }
                break;
                //busqueda por nombre de producto
            case 2 :
            {
                System.out.print("Ingrese nombre del producto : ");
                teclado = read.nextLine();
                teclado = read.nextLine();
                if("Todos".equals(teclado) ||"TODOS".equals(teclado)|| "todos".equals(teclado))
                {
                    for (int i = 0; i < invt.size(); i++) 
                    {
                        System.out.println("Cod: "+invt.get(i).codInventario +" Nombre: " +invt.get(i).nombInventario + " Cantidad: " + invt.get(i).cantidad );
                    }
                }
                else{
                 for (int i = 0; i <invt.size(); i++)
                 {
                     if (teclado.equals(invt.get(i).nombInventario)||teclado.equals(invt.get(i).nombInventario.toUpperCase())||teclado.equals(invt.get(i).nombInventario.toLowerCase()))
                     {
                        pos = i;
                        t = true;
                     }
                 }
                 if (t == true)
                 {
                     System.out.println("La cantidad del producto " +invt.get(pos).nombInventario+" es de : " +""+ invt.get(pos).cantidad);
                 }
                 else 
                 {
                     if(t ==false ){
                     System.out.println("El producto no ha sido encontrado");
                     }
                 }
                }
            }
                break;
                
                //mostrar todos los productos
            case 3 :
            {
                for (int i = 0; i < invt.size(); i++) 
                {
                    System.out.println("Cod: "+invt.get(i).codInventario +" Nombre: " +invt.get(i).nombInventario + " Cantidad: " + invt.get(i).cantidad );
                }
            }
                break;
            default :
                System.out.println("Error,opcion no valida");
                break;
        }
        

    }
}
