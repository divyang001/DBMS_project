package sample;

import Database_functions.Login_check;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main  {
    public void login(Stage windows,String table){

        Login_check Check_user = new Login_check();
        Label lab = new Label("invalid user name or password");
        Scene scene2;

       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
       // primaryStage.setTitle("Hello World");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);
        //Label
        Label name = new Label("UserName");
        grid.setConstraints(name, 0, 0);

        TextField input = new TextField();
        grid.setConstraints(input, 1, 0);


        Label pass = new Label("Password");
        grid.setConstraints(pass, 0, 1);

       /* TextField input2 = new TextField();
        input2.setPromptText("Password");*/
        PasswordField input2 = new PasswordField();
        input2.setPromptText("Password");
        grid.setConstraints(input2, 1, 1);

        Button login = new Button("Login");
        grid.setConstraints(login, 1, 2);

        Button ChangeLogin=new Button("ChangeLogin");
        grid.setConstraints(ChangeLogin, 1, 3);

        Label lb= new Label("");
        grid.setConstraints(lb,1,5);
        StackPane layout2 = new StackPane();
       // Label labels=new Label(status);
        //layout2.getChildren().add(labels);
        scene2 = new Scene(layout2, 300, 300);


        login.setOnAction(e -> {

            if(Check_user.check(input.getText(),input2.getText(),table))
            {
                if(table=="fac_password")
                {
                    Faculty obj=new Faculty();
                    obj.MainMenu(windows,input.getText());

                }
                else {
                    Student obj=new Student();
                    obj.trying(windows,input.getText());

                }

            }
            else
            {
               lb.setText("try Again");
            }

        });
        ChangeLogin.setOnAction(event -> {

            SuperMain obj=new SuperMain();
            try {
                obj.start(windows);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        grid.getChildren().addAll(name,input,pass,input2,login,ChangeLogin,lb);
        Scene scene1234 = new Scene(grid, 300, 300);
        scene1234.getStylesheets().add("/styleSheet/VIper.css");
        windows.setScene(scene1234);
        windows.show();
    }


    }

