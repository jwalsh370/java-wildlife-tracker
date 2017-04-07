import java.sql.Timestamp;
import java.util.Date;
import org.sql2o.*;



public abstract class AnimalView {

  public String name;
  public int id;
  public Timestamp viewDate;
  public int range;


public static final int MAX_RANGE_LEVEL = 30;
public static final int MIN_ALL_LEVELS = 0;


  public String getName(){
    return name;
  }

  public Timestamp getViewDate() {
    return viewDate;
  }


  public int getId() {
      return id;
  }

  public int getRange() {
    return range;
  }

  public void range(){
    if (range >= MAX_RANGE_LEVEL){
      throw new UnsupportedOperationException("Your animal is out of range, either retrieve it or leave it!");
    }
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE animalViews SET range = now() WHERE id = :id";
      con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();
    }
    range++;
  }

}
