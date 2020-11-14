package railway.fare_calculation.domain.common;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AmountTest {
  @ParameterizedTest
  @CsvSource({"1000, 1000", "1001, 1000", "1011, 1010"})
  public void value(int srcAmountValue, int expectedAmountValue) {
    assertEquals(Amount.from(expectedAmountValue), Amount.from(srcAmountValue));
  }

  @ParameterizedTest
  @CsvSource({"1000, 50, 950", "9000, 1000, 8000"})
  public void minus(int srcAmountValue1, int srcAmountValue2, int expectedAmountValue) {
    assertEquals(
        Amount.from(expectedAmountValue),
        Amount.from(srcAmountValue1).minus(Amount.from(srcAmountValue2)));
  }
}
