import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class RangerTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test public void ranger_instantiatiatesCorrectly_true() {
    Ranger testRanger = new Ranger("Rick", "rick@rick.com", 436);
    assertEquals(true, testRanger instanceof Ranger);
  }

  @Test public void getEmail_returnsEmailAttribute_true() {
    Ranger testRanger = new Ranger("Rick", "rick@rick.com", 436);
    assertEquals("rick@rick.com", testRanger.getEmail());
  }
}
