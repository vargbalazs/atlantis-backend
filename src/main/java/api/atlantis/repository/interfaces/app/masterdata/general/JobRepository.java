package api.atlantis.repository.interfaces.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Job;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"department", "department.plant",
            "department.plant.company"})
    List<Job> findAll();
}
