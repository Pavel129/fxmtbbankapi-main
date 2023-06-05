package com.maritimebank.FXMTBBankAPI;

import javafx.fxml.FXML;
import ru.inversion.bicomp.pref.PreferencesWorker;
import ru.inversion.dataset.XXIDataSet;
import ru.inversion.dataset.fx.DSFXAdapter;
import ru.inversion.fx.app.AppException;

import ru.inversion.fx.form.*;
import ru.inversion.fx.form.controls.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author  Grigorev
 * @since   Tue Sep 06 17:02:03 MSK 2022
 */
public class ViewMtbBankApiPaymentTotalController extends JInvFXBrowserController 
{
    @FXML private JInvTable<PMtbBankApiPaymentTotal> MTB_BANK_API_PAYMENT_TOTAL;
    @FXML private JInvTable<PMtbBankApiPaymentDetail> MTB_BANK_API_PAYMENT_DETAIL;
    
    @FXML private JInvToolBar toolBar;
    
    @FXML private JInvCalendar PERIOD_START,PERIOD_END;
    
    private POptions pv = new POptions ();
    
    private final XXIDataSet<PMtbBankApiPaymentTotal>   dsMTB_BANK_API_PAYMENT_TOTAL    = new XXIDataSet<> ();
    private final XXIDataSet<PMtbBankApiPaymentDetail>  dsMTB_BANK_API_PAYMENT_DETAIL   = new XXIDataSet<> ();

    private void initDataSet () throws Exception
    {
        dsMTB_BANK_API_PAYMENT_TOTAL.setTaskContext (getTaskContext ());
        dsMTB_BANK_API_PAYMENT_TOTAL.setRowClass (PMtbBankApiPaymentTotal.class);
    
        dsMTB_BANK_API_PAYMENT_DETAIL.setTaskContext (getTaskContext ());
        dsMTB_BANK_API_PAYMENT_DETAIL.setRowClass (PMtbBankApiPaymentDetail.class);
        
        PERIOD_START.setValue(LocalDate.of(
                Integer.parseInt(pv.getPERIOD_START().substring(0,4))
                ,Integer.parseInt(pv.getPERIOD_START().substring(4,6))
                ,Integer.parseInt(pv.getPERIOD_START().substring(6,8))));
        PERIOD_END.setValue(LocalDate.of(
                Integer.parseInt(pv.getPERIOD_END().substring(0,4))
                ,Integer.parseInt(pv.getPERIOD_END().substring(4,6))
                ,Integer.parseInt(pv.getPERIOD_END().substring(6,8))));
    
    }
    @Override
    protected void afterInit() throws AppException {
        PERIOD_START.valueProperty().addListener( (v,o,n) -> PostChngDateStart() );
        PERIOD_END.valueProperty().addListener( (v,o,n) -> PostChngDateEnd() );
    }
    
    private void PostChngDateStart () {
        if (PERIOD_START.getValue()!=null){
            pv.setPERIOD_START((PERIOD_START.getValue().format(DateTimeFormatter.ofPattern("yyyyMMdd"))));
            try{
                PreferencesWorker.save(taskContext,pv);
            }catch (Exception e){
                handleException(e);
            }
        }
        //doRefresh(MTB_BANK_API_PAYMENT_TOTAL);
        //doRefresh(MTB_BANK_API_PAYMENT_DETAIL);
    }
    private void PostChngDateEnd ()
    {
        if (PERIOD_END.getValue()!=null){
            pv.setPERIOD_END((PERIOD_END.getValue().format(DateTimeFormatter.ofPattern("yyyyMMdd"))));
            try{
                PreferencesWorker.save(taskContext,pv);
            }catch (Exception e){
                handleException(e);
            }
        }
        //doRefresh(MTB_BANK_API_PAYMENT_TOTAL);
        //doRefresh(MTB_BANK_API_PAYMENT_DETAIL);
    }
//
// Initializes the controller class.
//
    @Override
    protected void init() throws Exception
    {
        setTitle (getBundleString ("VIEW.TITLE"));
        PreferencesWorker.load (getTaskContext (), pv);
        
        initDataSet ();

        DSFXAdapter<PMtbBankApiPaymentTotal> dsfxPayTotal = DSFXAdapter.bind (dsMTB_BANK_API_PAYMENT_TOTAL, MTB_BANK_API_PAYMENT_TOTAL, null, false);
        dsfxPayTotal.setEnableFilter (true);
    
        DSFXAdapter<PMtbBankApiPaymentDetail> dsfxPayDetail = DSFXAdapter.bind (dsMTB_BANK_API_PAYMENT_DETAIL, MTB_BANK_API_PAYMENT_DETAIL, null, false);
        dsfxPayDetail.setEnableFilter (true);
    
        initToolBar ();

        MTB_BANK_API_PAYMENT_TOTAL.setToolBar (toolBar);       
        MTB_BANK_API_PAYMENT_TOTAL.setAction (ActionFactory.ActionTypeEnum.REFRESH, (a) -> doRefresh (MTB_BANK_API_PAYMENT_TOTAL));
    
        MTB_BANK_API_PAYMENT_DETAIL.setToolBar (toolBar);
        MTB_BANK_API_PAYMENT_DETAIL.setAction (ActionFactory.ActionTypeEnum.REFRESH, (a) -> doRefresh (MTB_BANK_API_PAYMENT_DETAIL));
        
        doRefresh (MTB_BANK_API_PAYMENT_TOTAL);
        doRefresh (MTB_BANK_API_PAYMENT_DETAIL);
    }        
//
//
//    
    private void doRefresh (JInvTable t)
    {
        t.executeQuery ();
    }
//
//
//    
    private void initToolBar () 
    {
        
        toolBar.setStandartActions (ActionFactory.ActionTypeEnum.REFRESH);
        
    }
//
//    
//
}

