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

    private int id;
    private Bill bill;

    private DateTime emission;
    // Dados do Contrato
    private BigDecimal consumption;
    private int tension;     // Volts
    private Group group;    // Grupo/subgrupo
    private Classe classe;  // Classe/subclasse
    private SupplyType supplyType;
    private BigDecimal financialItems;
    private Modalities modalitie;
    private BigDecimal tributes;
    private BigDecimal icms;
    // Tarifas
    private final List<TariffFlag> tariffFlags;
    private final List<Product> products;

    public EnergyBill() {
        tariffFlags = new ArrayList<>();
        products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(final Bill bill) {
        this.bill = bill;
    }

    public DateTime getEmission() {
        return emission;
    }

    public void setEmission(final DateTime emission) {
        this.emission = emission;
    }

    public BigDecimal getConsumption() {
        return consumption;
    }

    public void setConsumption(final BigDecimal consumption) {
        this.consumption = consumption;
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

    public BigDecimal getFinancialItems() {
        return financialItems;
    }

    public void setFinancialItems(final BigDecimal financialItems) {
        this.financialItems = financialItems;
    }

    public Modalities getModalitie() {
        return modalitie;
    }

    public void setModalitie(final Modalities modalitie) {
        this.modalitie = modalitie;
    }

    public BigDecimal getTributes() {
        return tributes;
    }

    public void setTributes(final BigDecimal tributes) {
        this.tributes = tributes;
    }

    public BigDecimal getIcms() {
        return icms;
    }

    public void setIcms(final BigDecimal icms) {
        this.icms = icms;
    }

    public List<TariffFlag> getTariffFlags() {
        return tariffFlags;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addTariffFlag(TariffFlag tariffFlag) {
        this.tariffFlags.add(tariffFlag);
    }
}
