package wk9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChampionshipStatistics {

    public static double calculateAveragePointsPerDriver(List<Driver> drivers){
        double totalPoints = 0;
        for(Driver driver : drivers){
            totalPoints += driver.getPoints();
        }
        return totalPoints / drivers.size();
    }

   public static String findMostsuccessfulcountry(List<Driver> drivers) {
        Map<String, Integer> countryPoints = new HashMap<>();
        
        for (Driver driver : drivers) {
            String country = driver.getCountry();
            int points = driver.getPoints();
            countryPoints.put(country, countryPoints.getOrDefault(country, 0) + points);
        }

        String bestCountry = "";
        int maxPoints = 0;
        for (Map.Entry<String, Integer> entry : countryPoints.entrySet()) {
            if (entry.getValue() > maxPoints) {
                maxPoints = entry.getValue();
                bestCountry = entry.getKey();
            }
        }

        return bestCountry;
    }
        

}
