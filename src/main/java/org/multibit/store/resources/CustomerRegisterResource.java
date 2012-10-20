package org.multibit.store.resources;

import com.yammer.dropwizard.jersey.caching.CacheControl;
import com.yammer.metrics.annotation.Timed;
import org.multibit.store.views.PublicFreemarkerView;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.TimeUnit;

/**
 * <p>Resource to provide the following to application:</p>
 * <ul>
 * <li>Provision of configuration for customer registration page</li>
 * </ul>
 *
 * @since 0.0.1
 */
@Component
@Path("/register")
@Produces(MediaType.TEXT_HTML)
public class CustomerRegisterResource extends BaseResource {

  /**
   * Provide the initial view on to the system
   *
   * @return A localised view containing HTML
   */
  @GET
  @Timed
  @CacheControl(maxAge = 5, maxAgeUnit = TimeUnit.MINUTES)
  public PublicFreemarkerView showRegistration() {
    // TODO Add i18n
    // TODO Add security
    return new PublicFreemarkerView("account/register.ftl");
  }

  /**
   * Provide the initial view on to the system
   *
   * @return A localised view containing HTML
   */
  @POST
  @Timed
  @CacheControl(maxAge = 5, maxAgeUnit = TimeUnit.MINUTES)
  public PublicFreemarkerView handleRegistration(
    @FormParam("username") String rawUsername,
    @FormParam("password1") String rawPassword1,
    @FormParam("password2") String rawPassword2
    ) {
    // TODO Add i18n
    // TODO Add security
    return new PublicFreemarkerView("account/profile.ftl");
  }

}
