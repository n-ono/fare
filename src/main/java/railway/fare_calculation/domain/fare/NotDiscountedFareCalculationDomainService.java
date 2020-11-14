package railway.fare_calculation.domain.fare;

import railway.fare_calculation.domain.common.Amount;

/**
 * 割引適用前の運賃を計算するドメインサービス
 */
public class NotDiscountedFareCalculationDomainService {
  public static NotDiscountedFare calculate(Amount amount) {
    return NotDiscountedFare.from(amount);
  }
}
