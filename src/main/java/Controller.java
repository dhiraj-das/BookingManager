import helper.IntegerFilter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.util.converter.IntegerStringConverter;
import model.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    @FXML private TextField bookingIdTextField;

    // MARK: Receiver UI Properties
    @FXML private TextField recipientName;
    @FXML private TextField recipientMobileNo;
    @FXML private TextArea recipientAddress;
    @FXML private TextField recipientCountry;
    @FXML private TextField recipientPincode;

    //MARK: Tracking Tab
    @FXML private TextField trackingId;
    @FXML private TextArea packageDetailsTextArea;
    @FXML private ProgressIndicator trackDocumentProgressIndicator;

    APIInterface apiInterface;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        trackDocumentProgressIndicator.setVisible(false);
        TextFormatter<Integer> formatter = new TextFormatter<>(
                new IntegerStringConverter(),
                null,
                new IntegerFilter());
        senderMobileNo.setTextFormatter(formatter);

    }

    public void onExitPressed(ActionEvent event) {
        System.exit(0);
    }

    public void onSavePressed(ActionEvent event) {
        if(validateTextFields()) {
            Document document = new Document();
            document.senderName = senderName.getText();
            document.senderMobileNo = senderMobileNo.getText();
            document.senderAddress = senderAddress.getText();
            document.senderCountry = senderCountry.getText();
            document.senderPincode = senderPincode.getText();
            document.senderDescription = itemDescription.getText();
            document.senderWeight = packageWeight.getText();
            document.receiverName = recipientName.getText();
            document.receiverMobileNo = recipientMobileNo.getText();
            document.receiverAddress = recipientAddress.getText();
            document.receiverCountry = recipientCountry.getText();
            document.receiverPincode = recipientPincode.getText();

            apiInterface = APIClient.getClient().create(APIInterface.class);

            Call call = apiInterface.saveDocument(document);
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    Document doc = (Document) response.body();
                    if(doc == null) {
                        return;
                    }
                    bookingIdTextField.textProperty().setValue(doc.id);
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    trackDocumentProgressIndicator.setVisible(false);
                    call.cancel();
                }
            });
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

    public void onShowDetailsTapped(ActionEvent event) {
        if(trackingId.getText().isEmpty()) {
            trackingId.setStyle("-fx-prompt-text-fill: red;");
            return;
        }
        String trackingIdString = trackingId.getText();
        trackDocumentProgressIndicator.setVisible(true);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        Call call = apiInterface.getDocument(trackingIdString);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                trackDocumentProgressIndicator.setVisible(false);
                Document doc = (Document) response.body();
                if(doc == null) {
                    return;
                }
                packageDetailsTextArea.textProperty().setValue(doc.toString());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                trackDocumentProgressIndicator.setVisible(false);
                call.cancel();
            }
        });
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
