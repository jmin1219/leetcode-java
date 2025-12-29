package hashmaps;

// Custom HashMap implementation using chaining (linked list per bucket)
// Build phase: Dec 28, 2025
public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    
    private class Entry {
      K key;
      V value;
      Entry next;

      Entry(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }
    
    private Entry[] buckets;

    public MyHashMap() {
        // Initialize your buckets
        buckets = (Entry[]) new Object[DEFAULT_CAPACITY];
    }
    
    private int hash(K key) {
        // Convert key to bucket index
        return Math.abs(key.hashCode()) % buckets.length;
    }
    
    public void put(K key, V value) {
        // Add or update
        int idx = hash(key);
        Entry current = buckets[idx];

        // Check if key exists, update if found
        while (current != null) {
          if (current.key.equals(key)) {
            current.value = value;
            return;
          }
          current = current.next;
        }

        // Key not found: add new node at HEAD
        Entry newEntry = new Entry(key, value);
        newEntry.next = buckets[idx];
        buckets[idx] = newEntry;

    }
    
    public V get(K key) {
      // Find and return, or null
      int idx = hash(key);
      Entry current = buckets[idx];

      while (current != null) {
        if (current.key.equals(key)) {
          return current.value;
        }
        current = current.next;
      }
      return null;
    }
    
    public V remove(K key) {
      // Delete and return old value
      int idx = hash(key);
      Entry current = buckets[idx];

      if (current == null) return null;

      // If Head is the match: use current
      if (current.key.equals(key)) {
        V oldValue = current.value;
        buckets[idx] = current.next;
        return oldValue;
      }

      // Search rest of chain
      while (current.next != null) {
        if (current.next.key.equals(key)) {
          V oldValue = current.next.value;
          current.next = current.next.next;
          return oldValue;
        }
        current = current.next;
      }

      return null;
    }
}