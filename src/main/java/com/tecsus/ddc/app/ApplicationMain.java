package com.tecsus.ddc.app;

import com.tecsus.ddc.connection.Connector;
import com.tecsus.ddc.language.LanguageKeyValue;
import com.tecsus.ddc.user.LoggedUser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class ApplicationMain extends Application {

    public static Connector connector = new Connector();

    private static Stage stage;
    // Scenes
    public static Scene login;
    public static Scene dashboard;
    public static Scene energy;
    public static Scene water;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        try {
            Parent login = FXMLLoader.load(getClass().getResource("/app/login.fxml"));
            ApplicationMain.login = new Scene(login);

            Parent dashboard = FXMLLoader.load(getClass().getResource("/app/dashbooard.fxml"));
            ApplicationMain.dashboard = new Scene(dashboard);

            Parent energy = FXMLLoader.load(getClass().getResource("/app/energy.fxml"));
            ApplicationMain.energy = new Scene(energy);

            Parent water = FXMLLoader.load(getClass().getResource("/app/water.fxml"));
            ApplicationMain.water = new Scene(water);

            stage.setScene(ApplicationMain.login);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeScene(Screen screen, Object userData) {
        screen.set(ApplicationMain.stage, userData);
    }

    public static void changeScene(Screen screen) {
        screen.set(ApplicationMain.stage, null);
    }

    public interface OnChangeScreen {
        void onScreenChange(Screen screen, Object userData);
    }

    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();

    public static void addOnChangeScreenListener(OnChangeScreen listener) {
        listeners.add(listener);
    }

    public static void notifyAllListeners(Screen screen, Object userData) {
        for (OnChangeScreen listener : listeners)
            listener.onScreenChange(screen, userData);
    }

    public static void showErrorMessage(String title, String header) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.showAndWait();
    }
}
