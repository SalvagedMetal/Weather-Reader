import java.util.Comparator;

public class RainSorter implements Comparator<Weather> {
    @Override
    public int compare(Weather o1, Weather o2) {
        if (o1.getRain() > o2.getRain())
            return -1;
        else if (o1.getRain() < o2.getRain())
            return 1;
        else
            return 0;
    }
}
