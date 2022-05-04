package api.atlantis.repository.interfaces.app.masterdata.production;

import api.atlantis.domain.app.masterdata.production.SalesProduct;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesProductRepository extends JpaRepository<SalesProduct, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"capGroup", "capGroup.capUnit", "unit",
            "company", "plant"})
    List<SalesProduct> findAll();
}
