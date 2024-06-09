package org.example.pakneekneepos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CheckoutController implements Initializable {
    @FXML
    Label reciept = new Label(HelloController.order.items.toString());
    private Stage stage;
    private Scene scene;
    private Parent root;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        reciept.setText(HelloController.order.toString());

    }
    public void comfirm(ActionEvent event) throws IOException {
        FileManger.printRecipe(HelloController.order);
        HelloController.order = new Order();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        root =loader.load();
        HelloController choiceController = loader.getController();
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void restart(ActionEvent event) throws IOException {

        HelloController.order = new Order();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        root =loader.load();
        HelloController choiceController = loader.getController();
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
