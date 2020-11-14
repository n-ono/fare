package railway.fare_calculation.domain.fare;

import org.junit.jupiter.api.Test;
import railway.fare_calculation.domain.common.Amount;

import static org.junit.jupiter.api.Assertions.*;

class NotDiscountedFareCalculationDomainServiceTest {
  @Test
  public void calculate() {
    assertEquals(
        NotDiscountedFare.from(Amount.from(10010)),
        NotDiscountedFareCalculationDomainService.calculate(Amount.from(10010)));
  }
}
