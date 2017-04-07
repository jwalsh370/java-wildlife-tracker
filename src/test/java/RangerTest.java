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

  @Test public void getBadgeNumber_returnsBadgeAttribute_true() {
    Ranger testRanger = new Ranger("Rick", "rick@rick.com", 436);
    assertEquals(436, testRanger.getBadgeNumber());
  }

  @Test
  public void save_assignsIdAndSavesObjectToDatabase() {
    Ranger testRanger = new Ranger("Rick", "rick@rick.com", 436);
    testRanger.save();
    Ranger savedRanger = Ranger.all().get(0);
    assertEquals(testRanger.getId(), savedRanger.getId());
  }

  @Test
  public void all_returnsAllInstancesOfRanger_true() {
    Ranger firstRanger = new Ranger("Rick", "rick@rick.com", 436);
    firstRanger.save();
    Ranger secondRanger = new Ranger("Rick", "rick@rick.com", 436);
    secondRanger.save();
    assertEquals(true, Ranger.all().get(0).equals(firstRanger));
    assertEquals(true, Ranger.all().get(1).equals(secondRanger));
  }

  @Test
  public void find_returnsRangerWithSameId_secondRanger() {
    Ranger firstRanger = new Ranger("Rick", "rick@rick.com", 436);
    firstRanger.save();
    Ranger secondRanger = new Ranger("Jenny", "JenE@Me.com", 1414);
    secondRanger.save();
    assertEquals(Ranger.find(secondRanger.getId()), secondRanger);
  }

  @Test
  public void update_updatesEmailAttribute_true() {
    Ranger testRanger = new Ranger("Rick", "rick@rick.com", 436);
    testRanger.save();
    testRanger.updateEmail("Rickyrickrick@Rick.com");
    assertEquals("Rickyrickrick@Rick.com", Ranger.find(testRanger.getId()).getEmail());
  }

  @Test
  public void update_updatesBadgeNumberAttribute_true() {
    Ranger testRanger = new Ranger("Rick", "rick@rick.com", 436);
    testRanger.save();
    testRanger.updateBadgeNumber(445);
    assertEquals(445, Ranger.find(testRanger.getId()).getBadgeNumber());
  }



}
