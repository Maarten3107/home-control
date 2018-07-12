package be.mmidia.light.repository;

import be.mmidia.light.model.Group;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    //List<Group> findAllByLightId(final String lightId);
}
