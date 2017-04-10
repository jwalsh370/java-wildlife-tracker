import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Ranger extends AnimalView implements DatabaseManagement {
  private String email;
  private int badgeNumber;

  public Ranger(String name, String email, int badgeNumber){
    this.name = name;
    this.email = email;
    this.badgeNumber = badgeNumber;
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public int getBadgeNumber() {
    return badgeNumber;
  }

  @Override
  public boolean equals(Object otherRanger) {
    if(!(otherRanger instanceof Ranger)) {
      return false;
    } else {
      Ranger newRanger = (Ranger) otherRanger;
      return this.getName().equals(newRanger.getName());
    }
  }


  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO rangers (name, email, badgeNumber, viewDate) VALUES (:name, :email, :badgeNumber, now());";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("email", this.email)
        .addParameter("badgeNumber", this.badgeNumber)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<Ranger> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM rangers;";
      return con.createQuery(sql)
        .executeAndFetch(Ranger.class);
    }
  }

  public static Ranger find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM rangers WHERE id=:id;";
      Ranger ranger = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Ranger.class);
      return ranger;
    }
  }

  public void updateName(String name) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE rangers SET name=:name WHERE id=:id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .addParameter("name", name)
        .executeUpdate();
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM rangers WHERE id=:id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public List<Sighting> getSightings() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings WHERE ranger_id=:id;";
        List<Sighting> sightings = con.createQuery(sql)
          .addParameter("id", id)
          .executeAndFetch(Sighting.class);
      return sightings;
    }
  }

  public List<Animal> getAnimals() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals WHERE ranger_id=:id;";
        List<Animal> animals = con.createQuery(sql)
          .addParameter("id", id)
          .executeAndFetch(Animal.class);
      return animals;
    }
  }

  public void updateEmail(String email) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE rangers SET email=:email WHERE id=:id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .addParameter("email", email)
        .executeUpdate();
    }
  }

  public void updateBadgeNumber(int badgeNumber) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE rangers SET badgeNumber=:badgeNumber WHERE id=:id;";
      con.createQuery(sql)
        .addParameter("badgeNumber", badgeNumber)
        .addParameter("id", id)
        .executeUpdate();
    }
  }
}
