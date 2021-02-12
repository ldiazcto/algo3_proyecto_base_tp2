package edu.fiuba.algo3.modelo;

public class MovimientoDerecha implements Movimiento{

    public void mover(Posicion posicion){
        posicion.desplazarDerecha();
    }

    @Override
    public Movimiento opuesto() {
        return new MovimientoIzquierda();
    }
}
