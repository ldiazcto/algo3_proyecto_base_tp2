package edu.fiuba.algo3.modelo;

public class LapizLevantado implements Lapiz {

    @Override
    public void dibujar(Movimiento movimiento, Posicion posicion){
        movimiento.mover(posicion);
    }

    /* quedó por la primera entrega pero necesita un refactor */
    @Override
    public boolean puedeDibujar() {
        return false;
    }
}
