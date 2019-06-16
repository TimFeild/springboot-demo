package strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Long> longs = new ArrayList<Long>();
        longs.add(2L);
        longs.add(7L);
        longs.add(3L);
        Collections.sort(longs, new Comparator<Long>() {
            public int compare(Long o1, Long o2) {
                return o1>o2 ? 1 : -1;
            }
        });
        System.out.println(longs);
    }
}
