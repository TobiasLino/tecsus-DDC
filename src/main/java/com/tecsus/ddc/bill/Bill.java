package com.tecsus.ddc.bill;

import com.tecsus.ddc.bill.type.BillType;
import com.tecsus.ddc.instalation.Instalation;
import com.tecsus.ddc.meter.Meter;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Data
public class Bill {

    protected String billNum;
    protected Instalation instalation;
    protected BigDecimal value;
    protected Date refMonth;
    protected Date previousRead;
    protected BigDecimal previousReadValue;
    protected Date actualRead;
    protected BigDecimal actualReadValue;
    protected Date nextRead;
    protected Date dueDate;
    protected Integer consum;
    protected Integer consumPeriod;
    protected Meter meter;
    protected BillType billType;
}
