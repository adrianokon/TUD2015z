package service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domain.Place;
import domain.Tournament;

public class PlaceManager {

   private Connection        conn;                 //typy klasowe nie proste bo z duzej
   //typ ps do przechowywania zapytan do bazy, getallplaces zmienna mogaca przechowywac obiekt
   private PreparedStatement getAllPlaces;
   private PreparedStatement deleteAllPlaces;
   private PreparedStatement addPlace;
   private PreparedStatement getPlaceById;
   private PreparedStatement deletePlaceById;
   private PreparedStatement getTournamentsByPlace;

   public PlaceManager() {
      try {
         conn = InitDatabaseHelper.initDB(); //metoda do tworzenia i laczenia z baza, metoda zwraca polaczenie do bazy
         getAllPlaces = conn.prepareStatement("SELECT id, country, city, name FROM Place"); //preapre s metoda do stworzenia obiektu przechowujacwego zapytanie
         getPlaceById = conn.prepareStatement("SELECT id, country, city, name FROM Place WHERE id = ?");
         deletePlaceById = conn.prepareStatement("DELETE FROM Place WHERE id = ?");
         deleteAllPlaces = conn.prepareStatement("DELETE FROM Place");
         addPlace = conn.prepareStatement("INSERT INTO Place(country, city, name) VALUES(?, ?, ?)");
         getTournamentsByPlace = conn.prepareStatement("SELECT id, entry_fee, win, place_id FROM Tournament WHERE place_id = ?");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

//placemanager klasa do wykonywania operacji na danej tabeli z bazy
   public Place getPlaceById(long id) {
      try {
         getPlaceById.setLong(1, id); //1 oznacza ktory xznak zapytania, a potem podajemy wartosc
         //result rs zawiera zawsze to co pobralismy z bazy, resultset typ zmiennej tego co z bazy bierzemy, rs przechowuje wynik zapytania
         ResultSet rs = getPlaceById.executeQuery();//wykonanie zapytania ktore jest juz przechowywane w getp
         if (rs.next()) {
            Place p = new Place(); //do obiektu klasy place wpisuje wartosci rekordu
            p.setId(rs.getLong("id"));
            p.setCountry(rs.getString("country"));
            p.setCity(rs.getString("city"));
            p.setName(rs.getString("name"));
            return p;
         } else {
            return null;
         }
      } catch (SQLException e) {
         e.printStackTrace();
         return null;
      }
   }

   public void deletePlaceById(long id) {
      try {
         deletePlaceById.setLong(1, id);
         deletePlaceById.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public void addPlace(Place p) {
      try { // obiekt p jest przekazany do zapisania w bazie, przepisuje wartosci pol z p i wpisuje w odpowiadajaca mijsca w zapytaniu
         addPlace.setString(1, p.getCountry());
         addPlace.setString(2, p.getCity());
         addPlace.setString(3, p.getName());
         addPlace.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public List<Place> getAllPlaces() {
      List<Place> placesList = new ArrayList<Place>();
      try {
         ResultSet rs = getAllPlaces.executeQuery();
         while (rs.next()) {
            Place p = new Place();
            p.setId(rs.getLong("id"));
            p.setCountry(rs.getString("country"));
            p.setCity(rs.getString("city"));
            p.setName(rs.getString("name"));
            placesList.add(p);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return placesList;
   }

   public void deleteAllPlaces() {
      try {
         // executeUpdate, bo przeprowadzamy zmiany w bazie
         deleteAllPlaces.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public List<Tournament> getTournamentByPlace(Place p) {
      List<Tournament> tList = new ArrayList<Tournament>();
      try {
         getTournamentsByPlace.setLong(1, p.getId());
         ResultSet rs = getTournamentsByPlace.executeQuery();
         while (rs.next()) {
            Tournament t = new Tournament();
            t.setId(rs.getLong("id"));
            t.setEntry_fee(rs.getDouble("entry_fee"));
            t.setWin(rs.getDouble("win"));
            t.setPlace_id(rs.getLong("place_id"));
            tList.add(t);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return tList;
   }
}
