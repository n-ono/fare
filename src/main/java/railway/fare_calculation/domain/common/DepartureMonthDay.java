package railway.fare_calculation.domain.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.MonthDay;

/**
 * 出発月日
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DepartureMonthDay {
  private final MonthDay value;

  public static DepartureMonthDay from(MonthDay monthDay) {
    return new DepartureMonthDay(monthDay);
  }

  public int getMonthValue() {
    return value.getMonthValue();
  }

  public int getDayOfMonth() {
    return value.getDayOfMonth();
  }
}
