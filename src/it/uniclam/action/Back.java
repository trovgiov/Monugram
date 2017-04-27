package it.uniclam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
  *
  * @author Enifix
  */
public class Back implements ServletRequestAware {
    HttpServletRequest hsr;
    HttpSession hs;

public String execute()
{
    hs=hsr.getSession();
    hs.invalidate();
    return "success";
}

@Override
public void setServletRequest(HttpServletRequest hsr)
{
    this.hsr=hsr;
}
}