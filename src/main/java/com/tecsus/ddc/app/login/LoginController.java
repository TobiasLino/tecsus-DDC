package com.tecsus.ddc.app.login;

import com.tecsus.ddc.app.ApplicationMain;
import com.tecsus.ddc.app.Screen;
import com.tecsus.ddc.language.LanguageKeyValue;
import com.tecsus.ddc.security.SecurityContext;
import com.tecsus.ddc.user.*;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

public class LoginController {

    @Getter @Setter
    private UserController userController;
    @Getter @Setter
    private Stage primaryStage;

    public LoginController() {
        UserRepository userRepository = new UserRepository(ApplicationMain.connector.getConnection());
        RoleRepository roleRepository = new RoleRepository(ApplicationMain.connector.getConnection());
        userController = new UserController(userRepository, roleRepository);
    }

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;


    public boolean validateLogin(String login, String password) {
        return validateUsername(login) && validatePassword(password);
    }

    private boolean validateUsername(String username) {
        if (username == null || username.isEmpty()) {
            ApplicationMain.showErrorMessage(LanguageKeyValue.login_errors.getText(), LanguageKeyValue.empty_username.getText());
            return false;
        }
        return true;
    }

    private boolean validatePassword(String pass) {
        if (pass == null || pass.isEmpty()) {
            ApplicationMain.showErrorMessage(LanguageKeyValue.login_errors.getText(), LanguageKeyValue.empty_password.getText());
            return false;
        }
        return true;
    }


    @FXML
    protected void signIn(javafx.event.ActionEvent actionEvent) {
        String name = usernameField.getText();
        String pass = passwordField.getText();

        if (!validateLogin(name, pass)) return;

        User user = userController.find(name, pass);
        if (user == null)
            ApplicationMain.showErrorMessage(LanguageKeyValue.login_errors.getText(), LanguageKeyValue.user_not_found.getText());

        SecurityContext.loggedUser = new LoggedUser();
        SecurityContext.loggedUser.setUser(user);
        ApplicationMain.changeScene(Screen.DASHBOARD, "");
    }

    @FXML
    public void initialize() {
        ApplicationMain.addOnChangeScreenListener((screen, userData) -> System.out.println("NOVA TELA"));
    }
}
