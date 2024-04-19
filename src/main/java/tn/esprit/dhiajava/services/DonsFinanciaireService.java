package tn.esprit.dhiajava.services;

import tn.esprit.dhiajava.interfaces.IService;
import tn.esprit.dhiajava.models.DonsModel;
import tn.esprit.dhiajava.utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonsFinanciaireService implements IService<DonsModel> {


    private final MyDatabase myDatabase;

    public DonsFinanciaireService(MyDatabase myDatabase) {
        this.myDatabase = myDatabase;
    }
    //dependecy injection

    @Override
    public void add(DonsModel don) {
        try (Connection connection = myDatabase.getCnx()) {
            String sql = "INSERT INTO dons_financiaire (titre, description, montant) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Set values for the prepared statement
                preparedStatement.setString(1, don.getTitre());
                preparedStatement.setString(2, don.getDescription());
                preparedStatement.setDouble(3, don.getMontant());

                // Execute the update
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Don financier added successfully.");
                } else {
                    System.out.println("Failed to add don financier.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error adding don financier: " + e.getMessage());
        }
    }

    @Override
    public void update(DonsModel donsModel, int id) {
        try (Connection connection = myDatabase.getCnx()) {
            String sql = "UPDATE dons_financiaire SET titre = ?, description = ?, montant = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Set values for the prepared statement
                preparedStatement.setString(1, donsModel.getTitre());
                preparedStatement.setString(2, donsModel.getDescription());
                preparedStatement.setDouble(3, donsModel.getMontant());
                preparedStatement.setInt(4, id);

                // Execute the update
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Don financier updated successfully.");
                } else {
                    System.out.println("Failed to update don financier.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error updating don financier: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = myDatabase.getCnx();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM dons_financiaire WHERE id = ?")) {

            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Don financier deleted successfully.");
            } else {
                System.out.println("No don financier found with id: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Error deleting don financier: " + e.getMessage());
        }
    }


    @Override
    public List<DonsModel> getAll() {
        List<DonsModel> donsList = new ArrayList<>();

        try (Connection connection = myDatabase.getCnx();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM dons_financiaire")) {

            while (resultSet.next()) {
                DonsModel don = new DonsModel();
                don.setId(resultSet.getInt("id"));
                don.setTitre(resultSet.getString("titre"));
                don.setDescription(resultSet.getString("description"));
                don.setMontant(resultSet.getInt("montant"));
                donsList.add(don);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving dons financiers: " + e.getMessage());
        }

        return donsList;
    }


    @Override
    public DonsModel getById(int id) {
        DonsModel don = null;

        try (Connection connection = myDatabase.getCnx();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM dons_financiaire WHERE id = ?")) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    don = new DonsModel();
                    don.setId(resultSet.getInt("id"));
                    don.setTitre(resultSet.getString("titre"));
                    don.setDescription(resultSet.getString("description"));
                    don.setMontant(resultSet.getInt("montant"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving don financier by id: " + e.getMessage());
        }

        return don;
    }

}
