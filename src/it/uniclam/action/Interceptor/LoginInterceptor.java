package it.uniclam.action.Interceptor;

/**
 * Created by GiovanniTrovini on 05/06/17.
 */

         import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.Map;

/**
 * Gestione degli interceptor necessari per il login
 */
public class LoginInterceptor implements Interceptor {
    private static final long serialVersionUID = 1L;
    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void init() {
        // TODO Auto-generated method stub

    }

    /**
     * Intercetta il loginId della session creata. Se loginid è null, rimanda alla pagina di login
     * @param invocation
     * @return
     * @throws Exception
     */
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Map<String, Object> sessionAttributes = invocation
                .getInvocationContext().getSession();

        if (sessionAttributes == null
                || sessionAttributes.get("loginId") == null) {
            return "login";
        } else {
            if (!((String) sessionAttributes.get("loginId")).equals(null)) {
                return invocation.invoke();
            } else {
                return "login";
            }
        }

    }

}
