package club.banyuan;

import java.util.ArrayList;
import java.util.List;

public class SightingFiller {

  public List<Sighting> getSightings() {
    List<Sighting> sightings = new ArrayList<>();

    sightings.add(new Sighting(0, "山地大猩猩", 3, 1, 0));
    sightings.add(new Sighting(0, "水牛", 10, 1, 0));
    sightings.add(new Sighting(0, "大象", 0, 1, 0));
    sightings.add(new Sighting(1, "山地大猩猩", 1, 2, 0));
    sightings.add(new Sighting(2, "山地大猩猩", 3, 3, 0));
    sightings.add(new Sighting(3, "山地大猩猩", 0, 2, 0));
    sightings.add(new Sighting(3, "水牛", 2, 1, 0));
    sightings.add(new Sighting(3, "河马", 25, 1, 0));

    sightings.add(new Sighting(0, "山地大猩猩", 4, 1, 1));
    sightings.add(new Sighting(0, "水牛", 16, 1, 1));
    sightings.add(new Sighting(1, "河马", 20, 1, 1));
    sightings.add(new Sighting(3, "水牛", 0, 2, 1));
    sightings.add(new Sighting(3, "河马", 30, 2, 1));

    sightings.add(new Sighting(0, "山地大猩猩", 1, 1, 2));
    sightings.add(new Sighting(1, "山地大猩猩", 2, 2, 2));
    sightings.add(new Sighting(2, "山地大猩猩", 0, 3, 2));
    sightings.add(new Sighting(3, "河马", 30, 2, 2));
    sightings.add(new Sighting(3, "大象", 24, 2, 2));

    return sightings;
  }

}
