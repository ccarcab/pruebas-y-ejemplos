package com.pruebas.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class MainController extends App implements Initializable {

	// Mapa para almacenar las escenas hijas
	private static Map<String, Parent> scenes;

	// Panel hijo
	@FXML
	private StackPane subScene;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Se inicializa el mapa
		scenes = new HashMap<>();
		try {
			// Insertamos las vistas hijas en el mapa, usando de clave su nombre
			scenes.put("primary", loadFXML("primary"));
			scenes.put("secondary", loadFXML("secondary"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void loadPrimary() {
		load("primary");
	}

	@FXML
	private void loadSecondary() {
		load("secondary");
	}

	/**
	 * Método que carga una escena a la cuál corresponde el nombre aportado
	 * 
	 * @param sceneName
	 */
	private void load(String sceneName) {
		// Se limpia la vista hija
		subScene.getChildren().clear();
		// Se añade la nueva vista
		subScene.getChildren().add(scenes.get(sceneName));
	}

}
