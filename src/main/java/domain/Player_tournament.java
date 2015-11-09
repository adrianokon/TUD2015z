package domain;

public class Player_tournament {

   private long id;
   private long player_id;
   private long tournament_id;

   public Player_tournament() {
   }

   public Player_tournament(long player_id, long tournament_id) {
      super();
      this.player_id = player_id;
      this.tournament_id = tournament_id;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public long getPlayer_id() {
      return player_id;
   }

   public void setPlayer_id(long player_id) {
      this.player_id = player_id;
   }

   public long getTournament_id() {
      return tournament_id;
   }

   public void setTournament_id(long tournament_id) {
      this.tournament_id = tournament_id;
   }
}
