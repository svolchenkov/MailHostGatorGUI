/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpostgui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import testpost.Sender;

/**
 *
 * @author Sergey
 */
public class TestPostGUI extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("HostGatorTest");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label emailToLable = new Label("Email to:");
        grid.add(emailToLable, 0, 1);

        TextField emailTo = new TextField();
        grid.add(emailTo, 1, 1);

        Label bodyLable = new Label("Body:");
        grid.add(bodyLable, 0, 2);

        TextField body = new TextField();
        grid.add(body, 1, 2);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        Button btn = new Button("Send");
        HBox hbBtn = new HBox(10);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Sender s = new Sender();
                s.send(emailTo.getText(), body.getText());
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("sent");
            }
        });

        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        Scene scene = new Scene(grid, 500, 275);
        primaryStage.setScene(scene);

        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
