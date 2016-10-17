package sample;

import Database_functions.StudentDb;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import models.MarksModel;

/**
 * Created by divyang on 18/10/16.
 */
public class Attend {

    public void attends(Stage windows, String id)
    {
        Scene scene;
        Button button;
        TableView<MarksModel> table = new TableView();

        final Label label = new Label("Attendance-Fall Semester 2016-17");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);
        TableColumn<MarksModel,String> course_code = new TableColumn("Course Code");
        course_code.setCellValueFactory(new PropertyValueFactory<MarksModel, String>("courseCode"));
        TableColumn<MarksModel, Integer> cat = new TableColumn("Attendance");
        cat.setCellValueFactory(new PropertyValueFactory<MarksModel, Integer>("attendance"));
        StudentDb obz =new StudentDb();
        table.setItems(obz.ats(id));
        button= new Button("Back");

        button.setOnAction(event -> {

            Fall obj = new Fall();
            obj.currentsem(windows, id);
        });

        table.getColumns().addAll(course_code, cat);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table,button);

        scene = new Scene(new Group());
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        scene.getStylesheets().add("/styleSheet/current_sem.css");
        windows.setScene(scene);
        windows.show();



    }


}
