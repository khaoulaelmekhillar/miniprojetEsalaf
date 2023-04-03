package com.exemple.model;

import java.sql.SQLException;
import java.util.List;

public class Credit {
    private int id_credit;
    private int quantite;
    private String date_enregistrement;
    private int id_produit;
    private int id_client;




    public Credit(int id_credit, int quantite, String date_enregistrement,int id_produit, int id_client) {
        this.id_credit = id_credit;
        this.quantite = quantite;
        this.date_enregistrement = date_enregistrement;
        this.id_produit = id_produit;
        this.id_client = id_client;
    }


    public int getId_credit() {
        return id_credit;
    }

    public void setId_credit(int id_credit) {
        this.id_credit = id_credit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDate_enregistrement() {
        return date_enregistrement;
    }

    public void setDate_enregistrement(String date_enregistrement) {
        this.date_enregistrement = date_enregistrement;
    }



    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id_credit=" + id_credit +
                ", quantite=" + quantite +
                ", date_enregistrement=" + date_enregistrement +
                ", id_produit=" + id_produit +
                ", id_client=" + id_client +
                '}';
    }
    public static void main(String[] args) {
        try {
            // entity
            Credit CRD  = new Credit(4,19,"08/02/2023",2,3);

            //Transacatio
           CreditDAO CRDdao = new CreditDAO();

            // save trasanction
            CRDdao.save(CRD);


            List<Credit> mylist =  CRDdao.getAll();

            for (Credit temp :mylist ) {

                System.out.println(temp.toString());

            }






        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

