package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

/**
 * Created by divyang on 18/10/16.
 */
public class Fall {

    public  void currentsem(Stage windows, String id)
    {
        Button Attendance= new Button("Attendance");
        Button Markss = new Button("Marks");
        Button back = new Button("back");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setConstraints(Attendance, 1, 1);
        grid.setConstraints(Markss, 1, 2);
        grid.setConstraints(back,1,6);
        // StackPane layout2 = new StackPane();

        grid.getChildren().addAll(Attendance,Markss,back);
        Scene scene1234 = new Scene(grid, 300, 300);
        scene1234.getStylesheets().add("/styleSheet/VIper.css");
        windows.setScene(scene1234);
        windows.show();

        Attendance.setOnAction(event -> {
            Attend obj = new Attend();
            obj.attends(windows, id);

        });
        Markss.setOnAction(event -> {
            Current_sem obj = new Current_sem();
            obj.Marks(windows, id);

        });
        back.setOnAction(event -> {
            Student obj = new Student();
            obj.trying(windows, id);


        });


    }

}
