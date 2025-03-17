package wk9;

public class AsphaltCar extends RallyCar {
    private double downforce;

    public AsphaltCar(String make, String model, int horsepower, double downforce) {
        super(make, model, horsepower);
        this.downforce = downforce;
    }

    public double getDownforce() {
        return downforce;
    }

    public double CalculatePerformance(){
        return getHorsepower() * downforce;
    }

}
