// PrimaryController.java
package tubes_pbo;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PrimaryController {
    @FXML
    private TextField namaField;

    @FXML
    private TextField mejaField;

    @FXML
    private void switchToMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();

        MenuController menuController = loader.getController();
        menuController.initData(namaField.getText(), mejaField.getText());

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
