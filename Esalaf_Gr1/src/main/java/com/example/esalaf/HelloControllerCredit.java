package com.example.esalaf;

import com.exemple.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloControllerCredit implements Initializable {




    @FXML
    private TableView<Credit> mytab;

    @FXML
    private TableColumn<Credit, Long> col_id;
    @FXML
    private TableColumn<Client, Long> col_idc;
    @FXML
    private TableColumn<Produit, Long> col_idp;

    @FXML
    private TableColumn<Credit, String> col_Quantite;

    @FXML
    private TableColumn<Credit, Long> col_Date;

    public HelloControllerCredit() {
    }


    public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<Credit,Long>("id_credit"));
        col_idc.setCellValueFactory(new PropertyValueFactory<Client,Long>("id_client"));
        col_idp.setCellValueFactory(new PropertyValueFactory<Produit,Long>("id_produit"));
        col_Quantite.setCellValueFactory(new PropertyValueFactory<Credit,String>("quantite"));
        col_Date.setCellValueFactory(new PropertyValueFactory<Credit, Long>("date_enregistrement"));
        mytab.setItems(getDataCredits());
    }

    public static ObservableList<Credit> getDataCredits(){

        CreditDAO crddao = null;

        ObservableList<Credit> listfx = FXCollections.observableArrayList();

        try {
           crddao = new CreditDAO();
            for(Credit ettemp : crddao.getAll())
                listfx.add(ettemp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UpdateTable();
    }
}
