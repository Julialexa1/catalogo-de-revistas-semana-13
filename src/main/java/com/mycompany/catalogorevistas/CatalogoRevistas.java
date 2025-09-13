
package com.mycompany.catalogorevistas;

import java.util.Scanner;

public class CatalogoRevistas {
    // Catálogo de revistas almacenado en un arreglo
    private static String[] revistas = {
            "National Geographic",
            "Science Today",
            "Nature",
            "Time",
            "Forbes",
            "Popular Mechanics",
            "Harvard Business Review",
            "The Economist",
            "Scientific American",
            "History Channel Magazine"
    };

    // Método de búsqueda iterativa
    public static boolean buscarIterativo(String[] catalogo, String titulo) {
        for (String revista : catalogo) {
            if (revista.equalsIgnoreCase(titulo)) {
                return true; // Encontrado
            }
        }
        return false; // No encontrado
    }

    // Método de búsqueda recursiva
    public static boolean buscarRecursivo(String[] catalogo, String titulo, int indice) {
        if (indice >= catalogo.length) {
            return false; // Caso base: se recorrió todo el arreglo
        }
        if (catalogo[indice].equalsIgnoreCase(titulo)) {
            return true; // Encontrado
        }
        // Llamada recursiva al siguiente índice
        return buscarRecursivo(catalogo, titulo, indice + 1);
    }

    // Método principal con menú interactivo
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=========== MENÚ ===========");
            System.out.println("1. Buscar revista (iterativo)");
            System.out.println("2. Buscar revista (recursivo)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título de la revista a buscar: ");
                    String titulo1 = scanner.nextLine();
                    if (buscarIterativo(revistas, titulo1)) {
                        System.out.println("Resultado: Encontrado");
                    } else {
                        System.out.println("Resultado: No encontrado");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el título de la revista a buscar: ");
                    String titulo2 = scanner.nextLine();
                    if (buscarRecursivo(revistas, titulo2, 0)) {
                        System.out.println("Resultado: Encontrado");
                    } else {
                        System.out.println("Resultado: No encontrado");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}

