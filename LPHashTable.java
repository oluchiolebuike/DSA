import java.util.List;
/**
 * Simple hash table implementation using linear probing.
 *
 * @author Stephan Jamieson
 * @version 24/4/2015
 */
public class LPHashTable extends HashTable {

    /**
     * Create an LPHashTable with DEFAULT_SIZE table.
     */
    public LPHashTable() { super(); }
    /**
     * Create an LPHashTable with the given default size table.
     */
    public LPHashTable(final int size) { super(size); }

    /**
     * Find the index for entry: if entry is in the table, then returns its position;
     * if it is not in the table then returns the index of the first free slot.
     * Returns -1 if a slot is not found (such as when the table is full under LP).
     *
     */
    protected int findIndex(String key) {
		// Implement using linear probing.
      // resetProbeCount();
      
      // Calculated hash index when been given a key
      int index = hashFunction(key);
      
      // Start index
      int start = index; 
      
      // Continue to loop until probing has failed when the number of probes exceeds the table size (i>M).  
      while (getProbeCount()<= tableSize()){
         // Count the current attempt
         incProbeCount() ;

         if (table[index] == null || key.equals(table[index])){
            return index;
         }
         
         // Move to next slot
         index = (index + 1) % tableSize();
      }
    return -1;
    }
}
