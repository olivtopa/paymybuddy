package com.olivtopa.paymybuddy.dto;

public class DepositRequest {
	
	private String email;

    private String bic;

    private String iban;

    private double moneyToAdd;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMoneyToAdd() {
        return moneyToAdd;
    }

    public void setMoneyToAdd(double moneyToAdd) {
        this.moneyToAdd = moneyToAdd;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "DepositRequest{" +
                "email='" + email + '\'' +
                ", bic='" + bic + '\'' +
                ", iban='" + iban + '\'' +
                ", moneyToAdd=" + moneyToAdd +
                '}';
    }

}
