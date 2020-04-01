package linked_list;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MyLinkedListTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Captor
    private ArgumentCaptor<List<String>> captor;

    final private String firstElement = "First element";
    final private String secondElement = "2";
    final private String thirdElement = "3 element";

    @Test
    public void testGet() {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add(firstElement);

        assertEquals(linkedList.get(), firstElement);
    }

    @Test
    public void testAdd() {
        List<String> asList = Arrays.asList(firstElement, secondElement, thirdElement, firstElement);
        final List<String> mockedList = mock(List.class);
        mockedList.addAll(asList);
        verify(mockedList).addAll(captor.capture());

        final List<String> capturedArgument = captor.getValue();
        assertThat(capturedArgument, hasItems(firstElement, secondElement, thirdElement));
        assertThat(capturedArgument, equalTo(asList));
        // should emit error
        // assertThat(capturedArgument, equalTo(Arrays.asList(firstElement)));
        assertThat(capturedArgument, not(equalTo(Arrays.asList(firstElement))));
        // should emit error
        // assertThat(capturedArgument, not(equalTo(asList)));
        assertEquals(capturedArgument, asList);

        List<String> mockList = mock(MyLinkedList.class);
        mockList.add(firstElement);
        mockList.add(secondElement);
        mockList.add(thirdElement);

        verify(mockList, atLeast(1)).add(firstElement);
        verify(mockList, times(3)).add(anyString());
    }

    @Test
    public void testSize() {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add(firstElement);
        linkedList.add(secondElement);
        linkedList.add(thirdElement);

        assertEquals(linkedList.size(), 3);
    }

}
