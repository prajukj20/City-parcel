package com.example.cityparcel_listpassed_method;

public class carddetail {
    String cardno;
    String Name;
    String date;
    String CVV_no;

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCVV_no() {
        return CVV_no;
    }

    public void setCVV_no(String CVV_no) {
        this.CVV_no = CVV_no;
    }

    public carddetail(String cardno, String name, String date, String CVV_no) {
        this.cardno = cardno;
        Name = name;
        this.date = date;
        this.CVV_no = this.CVV_no;
    }
}
