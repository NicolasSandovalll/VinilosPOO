import dominio.ViniloManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ViniloManagerTest {
    private ViniloManager manager;

    @BeforeEach
    public void setUp() {
        manager = new ViniloManager();
        // Agrega algunos vinilos a la colección para facilitar las pruebas
        manager.agregarVinilo("Nikazo", "Ese soy yo", 2002);
        manager.agregarVinilo("M", "El disco", 1890);
    }

    @Test
    public void testAgregarViniloConDatosValidos() {
        manager.agregarVinilo("Nikazo", "sdsdd", 2002);
        assertEquals(3, manager.cantidadVinilos(), "Se espera que en la colección se haya agregado uno más , 3 en total");
    }

    @Test
    public void testAgregarViniloConDatosInvalidos() {
        manager.agregarVinilo("", "", 0);
        assertEquals(2, manager.cantidadVinilos(), "Se espera 2 vinilos ya que no se pueden agregar datos inválidos");
    }

    @Test
    public void testAgregarViniloConNombreDeUnaLetra() {
        manager.agregarVinilo("b", "El disco", 1890);
        assertEquals(3, manager.cantidadVinilos(), "Se espera que se agregue el disco ya que se acepta el nombre del artista con una sola letra");
    }

    @Test
    public void testNoAgregarViniloDuplicado() {
        manager.agregarVinilo("Nikazo", "Ese soy yo", 2002); // Ya existe en setUp
        assertEquals(2, manager.cantidadVinilos(), "No se debe agregar un vinilo duplicado");
    }


    // Pruebas unitarias para buscarVinilo
    @Test
    public void testBuscarViniloExistente() {
        assertTrue(manager.buscarVinilo("nikazo", "ese soy yo", 2002), "Se espera encontrar el vinilo en la colección"); //
    }

    @Test
    public void testBuscarViniloNoExistente() {
        assertFalse(manager.buscarVinilo("ArtistaDesconocido", "DiscoFantasma", 2021), "No se espera encontrar un vinilo que no existe");
    }

    @Test
    public void testBuscarViniloConDatosParciales() {
        assertFalse(manager.buscarVinilo("Nikazo", "", 2002), "No se espera encontrar un vinilo con datos parciales");
        assertFalse(manager.buscarVinilo("", "Ese soy yo", 2002), "No se espera encontrar un vinilo con datos incompletos");
    }

    @Test
    public void testBuscarViniloConAnoInvalido() {
        assertFalse(manager.buscarVinilo("Nikazo", "Ese soy yo", 2025), "No se espera encontrar un vinilo con año incorrecto");
    }

    @Test
    public void testLimiteMaximoVinilos() {
        // Agrega 100 vinilos válidos
        for (int i = 0; i < 100; i++) {
            manager.agregarVinilo("Artista" + i, "Disco" + i, 1900 + i);
        }

        // Verifica que la cantidad de vinilos sea 100
        assertEquals(100, manager.cantidadVinilos(), "Se espera que la colección contenga exactamente 100 vinilos");

        // Intenta agregar un vinilo adicional
        manager.agregarVinilo("ArtistaExtra", "DiscoExtra", 2022);

        // Verifica nuevamente que la cantidad de vinilos sigue siendo 100 y no ha aumentado
        assertEquals(100, manager.cantidadVinilos(), "No se debe permitir agregar más de 100 vinilos");
    }


}
