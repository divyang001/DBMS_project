package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by divyang on 7/9/16.
 */
public class Faculty {
    public void MainMenu(Stage window,String id)
    {
        Button profile = new Button("PROFILE");
        Button current_sem = new Button("FALL 2016-17");
        Button proc = new Button("PROCTEES");
        Button logout=new Button("Log Out");

        javafx.scene.layout.GridPane grid = new javafx.scene.layout.GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        GridPane.setConstraints(profile, 1, 1);
        GridPane.setConstraints(current_sem, 1, 2);
        GridPane.setConstraints(proc, 1, 3);
        GridPane.setConstraints(logout, 1, 4);

        grid.getChildren().addAll(profile, current_sem, proc,logout);

        Scene scene = new Scene(grid, 300, 300);
        scene.getStylesheets().add("/styleSheet/studfac.css");
        window.setScene(scene);
        window.show();
        logout.setOnAction(event -> {

            Main obj=new Main();
            obj.login(window,"fac_password");

        });

        profile.setOnAction(event -> {

            FacultyProfile obj=new FacultyProfile();
            obj.detailing(window, id);
        });

        proc.setOnAction(event -> {
            Proctees obj=new Proctees();
            obj.procte(window, id);
        });


    }

}
