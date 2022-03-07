package client;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.TextFlow;


public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button1;
    @FXML
    private TextFlow textWindow;


    @FXML
    private ListView<String> resultLabel;

    public void sentMessageToField (String a){

        if (a != null) {
            resultLabel.getItems().add(a);

        }

    }


    @FXML
    void enterButton(KeyEvent event) {
        String textFromField = textFields.getText().trim();
        if (event.getCode() == KeyCode.ENTER) {


            if (textFromField != null) {


                resultLabel.getItems().add(textFromField);
                ServerNetwork.sentMessage(textFromField);
                textFields.clear();


            }
        }

    }


    @FXML
    private TextField textFields;

    @FXML
    void button1() {
        String textFromField = textFields.getText().trim();
        if (textFromField != null) {

            resultLabel.getItems().add(textFromField);


        }

    }

    @FXML
    void initialize() {
        assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert textFields != null : "fx:id=\"textFields\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

}