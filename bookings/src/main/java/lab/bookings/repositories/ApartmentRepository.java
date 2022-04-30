package lab.bookings.repositories;

import lab.bookings.models.Apartment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ApartmentRepository
        extends CrudRepository<Apartment, Long> {
    @Query("select a from Apartment a " +
            "where a.capacity >= :numGuests and " +
            "not exists (select b from a.bookings b " +
            " where :startDay < b.toDate and :endDay > b.fromDate) " +
            "order by a.capacity")
    List<Apartment> getFreeApartments(@Param("numGuests") Integer numGuests,
                                      @Param("startDay") LocalDate startDay,
                                      @Param("endDay") LocalDate endDay);
}