package railway.fare_calculation.domain.fare;

import lombok.*;
import railway.fare_calculation.domain.common.Amount;

/**
 * 運賃
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Fare {
  @Getter private final Amount amount;

  public static Fare from(Amount amount) {
    return new Fare(amount);
  }
}
