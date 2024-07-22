package fr.simplex_software.quarkus_simple;

import jakarta.enterprise.context.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.time.*;
import java.time.format.*;

@ApplicationScoped
@Path("time")
public class TimeResource
{
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String currentTime()
  {
    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("d MMM uuuu, HH:mm:ss"));
  }
}
