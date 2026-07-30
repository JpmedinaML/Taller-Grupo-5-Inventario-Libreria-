package inventario;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {

    //  VARIABLES GLOBALES 
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> nombres = new ArrayList<>();
    static ArrayList<String> autores = new ArrayList<>();
    static ArrayList<Double> precios = new ArrayList<>();
    static ArrayList<Double> preciosDescuento = new ArrayList<>();
    static ArrayList<Integer> cantidades = new ArrayList<>();
    static ArrayList<Double> valoresTotalesLibro = new ArrayList<>();
    static double valorTotalInventario = 0;
    static double precioConDescuento = 0;

    public static void main(String[] args) {
        char opcion;
        do {
            entrada();
            proceso();
            System.out.print("¿Desea registrar otro libro? (s/n): ");
            opcion = sc.next().toLowerCase().charAt(0);
            sc.nextLine(); 
        } while (opcion == 's');

        salidaFinal();
    }

    //  ENTRADA 
    static void entrada() {
        System.out.println("\n--- Registro de nuevo libro ---");

        System.out.print("Nombre del libro: ");
        String nombre = sc.nextLine();

        System.out.print("Autor del libro: ");
        String autor = sc.nextLine();

        System.out.print("Precio del libro: ");
        double precio = sc.nextDouble();

        System.out.print("Cantidad en inventario: ");
        int cantidad = sc.nextInt();
        sc.nextLine(); 

        nombres.add(nombre);
        autores.add(autor);
        precios.add(precio);
        cantidades.add(cantidad);
    }

    // PROCESO 
    static void proceso() {
        int i = nombres.size() - 1;

        double precio = precios.get(i);
        int cantidad = cantidades.get(i);

        calcularDescuento(precio);
        double valorTotalLibro = precioConDescuento * cantidad;

        preciosDescuento.add(precioConDescuento);
        valoresTotalesLibro.add(valorTotalLibro);

        valorTotalInventario += valorTotalLibro;

        salidaLibro(i);
    }

    static void calcularDescuento(double precio) {
        if (precio > 50000) {
            precioConDescuento = precio * 0.85;
        } else if (precio > 30000 && precio <= 50000) {
            precioConDescuento = precio * 0.90;
        } else {
            precioConDescuento = precio;
        }
    }

    //  SALIDA (por cada libro) 
    static void salidaLibro(int i) {
        System.out.println("\n Datos del libro registrado ");
        System.out.println("Nombre: " + nombres.get(i));
        System.out.println("Autor: " + autores.get(i));
        System.out.println("Precio original: " + (int)(precios.get(i) * 100) / 100.0);
        System.out.println("Precio con descuento: " + (int)(preciosDescuento.get(i) * 100) / 100.0);
        System.out.println("Cantidad en inventario: " + cantidades.get(i));
        System.out.println("Valor total del libro: " + (int)(valoresTotalesLibro.get(i) * 100) / 100.0);
    }

    // SALIDA FINAL 
    static void salidaFinal() {
        System.out.println("\nRESUMEN DEL INVENTARIO ");
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println("\nLibro " + (i + 1) + ":");
            System.out.println("Nombre: " + nombres.get(i));
            System.out.println("Autor: " + autores.get(i));
            System.out.println("Precio original: " + (int)(precios.get(i) * 100) / 100.0);
            System.out.println("Precio con descuento: " + (int)(preciosDescuento.get(i) * 100) / 100.0);
            System.out.println("Cantidad: " + cantidades.get(i));
            System.out.println("Valor total: " + (int)(valoresTotalesLibro.get(i) * 100) / 100.0);
        }
        System.out.println("\nVALOR TOTAL DEL INVENTARIO: " + (int)(valorTotalInventario * 100) / 100.0);
    }
}
