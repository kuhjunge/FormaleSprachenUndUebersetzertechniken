package postFix;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PostFixController extends Application {

	public final static String postFixViewFile = "PostFixView.fxml";

	Stage stage;

	@FXML
	private TextField textFieldResult;

	@FXML
	private TextArea textAreaInput;

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
