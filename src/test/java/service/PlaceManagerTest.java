package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import domain.Place;


public class PlaceManagerTest {

   PlaceManager placeManager = new PlaceManager();

   @Test
   public void testDeleteById() {
      placeManager.deleteAllPlaces();
      Place p = new Place();
      p.setName("abc");
      p.setCity("Gdansk");
      p.setCountry("Polska");
      placeManager.addPlace(p);
      p = new Place();
      p.setName("def");
      p.setCity("Gdynia");
      p.setCountry("Polska");
      placeManager.addPlace(p);
      p = new Place();
      p.setName("xyz");
      p.setCity("Sopot");
      p.setCountry("Polska");
      placeManager.addPlace(p);
      List<Place> list = placeManager.getAllPlaces();
      p = list.get(1);
      placeManager.deletePlaceById(p.getId());
      list = placeManager.getAllPlaces();
      for (int i = 0; i < list.size(); i++) {
         Place _p = list.get(i);
         assertTrue(_p.getId() != p.getId());
      }
   }

   @Test
   public void testGetById() {
      placeManager.deleteAllPlaces();
      Place p = new Place();
      p.setName("abc");
      p.setCity("Gdansk");
      p.setCountry("Polska");
      placeManager.addPlace(p);
      p = new Place();
      p.setName("def");
      p.setCity("Gdynia");
      p.setCountry("Polska");
      placeManager.addPlace(p);
      p = new Place();
      p.setName("xyz");
      p.setCity("Sopot");
      p.setCountry("Polska");
      placeManager.addPlace(p);
      List<Place> list = placeManager.getAllPlaces();
      p = list.get(1);
      Place q = placeManager.getPlaceById(p.getId());
      assertEquals(p.getCountry(), q.getCountry());
      assertEquals(p.getId(), q.getId());
      assertEquals(p.getName(), q.getName());
      assertEquals(p.getCity(), q.getCity());
   }

   @Test
   public void testGetAll() {
      placeManager.deleteAllPlaces();
      Place p = new Place();
      p.setName("abc");
      p.setCity("Gdansk");
      p.setCountry("Polska");
      placeManager.addPlace(p);
      p = new Place();
      p.setName("def");
      p.setCity("Gdynia");
      p.setCountry("Polska");
      placeManager.addPlace(p);
      p = new Place();
      p.setName("xyz");
      p.setCity("Sopot");
      p.setCountry("Polska");
      placeManager.addPlace(p);
      List<Place> list = placeManager.getAllPlaces();
      assertEquals(list.size(), 3);
   }

   @Test
    
   public void testDeleteAll() {
      Place p = new Place();
      p.setName("abc");
      p.setCity("Gdansk");
      p.setCountry("Polska");
      placeManager.addPlace(p);
      placeManager.deleteAllPlaces(); 
      List<Place> list = placeManager.getAllPlaces();
      assertEquals(list.size(), 0);
   }

   @Test
   public void testAdding() {
      Place p = new Place();
      p.setName("abc");
      p.setCity("Gdansk");
      p.setCountry("Polska");
      placeManager.deleteAllPlaces();
      placeManager.addPlace(p);
      List<Place> places = placeManager.getAllPlaces();
      assertEquals(places.size(), 1);
      Place p1 = places.get(0);
      assertEquals(p1.getName(), "abc");
   }
}
