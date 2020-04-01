package linked_list;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;

import static org.junit.Assert.assertEquals;

public class MyLinkedListTest {

    private String firstElement = "First element";
    private String secondElement = "2";
    private String thirdElement = "3 element";

    @Test
    public void testGet() {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add(firstElement);

        assertEquals(linkedList.get(), firstElement);
    }

    @Test
    public void testAdd() {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add(firstElement);
        linkedList.add(secondElement);
        linkedList.add(thirdElement);

        Iterator<String> iterator = linkedList.iterator();
        assertEquals(iterator.next(), firstElement);
        assertEquals(iterator.next(), secondElement);
        assertEquals(iterator.next(), thirdElement);
    }

    @Test
    public void testSize() {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add(firstElement);
        linkedList.add(secondElement);
        linkedList.add(thirdElement);

        assertEquals(linkedList.size(), 3);
    }

    @Test
    public void mockitoTest() {
        List<String> mockList = mock(MyLinkedList.class);
        mockList.add("Pankaj");
        mockList.size();

        verify(mockList).add("Pankaj");
    }
}
