package com.mycompany.gestiontareas;

public class Tareas {
    private int id;
    private String descripcion;
    private boolean completada;

    public Tareas(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.completada = false;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return id + ". [" + (completada ? "X" : " ") + "] " + descripcion;
    }
}

