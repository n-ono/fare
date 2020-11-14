package railway.fare_calculation.infrastructure.catalogue;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import railway.fare_calculation.domain.catalogue.CatalogueRepository;
import railway.fare_calculation.domain.common.Amount;
import railway.fare_calculation.domain.common.Destination;
import railway.fare_calculation.infrastructure.catalogue.response.CatalogueResponse;

import java.util.Objects;

@Repository
@AllArgsConstructor
public class CatalogueRepositoryImpl implements CatalogueRepository {
  public static final String URL = "http://catalogue:8080/catalogue/basic-fare?destination={destination}";

  @Autowired private final RestTemplate restTemplate;

  @Override
  public Amount findBy(Destination destination) {
    return Amount.from(
        Objects.requireNonNull(
                restTemplate.getForObject(
                    URL, CatalogueResponse.class, getDestinationString(destination)))
            .getAmountValue());
  }

  private String getDestinationString(Destination destination) {
    return destination.isShinOsaka() ? "shinosaka" : "himeji";
  }
}
