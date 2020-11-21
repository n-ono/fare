package railway.fare_calculation.infrastructure.catalogue.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CatalogueResponse {
  @Getter @Setter private int value;
}
