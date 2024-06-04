package org.example.pakneekneepos;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public static Order order = new Order();
    @FXML
    Label orderPrint = new Label();
    @FXML
    Label orderLabel = new Label(order.items.toString());
    @FXML
    TextArea orderTotal = new TextArea("Total");
    //public ListView<String> orderLabel = new ListView<>();
    //ObservableList<String> item = FXCollections.observableArrayList("Test");

    public void initialize(URL url, ResourceBundle resourceBundle) {
        //System.out.println(order.toString());
        orderLabel.setText(order.toString());
        //Order.getItems().addAll(Chip.getFlavorsList());
        //chipFlavor.setValue("BBQ");
        //chipFlavor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
        double sum = 0;
        for(Sellable item: order.items){sum += item.getPrice();}

        orderTotal.setText("Total                    "+ sum);
    }


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void exit(){
        System.exit(0);
    }

    @FXML
    protected void Choices(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Choices.fxml"));
        System.out.println(order.items);
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void addSandwich(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Sandwich.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void addDrink(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Drink.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void addChip(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Chip.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void checkout(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Checkout.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void CancelOrder(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}

    protected void addToOrder(Sellable item){
        order.items.add(item);
    }


}