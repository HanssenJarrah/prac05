package mapset;

import java.util.*;

public class MapSet<K, V> extends AbstractMap<K, HashSet<V>> implements Iterable<V> {
    public HashMap<K, HashSet<V>> map = new HashMap<>();

    public void AddValue(K key, V value)
    {
        if (!map.containsKey(key))
        {
            map.put(key, new HashSet<V>());
        }
        map.get(key).add(value);
    }

    @Override
    public Iterator<V> iterator() {
        return new MapListIterator<>();
    }

    @Override
    public Set<Entry<K, HashSet<V>>> entrySet() {
        return map.entrySet();
    }

    public class MapListIterator<V> implements Iterator<V>
    {
        int key = 0;
        int value = 0;
        ArrayList<HashSet<V>> keys;
        HashSet<V> currentValues;
        Iterator<V> currentValuesIterator;

        public MapListIterator()
        {
            ArrayList a = new ArrayList(map.values());
            Collections.sort(a, (HashSet<V> z, HashSet<V> x) -> x.size() - z.size());
            keys = a;
            currentValues = keys.get(key);
            currentValuesIterator = currentValues.iterator();
        }

        @Override
        public boolean hasNext() {
            return key < keys.size() - 1  || currentValuesIterator.hasNext();
        }

        @Override
        public V next() {
            if(!currentValuesIterator.hasNext())
            {
                HashSet<V> newValuesSet = keys.get(++key);
                currentValuesIterator = newValuesSet.iterator();
            }
            return currentValuesIterator.next();
        }
    }
}
