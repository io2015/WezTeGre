package pl.weztegre.models;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.weztegre.EqualsTester;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 15.05.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class MessageTest {

    private Message Message;
    private Message Message2;

    @Before
    public void setUp() throws Exception {
        Message = new Message();
        Message.setId(1);
        Message2 = new Message();
        Message2.setId(2);

    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<Message> equalsTester = EqualsTester.newInstance(new Message());
        equalsTester.assertEqual(new Message(), new Message());
        equalsTester.assertNotEqual(Message, Message2);
    }

    @Test
    public void testHashCode() throws Exception {
        Message2.setId(1);
        assertTrue(Message.equals(Message2) && Message2.equals(Message));
        assertTrue(Message.hashCode() == Message2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Message{id=1, sender=null, addressee=null, subject='null', content='null', city='null', senderRead=false, addresseeRead=false, value=null, advertisement=null}",
                Message.toString());

    }

}