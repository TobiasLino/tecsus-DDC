package com.tecsus.ddc.bills;

import com.tecsus.ddc.Client;
import com.tecsus.ddc.Dealership;
import com.tecsus.ddc.User;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Objects;

/**
 * @author TOBIASDASILVALINO
 */
public class SavedBill {

    private long userId;
    private User user;
    private Dealership dealership;
    private Client client;
    private Bill bill;
    private DateTime register;

    public SavedBill(
            final long userId,
            final User user,
            final Dealership dealership,
            final Client client,
            final Bill bill,
            final DateTime register) {
        this.userId = userId;
        this.user = user;
        this.dealership = dealership;
        this.client = client;
        this.bill = bill;
        this.register = register;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleDateFormat formater = new SimpleDateFormat("dd/mm/YYYY");
        SavedBill savedBill = (SavedBill) o;

        return userId == savedBill.userId &&
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
        return Objects.hash(userId, user, dealership, client, bill, register);
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public DateTime getRegister() {
        return register;
    }

    public void setRegister(DateTime register) {
        this.register = register;
    }
}
