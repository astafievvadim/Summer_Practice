package javaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("/screens/MainScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1000 , 750);
        Image icon = new Image(getClass().getResource("/icon/satellite.png").toExternalForm());

        stage.getIcons().add(icon);

        stage.setTitle("Satellite.exe");
        stage.setScene(scene);
        stage.show();
    }

    public static void application() {
        launch();
    }


}