package edu.fiuba.algo3;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotonEjecutar extends Button implements ObservadorSectorAlgoritmo {

    VBox contenedorAlgoritmo;

    public BotonEjecutar(VBox botones) {
        super("Ejecutar algoritmo!");
        this.setDisable(true);
    }

    @Override
    public void cambios(VBox nuevoContenedor) {
        this.contenedorAlgoritmo = nuevoContenedor;
        this.setDisable( this.contenedorAlgoritmo.getChildren().size() == 0 );
        this.setOnMouseClicked( new EjecucionAlgoritmoHandler( this.contenedorAlgoritmo ) );
    }
}
