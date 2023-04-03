package com.exemple.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO extends BaseDAO<Produit> {
    public ProduitDAO() throws SQLException {

        super();
    }

    // mapping objet --> relation
    @Override
    public void save(Produit object) throws SQLException {

        String req = "insert into produit (Nom , Prix) values (? , ?) ;";


        this.preparedStatement = this.connection.prepareStatement(req);

        this.preparedStatement.setString(1 , object.getNom());
        this.preparedStatement.setString(2 , object.getPrix());


        this.preparedStatement.execute();

    }

    @Override
    public void update(Produit object) throws SQLException {

    }

    @Override
    public void delete(Produit object) throws SQLException {

    }

    @Override
    public Produit getOne(Long id) throws SQLException {
        return null;
    }


    // mapping relation --> objet
    @Override
    public List<Produit> getAll() throws SQLException{

        List<Produit> myliste = new ArrayList<Produit>();
        String req = " select * from produit" ;


        this.statement = this.connection.createStatement();

        this.resultSet =  this.statement.executeQuery(req);

        while (this.resultSet.next()){

            myliste.add( new Produit(this.resultSet.getInt(1) , this.resultSet.getString(2),
                    this.resultSet.getString(3)));


        }

        return myliste;
    }
}

