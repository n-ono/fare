package railway.fare_calculation.domain.fare;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import railway.fare_calculation.domain.common.Amount;

/**
 * 割引適用前の運賃
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class NotDiscountedFare {
  @Getter private final Amount amount;

  public static NotDiscountedFare from(Amount amount) {
    return new NotDiscountedFare(amount);
  }
}
