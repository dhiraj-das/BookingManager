package model;

public class SenderBuilder {
    protected String name;
    protected String mobileNo = "";
    protected String address = "";
    protected String country = "";
    protected String pincode = "";
    protected String description = "";
    protected String weight = "";

    public SenderBuilder(String name) {
        this.name = name;
    }

    public model.SenderBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public model.SenderBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public model.SenderBuilder setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public model.SenderBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public model.SenderBuilder setPincode(String pincode) {
        this.pincode = pincode;
        return this;
    }

    public model.SenderBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public model.SenderBuilder setWeight(String weight) {
        this.weight = weight;
        return this;
    }

    public Sender build() {
        return new Sender(this);
    }
}
