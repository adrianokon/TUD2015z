package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hsqldb.types.Types;
import domain.Tournament;

public class TournamentManager {

   private Connection        conn;
   private PreparedStatement getAllTournaments;
   private PreparedStatement deleteAllTournaments;
   private PreparedStatement addTournament;

   public TournamentManager() {
      try {
         conn = InitDatabaseHelper.initDB();
         getAllTournaments = conn.prepareStatement("SELECT id, entry_fee, win, place_id FROM Tournament");
         deleteAllTournaments = conn.prepareStatement("DELETE FROM Tournament");
         addTournament = conn.prepareStatement("INSERT INTO Tournament(entry_fee, win, place_id) VALUES(?, ?, ?)");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public void addTournament(Tournament t) {
      try {
         addTournament.setDouble(1, t.getEntry_fee());
         addTournament.setDouble(2, t.getWin());
         if (t.getPlace_id() == null)
            addTournament.setNull(3, Types.BIGINT);
         else
            addTournament.setLong(3, t.getPlace_id());
         addTournament.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public List<Tournament> getAllTournaments() {
      List<Tournament> tournamentsList = new ArrayList<Tournament>();
      try {
         ResultSet rs = getAllTournaments.executeQuery();
         while (rs.next()) {
            Tournament t = new Tournament();
            t.setId(rs.getLong("id"));
            t.setEntry_fee(rs.getDouble("entry_fee"));
            t.setWin(rs.getDouble("win"));
            t.setPlace_id(rs.getLong("place_id"));
            tournamentsList.add(t);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return tournamentsList;
   }

   public void deleteAllTournaments() {
      try {
         // executeUpdate, bo przeprowadzamy zmiany w bazie
         deleteAllTournaments.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
