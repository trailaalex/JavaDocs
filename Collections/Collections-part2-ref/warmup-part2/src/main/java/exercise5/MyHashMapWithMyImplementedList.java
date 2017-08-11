package exercise5;

import exercise4.MyHashMap;

import java.util.*;

/**
 * Create a HashMap that uses to store the buckets your implementation of MyImplementedList that you
 * created in the Collections I workshop.
 *
 * Created by Radu.Hoaghe on 7/6/2017.
 */
public class MyHashMapWithMyImplementedList {

    // TODO uncomment the following line and add your MyImplementedList implementation to the project
    private MyImplementedList<LinkedList<MyEntry>> buckets;

    private final int BUCKET_ARRAY_SIZE = 16;

    public MyHashMapWithMyImplementedList() {
        // TODO
        buckets = new MyImplementedList<LinkedList<MyEntry>>();
        for(int i = 0; i < BUCKET_ARRAY_SIZE; i++)
            buckets.add(new LinkedList<MyEntry>());
    }

    public String get(String key) {
        // TODO
        if(key == null)
            return null;
        int index = Math.abs(key.hashCode() % BUCKET_ARRAY_SIZE);
        if(index < 0 || index >= BUCKET_ARRAY_SIZE)
            return null;
        for(MyEntry entry : buckets.get(index))
            if(entry.getKey().equals(key))
                return entry.getValue();
        return null;
    }

    /*  public void put(String key, String value) {
          // TODO
          if(key == null) {
              buckets.get(0).add(new MyEntry(key,value));
          }
          else {
              int index = Math.abs(key.hashCode() % BUCKET_ARRAY_SIZE);
              buckets.get(index).add(new MyEntry(key,value));
          }

      }*/
    public void put(String key, String value) {
        //
        if (key == null) {
            buckets.get(0).add(new MyEntry(key, value));
        } else {
            // boolean ok = true;
            int hash = Math.abs(key.hashCode() % BUCKET_ARRAY_SIZE);
            if (hash >= 0 && hash < 16) {
                if (hash < buckets.size()) {

                    if (buckets.get(hash).size() == 0) {
                        buckets.get(hash).add(new MyEntry(key, value));
                    } else {
                        for (MyEntry entry : buckets.get(hash)) {
                            if (entry.equals(new MyEntry(key, value))) {
                                entry.setValue(value);
                            }
                        }

                    }

                }
            }
        }
    }


    public Set<String> keySet() {
        // TODO
        Set<String> keys = new HashSet<String>();
        for(int i = 0; i < BUCKET_ARRAY_SIZE; i++)
            for(MyEntry entry : buckets.get(i))
                keys.add(entry.getKey());
        return keys;
    }

    public Collection<String> values() {
        // TODO
        Collection<String> values = new ArrayList<String>();
        for(int i = 0; i< BUCKET_ARRAY_SIZE; i++)
            for(MyEntry entry : buckets.get(i))
                values.add(entry.getValue());
        return values;
    }

    public String remove(String key) {
        // TODO Returns the value associated with the key removed from the map or null if the key wasn't found
        int index = Math.abs(key.hashCode() % BUCKET_ARRAY_SIZE);
        if(index < 0 || index >= BUCKET_ARRAY_SIZE)
            return null;
        else
        {
            for(MyEntry entry : buckets.get(index))
                if(entry.getKey().equals(key))
                {   String value;
                    value = entry.getValue();
                    buckets.get(index).remove(entry);
                    return value;
                }

        }
        return null;
    }

    public boolean containsKey(String key) {
        // TODO
        int index = Math.abs(key.hashCode() % BUCKET_ARRAY_SIZE);
        if(index < 0 || index >BUCKET_ARRAY_SIZE)
            return false;
        else
        {
            for(MyEntry entry : buckets.get(index)) {
                int index1 = Math.abs(entry.getKey().hashCode() % BUCKET_ARRAY_SIZE);
                if(index == index1)
                    if (entry.getKey().equals(key))
                        return true;
            }
        }
        return false;
    }

    public boolean containsValue(String value) {
        // TODO
        for(int i = 0; i < BUCKET_ARRAY_SIZE; i++)
            for(MyEntry entry : buckets.get(i))
                if(entry.getValue().equals(value))
                    return true;
        return false;
    }

    public int size() {
        // TODO Return the number of the Entry objects stored in all the buckets
        int nr = 0;
        for(int i = 0; i < BUCKET_ARRAY_SIZE; i++)
            nr += buckets.get(i).size();

        return nr;
    }

    public void clear() {
        // TODO Remove all the Entry objects from the bucket list
        for(int i = 0; i < BUCKET_ARRAY_SIZE; i++)
            buckets.get(i).clear();
    }

    public Set<MyHashMap.MyEntry> entrySet() {
        // TODO Return a Set containing all the Entry objects
        Set<MyHashMap.MyEntry> result = new HashSet<MyHashMap.MyEntry>();
        for (int i = 0; i < BUCKET_ARRAY_SIZE; i++) {
            LinkedList<MyEntry> list = buckets.get(i);
            for(int j = 0; j < list.size(); j ++) {
                MyEntry newEntry = list.get(j);
                result.add(new MyHashMap.MyEntry(newEntry.getKey(), newEntry.getValue()));
            }
        }
        return result;
    }

    public boolean isEmpty() {
        // TODO
        if(size() == 0)
            return true;
        return false;
    }

    public static class MyEntry {
        private String key;
        private String value;

        public MyEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
