package com.lib.icore;

import org.ppl.BaseClass.BaseiCore;
import org.ppl.etc.UrlClassList;

public class iBalance extends BaseiCore {
	private String className = null;

	public iBalance() {
		// TODO Auto-generated constructor stub
		className = this.getClass().getCanonicalName();
		super.GetSubClassName(className);
	}

	@Override
	public void Show() {
		// TODO Auto-generated method stub
		UrlClassList ucl = UrlClassList.getInstance();
		if (super.Init() == -1) {

			String err_url = ucl.BuildUrl("login", "");

			TipMessage(err_url, _CLang("error_passwd_or_name"));
		} else {
			
			setRoot("icore", ucl.BuildUrl("icore", time() + ""));
			setRoot("balance", ucl.Url("balance"));
			setRoot("face", ucl.Url("face"));
			
			setRoot("istrategy_url", ucl.Url("strategy"));
			setRoot("itrade_url", ucl.Url("trade"));
			setRoot("irisk_url", ucl.Url("risk"));
			setRoot("iarbitrage_url", ucl.Url("arbitrage"));
			
			
			super.View();
		}
	}
}
