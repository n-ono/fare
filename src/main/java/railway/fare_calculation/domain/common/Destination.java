package railway.fare_calculation.domain.common;

/**
 * 目的地
 * 新大阪 or 姫路
 */
public enum Destination {
  SHINOSAKA,
  HIMEJI;

  public boolean isShinOsaka() {
    return this == SHINOSAKA;
  }
}
