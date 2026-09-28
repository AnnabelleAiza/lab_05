package com.mycompany.lab_05;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    Label messageLabel = new Label();
    Label size = new Label();

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        
        Label title = new Label("Select type of bag:");
        Label radiosTitle = new Label("Select size of bag:");
        Label hBoxTitle = new Label("Select amount of bags:");
        
        messageLabel.setAlignment(Pos.TOP_CENTER);
        
        ListView<String> list = new ListView<>();
        list.setPrefSize(120,100);
        list.getItems().addAll("Full decorative", "Beaded", "Pirate Design",
                "Fringed", "Leather", "Plain");
               
        ComboBox<Integer> combo = new ComboBox<>();
        combo.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        combo.setPromptText("Amount");
        
        RadioButton radio1 = new RadioButton("Small");
        radio1.setUserData("Small");
        RadioButton radio2 = new RadioButton("Medium");
        radio2.setUserData("Medium");
        RadioButton radio3 = new RadioButton("Large");
        radio3.setUserData("Large");
        
        ToggleGroup radioGroup = new ToggleGroup();
        
        radioGroup.getToggles().addAll(radio1, radio2, radio3);
       
        radio1.setSelected(true);

        Button orderBtn = new Button("Order");
        Button clearBtn = new Button("Clear");
        
        orderBtn.setOnAction(event -> {
            int amountSelected = combo.getValue();
            String size = radioGroup.getSelectedToggle().getUserData().toString();
            String type = list.getSelectionModel().getSelectedItem();
            messageLabel.setText("You ordered " + amountSelected + " " + size +
                     " " + type + " bags");
        });

        clearBtn.setOnAction(event -> {
            messageLabel.setText("");
            list.getSelectionModel().clearSelection();
            combo.getSelectionModel().clearSelection();
            radioGroup.selectToggle(null);
        });
        VBox radios = new VBox();
        radios.getChildren().addAll(radiosTitle, radio1, radio2, radio3);
        radios.setPadding(new Insets (20));
        
        HBox hboxTitle = new HBox();
        hboxTitle.getChildren().addAll(hBoxTitle);
        
        HBox hbox = new HBox();
        hbox.getChildren().addAll(radios, combo);
        hbox.setSpacing(10);
        hbox.setLayoutX(10);
        
        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(orderBtn, clearBtn);
        hbox.setPadding(new Insets (20));
        hbox.setSpacing(10);
        
        root.getChildren().addAll(title, list, hboxTitle, hbox, hbox2, messageLabel);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}