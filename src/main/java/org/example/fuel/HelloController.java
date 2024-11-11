package org.example.fuel;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {
    public TextField distanceInput;
    public TextField fuelInput;
    public Label fuel;
    public Label distance;
    public Label response;
    public Button calculate;
    private String language = "EN";
    private Stage stage;
    private FuelService fuelService = new FuelService();
    private double FUEL_PRICE = 1.61;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setEN(ActionEvent actionEvent) {
        language = "EN";
        distance.setText("Distance (km)");
        fuel.setText("Fuel consumption (l/100km)");
        calculate.setText("Calculate");
    }

    public void setFR(ActionEvent actionEvent) {
        language = "FR";
        distance.setText("Distance (km)");
        fuel.setText("Consommation de carburant (l/100km)");
        calculate.setText("Calculer");
    }

    public void setJP(ActionEvent actionEvent) {
        language = "JP";
        distance.setText("距離（km）");
        fuel.setText("燃費（l/100km）");
        calculate.setText("計算する");
    }

    public void setIR(ActionEvent actionEvent) {
        language = "IR";
        distance.setText("مسافت (کیلومتر)");
        fuel.setText("مصرف سوخت (لیتر/100 کیلومتر)");
        calculate.setText("محاسبه");
    }

    public void calculatePrice(ActionEvent actionEvent) {
        try {
            double distanceValue = Double.parseDouble(distanceInput.getText());
            double fuelConsumptionRate = Double.parseDouble(fuelInput.getText());
            double fuelCost = (distanceValue / 100) * fuelConsumptionRate * FUEL_PRICE;
            response.setText(String.format("Fuel Cost: %.2f", fuelCost));
        } catch (NumberFormatException e) {
            switch (language) {
                case "EN" -> response.setText("Invalid input. Please enter valid numbers.");
                case "FR" -> response.setText("Entrée invalide. Veuillez entrer des nombres valides.");
                case "JP" -> response.setText("無効な入力です。有効な数値を入力してください。");
                case "IR" -> response.setText("ورودی نامعتبر است. لطفاً اعداد معتبر وارد کنید.");
                default -> {
                }
            }
        }
    }
}