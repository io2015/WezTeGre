package pl.weztegre.enums;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 13.06.15.
 */
public class StateTest {
    private State state;

    @Test
    public void testToStringNew() throws Exception {
        state = State.New;
        assertEquals("Nowy", state.toString());
    }

    @Test
    public void testToStringUsedBad() throws Exception {
        state = State.UsedBad;
        assertEquals("Używany - kiepski", state.toString());
    }

    @Test
    public void testToStringUsedAverage() throws Exception {
        state = State.UsedAverage;
        assertEquals("Używany - średni", state.toString());
    }

    @Test
    public void testToStringGood() throws Exception {
        state = State.UsedGood;
        assertEquals("Używany - dobry", state.toString());
    }
}