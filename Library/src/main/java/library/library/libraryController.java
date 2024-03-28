package library.library;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class libraryController {
        @FXML
        private TextField username , password;

        @FXML
        private Label title;


        String user_user;
        String user_pass;

        ResultSet resultSet = null;



        public void submit(ActionEvent event) throws IOException {
                user_user = username.getText();
                user_pass = password.getText();


                String url = "jdbc:postgresql://localhost:5432/postgres";
                String user = "postgres";
                String password = "2005";


                String query = "SELECT * FROM lib_user WHERE username = ? and pass = ?";

                try (Connection con = DriverManager.getConnection(url,user,password)) {
                        PreparedStatement pst = con.prepareStatement(query);

                        pst.setString(1,user_user);
                        pst.setString(2,user_pass);
                        resultSet = pst.executeQuery();
                        if(!resultSet.next()){
                                title.setText("Invalid credentials");
                        }
                        else{
                                title.setText("Login Successful");
                                FXMLLoader fxmlLoader = new FXMLLoader(Library.class.getResource("Dashboard.fxml"));
                                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                Scene scene = new Scene(fxmlLoader.load(), 800, 800);
                                stage.setScene(scene);
                                stage.show();

                        }
                        System.out.println("Success");
                } catch (SQLException e) {
                        Logger lgr = Logger.getLogger(postgres.class.getName());
                        lgr.log(Level.SEVERE, e.getMessage(),e);
                } ;


        }

        public void back(ActionEvent event) throws IOException{
                FXMLLoader fxmlLoader = new FXMLLoader(Library.class.getResource("main.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(fxmlLoader.load(), 800, 800);
                stage.setScene(scene);
                stage.show();
        }

        public void new_user(ActionEvent event) throws IOException{
                FXMLLoader fxmlLoader = new FXMLLoader(Library.class.getResource("Register.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(fxmlLoader.load(), 800, 800);
                stage.setScene(scene);
                stage.show();
        }







}