package com.exemple.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreditDAO extends BaseDAO<Credit> {
    public CreditDAO() throws SQLException {
        super();
    }

    // mapping objet --> relation
    @Override
    public void save(Credit credit) throws SQLException {
        String req = "INSERT INTO credit (quantite, date_enregistrement, id_produit, id_client) " +
                "VALUES (?, ?, ?, ?)";

        this.preparedStatement = this.connection.prepareStatement(req);

        this.preparedStatement.setInt(1, credit.getQuantite());
        this.preparedStatement.setString(2, credit.getDate_enregistrement());
        this.preparedStatement.setLong(4, credit.getId_produit());
        this.preparedStatement.setLong(5, credit.getId_client());

        this.preparedStatement.execute();
    }

    @Override
    public void update(Credit credit) throws SQLException {
        String req = "UPDATE credit SET quantite=?, date_enregistrement=?, id_produit=?, id_client=? " +
                "WHERE id_credit=?";

        this.preparedStatement = this.connection.prepareStatement(req);

        this.preparedStatement.setInt(1, credit.getQuantite());
        this.preparedStatement.setString(2, credit.getDate_enregistrement());
        this.preparedStatement.setLong(4, credit.getId_produit());
        this.preparedStatement.setLong(5, credit.getId_client());
        this.preparedStatement.setLong(6, credit.getId_credit());

        this.preparedStatement.execute();
    }

    @Override
    public void delete(Credit credit) throws SQLException {
        String req = "DELETE FROM credit WHERE id_credit=?";

        this.preparedStatement = this.connection.prepareStatement(req);

        this.preparedStatement.setLong(1, credit.getId_credit());

        this.preparedStatement.execute();
    }

    @Override
    public Credit getOne(Long id) throws SQLException {
        String req = "SELECT * FROM credit WHERE id_credit=?";

        this.preparedStatement = this.connection.prepareStatement(req);

        this.preparedStatement.setLong(1, id);

        this.resultSet = this.preparedStatement.executeQuery();

        if (this.resultSet.next()) {
            ProduitDAO produitDAO = new ProduitDAO();
            ClientDAO clientDAO = new ClientDAO();

            Produit produit = produitDAO.getOne(this.resultSet.getLong("id_produit"));
            Client client = clientDAO.getOne(this.resultSet.getLong("id_client"));

            int Client;
            return new Credit(
                    this.resultSet.getInt("id_credit"),
                    this.resultSet.getInt("quantite"),
                    this.resultSet.getString("date_enregistrement"),
                    produit.getId_produit(),
                    client.getId_client()
            );
        }

        return null;
    }

    // mapping relation --> objet
    @Override
    public List<Credit> getAll() throws SQLException {
        List<Credit> mylist = new ArrayList<>();
        String req = "SELECT * FROM credit";

        this.statement = this.connection.createStatement();

        this.resultSet = this.statement.executeQuery(req);

        while (this.resultSet.next()) {
            ProduitDAO produitDAO = new ProduitDAO();
            ClientDAO clientDAO = new ClientDAO();

            Produit produit = produitDAO.getOne(this.resultSet.getLong("id_produit"));
            Client client = clientDAO.getOne(this.resultSet.getLong("id_client"));

            mylist.add(new Credit(this.resultSet.getInt("id_credit"), this.resultSet.getInt("quantite"), this.resultSet.getString("date_enregistrement"), this.resultSet.getInt("id_produit"), this.resultSet.getInt("id_client")));
        }

        return mylist;
    }
}