package wk9;


import java.util.List;

/**
 * RallyChampionship management class
 *
 */
public class RallyChampionship {



    public static void main( String[] args ){
        RallyCar car1 = new GravelCar("Toyota", "Yaris", 300, 0.3);
        RallyCar car2 = new AsphaltCar("Hyundai", "i20", 350, 0.5);
        RallyCar car3 = new GravelCar("Ford", "Fiesta", 320, 0.4);
        RallyCar car4 = new AsphaltCar("Citroen", "C3", 330, 0.6);

        Driver driver1 = new Driver("Sebastian Ogier", "France", car1);
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland", car2);
        Driver driver3 = new Driver("Ott Tänäk", "Estonia", car3);
        Driver driver4 = new Driver("Thierry Neuville", "Belgium", car4);

        RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyväskylä");
        race1.recordResult(driver1, 1, 25);
        race1.recordResult(driver2, 2, 18);
        race1.recordResult(driver3, 3, 15);
        race1.recordResult(driver4, 4, 12);

        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo", "Monaco");
        race2.recordResult(driver3, 1, 25);
        race2.recordResult(driver4, 2, 18);
        race2.recordResult(driver1, 3, 15);
        race2.recordResult(driver2, 4, 12);

        ChampionshipManager manager = ChampionshipManager.getInstance();
        manager.registerDriver(driver1);
        manager.registerDriver(driver2);
        manager.registerDriver(driver3);
        manager.registerDriver(driver4);

        manager.addRaceResult(race1);
        manager.addRaceResult(race2);

        manager.displayDrivers();
        System.out.println("====== CHAMPIONSHIP LEADER ======");
        String leader = manager.getLeadingDriver().getName();
        int points = manager.getLeadingDriver().getPoints();
        System.out.println(leader + " with " + points + " points");
        System.out.println();

        System.out.println("====== CHAMPIONSHIP STATISTICS ======");
        System.out.println("Total drivers: " + ChampionshipManager.getTotalDrivers());
        System.out.println("Total races: " + ChampionshipManager.getTotalRaces());
        System.out.println();

        List<Driver> drivers = manager.getDrivers();
        System.out.println("Average points per driver: " + ChampionshipStatistics.calculateAveragePointsPerDriver(drivers));
        System.out.println("Most successful country: " + ChampionshipStatistics.findMostsuccessfulcountry(drivers));
        System.out.println("Total championship points: " + manager.getTotalChampionshipPoints());
        System.out.println();

        System.out.println("====== RACE RESULTS ======");
        manager.displayRaceStandings();
        System.out.println();

        System.out.println("====== CAR PERFORMANCE RATINGS ======");
        System.out.println("Car 1: " + car1.CalculatePerformance());
        System.out.println("Car 2: " + car2.CalculatePerformance());
        System.out.println("Car 3: " + car3.CalculatePerformance());
        System.out.println("Car 4: " + car4.CalculatePerformance());







    }

}
