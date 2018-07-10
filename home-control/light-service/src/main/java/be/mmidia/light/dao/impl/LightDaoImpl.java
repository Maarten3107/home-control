package be.mmidia.light.dao.impl;

import be.mmidia.light.dao.LightDao;
import be.mmidia.light.model.Light;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class LightDaoImpl /*extends AbstractDao*/ implements LightDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Light> findAll() {
        sessionFactory.getCurrentSession(). createJpaCriteria
        return sessionFactory.getCurrentSession().createCriteria(Light.class).list();
    }

    @Override
    public Light getOne(String id) {
        return null;
    }

    @Override
    public void updateLight(Object o) {

    }

    @Override
    public Set<Light> findByState(Light.State state) {
        return null;
    }

    /*@Override
    public void updateLight(Light light) {

    }*/

    @Override
    public void removeLightById(String id) {

    }
/*    @Override
    public Set<Light> fetchAllLights() {
        return null;
    }

    @Override
    public Light fetchLightById(String lightId) {
        return null;
    }

    @Override
    public Set<Light> fetchLightsByState(Light.State state) {
        // Where state == state
        return null;
    }

    @Override
    public void updateLight(Light light) {

    }

    @Override
    public void batchUpdateLight(Map<String, Light> lightList) {

    }

    @Override
    public void removeLight(String lightId) {

    }

    @Override
    public String addLight(Light light) {
        return null;
    }*/
}
