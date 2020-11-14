package railway.fare_calculation.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import railway.fare_calculation.domain.catalogue.CatalogueRepository;
import railway.fare_calculation.domain.common.*;
import railway.fare_calculation.domain.discount.DiscountRepository;
import railway.fare_calculation.domain.fare.Fare;
import railway.fare_calculation.domain.fare.NotDiscountedFare;
import railway.fare_calculation.domain.fare.NotDiscountedFareCalculationDomainService;

@Service
@AllArgsConstructor
public class FareCalculationService {
  @Autowired private final CatalogueRepository catalogueRepository;
  @Autowired private final DiscountRepository discountRepository;

  public Fare calculate(
      Destination destination,
      TripType tripType,
      Passenger passenger,
      DepartureMonthDay departureMonthDay) {
    Amount amount = catalogueRepository.findBy(destination);
    NotDiscountedFare notDiscountedFare =
        NotDiscountedFareCalculationDomainService.calculate(amount);
    return discountRepository.calculate(
        notDiscountedFare, tripType, destination, passenger, departureMonthDay);
  }
}
