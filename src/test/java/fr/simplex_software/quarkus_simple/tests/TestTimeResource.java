package fr.simplex_software.quarkus_simple.tests;

import io.quarkus.test.junit.*;
import io.restassured.response.*;
import org.apache.http.*;
import org.junit.jupiter.api.*;

import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.*;

@QuarkusTest
public class TestTimeResource
{
  @Test
  public void testCurrentTime()
  {
    Response response = given().when().get("/time");
    assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
    assertThat(response.getBody()).isNotNull();
    assertThat(LocalDateTime.parse(response.prettyPrint(), DateTimeFormatter.ofPattern("d MMM uuuu, HH:mm:ss")))
      .isCloseTo(LocalDateTime.now(), byLessThan(1, ChronoUnit.HOURS));
  }
}
