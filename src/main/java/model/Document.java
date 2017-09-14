package model;

import com.google.gson.annotations.SerializedName;

public class Document {

    @SerializedName("receiverName")
    public String receiverName;

    @SerializedName("receiverMobileNo")
    public String receiverMobileNo;

    @SerializedName("receiverAddress")
    public String receiverAddress;

    @SerializedName("receiverCountry")
    public String receiverCountry;

    @SerializedName("receiverPincode")
    public String receiverPincode;

    @SerializedName("senderName")
    public String senderName;

    @SerializedName("senderMobileNo")
    public String senderMobileNo;

    @SerializedName("senderAddress")
    public String senderAddress;

    @SerializedName("senderCountry")
    public String senderCountry;

    @SerializedName("senderPincode")
    public String senderPincode;

    @SerializedName("senderDescription")
    public String senderDescription;

    @SerializedName("senderWeight")
    public String senderWeight;

    @SerializedName("id")
    public String id;

    @SerializedName("content")
    public String content = "content";

    @Override
    public String toString() {
        String description = "Receiver's Name: " + receiverName + "\n" +
                                "Receiver's Mobile No: " + receiverMobileNo + "\n" +
                                "Receiver's Address: " + receiverAddress + "\n" +
                                "Receiver's Country: " + receiverCountry + "\n" +
                                "Receiver's Pincode: " + receiverPincode + "\n" +
                                "Sender's Name: " + senderName + "\n" +
                                "Sender's Mobile No: " + senderMobileNo + "\n" +
                                "Sender's Address: " + senderAddress + "\n" +
                                "Sender's Country: " + senderCountry + "\n" +
                                "Sender's Pincode: " + senderPincode + "\n" +
                                "Sender's Description: " + senderDescription + "\n" +
                                "Document Weight: " + senderWeight + "\n" +
                                "Tracking Id: " + id;
        return description;
    }
}
