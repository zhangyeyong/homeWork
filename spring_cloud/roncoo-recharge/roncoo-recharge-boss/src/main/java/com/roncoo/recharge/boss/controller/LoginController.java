/**
 * Copyright 2015-现在 广州市领课网络科技有限公司
 */
package com.roncoo.recharge.boss.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roncoo.recharge.util.Constants;
import com.roncoo.recharge.util.base.BaseController;
import com.roncoo.recharge.util.bjui.Bjui;
import com.xiaoleilu.hutool.json.JSONUtil;
import com.xiaoleilu.hutool.util.ObjectUtil;

@Controller
public class LoginController extends BaseController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return redirect("/index");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if (ObjectUtil.isNotNull(SecurityUtils.getSubject().getSession().getAttribute(Constants.Session.USER))) {
			return redirect("/index");
		}
		// 判断是否ajax请求
		if (req.getHeader("x-requested-with") != null && req.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
			WebUtils.getAndClearSavedRequest(req); // 清除记录的url，这里不需要
			PrintWriter out = resp.getWriter();
			Bjui bj = new Bjui();
			bj.setStatusCode(301);
			bj.setMessage("timeout");
			out.print(JSONUtil.toJsonStr(bj));
			out.flush();
			return null;
		}
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(UsernamePasswordToken usernamePasswordToken, ModelMap modelMap) {
		try {
			SecurityUtils.getSubject().login(usernamePasswordToken);
			return redirect("/index");
		} catch (Exception e) {
			logger.error("登录异常", e.getMessage());
			modelMap.put("msg", e.getMessage());
			return "login";
		}
	}

	@RequestMapping(value = "/timeout", method = { RequestMethod.GET, RequestMethod.POST })
	public void timeout() {

	}
}
