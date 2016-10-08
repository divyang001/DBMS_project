package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by divyang on 7/9/16.
 */
public class SuperMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Button student = new Button("Student");
        Button faculty = new Button("Faculty");

        Stage windows = primaryStage;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setConstraints(faculty, 1, 1);
        grid.setConstraints(student, 1, 2);
       // StackPane layout2 = new StackPane();

        grid.getChildren().addAll(student,faculty);
        Scene scene1234 = new Scene(grid, 300, 300);
        scene1234.getStylesheets().add("/styleSheet/VIper.css");
        windows.setScene(scene1234);
        windows.show();

        student.setOnAction(event -> {
            Main obj=new Main();
            obj.login(windows,"stud_password");
        });
        faculty.setOnAction(event -> {
            Main obj=new Main();
            obj.login(windows,"fac_password");
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}


