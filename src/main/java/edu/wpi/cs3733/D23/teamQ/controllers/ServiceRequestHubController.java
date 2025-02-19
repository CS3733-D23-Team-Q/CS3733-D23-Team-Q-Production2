package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ServiceRequestHubController implements IController {
  @FXML Button ccrButton;
  @FXML Button mdButton;
  @FXML Button frdButton;
  @FXML Button fedButton;
  @FXML Button ospButton;

  @FXML
  public void initialize() {};

  @FXML
  public void ccrButtonClicked() {
    Navigation.navigateRight(Screen.CONFERENCE_ROOM_REQUEST);
  }

  @FXML
  public void mdButtonClicked() {
    Navigation.navigateRight(Screen.MEAL_REQUEST);
  }

  @FXML
  public void frdButtonClicked() {
    Navigation.navigateRight(Screen.FLOWER_REQUEST);
  }

  @FXML
  public void fedButtonClicked() {
    Navigation.navigateRight(Screen.FURNITURE_REQUEST);
  }

  @FXML
  public void ospButtonClicked() {
    Navigation.navigateRight(Screen.OFFICE_SUPPLIES_REQUEST);
  }
}
