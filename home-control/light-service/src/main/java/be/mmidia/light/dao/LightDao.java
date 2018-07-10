package be.mmidia.light.dao;

import be.mmidia.light.model.Light;
import java.util.List;
import java.util.Set;

public interface LightDao <Light>/* extends JpaRepository<Light, String>*/ {
    List<Light> findAll();

    Light getOne(String id);

    Set<Light> findByState(be.mmidia.light.model.Light.State state);

    void updateLight(Light light);

    void removeLightById(String id);

    //List<Light> findAll();

    //Light getOne(final String lightId);

    /*@Query("select l from light l where l.state = :state")
    Set<Light> findByState(@Param("state") final Light.State state);*/

    //void updateLight(Light light);

    //void removeLightById(String lightId);

    //String addLight(Light light);
}
