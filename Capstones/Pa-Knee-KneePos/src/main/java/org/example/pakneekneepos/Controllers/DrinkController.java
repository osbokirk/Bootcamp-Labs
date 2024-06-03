package org.example.pakneekneepos;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DrinkController implements Initializable {
    @FXML
    ComboBox<String> sizeOptions ;
    @FXML
    ComboBox<String> flavorOptions ;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        flavorOptions.setItems(FXCollections.observableList(Drink.getFlavorList()));
        sizeOptions .setItems(FXCollections.observableList(Drink.priceChart.keySet().stream().toList()));
    }
    public void submitItem(ActionEvent event) throws IOException {
        Drink drink = new Drink();
        drink.setFlavor(flavorOptions.getValue());
        drink.setSize(sizeOptions.getValue());
        //drink.setPrice();
        HelloController.order.items.add(drink);
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


}
