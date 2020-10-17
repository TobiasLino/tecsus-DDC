package com.tecsus.ddc.bills;

import com.tecsus.ddc.client.Client;
import com.tecsus.ddc.dealership.Dealership;
import com.tecsus.ddc.user.User;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Objects;

/**
 * @author TOBIASDASILVALINO
 */
public class SavedBill<BillType> {

    private String userName;
    private User user;
    private Dealership dealership;
    private Client client;
    private BillType bill;
    private DateTime register;

    public SavedBill(
            final String userName,
            final User user,
            final Dealership dealership,
            final Client client,
            final BillType bill,
            final DateTime register) {
        this.userName = userName;
        this.user = user;
        this.dealership = dealership;
        this.client = client;
        this.bill = bill;
        this.register = register;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YY HH:mm");
        return "SavedBill{" +
                "userName='" + userName + '\'' +
                ", user=" + user.toString() +
                ", dealership=" + dealership.toString() +
                ", client=" + client.toString() +
                ", bill=" + bill.toString() +
                ", register=" + formatter.format(register.toDate()) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/YYYY");
        SavedBill savedBill = (SavedBill) o;

        return userName == savedBill.userName &&
                Objects.equals(user, savedBill.user) &&
                Objects.equals(dealership, savedBill.dealership) &&
                Objects.equals(client, savedBill.client) &&
                Objects.equals(bill, savedBill.bill) &&
                Objects.equals(
                        formater.format(register.toDate()),
                        formater.format(savedBill.register.toDate()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, user, dealership, client, bill, register);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Dealership getDealership() {
        return dealership;
    }

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BillType getBill() {
        return bill;
    }

    public void setBill(BillType bill) {
        this.bill = bill;
    }

    public DateTime getRegister() {
        return register;
    }

    public void setRegister(DateTime register) {
        this.register = register;
    }
}
