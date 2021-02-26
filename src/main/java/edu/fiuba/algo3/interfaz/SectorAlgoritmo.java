package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.HabilidadAceptarDragHandler;
import edu.fiuba.algo3.HabilidadDropHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SectorAlgoritmo extends VBox {

    public SectorAlgoritmo(ContenedorBotonera contenedorBotonera){
        Label text = new Label("Espacio de Trabajo");
        text.setMaxWidth(Double.MAX_VALUE);
        text.setAlignment(Pos.CENTER);
        text.setTextFill(Color.WHITE);
        text.setStyle("-fx-background-color: rgb(85,40,129);");
        text.setFont(Font.font("Times",20));
        text.setTextFill(Color.WHITE);
        this.getChildren().add(text);

        VBox contenedorAlgoritmo = new VBox();
        contenedorAlgoritmo.setPrefSize(400, 900);
        contenedorAlgoritmo.setAlignment(Pos.TOP_CENTER);
        this.getChildren().add(contenedorAlgoritmo);

        this.setMinWidth(600);
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));

        contenedorAlgoritmo.setOnDragOver( new HabilidadAceptarDragHandler(TransferMode.ANY) );

        contenedorAlgoritmo.setOnDragDropped( new HabilidadDropHandler(this, contenedorAlgoritmo, contenedorBotonera) );
    }

}
