package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domain.Player;
import domain.Tournament;

public class PlayerManager {

   private Connection        conn;
   private PreparedStatement getAllPlayers;
   private PreparedStatement deleteAllPlayers;
   private PreparedStatement addPlayer;
   private PreparedStatement getTournamentsByPlayer;
   private PreparedStatement addPlayer_tournament;
   private PreparedStatement deletePlayer_tournamentByPlayer;
   private PreparedStatement deleteAllPlayer_tournament;
   private PreparedStatement deleteOnePlayer_tournament;

   public PlayerManager() {
      try {
         conn = InitDatabaseHelper.initDB();
         deleteOnePlayer_tournament = conn.prepareStatement(
        		 "DELETE FROM Player_tournament WHERE player_id = ? AND tournament_id = ?");
         deleteAllPlayer_tournament = conn.prepareStatement("DELETE FROM Player_tournament");
         deletePlayer_tournamentByPlayer = conn.prepareStatement(//
         "DELETE FROM Player_tournament WHERE player_id = ?");
         addPlayer_tournament = conn.prepareStatement(//
         "INSERT INTO Player_tournament(player_id, tournament_id) VALUES(?, ?)");
         getTournamentsByPlayer = conn.prepareStatement(//
         "SELECT id, entry_fee, win, place_id " + //
               " FROM Tournament t " + //
               " JOIN Player_tournament pt ON t.id=pt.tournament_id" + //
               " WHERE pt.player_id = ?");
         getAllPlayers = conn.prepareStatement("SELECT id, nick, country, ranking, earned_money, wins_count FROM Player");
         deleteAllPlayers = conn.prepareStatement("DELETE FROM Player");
         addPlayer = conn.prepareStatement("INSERT INTO Player(nick, country, ranking, earned_money, wins_count) VALUES(?, ?, ?, ?, ?)");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public void addPlayer_tournament(Player p, Tournament t) {
      try {
         addPlayer_tournament.setLong(1, p.getId());
         addPlayer_tournament.setLong(2, t.getId());
         addPlayer_tournament.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public void deleteOnePlayer_tournament (long player_id, long tournament_id){
	  try {
		deleteOnePlayer_tournament.setLong(1, player_id);
		deleteOnePlayer_tournament.setLong(2, tournament_id);
		deleteOnePlayer_tournament.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} 
   }
   public void deletePlayer_TournamentByPlayer(long player_id) {
      try {
         deletePlayer_tournamentByPlayer.setLong(1, player_id);
         deletePlayer_tournamentByPlayer.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public ArrayList<Tournament> getTournamentsByPlayer(long player_id) {
      ArrayList<Tournament> list = new ArrayList<Tournament>();
      try {
         getTournamentsByPlayer.setLong(1, player_id);
         ResultSet rs = getTournamentsByPlayer.executeQuery();
         while (rs.next()) {
            Tournament t = new Tournament();
            t.setId(rs.getLong("id"));
            t.setEntry_fee(rs.getDouble("entry_fee"));
            t.setWin(rs.getDouble("win"));
            t.setPlace_id(rs.getLong("place_id"));
            list.add(t);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return list;
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
        
         deleteAllPlayer_tournament.executeUpdate();

         deleteAllPlayers.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
