package service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import domain.Player;

public class PlayerManagerTest {

   PlayerManager playerManager = new PlayerManager();

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
