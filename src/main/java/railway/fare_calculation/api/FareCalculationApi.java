package railway.fare_calculation.api;

import io.vavr.API;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import railway.fare_calculation.api.response.FareCalculationResponse;
import railway.fare_calculation.domain.catalogue.CatalogueRepository;
import railway.fare_calculation.domain.common.DepartureMonthDay;
import railway.fare_calculation.domain.common.Destination;
import railway.fare_calculation.domain.common.Passenger;
import railway.fare_calculation.domain.common.TripType;
import railway.fare_calculation.domain.discount.DiscountRepository;
import railway.fare_calculation.domain.fare.Fare;
import railway.fare_calculation.service.FareCalculationService;

import java.time.MonthDay;

import static io.vavr.API.$;

@RestController
@AllArgsConstructor
public class FareCalculationApi {
  @Autowired private final FareCalculationService service;
  @Autowired private final CatalogueRepository catalogueRepository;
  @Autowired private final DiscountRepository discountRepository;

  @RequestMapping(value = "/calculate", method = RequestMethod.GET)
  public FareCalculationResponse calculate(
      @RequestParam(name = "destination") String destination,
      @RequestParam(name = "trip-type") String tripType,
      @RequestParam(name = "children") int children,
      @RequestParam(name = "adults") int adults,
      @RequestParam(name = "departure-month-day") String departureMonthDay) {
    Fare fare =
        service.calculate(
            getDestination(destination),
            getTripType(tripType),
            getPassenger(children, adults),
            getDepartureMonthDay(departureMonthDay));
    return new FareCalculationResponse(fare.getAmount().getValue());
  }

  private Destination getDestination(String destination) {
    return API.Match(destination)
        .of(
            API.Case($("shinosaka"), Destination.SHINOSAKA),
            API.Case($("himeji"), Destination.HIMEJI));
  }

  private TripType getTripType(String tripType) {
    return API.Match(tripType)
        .of(API.Case($("one-way"), TripType.ONE_WAY), API.Case($("round"), TripType.ROUND));
  }

  private Passenger getPassenger(int children, int adults) {
    return new Passenger(children, adults);
  }

  private DepartureMonthDay getDepartureMonthDay(String departureMonthDay) {
    final int month = Integer.parseInt(departureMonthDay.substring(0, 2));
    final int dayOfMonth = Integer.parseInt(departureMonthDay.substring(2, 4));
    return DepartureMonthDay.from(MonthDay.of(month, dayOfMonth));
  }
}
