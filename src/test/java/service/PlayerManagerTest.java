package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import domain.Player;
import domain.Tournament;

public class PlayerManagerTest {

   PlayerManager playerManager = new PlayerManager();

   @Test
   public void testAddPlayerTournament() {
      Player p = new Player();
      p.setCountry("Polska");
      p.setEarned_money(1200);
      p.setNick("abc");
      p.setRanking(1);
      p.setWins_count(0);
      playerManager.addPlayer(p);
      //
      Tournament t = new Tournament();
      t.setEntry_fee(123);
      t.setWin(100);
      TournamentManager tm = new TournamentManager();
      tm.addTournament(t);
      //
      List<Player> l = playerManager.getAllPlayers();
      Player jas = l.get(0);
      List<Tournament> l2 = tm.getAllTournaments();
      Tournament malgosia = l2.get(0);
      //
      playerManager.addPlayer_tournament(jas.getId(), malgosia.getId());
      List<Tournament> turniejeJasia = playerManager.getTournamentsByPlayer(jas.getId());
      //
      for (int i = 0; i < turniejeJasia.size(); i++) {
         Tournament turniej = turniejeJasia.get(i);
         if (malgosia.getId() == turniej.getId()) {
            assertTrue(true);
            return;
         }
      }
      assertTrue(false);
   }

   @Test
   public void testAddPlayer() {
      playerManager.deleteAllPlayers();
      Player p = new Player();
      p.setNick("abc");
      p.setCountry("Polska");
      p.setRanking(3);
      p.setEarned_money(100);
      p.setWins_count(100000);
      playerManager.addPlayer(p);
      assertEquals(playerManager.getAllPlayers().size(), 1);
   }

   @Test
   public void testGetAll() {
      playerManager.deleteAllPlayers();
      Player p = new Player();
      p.setNick("abc");
      p.setCountry("Polska");
      p.setRanking(3);
      p.setEarned_money(100);
      p.setWins_count(100000);
      playerManager.addPlayer(p);
      p = new Player();
      p.setNick("def");
      p.setCountry("Polska");
      p.setRanking(4);
      p.setEarned_money(200);
      p.setWins_count(1000);
      playerManager.addPlayer(p);
      p = new Player();
      p.setNick("xyz");
      p.setCountry("Polska");
      p.setRanking(1);
      p.setEarned_money(102030);
      p.setWins_count(23456);
      playerManager.addPlayer(p);
      assertEquals(playerManager.getAllPlayers().size(), 3);
   }

   @Test
   public void testDeleteAll() {
      Player p = new Player();
      p.setNick("abc");
      p.setCountry("Polska");
      p.setRanking(3);
      p.setEarned_money(100);
      p.setWins_count(100000);
      playerManager.addPlayer(p);
      p = new Player();
      p.setNick("def");
      p.setCountry("Polska");
      p.setRanking(4);
      p.setEarned_money(200);
      p.setWins_count(1000);
      playerManager.addPlayer(p);
      p = new Player();
      p.setNick("xyz");
      p.setCountry("Polska");
      p.setRanking(1);
      p.setEarned_money(102030);
      p.setWins_count(23456);
      playerManager.addPlayer(p);
      playerManager.deleteAllPlayers();
      assertEquals(playerManager.getAllPlayers().size(), 0);
   }
}
