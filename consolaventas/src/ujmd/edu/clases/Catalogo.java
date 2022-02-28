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
public class Catalogo {

    Scanner reader = new Scanner(System.in);
    private int[] codigo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private String[] producto = {" plato de carne c/u $0.10", 
        " plato de pollo c/u $5.00", 
        " plato de pasta c/u $3.00", 
        " plato de costilla c/u $0.50", 
        " plato de cerdo c/u $ 0.80", 
        " desayuno tipico c/u $0.30",
        " desayuno americano c/u $ 2.25", 
        " desayuno economico c/u $ 2.75", 
        " plato de mariscos c/u $1.80", 
        " entradas varias c/u $3.25"};
    int f = 0;
    String p;

    public Catalogo() {
    }

    public Catalogo(int[] codigo, String[] producto, double[] precio) {
        this.codigo = codigo;
        this.producto = producto;
    }

    public int[] getCodigo() {
        return codigo;
    }

    public void setCodigo(int[] codigo) {
        this.codigo = codigo;
    }

    public String[] getProducto() {
        return producto;
    }

    public void setProducto(String[] producto) {
        this.producto = producto;
    }
// para venta

    public void imprimir() {
        for (int f = 0; f < 9; f++) {
            System.out.println(codigo[f] + producto[f]);
        }

    }

// consulta de inventario
    public void imprimircodigo() {

        System.out.println("Ingrese valor de la componente:");
        f = reader.nextInt();
        System.out.print(codigo[f - 1] + producto[f - 1]);
    }
}
