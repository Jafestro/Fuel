package org.example.fuel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuelService {
    public void insertFuelData(double distance, double fuelConsumption, double price, String language) {
        try {
            // Establishing a connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuel_consumption", "root", "root");

            // Prepare the SQL statement based on the selected language
            String sql;
            sql = "INSERT INTO trip_info (distance, fuel_consumption_per_100km, used_fuel_price, language) VALUES (?, ?, ?, ?)";


            // Creating a PreparedStatement
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, distance);
            statement.setDouble(2, fuelConsumption);
            statement.setDouble(3, price);
            statement.setString(4, language);

            // Executing the statement
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Fuel data inserted successfully!");
            } else {
                System.out.println("Failed to insert fuel data.");
            }

            // Closing resources
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
