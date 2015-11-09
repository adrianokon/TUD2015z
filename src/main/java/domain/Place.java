package domain;

public class Place {

   private long   id;
   private String country;
   private String city;
   private String name;

   public Place() {
   }

   public Place(String country, String city, String name) {
      super();
      this.country = country;
      this.city = city;
      this.name = name;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
