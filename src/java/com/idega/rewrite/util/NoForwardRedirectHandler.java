package com.idega.rewrite.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.idega.servlet.filter.util.PagesRedirectHandler;

public class NoForwardRedirectHandler implements PagesRedirectHandler{

	public boolean isForwardOnRootURIRequest(HttpServletRequest request, HttpServletResponse response) {
		return false;
	}

}
