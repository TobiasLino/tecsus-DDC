package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.ProductDescription;
import com.tecsus.ddc.bills.energy.enums.TariffFlags;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author TOBIASDASILVALINO
 */
public class EnergyBill {

    private DateTime emission;
    private double tension;     // Volts
    private double consumption;
    private ConsumptionDescription consumptionDescription;
    private Group group;    // Grupo/subgrupo classe/subclasse
    private RushHour rushHour;  // apenas para grupo A industrial
    private final List<TariffFlag> tariffFlags = new ArrayList<>();
    private final List<Product> products = new ArrayList<>();

    public EnergyBill() {
    }

    public EnergyBill(
            final DateTime emission,
            final double tension,
            final double consumption,
            final ConsumptionDescription consumptionDescription,
            final Group group,
            final RushHour rushHour) {
        this.emission = emission;
        this.tension = tension;
        this.consumption = consumption;
        this.consumptionDescription = consumptionDescription;
        this.group = group;
        this.rushHour = rushHour;
    }

    public DateTime getEmission() {
        return emission;
    }

    public void setEmission(final DateTime emission) {
        this.emission = emission;
    }

    public double getTension() {
        return tension;
    }

    public void setTension(final double tension) {
        this.tension = tension;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(final double consumption) {
        this.consumption = consumption;
    }

    public ConsumptionDescription getConsumptionDescription() {
        return consumptionDescription;
    }

    public void setConsumptionDescription(final ConsumptionDescription consumptionDescription) {
        this.consumptionDescription = consumptionDescription;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(final Group group) {
        this.group = group;
    }

    public RushHour getRushHour() {
        return rushHour;
    }

    public void setRushHour(final RushHour rushHour) {
        this.rushHour = rushHour;
    }

    public List<TariffFlag> getTariffFlags() {
        return tariffFlags;
    }

    public List<TariffFlag> getTariffFlag(final TariffFlags flag) throws NullPointerException {
        if (tariffFlags.isEmpty()) {
            throw new NullPointerException();
        }
        return tariffFlags.stream()
                .filter(f -> f.getFlag().equals(flag))
                .collect(Collectors.toList());
    }

    public void addTariffFlag(final TariffFlag tariffFlag) {
        this.tariffFlags.add(tariffFlag);
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getProduct(final ProductDescription productDescription) throws NullPointerException {
        if (products.isEmpty()) {
            throw new NullPointerException();
        }
        return products.stream()
                .filter(p -> p.getDescription().equals(productDescription))
                .collect(Collectors.toList());
    }

    public void addProduct(final Product product) {
        this.products.add(product);
    }
}
