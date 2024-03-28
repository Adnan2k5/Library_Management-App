package library.library;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class register {

        @FXML
        private TextField name;
        @FXML
        private TextField username;
        @FXML
        private TextField password;

        public  void reg(ActionEvent event) throws IOException{
                String NAME  = name.getText();
                String USER_name = username.getText();
                String USER_pass  = password.getText();



                postgres.write(NAME,USER_name,USER_pass);

                System.out.println("NEW USER REGISTERED");
                System.out.println("NAME: " + NAME);
                System.out.println("USERNAME: " + USER_name);
                System.out.println("PASS: " + USER_pass);

        }

}
