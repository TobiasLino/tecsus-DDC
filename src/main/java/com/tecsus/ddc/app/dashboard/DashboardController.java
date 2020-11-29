package com.tecsus.ddc.app.dashboard;

import com.tecsus.ddc.app.ApplicationMain;
import com.tecsus.ddc.app.Screen;
import com.tecsus.ddc.security.SecurityContext;
import com.tecsus.ddc.user.LoggedUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class DashboardController {

    @FXML
    protected void addEnergy(ActionEvent event) {
        ApplicationMain.changeScene(Screen.ENERGY, SecurityContext.loggedUser);
    }

    @FXML
    protected void addWater(ActionEvent event) {
        ApplicationMain.changeScene(Screen.WATER, SecurityContext.loggedUser);
    }

    @FXML
    protected void logoff() {
        SecurityContext.loggedUser = null;
        ApplicationMain.changeScene(Screen.LOGIN);
    }
}
