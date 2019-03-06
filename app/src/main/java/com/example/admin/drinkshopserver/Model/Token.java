package com.example.admin.drinkshopserver.Model;

public class Token {
    public String phone;
    public String token;
    public int issevertoken;

    public Token() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getIssevertoken() {
        return issevertoken;
    }

    public void setIssevertoken(int issevertoken) {
        this.issevertoken = issevertoken;
    }
}
