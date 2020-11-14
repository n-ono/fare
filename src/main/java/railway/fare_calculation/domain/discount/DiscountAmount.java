package railway.fare_calculation.domain.discount;

import lombok.*;
import railway.fare_calculation.domain.common.Amount;

/**
 * 割引料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DiscountAmount {
  @Getter private final Amount amount;

  public static DiscountAmount from(Amount amount) {
    return new DiscountAmount(amount);
  }
}
