package org.web.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	private static final String LOGIN="login";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	/**
	 * This implementation always returns {@code true}.
	 * 기존 HttpSession에 남아잇는 정보가 있는 경우 정보를 삭제
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		if(session.getAttribute(LOGIN)!=null) {
			logger.info("clear login data before");
			session.removeAttribute(LOGIN);
		}
		return true;
	}

	/**
	 * This implementation is empty.
	 * UserController에서 userVO라는 이름으로 객체를 담아둔 상태.
	 * 이 상태를 체크해서 HttpSession에 저장
	 */
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
	
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object userVO = modelMap.get("userVO");
		
		if(userVO != null) {
			logger.info("new login success");
			session.setAttribute(LOGIN, userVO);
			response.sendRedirect("/");
		}
	}

}
/*ModelAndView 뷰와 모델을 기술할 필요가 있을 때*/