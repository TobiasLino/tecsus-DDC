package com.tecsus.ddc.controller.service.tariffs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tecsus.ddc.controller.config.ResidentialSupplyTariffConfig;
import com.tecsus.ddc.dealership.enums.EnergyDealerships;
import com.tecsus.ddc.tariffs.ResidentialSupplyTariff;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.httpclient.HttpClient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @author TOBIASDASILVALINO
 */
public class ResidentialSupllyTariffService {

    private ResidentialSupplyTariffConfig config;
    private ArrayList<ResidentialSupplyTariff> list = new ArrayList<ResidentialSupplyTariff>();
    private EnergyDealerships target;

    private static final Logger log = LoggerFactory.getLogger(ResidentialSupllyTariffService.class);

    public ResidentialSupllyTariffService(final EnergyDealerships target) {
        this.target = target;
        this.config = new ResidentialSupplyTariffConfig();
    }

    public ResidentialSupllyTariffService construct() {
        log.info("Constructing Json for Residential Supply Tariff");

        HttpClient client = new HttpClient();
        HttpMethod GET = new GetMethod(config.getUrl());
        Gson json = new Gson();

        try {
            client.executeMethod(GET);
            String response = GET.getResponseBodyAsString();
            Type listType = new TypeToken<ArrayList<ResidentialSupplyTariff>>() {}.getType();
            list = json.fromJson(response, listType);

        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Optional<ResidentialSupplyTariff> create() {
        return list.stream()
                .filter(rst -> rst.getDealership().name().equals(target.name()))
                .findFirst();
    }
}