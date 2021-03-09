package jdbcdemo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anuturlapati
 */
/////////////////beginning of code//////////////////////////////////
//query: select all from employees and print their last_name, first_name of
import java.sql.*; // import java sql package
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Demo extends Application {

    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage stage) throws SQLException {
        Scanner input = new Scanner(System.in);
// next 3 lines: variables for the connection statement
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            // get a connect to the database using the user name and password used for MySQL root account

            myConn = DriverManager.getConnection("jdbc:mysql:///library", "root",
                    "chowdarY@759");
            //create a statement
            myStmt = myConn.createStatement();
            //execute SQL query
            myRs = myStmt.executeQuery("SELECT B.Title, BC.No_of_copies, LB.Branch_name FROM library.book_copies BC\n" +
                                        "INNER JOIN library.book B ON B.Book_id = BC.Book_id\n" +
                                        "INNER JOIN library.library_branch LB ON LB.Branch_id = BC.Branch_id\n" +
                                        "WHERE B.Book_id = 232323");
            //process the result set
            String data = "";
            while (myRs.next()) {

                data = data + myRs.getString("Title")+ "    "+ myRs.getString("No_of_copies")+ "    "+ myRs.getString("Branch_name")+ "\n";
                //System.out.println(myRs.getString("last_name") + ", "
                //        + myRs.getString("first_name"));
            }

            Text text1 = new Text();
            text1.setText(data);

            VBox root = new VBox();

            root.getChildren().addAll(text1);

            root.setSpacing(10);

            root.setStyle("-fx-padding: 10;"
                    + "-fx-border-style: solid inside;"
                    + "-fx-border-width: 2;"
                    + "-fx-border-insets: 5;"
                    + "-fx-border-radius: 5;"
                    + "-fx-border-color: blue;");

            Scene scene = new Scene(root, 300, 200);

            stage.setScene(scene);

            stage.setTitle("Books and Copies");

            stage.show();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
//cleaning up resources when we are done
            if (myRs != null) {
                myRs.close();
            }
            if (myStmt != null) {
                myStmt.close();
            }
            if (myConn != null) {
                myConn.close();
            }
        }

    }
}
///////////////////end of code//////////////
