package model;

public class Receiver {
    private String name;
    private String mobileNo;
    private String address;
    private String country;
    private String pincode;

    public Receiver(ReceiverBuilder builder) {
        this.name = builder.name;
        this.mobileNo = builder.mobileNo;
        this.address = builder.address;
        this.country = builder.country;
        this.pincode = builder.pincode;
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

    @Override
    public String toString() {
        return "Name: " + name + "\nMobile No:" + mobileNo;
    }
}
