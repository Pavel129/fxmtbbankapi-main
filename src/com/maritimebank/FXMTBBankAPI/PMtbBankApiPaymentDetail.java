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
@since   2022/09/08 10:35:24
*/
@Entity (name="com.maritimebank.FXMTBBankAPI.PMtbBankApiPaymentDetail")
@NamedNativeQuery (name="com.maritimebank.FXMTBBankAPI.PMtbBankApiPaymentDetail"
        ,query="SELECT DBACSTAMP,OP_TYPE,RCVNAME,RCVINN,CNAMEP,CBIC,RCVACC,RCVSUM,CBAPORDID,D_CREATE,DTRNTRAN,DOCNUM,DOCDATE,STATUS,CBAPERR from mtb.bank_api_payment_detail")
public class PMtbBankApiPaymentDetail implements Serializable
{
    private static final long serialVersionUID = 8_09_2022_10_35_26L;

    private LocalDateTime DBACSTAMP;
    private String OP_TYPE;
    private String RCVNAME;
    private String RCVINN;
    private String CNAMEP;
    private String CBIC;
    private String RCVACC;
    private BigDecimal RCVSUM;
    private String CBAPORDID;
    private LocalDateTime D_CREATE;
    private LocalDateTime DTRNTRAN;
    private Long DOCNUM;
    private LocalDate DOCDATE;
    private String STATUS;
    private String CBAPERR;

    public PMtbBankApiPaymentDetail(){}

    @Column(name="DBACSTAMP")
    public LocalDateTime getDBACSTAMP() {
        return DBACSTAMP;
    }
    public void setDBACSTAMP(LocalDateTime val) {
        DBACSTAMP = val; 
    }
    @Column(name="OP_TYPE",length = 16)
    public String getOP_TYPE() {
        return OP_TYPE;
    }
    public void setOP_TYPE(String val) {
        OP_TYPE = val; 
    }
    @Column(name="RCVNAME",length = 512)
    public String getRCVNAME() {
        return RCVNAME;
    }
    public void setRCVNAME(String val) {
        RCVNAME = val; 
    }
    @Column(name="RCVINN")
    public String getRCVINN() {
        return RCVINN;
    }
    public void setRCVINN(String val) {
        RCVINN = val; 
    }
    @Column(name="CNAMEP",length = 160)
    public String getCNAMEP() {
        return CNAMEP;
    }
    public void setCNAMEP(String val) {
        CNAMEP = val; 
    }
    @Column(name="CBIC",length = 9)
    public String getCBIC() {
        return CBIC;
    }
    public void setCBIC(String val) {
        CBIC = val; 
    }
    @Column(name="RCVACC")
    public String getRCVACC() {
        return RCVACC;
    }
    public void setRCVACC(String val) {
        RCVACC = val; 
    }
    @Column(name="RCVSUM",length = 0)
    public BigDecimal getRCVSUM() {
        return RCVSUM;
    }
    public void setRCVSUM(BigDecimal val) {
        RCVSUM = val; 
    }
    @Id 
    @Column(name="CBAPORDID",length = 36)
    public String getCBAPORDID() {
        return CBAPORDID;
    }
    public void setCBAPORDID(String val) {
        CBAPORDID = val; 
    }
    @Column(name="D_CREATE")
    public LocalDateTime getD_CREATE() {
        return D_CREATE;
    }
    public void setD_CREATE(LocalDateTime val) {
        D_CREATE = val; 
    }
    @Column(name="DTRNTRAN")
    public LocalDateTime getDTRNTRAN() {
        return DTRNTRAN;
    }
    public void setDTRNTRAN(LocalDateTime val) {
        DTRNTRAN = val; 
    }
    @Column(name="DOCNUM",length = 0)
    public Long getDOCNUM() {
        return DOCNUM;
    }
    public void setDOCNUM(Long val) {
        DOCNUM = val; 
    }
    @Column(name="DOCDATE")
    public LocalDate getDOCDATE() {
        return DOCDATE;
    }
    public void setDOCDATE(LocalDate val) {
        DOCDATE = val; 
    }
    @Column(name="STATUS",length = 9)
    public String getSTATUS() {
        return STATUS;
    }
    public void setSTATUS(String val) {
        STATUS = val; 
    }
    @Column(name="CBAPERR",length = 9)
    public String getCBAPERR() {
        return CBAPERR;
    }
    public void setCBAPERR(String val) {
        CBAPERR = val;
    }
}