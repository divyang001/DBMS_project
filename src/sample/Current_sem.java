package sample;

import Database_functions.StudentDb;
import javafx.collections.ObservableList;
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
import models.StudentModel;



public class Current_sem {

    public void Marks(Stage windows,String id)
    {
        Scene scene;
        Button button;
        TableView<MarksModel> table = new TableView();

        final Label label = new Label("Marks-Fall Semester 2016-17");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);
        TableColumn<MarksModel,String> course_code = new TableColumn("Course Code");
        course_code.setCellValueFactory(new PropertyValueFactory<MarksModel, String>("courseCode"));
        TableColumn<MarksModel, Integer> cat = new TableColumn("CAT");
        cat.setCellValueFactory(new PropertyValueFactory<MarksModel, Integer>("cat"));
        TableColumn<MarksModel, Integer> pbl = new TableColumn("PBL");
        pbl.setCellValueFactory(new PropertyValueFactory<MarksModel, Integer>("pbl"));
        TableColumn<MarksModel, Integer> fat = new TableColumn("FAT");
        fat.setCellValueFactory(new PropertyValueFactory<MarksModel, Integer>("fat"));
        TableColumn<MarksModel, String> grade = new TableColumn("Grade");
        grade.setCellValueFactory(new PropertyValueFactory<MarksModel, String>("grade"));
        System.out.print("hello");
        StudentDb obz =new StudentDb();
        table.setItems(obz.marks(id));
        button= new Button("Back");

        button.setOnAction(event -> {

            Fall obj = new Fall();
            obj.currentsem(windows, id);
        });

        table.getColumns().addAll(course_code, cat, pbl, fat, grade);

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
