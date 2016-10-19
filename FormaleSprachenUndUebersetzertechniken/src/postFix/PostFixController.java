package postFix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PostFixController extends Application {

	public final static String postFixViewFile = "PostFixView.fxml";

	Stage stage;

	@FXML
	private TextField textFieldResult;

	@FXML
	private TextArea textAreaInput;
	
	@FXML
	protected void loadFromFile() {
		final FileChooser fileChooser = new FileChooser();
		String ges ="";
		File f  = fileChooser.showOpenDialog(this.stage);
		if (f  != null && f.exists()) {
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
			this.textAreaInput.clear();
			this.textAreaInput.setText(ges);
		}
	}

	@FXML
	protected void evalPostFix() {
		try {
			this.textFieldResult.setText(Postfix.evalPostfix(this.textAreaInput.getText()) + "");
		} catch (@SuppressWarnings("unused") Exception e) {
			this.textFieldResult.setText("Fehlerhafte Eingabe!");
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

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
