package domain;


public class Player {

   private long    id;
   private String  nick;
   private String  country;
   private Integer ranking;
   private double  earned_money;
   private int     wins_count;

   public Player() {
   }

   public Player(String nick, String country, Integer ranking, double earned_money, int wins_count) {
      super();
      this.nick = nick;
      this.country = country;
      this.ranking = ranking;
      this.earned_money = earned_money;
      this.wins_count = wins_count;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getNick() {
      return nick;
   }

   public void setNick(String nick) {
      this.nick = nick;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public Integer getRanking() {
      return ranking;
   }

   public void setRanking(Integer ranking) {
      this.ranking = ranking;
   }

   public double getEarned_money() {
      return earned_money;
   }

   public void setEarned_money(double earned_money) {
      this.earned_money = earned_money;
   }

   public int getWins_count() {
      return wins_count;
   }

   public void setWins_count(int wins_count) {
      this.wins_count = wins_count;
   }
}
