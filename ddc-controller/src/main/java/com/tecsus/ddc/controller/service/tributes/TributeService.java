package com.tecsus.ddc.controller.service.tributes;

import com.tecsus.ddc.bills.tributes.Tribute;
import com.tecsus.ddc.controller.config.TributesConfig;
import com.tecsus.ddc.controller.exceptions.EmptyResponseBody;
import com.tecsus.ddc.controller.exceptions.InvalidMonth;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author TOBIASDASILVALINO
 */
public abstract class TributeService {

    protected Tribute tribute;
    protected BigDecimal aliq;
    protected String values;
    protected DateTime period;
    protected TributesConfig config;

    protected final int FIRST_INDEX;
    protected final int LAST_INDEX;

    private static final Logger log = LoggerFactory.getLogger(COFINSService.class);

    public TributeService(final Tribute tribute, int firstIndex, int lastIndex) {
        this.tribute = tribute;
        this.FIRST_INDEX = firstIndex;
        this.LAST_INDEX = lastIndex;
    }

    public void construct(DateTime period) {
        log.info("Getting table of values.");
        HttpClient client = new HttpClient();
        HttpMethod GET = new GetMethod(config.getURL());
        String response;
        try {
            client.executeMethod(GET);
            response = new String(GET.getResponseBody());
            if (response.isEmpty()) {
                throw new EmptyResponseBody();
            }
            response = removeHTML(response).toUpperCase();
            this.values = response;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (EmptyResponseBody emptyResponseBody) {
            emptyResponseBody.printError();
        }
    }


    private String removeHTML(String response) {
        String noTagRegex = "<[^>]+>";
        return response.replaceAll(noTagRegex, "");
    }


    public BigDecimal calculateAliq() throws InvalidMonth {
        String month = period.monthOfYear().getAsText().toUpperCase();
        int year = period.get(DateTimeFieldType.year());

        String n = month + "/" + year;
        String percentage;

        if (!values.contains(n)) {
            throw new InvalidMonth();
        } else {
            int index = values.indexOf(n) + n.length() + FIRST_INDEX;
            percentage = values.substring(index, index + LAST_INDEX);
            percentage = percentage.replace(',', '.');
            return new BigDecimal(percentage);
        }
    }


    public BigDecimal calulate() {
        return this.tribute.getAliq()
                .divide(new BigDecimal("100.0"))
                .multiply(this.tribute.getCalcBase());
    }
}
