import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import model.Receiver;
import model.Sender;
import model.SenderBuilder;
import model.ReceiverBuilder;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private Button exitButton;

    // MARK: Sender UI Properties
    @FXML private TextField senderName;
    @FXML private TextField senderMobileNo;
    @FXML private TextArea senderAddress;
    @FXML private TextField senderCountry;
    @FXML private TextField senderPincode;
    @FXML private TextArea itemDescription;
    @FXML private TextField packageWeight;

    // MARK: Receiver UI Properties
    @FXML private TextField recipientName;
    @FXML private TextField recipientMobileNo;
    @FXML private TextArea recipientAddress;
    @FXML private TextField recipientCountry;
    @FXML private TextField recipientPincode;

    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    public void onExitPressed(ActionEvent event) {
        System.exit(0);
    }

    public void onSavePressed(ActionEvent event) {
        if(validateTextFields()) {
            Sender sender = new SenderBuilder(senderName.getText())
                    .setMobileNo(senderMobileNo.getText())
                    .setAddress(senderAddress.getText())
                    .setCountry(senderCountry.getText())
                    .setPincode(senderPincode.getText())
                    .setDescription(itemDescription.getText())
                    .setWeight(packageWeight.getText())
                    .build();

            Receiver receiver = new ReceiverBuilder(recipientName.getText())
                    .setMobileNo(recipientMobileNo.getText())
                    .setAddress(recipientAddress.getText())
                    .setCountry(recipientCountry.getText())
                    .setPincode(recipientPincode.getText())
                    .build();

            System.out.println(sender.toString());
            System.out.println(receiver.toString());
        }
    }

    public void onClearSenderPressed(ActionEvent event) {
        senderName.textProperty().setValue("");
        senderMobileNo.textProperty().setValue("");
        senderAddress.textProperty().setValue("");
        senderCountry.textProperty().setValue("");
        senderPincode.textProperty().setValue("");
        itemDescription.textProperty().setValue("");
        packageWeight.textProperty().setValue("");
    }

    public void onClearReceiverPressed(ActionEvent event) {
        recipientName.textProperty().setValue("");
        recipientMobileNo.textProperty().setValue("");
        recipientAddress.textProperty().setValue("");
        recipientCountry.textProperty().setValue("");
        recipientPincode.textProperty().setValue("");
    }

    private Boolean validateTextFields() {
        Boolean valid = true;
        if(senderName.getText().isEmpty()) {
            senderName.setStyle("-fx-prompt-text-fill: red;");
            valid = false;
        }
        if(senderMobileNo.getText().isEmpty()) {
            senderMobileNo.setStyle("-fx-prompt-text-fill: red;");
            valid = false;
        }
        if(senderAddress.getText().isEmpty()) {
            senderAddress.setStyle("-fx-prompt-text-fill: red;");
            valid = false;
        }
        if(senderCountry.getText().isEmpty()) {
            senderCountry.setStyle("-fx-prompt-text-fill: red;");
            valid = false;
        }
        if(senderPincode.getText().isEmpty()) {
            senderPincode.setStyle("-fx-prompt-text-fill: red;");
            valid = false;
        }
        if(packageWeight.getText().isEmpty()) {
            packageWeight.setStyle("-fx-prompt-text-fill: red;");
            valid = false;
        }
        if(recipientName.getText().isEmpty()) {
            recipientName.setStyle("-fx-prompt-text-fill: red;");
            valid = false;
        }
        if(recipientMobileNo.getText().isEmpty()) {
            recipientMobileNo.setStyle("-fx-prompt-text-fill: red;");
            valid = false;
        }
        if(recipientAddress.getText().isEmpty()) {
            recipientAddress.setStyle("-fx-prompt-text-fill: red;");
            valid = false;
        }
        if(recipientCountry.getText().isEmpty()) {
            recipientCountry.setStyle("-fx-prompt-text-fill: red;");
            valid = false;
        }
        if(recipientPincode.getText().isEmpty()) {
            recipientPincode.setStyle("-fx-prompt-text-fill: red;");
            valid = false;
        }
        return valid;
    }
}
