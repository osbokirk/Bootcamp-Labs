package org.example.pakneekneepos;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChipController implements Initializable {
    @FXML
    private Label flavorLabel;
    @FXML
    private Button submit;

    @FXML
    private ChoiceBox<String> chipFlavor;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chipFlavor.getItems().addAll(Chip.getFlavorsList());
        chipFlavor.setValue("BBQ");
        chipFlavor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

            }
        });
    }
    public Chip addChip(){
        if(chipFlavor.getValue() != null){
            Chip chip = new Chip(chipFlavor.getValue());
        return chip;
        }
        return new Chip();
    }
    public void submitItem(ActionEvent event) throws IOException {
        System.out.println(HelloController.order.items);
        HelloController.order.items.add(addChip());
        System.out.println(HelloController.order.items);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Choices.fxml"));
        root =loader.load();
        HelloController choiceController = loader.getController();

        //System.out.println();

        //root = FXMLLoader.load(getClass().getResource("Choices.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void back(ActionEvent event)throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Choices.fxml"));
        root =loader.load();
        HelloController choiceController = loader.getController();
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void getFlavor(ActionEvent event){
        String myFlavor = chipFlavor.getValue();
    }

}
