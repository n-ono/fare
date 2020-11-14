package railway.fare_calculation.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class FareCalculationResponse {
  @Getter private final int fare;
}
