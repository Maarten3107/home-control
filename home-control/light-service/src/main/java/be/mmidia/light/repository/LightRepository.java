package be.mmidia.light.repository;

import be.mmidia.light.model.Light;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightRepository extends JpaRepository<Light, String> {
    List<Light> findByState(Light.State state);
}
