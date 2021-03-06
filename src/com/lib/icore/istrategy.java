package com.lib.icore;

import java.util.Map;

import org.ppl.BaseClass.BaseSurface;
import org.ppl.etc.UrlClassList;

public class istrategy extends BaseSurface {
	private String className = null;

	public istrategy() {
		// TODO Auto-generated constructor stub
		className = this.getClass().getCanonicalName();
		super.GetSubClassName(className);
	}

	@Override
	public void Show() {
		// TODO Auto-generated method stub

		int islogin = isLogin();
		UrlClassList ucl = UrlClassList.getInstance();

		// echo("islogin:"+islogin);
		setRoot("islogin", islogin);

		setRoot("strategy_name", "default strategy");

		setRoot("Step_Type", mConfig.GetInt("Step.strategy"));

		setRoot("istrategy_url", ucl.Url("strategy"));
		setRoot("itrade_url", ucl.Url("trade"));
		setRoot("irisk_url", ucl.Url("risk"));
		setRoot("iarbitrage_url", ucl.Url("arbitrage"));
		setRoot("register", ucl.Url("register"));
		
		int is = isLogin();
		if (is < 1) {
			setRoot("IndexTopBar", "1");
			String salt = getSalt();

			setRoot("Salt", salt);
			setRoot("ilogin_action_uri", ucl.Url("loginAction"));
		}

		tips();
		super.View();
	}
	
	private void tips() {
		String sql = "SELECT tips FROM `tips_info` ORDER BY rand() LIMIT 1 ";
		Map<String, Object> res = FetchOne(sql);
		if (res != null) {
			setRoot("tips", res.get("tips"));
		}
	}

}