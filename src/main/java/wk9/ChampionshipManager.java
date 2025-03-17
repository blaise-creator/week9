package wk9;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipManager {

    // Singleton instance
    private static ChampionshipManager instance;

    // List of drivers and races
    private List<Driver> drivers;
    private List<RallyRaceResult> races;

    // Static counters for total drivers and races
    private static int totaldrivers = 0;
    private static int totalraces = 0;

    // Private constructor to prevent instantiation
    private ChampionshipManager() {
        this.drivers = new ArrayList<>();
        this.races = new ArrayList<>();
    }

    // Method to get the total number of drivers
    public static int getTotalDrivers() {
        return totaldrivers;
    }

    // Method to get the total number of races
    public static int getTotalRaces() {
        return totalraces;
    }

    // Public method to get the singleton instance
    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    // Method to register a new driver
    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totaldrivers++;
    }

    // Method to add a race result
    public void addRaceResult(RallyRaceResult result) {
        races.add(result);
        totalraces++;
    }

    // Method to get the list of drivers
    public List<Driver> getDrivers() {
        return drivers;
    }

    // Method to get the driver standings sorted by points
    public List<Driver> getDriverStandings() {
        List<Driver> standings = new ArrayList<>(drivers);
        standings.sort((d1, d2) -> d2.getPoints() - d1.getPoints());
        return standings;
    }

    // Method to get the leading driver
    public Driver getLeadingDriver() {
        Driver leadingDriver = drivers.get(0);
        for (Driver driver : drivers) {
            if (driver.getPoints() > leadingDriver.getPoints()) {
                leadingDriver = driver;
            }
        }
        return leadingDriver;
    }

    // Method to get the total championship points
    public int getTotalChampionshipPoints() {
        int total = 0;
        for (Driver driver : drivers) {
            total += driver.getPoints();
        }
        return total;
    }

    // Method to display the list of drivers
    public void displayDrivers() {
        int i = 1;
        for (Driver driver : drivers) {
            System.out.println(i + ". " + driver.getName() + " (" + driver.getCountry() + ") : " + driver.getPoints() + " points.");
            i++;
        }
    }

    // Method to display the race standings for each race
    public void displayRaceStandings() {
        for (RallyRaceResult race : races) {
            race.printResults();
            System.out.println();
        }
    }
}