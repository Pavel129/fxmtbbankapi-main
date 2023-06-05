package com.maritimebank.FXMTBBankAPI;

import java.util.Collections;
import java.util.Map;
import ru.inversion.fx.form.ViewContext;
import ru.inversion.fx.app.BaseApp;
import ru.inversion.fx.form.FXFormLauncher;
import ru.inversion.tc.TaskContext;

/**
 *
 * @author  Grigorev
 * @since   Tue Sep 06 18:57:14 MSK 2022
 */
public class BankApiMain extends BaseApp
{
    
    @Override
    protected void showMainWindow () 
    {
        showViewMtbBankApiPaymentTotal (getPrimaryViewContext (), new TaskContext (), Collections.emptyMap ());
    }

    @Override
    public String getAppID () 
    {
        return "XXI.PMTBBANKAPIPAYMENTTOTAL"; 
    }
    
    public static void main (String[] args) 
    {
        launch (args);
    }

    public static void showViewMtbBankApiPaymentTotal (ViewContext vc, TaskContext tc, Map<String, Object> p) 
    {
        new FXFormLauncher<> (tc, vc, ViewMtbBankApiPaymentTotalController.class)
            .initProperties (p)
            .show ();
    }
    
}

