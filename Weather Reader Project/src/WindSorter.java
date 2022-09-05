import java.util.Comparator;

public class WindSorter implements Comparator<Weather> {
        @Override
        public int compare(Weather o1, Weather o2) {
            if (o1.getMeanWindSpeed() > o2.getMeanWindSpeed())
                return -1;
            else if (o1.getMeanWindSpeed() < o2.getMeanWindSpeed())
                return 1;
            else
                return 0;
        }
    }
