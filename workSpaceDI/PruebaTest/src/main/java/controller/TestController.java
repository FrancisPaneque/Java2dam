package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TestController {

 @FXML
 private Button myButton;

 @FXML
 private void handleButtonClick(ActionEvent event) {
     myButton.setText("clicked!");
 }
}
