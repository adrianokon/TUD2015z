package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domain.Player;

public class PlayerManager {

   private Connection        conn;
   private PreparedStatement getAllPlayers;
   private PreparedStatement deleteAllPlayers;
   private PreparedStatement addPlayer;

   public PlayerManager() {
      try {
         conn = InitDatabaseHelper.initDB();
         getAllPlayers = conn.prepareStatement("SELECT id, nick, country, ranking, earned_money, wins_count FROM Player");
         deleteAllPlayers = conn.prepareStatement("DELETE FROM Player");
         addPlayer = conn.prepareStatement("INSERT INTO Player(nick, country, ranking, earned_money, wins_count) VALUES(?, ?, ?, ?, ?)");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public void addPlayer(Player p) {
      try {
         addPlayer.setString(1, p.getNick());
         addPlayer.setString(2, p.getCountry());
         addPlayer.setInt(3, p.getRanking());
         addPlayer.setDouble(4, p.getEarned_money());
         addPlayer.setInt(5, p.getWins_count());
         addPlayer.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public List<Player> getAllPlayers() {
      List<Player> playersList = new ArrayList<Player>();
      try {
         ResultSet rs = getAllPlayers.executeQuery();
         while (rs.next()) {
            Player p = new Player();
            p.setId(rs.getLong("id"));
            p.setNick(rs.getString("nick"));
            p.setCountry(rs.getString("country"));
            p.setEarned_money(rs.getDouble("earned_money"));
            p.setWins_count(rs.getInt("wins_count"));
            playersList.add(p);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return playersList;
   }

   public void deleteAllPlayers() {
      try {
         // executeUpdate, bo przeprowadzamy zmiany w bazie
         deleteAllPlayers.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
