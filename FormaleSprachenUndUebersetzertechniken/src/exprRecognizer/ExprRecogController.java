package exprRecognizer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ExprRecogController extends Application {

	public final static String postFixViewFile = "ExprRecogView.fxml";

	Stage stage;

	@FXML
	private TextField textFieldResult;

	@FXML
	private TextArea textAreaInput;

	/**
	 * Läd Datei in den Textbereich
	 */
	@FXML
	protected void loadFromFile() {
		final FileChooser fileChooser = new FileChooser();
		File f = fileChooser.showOpenDialog(this.stage);
		if (f != null && f.exists()) {
			String ges = readData(f);
			this.textAreaInput.clear();
			this.textAreaInput.setText(ges);
		}
	}

	/**
	 * Läd den Inhalt einer Datei
	 * 
	 * @param f
	 *            Die Datei
	 * @return Inhalt der Datei
	 */
	private static String readData(File f) {
		String ges = "";
		// Try-With
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line;
			while ((line = br.readLine()) != null) {
				ges = ges + line;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ges;
	}

	/**
	 * Startet die Auswertung des Postfix Ausdruckes
	 */
	@FXML
	protected void evalFormInput() {
		try {
			evalInput();
		} catch (Exception e) {
			this.textFieldResult.setText(e.getMessage());
		}
	}

	private void evalInput() {
		String input = (this.textAreaInput.getText()) + "";
		boolean b = ExprRecognizer.isValid(input);
		this.textFieldResult.setText((b? ExprRecognizer.getTreeString(input): "Nicht gültiger Ausdruck"));
	}

	/**
	 * Startet die Oberfläche
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

	/**
	 * Startet die Oberfläche von JavaFX
	 */
	@Override
	public void start(Stage mainStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource(postFixViewFile));
		Scene scene = new Scene(root);
		mainStage.setTitle("Expression Recognizer");
		mainStage.setScene(scene);
		mainStage.show();
		this.stage = mainStage;
	}
}
