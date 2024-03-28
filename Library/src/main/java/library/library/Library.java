package library.library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Library extends Application {
    Scene Dashboard;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Library.class.getResource("main.fxml"));
        String css = this.getClass().getResource("main.css").toExternalForm();
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);
        scene.getStylesheets().add(css);
        stage.setTitle("KLU Library!");
        stage.setScene(scene);
        stage.show();
    }




    public static void main(String[] args) {
        launch();
    }
}