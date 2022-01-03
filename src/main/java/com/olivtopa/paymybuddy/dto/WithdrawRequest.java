package com.olivtopa.paymybuddy.dto;

public class WithdrawRequest {
	
	private String email;

    private String bic;

    private String iban;

    private double amount;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "WithdrawRequest{" +
                "email='" + email + '\'' +
                ", bic='" + bic + '\'' +
                ", iban='" + iban + '\'' +
                ", amount=" + amount +
                '}';
    }

}
