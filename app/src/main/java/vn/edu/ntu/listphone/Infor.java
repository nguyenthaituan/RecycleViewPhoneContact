package vn.edu.ntu.listphone;

public class Infor {
    String ID, Name, Birth, PhoneNumber, Address;

    public Infor() {
    }

    public Infor(String ID, String name, String birth, String phoneNumber, String address) {
        this.ID = ID;
        this.Name = name;
        this.Birth = birth;
        this.PhoneNumber = phoneNumber;
        this.Address = address;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBirth() {
        return Birth;
    }

    public void setBirth(String birth) {
        Birth = birth;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}

