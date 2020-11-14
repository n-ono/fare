package railway.fare_calculation.infrastructure.discount;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import railway.fare_calculation.domain.common.*;
import railway.fare_calculation.domain.discount.DiscountRepository;
import railway.fare_calculation.domain.fare.Fare;
import railway.fare_calculation.domain.fare.NotDiscountedFare;
import railway.fare_calculation.infrastructure.discount.response.DiscountResponse;

@Repository
@AllArgsConstructor
public class DiscountRepositoryImpl implements DiscountRepository {
  public static final String URL =
      "http://discount:8080/discount_calculation/discount-fare?fare={fare}&trip-type={tripType}&destination={destination}&children={children}&adults={adults}&departure-month-day={departureMonthDay}";

  @Autowired private final RestTemplate restTemplate;

  @Override
  public Fare calculate(
      NotDiscountedFare notDiscountedFare,
      TripType tripType,
      Destination destination,
      Passenger passenger,
      DepartureMonthDay departureMonthDay) {
    return Fare.from(
        Amount.from(
            restTemplate
                .getForObject(
                    URL,
                    DiscountResponse.class,
                    notDiscountedFare.getAmount().getValue(),
                    getTripTypeString(tripType),
                    getDestinationString(destination),
                    passenger.getChildren(),
                    passenger.getAdults(),
                    getDepartureMonthDay(departureMonthDay))
                .getDiscountAmountValue()));
  }

  private String getTripTypeString(TripType tripType) {
    return tripType.isOneWay() ? "one-way" : "round";
  }

  private String getDestinationString(Destination destination) {
    return destination.isShinOsaka() ? "shinosaka" : "himeji";
  }

  private String getDepartureMonthDay(DepartureMonthDay departureMonthDay) {
    return String.format(
        "%02d%02d", departureMonthDay.getMonthValue(), departureMonthDay.getDayOfMonth());
  }
}
