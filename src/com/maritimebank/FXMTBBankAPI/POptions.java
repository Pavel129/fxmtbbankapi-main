package com.maritimebank.FXMTBBankAPI;

import ru.inversion.bicomp.pref.Preference;
import ru.inversion.bicomp.pref.PreferenceType;
import ru.inversion.bicomp.pref.PriviledgeBundle;

import javax.persistence.Column;

public class POptions extends PriviledgeBundle {
	
	private String PERIOD_START, PERIOD_END;
	
	public POptions(){}
	
	@Override
	public int[] getActionList() {
		return new int[0];
	}
	
	@Override
	public String[] getRoleList() {
		return new String[0];
	}
	
	@Preference (type = PreferenceType.STANDARD, dbName = "MTB.BANK_API_PAYMENT_TOTAL.DBEG", defaultValue = "20220831")
	@Column(name="PERIOD_START",length = 8)
	public String getPERIOD_START() { return PERIOD_START;}
	public void setPERIOD_START(String val) {PERIOD_START = val;}
	
	@Preference (type = PreferenceType.STANDARD, dbName = "MTB.BANK_API_PAYMENT_TOTAL.DEND", defaultValue = "20220905")
	@Column(name="PERIOD_END",length = 8)
	public String getPERIOD_END() { return PERIOD_END;}
	public void setPERIOD_END(String val) {PERIOD_END = val;}
}