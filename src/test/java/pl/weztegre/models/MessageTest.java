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
    public void test() {}
}