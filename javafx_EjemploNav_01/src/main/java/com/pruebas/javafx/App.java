package com.pruebas.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App navegando cambiando la raíz de la escena principal
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
    	// Se carga la escena mediante el nombre del fxml
        scene = new Scene(loadFXML("primary"), 640, 480);
        // Se establece la escena en el escenario
        stage.setScene(scene);
        // Se muestra el escenario
        stage.show();
    }

    /**
     * Método que cambia el nodo raíz de la escena
     * 
     * @param fxml Nombre del fxml que se quiere cargar
     * 
     * @throws IOException
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Método que carga el archivo fxml y lo devuelve cargado
     * 
     * @param fxml
     * @return
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}