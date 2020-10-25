package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.TariffFlags;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

/**
 * @author TOBIASDASILVALINO
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TariffFlag {

    private TariffFlags flag;
    private DateTime start;
    private DateTime finish;
}
