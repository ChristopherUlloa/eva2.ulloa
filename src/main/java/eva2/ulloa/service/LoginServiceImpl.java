package eva2.ulloa.service;

import java.util.Objects;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


import eva2.ulloa.model.Persona;
import eva2.ulloa.model.Usuario;
import lombok.extern.slf4j.Slf4j;


@Stateless
public class LoginServiceImpl implements LoginService {

	
	public boolean loginX(String user, String password) {
		return true;
	}
	
	@Override
    public Persona login(String usuario, String password) {

        Persona persona = null;
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("evaluacion");
            EntityManager em = factory.createEntityManager();
            String hql = "from Usuario u where u.username = :username and u.password = :password";
            Usuario user = (Usuario) em.createQuery(hql)
                    .setParameter("username", usuario)
                    .setParameter("password", password)
                    .getSingleResult();

            if(Objects.nonNull(user)){
                persona = user.getPersona();
            }
        }catch (NoResultException e) {
        	System.out.println("NoResultException " + e.getMessage());
        } catch (Exception e) {
        	throw e;
        }

        return persona;
    }
	
	
}
