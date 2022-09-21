package model;

public class User {
    private String userName;
    private String nationalCode;

    public User(String userName, String nationalCode) {
        this.userName = userName;
        this.nationalCode = nationalCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String  getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }
}

