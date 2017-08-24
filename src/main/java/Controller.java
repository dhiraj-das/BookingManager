import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import model.Sender;
import model.SenderBuilder;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button exitButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    public void onExitPressed(ActionEvent event) {
        System.exit(0);
    }
}
