package model;

public class ReceiverBuilder {
    protected String name;
    protected String mobileNo = "";
    protected String address = "";
    protected String country = "";
    protected String pincode = "";

    public ReceiverBuilder(String name) {
        this.name = name;
    }

    public ReceiverBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public ReceiverBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ReceiverBuilder setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public ReceiverBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public ReceiverBuilder setPincode(String pincode) {
        this.pincode = pincode;
        return this;
    }

    public Receiver build() { return new Receiver(this); }
}
