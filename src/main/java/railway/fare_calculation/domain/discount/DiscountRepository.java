package railway.fare_calculation.domain.discount;

import railway.fare_calculation.domain.common.DepartureMonthDay;
import railway.fare_calculation.domain.common.Destination;
import railway.fare_calculation.domain.common.Passenger;
import railway.fare_calculation.domain.common.TripType;
import railway.fare_calculation.domain.fare.Fare;
import railway.fare_calculation.domain.fare.NotDiscountedFare;

public interface DiscountRepository {
  Fare calculate(
      NotDiscountedFare notDiscountedFare,
      TripType tripType,
      Destination destination,
      Passenger passenger,
      DepartureMonthDay departureMonthDay);
}
