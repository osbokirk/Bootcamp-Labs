package org.example.pakneekneepos;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;

public class SandwichController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ChoiceBox<String> breadSelcetor;
    @FXML
    private ChoiceBox<String> sizeSelector;
    @FXML
    Spinner<Integer> Ham,Turkey,Steak,Salami,RoastBeef;
    private Spinner<Integer>[] meatArray;
    @FXML
    Spinner<Integer> American,Provolone,Cheddar,Swiss;
    private Spinner<Integer>[] cheeseArray;
    @FXML
    Spinner<Integer> Lettuce,Onion,Tomatoes,Peppers,Jalepenos,Cucumber,Pickles,Guacomle,Mushrooms;
    private Spinner<Integer>[] vegtableArray;
    @FXML
    Spinner<Integer> Vinegar,OliveOil,Mayo,Mustard,Ranch,Vinaigrette,Ketchup,ThousandIsland;
    private Spinner<Integer>[] sauseArray;


    @FXML
    Spinner<Integer> AuJus,Sauce;
    private Spinner<Integer>[] sideArray;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        breadSelcetor.setItems(FXCollections.observableList(Sandwhich.getBreadOptions()));
        sizeSelector.setItems(FXCollections.observableList(Arrays.asList("FOURINCH","EIGHTINCH","TWELVEINCH")));
        meatArray= new Spinner[]{Ham,Turkey,Steak,Salami,RoastBeef};
        cheeseArray = new Spinner[]{American,Provolone,Cheddar,Swiss};
        vegtableArray = new Spinner[]{Lettuce,Onion,Tomatoes,Peppers,Jalepenos,Cucumber,Pickles,Guacomle,Mushrooms};
        sauseArray = new Spinner[]{Vinegar,OliveOil,Mayo,Mustard,Ranch,Vinaigrette,Ketchup,ThousandIsland};
        sideArray = new Spinner[]{AuJus,Sauce};
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10);
        valueFactory.setValue(0);

        for(Spinner<Integer> spinner : meatArray){
            spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10));
            System.out.println(spinner);
        }
        for(Spinner<Integer> spinner : cheeseArray){
            spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10));
            System.out.println(spinner);
        }
        for(Spinner<Integer> spinner : vegtableArray){
            spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10));
            System.out.println(spinner);
        }
        for(Spinner<Integer> spinner : sauseArray){
            spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10));
            System.out.println(spinner);
        }
        for(Spinner<Integer> spinner : sideArray){
            spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10));
            System.out.println(spinner);
        }

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
    public void submitItem(ActionEvent event) throws IOException {
        /*
        Drink drink = new Drink();
        drink.setFlavor(flavorOptions.getValue());
        drink.setSize(sizeOptions.getValue());
        //drink.setPrice();
        HelloController.order.items.add(drink);

         */
        if (breadSelcetor.getValue()!=null && sizeSelector.getValue()!=null) {
            Sandwhich sub = new Sandwhich(SandwhichSize.valueOf(sizeSelector.getValue()),breadSelcetor.getValue());
            //sub set meats
            HashMap<String,Double> userMeats =  new HashMap<>();
            for(Spinner spinner:meatArray){
                if((int)spinner.getValue()> 0){
                    String s = spinner.toString();
                    s = s.substring(s.indexOf("=")+1,s.indexOf(","));
                    userMeats.put(s,Double.valueOf(spinner.getValue().toString()) );
                }
            }
            sub.setMeats(userMeats);
            //sub set cheese
            HashMap<String,Double> userCheese = new HashMap<>();
            for(Spinner spinner:cheeseArray){
                if((int)spinner.getValue()> 0){
                    String s = spinner.toString();
                    s = s.substring(s.indexOf("=")+1,s.indexOf(","));
                    userCheese.put(s,Double.valueOf(spinner.getValue().toString()));
                }
            }
            sub.setCheeses(userCheese);
            //sub veg
            HashMap<String,Double> userVeg = new HashMap<>();
            for(Spinner spinner:vegtableArray){
                if((int)spinner.getValue()> 0){
                    String s = spinner.toString();
                    s = s.substring(s.indexOf("=")+1,s.indexOf(","));
                    userVeg.put(s,Double.valueOf(spinner.getValue().toString()));
                }
            }
            sub.setVeg(userVeg);
            //sub sauces
            HashMap<String,Double> userSauces = new HashMap<>();
            for(Spinner spinner : sauseArray){
                if((int)spinner.getValue()>0){
                    String s =spinner.toString();
                    s = s.substring(s.indexOf("=")+1,s.indexOf(","));
                    userSauces.put(s,Double.valueOf(Double.valueOf(spinner.getValue().toString())));
                }
            }
            sub.setSauseces(userSauces);
            //sub side
            // !!!!sub set tosted !!!
            HelloController.order.items.add(sub);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Choices.fxml"));
            root = loader.load();
            HelloController choiceController = loader.getController();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            System.out.println("YOU MUST SELECT BREADSIZE AND BREADTYPE");
        }

    }
}
