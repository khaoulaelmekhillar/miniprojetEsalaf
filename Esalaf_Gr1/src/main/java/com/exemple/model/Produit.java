package com.exemple.model;

import java.sql.SQLException;
import java.util.List;

public class Produit {
    private int id_produit ;

    private String Nom ;

    private String Prix ;

    public Produit() {
    }

    public Produit(int id_produit, String Nom, String Prix ) {
        this.id_produit = id_produit;
        this.Nom = Nom;
        this.Prix = Prix;
    }



    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrix() {
        return Prix;
    }

    public void setPrix(String Prix) {
        this.Prix = Prix;
    }

    @Override
    public String toString() {
        return "produit{" +
                "id_produit=" + id_produit +
                ", Nom='" + Nom + '\'' +
                ", Prix='" + Prix + '\'' +
                '}';
    }

    public static void main(String[] args) {
        try {
            // entity
            Produit PRD  = new Produit();

            //Transacatio
            ProduitDAO PRDdao = new ProduitDAO();

            // save trasanction
            PRDdao.save(PRD);


            List<Produit> myliste =  PRDdao.getAll();

            for (Produit temp :myliste) {

                System.out.println(temp.toString());

            }






        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
