package library.library;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

    private Parent root;

    public void SwitchDashboard(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Library.class.getResource("Dashboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);
        stage.setScene(scene);
        stage.show();

    }

}
