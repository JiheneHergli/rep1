package com.sfm.erp.entry;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;

@ManagedBean(name = "loginController")
@RequestScoped
public class entryController implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Log logger = LogFactory.getLog(getClass());

	public String getlogin() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		return auth.getName();

	}

	public String doLogin() throws ServletException, IOException,
			InterruptedException {
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
				.getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward((ServletRequest) context.getRequest(),
				(ServletResponse) context.getResponse());
		FacesContext.getCurrentInstance().renderResponse();
		return null;
	}

	public void doSomething() throws InterruptedException {
		Thread.sleep(2400);
	}

	@Override
	public void afterPhase(PhaseEvent event) {

	}

	@Override
	public void beforePhase(PhaseEvent event) {
		Exception e = (Exception) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap()
				.get(WebAttributes.AUTHENTICATION_EXCEPTION);
		if (e instanceof BadCredentialsException) {
			logger.debug("Found exception in session map " + e);
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap()
					.put(WebAttributes.AUTHENTICATION_EXCEPTION, null);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"username or password not valid ! ",
							"username or password not valid !"));
		}

	}

	@Override
	public PhaseId getPhaseId() {

		return PhaseId.RENDER_RESPONSE;
	}

}
