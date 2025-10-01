

package com.mycompany.gestiontareas;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas();
        boolean salir = false;

        System.out.println("--- Bienvenido al Gestor de Tareas ---");

        while (!salir) {
            mostrarMenu();
            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Introduce la descripción de la nueva tarea: ");
                        String descripcion = scanner.nextLine();
                        gestor.agregarTarea(descripcion);
                        break;
                    case 2:
                        gestor.listarTareas();
                        break;
                    case 3:
                        System.out.print("Introduce el ID de la tarea a marcar como completada: ");
                        if (scanner.hasNextInt()) {
                            int idCompletar = scanner.nextInt();
                            scanner.nextLine();
                            gestor.marcarTareaComoCompletada(idCompletar);
                        } else {
                            System.out.println("Error: Debes introducir un número de ID válido.");
                            scanner.nextLine(); 
                        }
                        break;
                    case 4:
                        System.out.print("Introduce el ID de la tarea a eliminar: ");
                        if (scanner.hasNextInt()) {
                            int idEliminar = scanner.nextInt();
                            scanner.nextLine(); 
                            gestor.eliminarTarea(idEliminar);
                        } else {
                            System.out.println("Error: Debes introducir un número de ID válido.");
                            scanner.nextLine();
                        }
                        break;
                    case 5:
                        salir = true;
                        System.out.println("Gracias por usar el gestor. ¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, elige una opción del 1 al 5.");
                        break;
                }
            } else {
                System.out.println("Error: Entrada no válida. Por favor, introduce un número.");
                scanner.nextLine();
            }
            System.out.println(); 
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("Elige una opción:");
        System.out.println("1. Registrar nueva tarea");
        System.out.println("2. Listar todas las tareas");
        System.out.println("3. Marcar tarea como completada");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Salir");
        System.out.print("-> ");
    }
}
