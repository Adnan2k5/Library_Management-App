package library.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class postgres {

        public static  void write(String name, String username,String pass){
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "2005";


            String query = "INSERT INTO lib_user(name,username,pass) VALUES(?,?,?)";

            try (Connection con = DriverManager.getConnection(url,user,password)) {
                PreparedStatement pst = con.prepareStatement(query);

                pst.setString(1,name);
                pst.setString(2,username);
                pst.setString(3,pass);
                pst.executeUpdate();
                System.out.println("Success");
            } catch (SQLException e) {
                Logger lgr = Logger.getLogger(postgres.class.getName());
                lgr.log(Level.SEVERE, e.getMessage(),e);
            } ;


        }


}
