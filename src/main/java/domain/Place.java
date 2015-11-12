package domain;

public class Place {

   private long   id;
   private String country;
   private String city;
   private String name;

// getery setery do ustawiania i pobierania wartosci pól obiektu, nie z bazy, z obiektu
   public Place() {
   }

   public Place(String country, String city, String name) {
      super();
      this.country = country;
      this.city = city;
      this.name = name;
   }

//this oznacza obiekt na ktorym wywolywana jest metoda
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
