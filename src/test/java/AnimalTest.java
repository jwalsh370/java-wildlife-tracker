import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class AnimalTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void animal_instantiatesCorrectly_false() {
    Animal testAnimal = new Animal("Deer", 1);
    assertEquals(true, testAnimal instanceof Animal);
  }

  @Test
  public void getName_animalInstantiatesWithName_Deer() {
    Animal testAnimal = new Animal("Deer", 1);
    assertEquals("Deer", testAnimal.getName());
  }

  @Test
  public void equals_returnsTrueIfNameIsTheSame_false() {
    Animal firstAnimal = new Animal("Deer", 1);
    Animal anotherAnimal = new Animal("Deer", 1);
    assertTrue(firstAnimal.equals(anotherAnimal));
  }

  @Test
  public void save_assignsIdToObjectAndSavesObjectToDatabase() {
    Animal testAnimal = new Animal("Deer", 1);
    testAnimal.save();
    Animal savedAnimal = Animal.all().get(0);
    assertEquals(testAnimal.getId(), savedAnimal.getId());
  }

  @Test
  public void all_returnsAllInstancesOfAnimal_false() {
    Animal firstAnimal = new Animal("Deer",1);
    firstAnimal.save();
    Animal secondAnimal = new Animal("Black Bear", 2);
    secondAnimal.save();
    assertEquals(true, Animal.all().get(0).equals(firstAnimal));
    assertEquals(true, Animal.all().get(1).equals(secondAnimal));
  }

  @Test
  public void find_returnsAnimalWithSameId_secondAnimal() {
    Animal firstAnimal = new Animal("Deer", 1);
    firstAnimal.save();
    Animal secondAnimal = new Animal("Black Bear", 2);
    secondAnimal.save();
    assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
  }

  @Test
  public void delete_deletesAnimalFromDatabase_0() {
    Animal testAnimal = new Animal("Deer", 1);
    testAnimal.save();
    testAnimal.delete();
    assertEquals(0, Animal.all().size());
  }

  public void updateName_updatesAnimalNameInDatabase_String() {
    Animal testAnimal = new Animal("Deer", 1);
    testAnimal.save();
    testAnimal.updateName("Buck");
    assertEquals("Buck", testAnimal.getName());
  }

  @Test
  public void find_returnsNullWhenNoAnimalFound_null() {
    assertTrue(Animal.find(999) == null);
  }

  @Test
  public void save_recordsViewDateinDatabase() {
    Animal testAnimal = new Animal("Deer", 1);
    testAnimal.save();
    Timestamp savedTestAnimalViewDate = Animal.find(testAnimal.getId()).getViewDate();
    Timestamp rightNow = new Timestamp(new Date().getTime());
    assertEquals(rightNow.getDay(), savedTestAnimalViewDate.getDay());
  }

  @Test
    public void animal_instantiatesWithRange(){
    Animal testAnimal = new Animal("Deer", 1);
      assertEquals(testAnimal.getRange(), (Animal.MAX_RANGE_LEVEL));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void range_throwsExceptionIfRangeIsatMaxValue() {
      Animal testAnimal = new Animal("Dog", 1);
        for(int i = Animal.MIN_ALL_LEVELS; i <= (Animal.MAX_RANGE_LEVEL); i++){
          testAnimal.range();
        }
    }


}
