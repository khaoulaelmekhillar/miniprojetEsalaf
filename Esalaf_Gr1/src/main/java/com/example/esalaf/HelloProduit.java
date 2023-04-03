package com.example.esalaf;

import com.exemple.model.Client;
import com.exemple.model.ClientDAO;
import com.exemple.model.Produit;
import com.exemple.model.ProduitDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloProduit implements Initializable {
    @FXML
    private TextField Nom;

    @FXML
    private TextField Prix;


    @FXML
    private TableView<Produit> mytab;

    @FXML
    private TableColumn<Produit, Long> col_id;

    @FXML
    private TableColumn<Produit, String> col_nom;

    @FXML
    private TableColumn<Produit, String> col_Prix;


    @FXML
    protected void onSaveButtonClick(){

        Produit PDR = new Produit(1 , Nom.getText() , Prix.getText() );

        try {
            ProduitDAO PDRdao = new ProduitDAO();

            PDRdao.save(PDR);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        UpdateTable();

    }


    public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<Produit,Long>("id_produit"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom"));
        col_Prix.setCellValueFactory(new PropertyValueFactory<Produit,String>("prix"));
        mytab.setItems(getDataProduits());
    }


    public static ObservableList<Produit> getDataProduits(){

       ProduitDAO PDRdao = null;

        ObservableList<Produit> listfx = FXCollections.observableArrayList();

        try {
            PDRdao = new ProduitDAO();
            for(Produit ettemp : PDRdao.getAll())
                listfx.add(ettemp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx ;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UpdateTable();
    }
}
