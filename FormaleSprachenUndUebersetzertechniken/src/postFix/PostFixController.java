package postFix;

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
import postFix.Exception.PostFixExpressionException;
import postFix.Exception.UnknownMathOperationException;

public class PostFixController extends Application {

	public final static String postFixViewFile = "PostFixView.fxml";

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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ges;
	}

	/**
	 * Startet die Auswertung des Postfix Ausdruckes
	 */
	@FXML
	protected void evalPostFix() {
		try {
			this.textFieldResult.setText(Postfix.evalPostfix(this.textAreaInput.getText()) + "");
		} catch(PostFixExpressionException e){
			this.textFieldResult.setText(e.getMessage());
		} catch (UnknownMathOperationException e) {
			this.textFieldResult.setText(e.getMessage());
		}
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
		mainStage.setTitle("PostFix Interpreter");
		mainStage.setScene(scene);
		mainStage.show();
		this.stage = mainStage;
	}
}
