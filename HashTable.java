/*
 * This class sets up the has table data structure along with
 * the utility methods to manipulate it.
 */
public class HashTable {

	private Node[] map;
	private int tableSize;
	
	// constructor
	public HashTable(int tableSize) {
		map = new Node[tableSize];
		this.tableSize = tableSize;
	}
	
	/*
	 * This is the hash function.
	 * For this hash function, return 0 if key is the empty string.
	 * Otherwise, calculate the sum of the ASCII values of the characters in key
	 * and find the remainder when divided by 8 (remember mod divisision %).
	 * Check the java API for String methods that may be helpful.
	 */
	private int hash(String key) {
		if (key == null) {
			return 0;		
			} else {
				int hash = 0;
				for (int i = 0; i<key.length(); i++) {
					hash += (int)key.charAt(i);
				}
				return hash % 8;
			}
	}
	
	/*
	 * This method should insert a node containing the given key
	 * in the proper bucket in the hash table.  Insert new nodes
	 * at the head of each linked list for ease of implementation.
	 */
	public void insert(String key) {
		Node newNode = new Node(key);
		if (map[hash(key)] == null) {
			map[hash(key)] = newNode;
		} else {
			newNode.next = map[hash(key)];
			map[hash(key)] = newNode;
		}
	}
	
	/*
	 * This method returs true if the search key is contained in the
	 * hash table, and false otherwise.
	 */
	public boolean search(String key) {
		Node scroller = map[hash(key)];
		boolean found = false;
		while (!found && scroller != null) {
		if (scroller.record == key) {
			found = true;
		} else {
			scroller = scroller.next;
		}
		}
		if (found == true) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * This method should print out the hash table row by row.
	 * Each line should print out a separate row of the table.
	 * Print the index followed a colon and then the records in that
	 * bucket with spaces between them.
	 * 
	 * For example:
	 * 1: Nicholas Mary Kim Jack
	 */
	public void printTable() {
		for (int i=0; i<tableSize; i++) {
			System.out.print(i  + ": ");
			Node scroller = map[i];
			while (scroller != null) {
				System.out.print(scroller.record + " ");
				scroller = scroller.next;
			}
			System.out.println();
		}
	}
	
	/*
	 * This method should delete ALL nodes matching the search key.
	 */
	public void delete(String key) {
		Node scroller = map[hash(key)];
		
		if (map[hash(key)].record.equals(key)) {
			map[hash(key)] = map[hash(key)].next;
			} else {
				while (scroller != null) {
					if (scroller.record.equals(key)) {
						map[hash(key)] = scroller.next;
					}
					scroller = scroller.next.next;
				}
			}
	}
	
}
