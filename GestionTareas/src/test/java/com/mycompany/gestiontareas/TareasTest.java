package com.mycompany.gestiontareas;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TareasTest {

    private GestorTareas gestor;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        gestor = new GestorTareas();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testAgregarTarea() {
        gestor.agregarTarea("Hacer la compra");
        gestor.listarTareas();
        assertTrue(outContent.toString().contains("[ ] Hacer la compra"));
    }

    @Test
    public void testMarcarTareaComoCompletada() {
        gestor.agregarTarea("Estudiar Java");
        gestor.marcarTareaComoCompletada(1);
        gestor.listarTareas();
        String output = outContent.toString();
        assertTrue(output.contains("[X] Estudiar Java"));
        assertFalse(output.contains("[ ] Estudiar Java"));
    }

    @Test
    public void testEliminarTarea() {
        gestor.agregarTarea("Limpiar el coche");
        gestor.agregarTarea("Pasear al perro");
        gestor.eliminarTarea(1);
        gestor.listarTareas();
        String output = outContent.toString();
        assertFalse(output.contains("Limpiar el coche"));
        assertTrue(output.contains("Pasear al perro"));
    }
}
