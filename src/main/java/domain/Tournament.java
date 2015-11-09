package domain;

public class Tournament {

   private long   id;
   private String place;
   private double entry_fee;
   private double win;
   private long   place_id;

   public Tournament() {
   }

   public Tournament(String place, double entry_fee, double win, long place_id) {
      super();
      this.place = place;
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

   public String getPlace() {
      return place;
   }

   public void setPlace(String place) {
      this.place = place;
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

   public long getPlace_id() {
      return place_id;
   }

   public void setPlace_id(long place_id) {
      this.place_id = place_id;
   }
}
