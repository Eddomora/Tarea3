package org.example.Logica;
import org.example.Logica.Excepciones.NoHayProductoException;
import org.example.Logica.Excepciones.PagoIncorrectoException;
import org.example.Logica.Excepciones.PagoInsuficienteException;

import java.util.Scanner;

public class MainInteractivo {
    public static void main(String[] args) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Scanner scanner = new Scanner(System.in);
        Expendedor exp = new Expendedor(10); //modificar con el enum
        Comprador c = null;

        while (true) {
            imprimirOpciones();
            int eleccion = scanner.nextInt();

            if (eleccion == 0) {
                System.out.println("Gracias por su compra. Hasta pronto");
                break;
            }
            Moneda m = new Moneda1500();

            switch (eleccion) {
                case 1:
                    c = new Comprador(m, 1, PRECIOS.COCACOLA.getPrecio(), exp);
                    System.out.println("-- Coca cola, su vuelto: $" + c.cuantoVuelto() + " --");

                    break;
                case 2:
                    c = new Comprador(m, 2, PRECIOS.FANTA.getPrecio(), exp);
                    System.out.println("-- Fanta, su vuelto: $" + c.cuantoVuelto() + " --");

                    break;
                case 3:
                    c = new Comprador(m, 3, PRECIOS.SPRITE.getPrecio(), exp);
                    System.out.println("-- Sprite, su vuelto: $" + c.cuantoVuelto() + " --");

                    break;
                case 4:
                    c = new Comprador(m, 4, PRECIOS.SNICKERS.getPrecio(), exp);
                    System.out.println("-- Snickers, su vuelto: $" + c.cuantoVuelto() + " --");

                    break;
                case 5:
                    c = new Comprador(m, 5, PRECIOS.SUPER8.getPrecio(), exp);
                    System.out.println("-- Super8, su vuelto: $" + c.cuantoVuelto() + " --");

                    break;
                default:
                    System.out.println("Elección no válida.");
            }
        }
        scanner.close();
    }
    public static void imprimirOpciones() {
            System.out.println("Elige una comida o bebida:");
            System.out.println("1. Coca cola");
            System.out.println("2. Fanta");
            System.out.println("3. Sprite");
            System.out.println("4. Snicker");
            System.out.println("5. Super8");
            System.out.println("0. Salir");
            System.out.print("Ingresa el número de tu elección: ");
        }
    }
