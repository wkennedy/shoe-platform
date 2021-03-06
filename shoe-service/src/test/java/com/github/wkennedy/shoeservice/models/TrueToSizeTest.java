package com.github.wkennedy.shoeservice.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrueToSizeTest {

    @Test
    public void getValue() {
        assertEquals(5, TrueToSize.FIVE.getValue());
    }

    @Test
    public void getDescription() {
        assertEquals("Really Big", TrueToSize.FIVE.getDescription());
    }

    @Test
    public void getFromValue() {
        assertEquals(TrueToSize.ONE, TrueToSize.getFromValue(1));
    }

    @Test
    public void getDescriptionForRange() {
        assertEquals(TrueToSize.REALLY_BIG, TrueToSize.getDescriptionForRange(4.8));
    }
}