package com.tecsus.ddc.bills;
import com.tecsus.ddc.instalation.Instalation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.math.BigDecimal;

/*
Classe abstrata da conta, são valore que as contas de água e luz possuem iguais
    - Valor; Vencimento; Mês Referência; Número Conta (PK); Período Consumo; Leitura Próxima, Leitura Atual; Leitura Anterior;
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Bill {

    //Atributos
    private Instalation instalation;
    private BigDecimal valor;
    private DateTime vencimento;
    private DateTime mesReferencia;
    private String numConta;
    private int periodoConsumo;
    private DateTime leituraProxima;
    private DateTime leituraAtual;
    private DateTime leituraAnterior;
    private String numMedidor;
    private BigDecimal valorLeituraAnterior;
    private BigDecimal valorLeituraAtual;
}
