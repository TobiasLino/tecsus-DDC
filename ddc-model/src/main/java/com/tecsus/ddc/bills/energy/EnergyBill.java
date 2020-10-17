package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.energy.enums.*;
import com.tecsus.ddc.bills.tributes.Tribute;
import com.tecsus.ddc.bills.tributes.Tributes;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author TOBIASDASILVALINO
 */
public class EnergyBill {

    private Bill bill;

    private DateTime emission;
    private String meterNumber;
    // Dados do Contrato
    private BigDecimal consumption;
    private int tension;     // Volts
    private Group group;    // Grupo/subgrupo
    private Classe classe;  // Classe/subclasse
    private SupplyType supplyType;
    // Tarifas
    private final List<TariffFlag> tariffFlags;
    private final List<Product> products;
    private final List<FinancialItem> financialItems;
    private final List<Tribute> tributes;

    public EnergyBill() {
        tariffFlags = new ArrayList<>();
        products = new ArrayList<>();
        financialItems = new ArrayList<>();
        tributes = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "EnergyBill{" +
                super.toString() +
                "emission=" + emission +
                ", tension=" + tension +
                ", group=" + group +
                ", classe=" + classe +
                ", supplyType=" + supplyType +
                ", tariffFlags=" + tariffFlags +
                ", products=" + products +
                ", financialItems=" + financialItems +
                ", tributes=" + tributes +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final EnergyBill that = (EnergyBill) o;
        return  Objects.equals(emission, that.emission) &&
                Objects.equals(tension, that.tension) &&
                Objects.equals(group, that.group) &&
                Objects.equals(classe, that.classe) &&
                supplyType == that.supplyType &&
                Objects.equals(tariffFlags, that.tariffFlags) &&
                Objects.equals(products, that.products) &&
                Objects.equals(financialItems, that.financialItems) &&
                Objects.equals(tributes, that.tributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emission, tension, group, classe, supplyType, tariffFlags, products, financialItems, tributes);
    }

    public DateTime getEmission() {
        return emission;
    }

    public void setEmission(final DateTime emission) {
        this.emission = emission;
    }

    public int getTension() {
        return tension;
    }

    public void setTension(final int tension) {
        this.tension = tension;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(final Group group) {
        this.group = group;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(final Classe classe) {
        this.classe = classe;
    }

    public SupplyType getSupplyType() {
        return supplyType;
    }

    public void setSupplyType(final SupplyType supplyType) {
        this.supplyType = supplyType;
    }

    public List<TariffFlag> getTariffFlags() {
        return tariffFlags;
    }

    public List<TariffFlag> getTariffFlag(final TariffFlags flag){
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

    public List<Product> getProduct(final ProductDescription productDescription){
        return products.stream()
                .filter(p -> p.getDescription().equals(productDescription))
                .collect(Collectors.toList());
    }

    public void addProduct(final Product product) {
        this.products.add(product);
    }

    public List<FinancialItem> getFinancialItems() {
        return financialItems;
    }

    public List<FinancialItem> getFinancialItem(ProductDescription pd) {
        return financialItems.stream()
                .filter(item -> item.getDescription().equals(pd))
                .collect(Collectors.toList());
    }


    public void addFinancialItem(FinancialItem item) {
        this.financialItems.add(item);
    }

    public List<Tribute> getTributes() {
        return tributes;
    }

    public Optional<Tribute> getTribute(Tributes tribute) {
        return tributes.stream()
                .filter(t -> t.getDescription().equals(tribute))
                .findFirst();
    }

    public void addTribute(Tribute tribute) {
        this.tributes.add(tribute);
    }

    public BigDecimal getTributesTotal() {
        BigDecimal res = new BigDecimal("0.0");
        if (!tributes.isEmpty())
            for (Tribute t : tributes) {
                res.add(t.getValue());
            }
        return res;
    }

    public BigDecimal getFinancialItemsTotal() {
        BigDecimal res = new BigDecimal("0.0");
        if (!financialItems.isEmpty()) {
            for (FinancialItem fi : financialItems) {
                res.add(fi.getValue());
            }
        }
        return res;
    }

    public BigDecimal getTotalValue() {
        BigDecimal total = new BigDecimal("0.00");
        for (Product p : products) {
            total.add(p.getTotalValue());
        }
        for (FinancialItem fi : financialItems) {
            total.add(fi.getValue());
        }
        if (!(total.compareTo(bill.getValor()) == 0)) {
            return total;
        }
        return bill.getValor();
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(final Bill bill) {
        this.bill = bill;
    }

    public BigDecimal getConsumption() {
        return consumption;
    }

    public void setConsumption(final BigDecimal consumption) {
        this.consumption = consumption;
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(final String meterNumber) {
        this.meterNumber = meterNumber;
    }
}
