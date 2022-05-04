package api.atlantis.repository.interfaces.app.plantresult;

import api.atlantis.domain.app.plantresult.Booking;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"company", "plant"})
    List<Booking> getBookingsByPlantIdAndYearAndMonth(Long plantId, int year, int month);

    @Query("SELECT b FROM Booking b LEFT JOIN FETCH b.company LEFT JOIN FETCH b.plant " +
            "WHERE b.costCenter = :costCenter AND b.plant.id = :plantId AND b.year = :year AND b.month = :month " +
            "AND b.accountNumber = :accountNumber")
    List<Booking> getBookingsForCostCenter(@Param("costCenter") String costCenter, @Param("plantId") Long plantId,
                                           @Param("year") int year, @Param("month") int month,
                                           @Param("accountNumber") String accountNumber);

    @Query("SELECT b FROM Booking b LEFT JOIN FETCH b.company LEFT JOIN FETCH b.plant " +
            "WHERE b.plant.id = :plantId AND b.year = :year AND b.month = :month " +
            "AND b.accountNumber = :accountNumber")
    List<Booking> getBookingsForAccountNumber(@Param("accountNumber") String accountNumber, @Param("plantId") Long plantId,
                                              @Param("year") int year, @Param("month") int month);
}
