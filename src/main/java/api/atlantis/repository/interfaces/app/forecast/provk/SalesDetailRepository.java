package api.atlantis.repository.interfaces.app.forecast.provk;

import api.atlantis.domain.app.forecast.provk.SalesDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesDetailRepository extends JpaRepository<SalesDetail, Long> {
    //  in this case we use the query annotation to avoid ugly long method names and not to have custom repository implementations
    @Query("SELECT sd FROM SalesDetail sd " +
            "LEFT JOIN FETCH sd.capGroup LEFT JOIN FETCH sd.salesProduct sp LEFT JOIN FETCH sd.provk " +
            "LEFT JOIN FETCH sp.unit " +
            "WHERE sd.provk.id = :provkId AND sd.year = :year AND sd.month = :month AND sd.version = :version")
    List<SalesDetail> getSalesDetails(@Param("provkId") Long provkId, @Param("year") int year, @Param("month") int month,
                                      @Param("version") int version);

}
