package com.mycompany.gestiontareas;

import com.mycompany.gestiontareas.Tareas;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GestorTareas {
    private List<Tareas> tareas;
    private int proximoId = 1; 


    public GestorTareas() {
        this.tareas = new ArrayList<>();
    }


    public void agregarTarea(String descripcion) {
        Tareas nuevaTarea = new Tareas(proximoId++, descripcion);
        tareas.add(nuevaTarea);
        System.out.println("Tarea registrada con éxito.");
    }

    public void listarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas pendientes.");
        } else {
            System.out.println("--- Lista de Tareas ---");
            for (Tareas tarea : tareas) {
                System.out.println(tarea);
            }
            System.out.println("-----------------------");
        }
    }

    public void marcarTareaComoCompletada(int id) {
        for (Tareas tarea : tareas) {
            if (tarea.getId() == id) {
                tarea.setCompletada(true);
                System.out.println("Tarea " + id + " marcada como completada.");
                return; 
            }
        }
        System.out.println("Error: No se encontró la tarea con ID " + id + ".");
    }


    public void eliminarTarea(int id) {
        Iterator<Tareas> iterador = tareas.iterator();
        while (iterador.hasNext()) {
            Tareas tarea = iterador.next();
            if (tarea.getId() == id) {
                iterador.remove();
                System.out.println("Tarea " + id + " eliminada correctamente.");
                return;
            }
        }
        System.out.println("Error: No se encontró la tarea con ID " + id + ".");
    }
}
