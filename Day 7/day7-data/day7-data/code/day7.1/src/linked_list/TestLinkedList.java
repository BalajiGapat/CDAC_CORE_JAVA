package linked_list;

import java.util.Collections;
import java.util.LinkedList;

public class TestLinkedList 
{
	public static void main(String[] args) 
	{
		LinkedList<String> l1 = new LinkedList<>();//size=0
		Collections.addAll(l1, "one", "two", "three", "four", "five");
		System.out.println(l1);//["one", "two", "three", "four", "five"]

		
		System.out.println("getFirst " + l1.getFirst());//one

		
		System.out.println("peek first: " + l1.peekFirst());//one
		System.out.println("peek : " + l1.peek());//one


		System.out.println("remove first " + l1.removeFirst());//one
		System.out.println("remove first " + l1.removeFirst());//two


		System.out.println("current list " + l1);//["three", "four", "five"]

		System.out.println("poll first " + l1.pollFirst());//three
		System.out.println("poll last " + l1.pollLast());//five
		System.out.println(l1);//four
		System.out.println("poll " + l1.poll());//four
		
		
		l1.addFirst("six");
		l1.addFirst("seven");
		System.out.println("l1 after 2 addFirst " + l1);//[seven , six]


		System.out.println("Offered " + l1.offer("1"));//true
		System.out.println("Offered " + l1.offerLast("2"));//true
		System.out.println("after 2 offers " + l1);//[seven , six,1,2]

		// addLast equivalent to add(E o)
		l1.addLast("ten");//
		l1.addLast("eleven");
		System.out.println("l1 after 2 addLast " + l1);//[seven , six,1,2,ten,eleven]


		System.out.println("removeLast " + l1.removeLast());
		System.out.println(l1);//[seven , six,1,2,ten]

	}

}
