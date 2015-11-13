package domain;


public class Tournament {

   private long   id;
   private double entry_fee;
   private double win;
   private Long   place_id;

   public Tournament() {
   }

   public Tournament(double entry_fee, double win, Long place_id) {
      super();
      this.entry_fee = entry_fee;
      this.win = win;
      this.place_id = place_id;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public double getEntry_fee() {
      return entry_fee;
   }

   public void setEntry_fee(double entry_fee) {
      this.entry_fee = entry_fee;
   }

   public double getWin() {
      return win;
   }

   public void setWin(double win) {
      this.win = win;
   }

   public Long getPlace_id() {
      return place_id;
   }

   public void setPlace_id(Long place_id) {
      this.place_id = place_id;
   }
}
