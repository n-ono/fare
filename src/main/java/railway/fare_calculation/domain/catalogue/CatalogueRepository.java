package railway.fare_calculation.domain.catalogue;

import railway.fare_calculation.domain.common.Amount;
import railway.fare_calculation.domain.common.Destination;

public interface CatalogueRepository {
  Amount findBy(Destination destination);
}
