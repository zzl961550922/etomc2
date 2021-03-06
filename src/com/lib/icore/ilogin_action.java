package com.lib.icore;

import org.ppl.BaseClass.BaseiCore;
import org.ppl.etc.UrlClassList;

public class ilogin_action extends BaseiCore {
	private String className = null;

	public ilogin_action() {
		// TODO Auto-generated constructor stub
		className = this.getClass().getCanonicalName();
		super.GetSubClassName(className);
	}

	@Override
	public void Show() {
		// TODO Auto-generated method stub

		UrlClassList ucl = UrlClassList.getInstance();

		int act = super.Init();

		if (act == 0) {
			String JumpUrl = ucl.BuildUrl("icore", time() + "");

			String RefUrl = porg.getHttpHeader("referer");
			if (RefUrl != null && RefUrl.length() > 0) {
				JumpUrl = RefUrl;
			}

			TipMessage(JumpUrl, _CLang("ok_welcome"));

		} else if (act == -5) {
			String err_url = ucl.Url("login");

			TipMessage(err_url, _CLang("error_user_active"));
		} else {
			String err_url = ucl.Url("login");

			TipMessage(err_url, _CLang("error_passwd_or_name"));
		}
	}
}
