package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BloqueRepeticionTest {

    BloqueRepeticion bloqueRepeticion;
    Personaje personaje;
    Dibujo dibujo;
    List<Bloque> bloquesAEjecutar;
    Posicion posicionEsperada;

    @BeforeEach
    public void setUp(){
        personaje = new Personaje();
        dibujo = new Dibujo();
        bloquesAEjecutar = new ArrayList();
    }
    @Test
    public void test01ElPersonajeNoCambiaDePosicionConUnBLoqueRepeticionVacio(){
        bloqueRepeticion = new BloqueRepeticion(2);

        bloqueRepeticion.ejecutar(personaje,dibujo);

        posicionEsperada = new Posicion(0,0);
        assertEquals( posicionEsperada.obtenerCoordenadas(), personaje.obtenerPosicion() );
    }
    @Test
    public void test02SeAgregarBloquesDeMovimientoALaDerechaYElPersonajeSeMueve(){
        for(int i = 0; i < 10 ; i++) {
            bloquesAEjecutar.add(new BloqueMovimiento(new MovimientoDerecha()));
        }

        bloqueRepeticion = new BloqueRepeticion(3);

        for(Bloque i : bloquesAEjecutar){
            bloqueRepeticion.agregarBloque(i);
        }

        bloqueRepeticion.ejecutar(personaje,dibujo);

        posicionEsperada = new Posicion(30, 0); // evitamos comparar vs Arrays.AsList.

        assertEquals( posicionEsperada.obtenerCoordenadas(), personaje.obtenerPosicion() );
    }
    @Test
    public void test03SeAgregarBloquesDeMovimientoALaIzquierdaYElPersonajeSeMueve(){
        for(int i = 0; i < 15 ; i++) {
            bloquesAEjecutar.add(new BloqueMovimiento(new MovimientoIzquierda()));
        }

        bloqueRepeticion = new BloqueRepeticion(2);

        for(Bloque i : bloquesAEjecutar){
            bloqueRepeticion.agregarBloque(i);
        }

        bloqueRepeticion.ejecutar(personaje,dibujo);

        posicionEsperada = new Posicion(-30, 0);

        assertEquals( posicionEsperada.obtenerCoordenadas(), personaje.obtenerPosicion());
    }

    @Test
    public void test04SeAgregarBloquesDeMovimientoEnTodasLasDireccionesYElPersonajeSeMueve(){

        for(int i = 0; i < 15 ; i++) {
            bloquesAEjecutar.add(new BloqueMovimiento(new MovimientoIzquierda()));
        }
        for(int i = 0; i < 20 ; i++) {
            bloquesAEjecutar.add(new BloqueMovimiento(new MovimientoDerecha()));
        }
        for(int i = 0; i < 30 ; i++) {
            bloquesAEjecutar.add(new BloqueMovimiento(new MovimientoArriba()));
        }
        for(int i = 0; i < 50 ; i++) {
            bloquesAEjecutar.add(new BloqueMovimiento(new MovimientoAbajo()));
        }

        bloqueRepeticion = new BloqueRepeticion(3);

        for(Bloque i : bloquesAEjecutar){
            bloqueRepeticion.agregarBloque(i);
        }

        bloqueRepeticion.ejecutar(personaje,dibujo);

        posicionEsperada = new Posicion(15, -60);
        assertEquals( posicionEsperada.obtenerCoordenadas(), personaje.obtenerPosicion());
    }

    @Test
    public void test05SeSubeyBajaElLapizRepetivamente() {
        bloquesAEjecutar.add(new BloqueLevantarLapiz());
        bloquesAEjecutar.add(new BloqueBajarLapiz());

        bloqueRepeticion = new BloqueRepeticion(3);

        for( Bloque i : bloquesAEjecutar ) {
            bloqueRepeticion.agregarBloque(i);
        }

        bloqueRepeticion.ejecutar(personaje, dibujo);

        assertFalse( personaje.tieneLapizLevantado() );
    }
    //agregue 1 test para el bloque de lapiz, pueden ir mas aunque no se que exactamente mas probar, es muy límitado.
}