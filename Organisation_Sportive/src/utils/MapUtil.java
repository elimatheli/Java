package utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Provides methods to manipulate Maps
 */
public class MapUtil {

    /**
     * Sort a map by descending order based on the values
     *
     * @param map       the name of the map
     * @param <K>       the type of the keys
     * @param <V>       the type of the values
     * @return          the sorted map
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByDescendingValue(Map<K, V> map) {

        List<Entry<K, V>> sortedEntries = new ArrayList<>(map.entrySet());

        sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : sortedEntries) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
