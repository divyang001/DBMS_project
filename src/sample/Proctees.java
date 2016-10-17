package sample;

import Database_functions.FacultyDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import models.StudentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by divyang on 7/9/16.
 */
public class Proctees {

    List<StudentModel> listing=new ArrayList<>();
    ListView<HBoxCell> listView = new ListView<HBoxCell>();
    public static class HBoxCell extends HBox {
        Label label = new Label();
        Button button = new Button();

        HBoxCell(String labelText, String buttonText, String id,Stage window,String id2) {
            super();

            label.setText(labelText);
            label.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(label, Priority.ALWAYS);
            button.setText(buttonText);
            button.setMaxWidth(100);
            this.getChildren().addAll(label, button);

            button.setOnAction(event -> {

                StudentProfile obj=new StudentProfile();
                obj.Profile(window,id,id2);
            });
        }
    }
    public Parent createContent(String id,Stage window) {
        BorderPane layout = new BorderPane();
        FacultyDb obj=new FacultyDb();

        listing=obj.Proctee(id);

        List<HBoxCell> list = new ArrayList<>();
        for(StudentModel stud:listing) {

            list.add(new HBoxCell(stud.getName()+" "  , "View Profile" ,stud.getId(),window,id));

        }
        ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list);
        listView.setItems(myObservableList);
        layout.setCenter(listView);

        return layout;
    }

    public void procte(Stage window,String id)
    {
        window.setScene(new Scene(createContent(id,window)));
        window.setWidth(300);
        window.setHeight(200);
        window.show();
    }

    }





