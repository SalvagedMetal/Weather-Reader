import java.util.Comparator;

public class SunSorter implements Comparator<Weather> {
    @Override
    public int compare(Weather o1, Weather o2) {
        if (o1.getSun() > o2.getSun())
            return 1;
        else if (o1.getSun() < o2.getSun())
            return -1;
        else
            return 0;
    }
}
