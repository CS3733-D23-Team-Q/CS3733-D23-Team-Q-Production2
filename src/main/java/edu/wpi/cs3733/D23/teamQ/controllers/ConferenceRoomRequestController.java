package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.db.Qdb;
import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class ConferenceRoomRequestController {
  Qdb qdb = Qdb.getInstance();
  @FXML ComboBox assigneeField;
  @FXML ComboBox roomNumberField;
  @FXML MFXDatePicker dateField;
  @FXML MFXTextField timeField;
  @FXML ComboBox foodField;
  @FXML MFXTextField specialInstructionsField;
  ObservableList<String> foodOptionsList =
      FXCollections.observableArrayList(
          "Brunch spread", "Dinner spread", "Snack spread", "No food");
  @FXML Button resetButton;
  @FXML Button cancelButton;
  @FXML Button submitButton;

  @FXML
  public void initialize() {
    this.assigneeField.setValue("Select an Assignee");
    this.assigneeField.setValue(qdb.getAllNames());
    this.roomNumberField.setValue("Select a Conference Room");
    String[] conf = {"CONF"};
    this.roomNumberField.setItems(qdb.getAllLongNames(conf));
    this.foodField.setValue("Select Food Option");
    this.foodField.setItems(foodOptionsList);
  }

  @FXML
  public void resetButtonClicked() {
    assigneeField.setValue("Select an Assignee");
    roomNumberField.setValue("Select a Location");
    dateField.clear();
    timeField.clear();
    foodField.setValue("Select Food Option");
    specialInstructionsField.clear();
  }

  @FXML
  public void cancelButtonClicked() {
    Navigation.navigate(Screen.SERVICE_PLACEHOLDER);
  }

  @FXML
  public void submitButtonClicked() {
    //    ConferenceRequest newCCR =
    //        new ConferenceRequest(
    //            0,
    //            "temp user",
    //            0,
    //            assigneeField.getText(),
    //            roomNumberField.getText(),
    //            specialInstructionsField.getText(),
    //            dateTimeField.getText(),
    //            (String) foodField.getValue());
    //    qdb.addConferenceRequest(newCCR);
    //    Navigation.navigate(Screen.HOME);
  }
}
