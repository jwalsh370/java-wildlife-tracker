import java.sql.Timestamp;
import java.util.Date;
import org.sql2o.*;



public abstract class AnimalView {

  public String name;
  public int id;
  public Timestamp viewDate;

  public String getName(){
    return name;
  }

  public Timestamp getViewDate() {
    return viewDate;
  }


  public int getId() {
      return id;
  }

}
