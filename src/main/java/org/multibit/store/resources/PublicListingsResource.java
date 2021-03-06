package org.multibit.store.resources;

import com.yammer.dropwizard.jersey.caching.CacheControl;
import com.yammer.metrics.annotation.Timed;
import org.multibit.mbm.client.PublicMerchantClient;
import org.multibit.mbm.model.ClientItem;
import org.multibit.store.model.HomeModel;
import org.multibit.store.views.PublicFreemarkerView;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>Resource to provide the following to application:</p>
 * <ul>
 * <li>Provision of configuration for public listings page</li>
 * </ul>
 *
 * @since 0.0.1
 */
@Component
@Path("/listings")
@Produces(MediaType.TEXT_HTML)
public class PublicListingsResource extends BaseResource {

  /**
   * Provides the listings view associated with selected items from the
   * general catalog
   *
   * @return A localised view containing HTML
   */
  @GET
  @Timed
  @CacheControl(noCache = true)
  public PublicFreemarkerView viewListings() {

    // Prepare the list of promotional items
    List<ClientItem> items = PublicMerchantClient
      .newInstance(getLocale())
      .items()
      .retrievePromotionalItemsByPage(0, 10);

    // Add it to the model
    HomeModel model = new HomeModel(items);
    model.setCart(populateCartSummary());

    return new PublicFreemarkerView<HomeModel>("store/listings.ftl", model);
  }

}
