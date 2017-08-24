package model;

public class Sender {
    private String name;
    private String mobileNo;
    private String address;
    private String country;
    private String pincode;
    private String description;
    private String weight;

    public Sender(SenderBuilder builder) {
        this.name = builder.name;
        this.mobileNo = builder.mobileNo;
        this.address = builder.address;
        this.country = builder.country;
        this.pincode = builder.pincode;
        this.description = builder.description;
        this.weight = builder.weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}