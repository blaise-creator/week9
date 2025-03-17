package wk9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RallyRaceResult implements RaceResult {
    private String raceName;
    private String location;
    private Map<Driver, Integer> results;

    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
        this.results = new HashMap<>();
    }

    public String getRaceName() {
        return raceName;
    }

    public String getLocation() {
        return location;
    }

    public void recordResult(Driver driver, int position, int points) {
        results.put(driver, points);
        driver.addPoints(points);
    }

    public int getDriverPoints(Driver driver) {
        return results.getOrDefault(driver, 0);
    }

    public List<Driver> getResults() {
        return new ArrayList<>(results.keySet());
    }

    public void printResults() {
        System.out.println("Race: " + raceName + " (" + location + ")");
        List<Map.Entry<Driver, Integer>> sortedResults = new ArrayList<>(results.entrySet());
        sortedResults.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        int position = 1;
        for (Map.Entry<Driver, Integer> entry : sortedResults) {
            if (position > 4) break;
            Driver driver = entry.getKey();
            int driverPoints = entry.getValue();
            System.out.println("Position " + position + ": " + driver.getName() + " - " + driverPoints + " points");
            position++;
        }
    }
}