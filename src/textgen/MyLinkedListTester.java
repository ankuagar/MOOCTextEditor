/**
 * 
 */
package textgen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
		emptyList = new MyLinkedList<Integer>();

		shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");

		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		try {
			emptyList.get(5);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		try {
			emptyList.get(-2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH + 2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{

		try {
			emptyList.remove(0);
			fail("Removal from an empty list at index 0");
		}
		catch (IndexOutOfBoundsException e) {

		}

		try {
			emptyList.remove(2);
			fail("Removal from an empty list at index 2");
		}
		catch (IndexOutOfBoundsException e) {

		}
		try {
			emptyList.remove(-1);
			fail("Removal from an empty list at index -1");
		}
		catch (IndexOutOfBoundsException e) {

		}

		try {
			list1.remove(list1.size());
			fail("Removal from a populated list at index == size");
		}
		catch (IndexOutOfBoundsException e) {

		}

		try {
			list1.remove(list1.size() + 2);
			fail("Removal from a populated list at index == size + 2");
		}
		catch (IndexOutOfBoundsException e) {

		}

		int a = list1.remove(1); //list1 has 65, 21, 42 to start with
		assertEquals("Remove: check a is correct after removal from middle of list", 21, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)65, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());

		a = list1.remove(list1.size() - 1); //list1 has 65, 42 to start with
		assertEquals("Remove: check a is correct ", 42, a);
		assertEquals("Remove: check size is correct ", 1, list1.size());

		a = list1.remove(list1.size() - 1); //list1 has 65 to start with
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check size is correct ", 0, list1.size());

		list1.add(65);
		a = list1.remove(0); //list1 has 65 to start with
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check size is correct ", 0, list1.size());

		try {
			list1.remove(0);
			fail("Removal at index 0 from a list which was emptied");
		}
		catch (IndexOutOfBoundsException e) {

		}

		try {
			list1.remove(1);
			fail("Removal at index 1 from a list which was emptied");
		}
		catch (IndexOutOfBoundsException e) {

		}

		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		emptyList.add(5);
		assertEquals("5", emptyList.toString());
		emptyList.add(5);
		assertEquals("5, 5", emptyList.toString());

		try {
			emptyList.add(null);
			fail("Adding a null element succeeded");
		}
		catch (NullPointerException e) {

		}
		emptyList.add(6);
		assertEquals("5, 5, 6", emptyList.toString());
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals(0, emptyList.size());

		emptyList.add(5);
		assertEquals(1, emptyList.size());
		emptyList.add(5);
		assertEquals(2, emptyList.size());
		emptyList.add(6);
		assertEquals(3, emptyList.size());

	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try {
			emptyList.add(-1, 1);
			fail("Adding at index -1 to an empty list succeeded");
		} catch (IndexOutOfBoundsException e) {

		}

		try {
			emptyList.add(2, 1);
			fail("Adding at index > 0 to an empty list succeeded");
		} catch (IndexOutOfBoundsException e) {

		}

		emptyList.add(0, 0);
		assertEquals(emptyList.toString(), "0");

		emptyList.add(0, 1);
		assertEquals(emptyList.toString(), "1, 0");

		longerList.add(7, 700);
		assertEquals(longerList.toString(), "0, 1, 2, 3, 4, 5, 6, 700, 7, 8, 9");
		assertEquals((Integer) 700, longerList.get(7));
		assertEquals((Integer) 6, longerList.get(6));
		assertEquals((Integer) 7, longerList.get(8));
		assertEquals((Integer) 11, (Integer)longerList.size());
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test

		try {
			emptyList.set(-1, 1);
			fail("Setting at index -1 to an empty list succeeded");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			emptyList.set(2, 1);
			fail("Setting at index 2 to an empty list succeeded");
		} catch (IndexOutOfBoundsException e) {

		}

		try {
			longerList.set(10, 1);
			fail("Setting at index == size to an longer list succeeded");
		} catch (IndexOutOfBoundsException e) {

		}

		longerList.set(0, 0+100);
		assertEquals("100, 1, 2, 3, 4, 5, 6, 7, 8, 9", longerList.toString());

		longerList.set(1, 1+100);
		assertEquals("100, 101, 2, 3, 4, 5, 6, 7, 8, 9", longerList.toString());


		longerList.set(8, 8+100);
		assertEquals("100, 101, 2, 3, 4, 5, 6, 7, 108, 9", longerList.toString());

	}
	
	
	// TODO: Optionally add more test methods.
	
}
