import java.util.ArrayList;
import java.util.Comparator;

public class Weather {
    private double year;
    private double month;
    private double meanTemp;
    private double maxTemp;
    private double minTemp;
    private double meanMaxTemp;
    private double meanMinTemp;
    private double rain;
    private double grassMinTemp;
    private double meanWindSpeed;
    private double highGust;
    private double sun;

    public Weather(double year, double month, double meanTemp, double maxTemp, double minTemp, double meanMaxTemp, double meanMinTemp, double rain, double grassMinTemp, double meanWindSpeed, double highGust, double sun) {
        this.year = year;
        this.month = month;
        this.meanTemp = meanTemp;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.meanMaxTemp = meanMaxTemp;
        this.meanMinTemp = meanMinTemp;
        this.rain = rain;
        this.grassMinTemp = grassMinTemp;
        this.meanWindSpeed = meanWindSpeed;
        this.highGust = highGust;
        this.sun = sun;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "year=" + year +
                ", month=" + month +
                ", meanTemp=" + meanTemp +
                ", maxTemp=" + maxTemp +
                ", minTemp=" + minTemp +
                ", meanMaxTemp=" + meanMaxTemp +
                ", meanMinTemp=" + meanMinTemp +
                ", rain=" + rain +
                ", grassMinTemp=" + grassMinTemp +
                ", meanWindSpeed=" + meanWindSpeed +
                ", highGust=" + highGust +
                ", sun=" + sun +
                '}';
    }

    //for writing into file
    public String toFile() {
        return year +
                ", " + month +
                ", " + meanTemp +
                ", " + maxTemp +
                ", " + minTemp +
                ", " + meanMaxTemp +
                ", " + meanMinTemp +
                ", " + rain +
                ", " + grassMinTemp +
                ", " + meanWindSpeed +
                ", " + highGust +
                ", " + sun;
    }

    public double getYear() {
        return year;
    }

    public void setYear(double year) {
        this.year = year;
    }

    public double getMonth() {
        return month;
    }

    public void setMonth(double month) {
        this.month = month;
    }

    public double getMeanTemp() {
        return meanTemp;
    }

    public void setMeanTemp(double meanTemp) {
        this.meanTemp = meanTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMeanMaxTemp() {
        return meanMaxTemp;
    }

    public void setMeanMaxTemp(double meanMaxTemp) {
        this.meanMaxTemp = meanMaxTemp;
    }

    public double getMeanMinTemp() {
        return meanMinTemp;
    }

    public void setMeanMinTemp(double meanMinTemp) {
        this.meanMinTemp = meanMinTemp;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

    public double getGrassMinTemp() {
        return grassMinTemp;
    }

    public void setGrassMinTemp(double grassMinTemp) {
        this.grassMinTemp = grassMinTemp;
    }

    public double getMeanWindSpeed() {
        return meanWindSpeed;
    }

    public void setMeanWindSpeed(double meanWindSpeed) {
        this.meanWindSpeed = meanWindSpeed;
    }

    public double getHighGust() {
        return highGust;
    }

    public void setHighGust(double highGust) {
        this.highGust = highGust;
    }

    public double getSun() {
        return sun;
    }

    public void setSun(double sun) {
        this.sun = sun;
    }


}
