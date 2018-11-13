package com.ztessc.gateway.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.zuul.context.RequestContext;
import com.ztessc.gateway.util.CombineException;

@RestController
public class ErrorHandlerController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String error(HttpServletRequest request) {
        RequestContext ctx = RequestContext.getCurrentContext();
        return CombineException.getErrorException(ctx.getThrowable()).toString();
    }



}
