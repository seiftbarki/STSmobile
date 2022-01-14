package com.example.stsproject;

public class abonne {
    private int id;
    private String cin;
    private String nompren;
    private String phone;
    private String adresse;
    private String email;
    private String login;
    private String password;


    public abonne() {
    }

    public abonne(int id) {
        this.id = id;
    }

    public abonne(String cin, String nompren, String phone, String adresse, String email, String login, String password) {
        this.cin = cin;
        this.nompren = nompren;
        this.phone = phone;
        this.adresse = adresse;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public abonne(int id, String cin, String nompren, String phone, String adresse, String email, String login, String password) {
        this.id = id;
        this.cin = cin;
        this.nompren = nompren;
        this.phone = phone;
        this.adresse = adresse;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public abonne(int id, String nompren ) {
        this.id = id;
        this.nompren = nompren;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNompren() {
        return nompren;
    }

    public void setNompren(String nompren) {
        this.nompren = nompren;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

