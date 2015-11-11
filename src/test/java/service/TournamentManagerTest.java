package service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import domain.Tournament;

public class TournamentManagerTest {

   TournamentManager tournamentManager = new TournamentManager();

   @Test
   public void testAdd() {
      tournamentManager.deleteAllTournaments();
      Tournament t = new Tournament();
      t.setEntry_fee(1000);
      t.setPlace_id(null);
      t.setWin(100000);
      tournamentManager.addTournament(t);
      assertEquals(tournamentManager.getAllTournaments().size(), 1);
   }

   @Test
   public void testGetAll() {
      tournamentManager.deleteAllTournaments();
      Tournament t = new Tournament();
      t.setEntry_fee(1000);
      t.setPlace_id(null);
      t.setWin(100000);
      tournamentManager.addTournament(t);
      t = new Tournament();
      t.setEntry_fee(2000);
      t.setPlace_id(null);
      t.setWin(200000);
      tournamentManager.addTournament(t);
      t = new Tournament();
      t.setEntry_fee(5);
      t.setPlace_id(null);
      t.setWin(50);
      tournamentManager.addTournament(t);
      assertEquals(tournamentManager.getAllTournaments().size(), 3);
   }

   @Test
   public void testDeleteAll() {
      Tournament t = new Tournament();
      t.setEntry_fee(1000);
      t.setPlace_id(null);
      t.setWin(100000);
      tournamentManager.addTournament(t);
      t = new Tournament();
      t.setEntry_fee(2000);
      t.setPlace_id(null);
      t.setWin(200000);
      tournamentManager.addTournament(t);
      t = new Tournament();
      t.setEntry_fee(5);
      t.setPlace_id(null);
      t.setWin(50);
      tournamentManager.addTournament(t);
      tournamentManager.deleteAllTournaments();
      assertEquals(tournamentManager.getAllTournaments().size(), 0);
   }
}
