import java.util.Comparator;

public class TempSorter implements Comparator<Weather> {

    @Override
    public int compare(Weather o1, Weather o2) {
        if (o1.getMaxTemp() > o2.getMaxTemp())
            return 1;
        else if (o1.getMaxTemp() < o2.getMaxTemp())
            return -1;
        else
            return 0;
    }
}
