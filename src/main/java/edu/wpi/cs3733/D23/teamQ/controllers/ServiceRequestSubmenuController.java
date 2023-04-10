package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;

public class ServiceRequestSubmenuController {
  @FXML MFXButton create;
  @FXML MFXButton edit;

  @FXML
  public void createClicked() {
    Navigation.navigate(Screen.SERVICE_REQUEST_HUB);
  }

  @FXML
  public void editClicked() {
    Navigation.navigate(Screen.LIST_REQUESTS);
  }
}
