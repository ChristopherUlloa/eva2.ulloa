package eva2.ulloa.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class SessionUtil {


    public static HttpSession obtenerSesion(){
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }
}
