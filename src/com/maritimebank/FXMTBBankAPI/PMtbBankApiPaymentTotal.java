package com.maritimebank.FXMTBBankAPI;

import java.math.BigDecimal;
import java.sql.*;
import java.time.*;
import java.io.Serializable;
import javax.persistence.*;
import ru.inversion.dataset.mark.*;
import ru.inversion.db.entity.ProxyFor;

/**
@author  Grigorev
@since   2022/09/06 17:01:51
*/
@Entity (name="com.maritimebank.FXMTBBankAPI.PMtbBankApiPaymentTotal")
@NamedNativeQuery (name="com.maritimebank.FXMTBBankAPI.PMtbBankApiPaymentTotal", query="SELECT CTRNCLIENT_NAME,OP_TYPE,TRN_CNT,TRN_SUM,COM_SUM,BANK_SUM from mtb.bank_api_payment_total order by 1 desc ,2 ")
public class PMtbBankApiPaymentTotal implements Serializable
{
    private static final long serialVersionUID = 6_09_2022_17_01_52L;

    private String CTRNCLIENT_NAME;
    private String OP_TYPE;
    private Long TRN_CNT;
    private BigDecimal TRN_SUM;
    private BigDecimal COM_SUM;
    private BigDecimal BANK_SUM;

    public PMtbBankApiPaymentTotal(){}

    @Id 
    @Column(name="CTRNCLIENT_NAME",length = 300)
    public String getCTRNCLIENT_NAME() {
        return CTRNCLIENT_NAME;
    }
    public void setCTRNCLIENT_NAME(String val) {
        CTRNCLIENT_NAME = val; 
    }
    @Column(name="OP_TYPE",length = 30)
    public String getOP_TYPE() {
        return OP_TYPE;
    }
    public void setOP_TYPE(String val) {
        OP_TYPE = val;
    }
    @Column(name="TRN_CNT",length = 0)
    public Long getTRN_CNT() {
        return TRN_CNT;
    }
    public void setTRN_CNT(Long val) {
        TRN_CNT = val; 
    }
    @Column(name="TRN_SUM",length = 0)
    public BigDecimal getTRN_SUM() {
        return TRN_SUM;
    }
    public void setTRN_SUM(BigDecimal val) {
        TRN_SUM = val; 
    }
    @Column(name="COM_SUM",length = 0)
    public BigDecimal getCOM_SUM() {
        return COM_SUM;
    }
    public void setCOM_SUM(BigDecimal val) {
        COM_SUM = val; 
    }
    @Column(name="BANK_SUM",length = 0)
    public BigDecimal getBANK_SUM() {
        return BANK_SUM;
    }
    public void setBANK_SUM(BigDecimal val) {
        BANK_SUM = val; 
    }
}