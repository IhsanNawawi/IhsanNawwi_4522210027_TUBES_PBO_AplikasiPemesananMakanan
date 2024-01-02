// MenuController.java
package tubes_pbo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MenuController {
    @FXML
    private ListView<String> menuListView;

    @FXML
    private Label totalLabel;

    @FXML
    private TextField amountField;

    private double totalAmount;
    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    private String namaPelanggan;
    private String nomorMeja;

    public void initialize() {
        // Initialize the menu items
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Nasi Goreng", 15000));
        menuItems.add(new MenuItem("Mie Ayam", 12000));
        menuItems.add(new MenuItem("Ayam Goreng", 13000));

        // Display menu items in the ListView
        for (MenuItem item : menuItems) {
            menuListView.getItems().add(item.getName() + " - Rp " + item.getPrice());
        }
    }

    @FXML
    private void addToCart() {
        int selectedIndex = menuListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            MenuItem selectedItem = menuItems.get(selectedIndex);
            totalAmount += selectedItem.getPrice();
            totalLabel.setText("Total: Rp " + totalAmount);
        } else {

        }
    }


    public void initData(String namaPelanggan, String nomorMeja) {
        this.namaPelanggan = namaPelanggan;
        this.nomorMeja = nomorMeja;
    }

    @FXML
    private void switchToSecondary() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
        Parent root = loader.load();

        SecondaryController secondaryController = loader.getController();
        secondaryController.initData(totalAmount, Double.parseDouble(amountField.getText()), namaPelanggan, nomorMeja);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
