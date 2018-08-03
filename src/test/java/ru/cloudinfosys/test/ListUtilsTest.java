package ru.cloudinfosys.test;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static ru.cloudinfosys.test.ListUtils.removeContinuousDuplicates;
import static ru.cloudinfosys.test.ListUtils.removeDuplicates;

public class ListUtilsTest {
    @Test
    void removeContinuousDuplicatesTestValid() {
        assertEquals(asList(2,2,1,1),
                removeContinuousDuplicates(asList(1,1,1,1,1,2,2,3,3,3,1,1), 3));

        assertEquals(asList(),
                removeContinuousDuplicates(asList(1, 1, 1), 3));

        assertEquals(asList(),
                removeContinuousDuplicates(asList(), 3));

        assertEquals(asList(1,1),
                removeContinuousDuplicates(asList(1,1,1,1,1,3,3,3,1,1), 3));

        assertEquals(asList(),
                removeContinuousDuplicates(asList(1,1,1,1,1,2,2,2,3,3,3,1,1,1), 3));
    }

    @Test
    void removeContinuousDuplicatesTestIllegalArgs() {
        assertThrows(IllegalArgumentException.class,
                () -> removeContinuousDuplicates(asList(1,1), 1));
        assertThrows(IllegalArgumentException.class,
                () -> removeContinuousDuplicates(null, 3));
        assertThrows(IllegalArgumentException.class,
                () -> removeContinuousDuplicates(asList(1,1, null), 3));
    }

    @Test
    void removeDuplicatesTestValid() {
        assertEquals(asList(2,2),
                removeDuplicates(asList(1,2,2,3,3,3,1,1), 3));

        assertEquals(asList(),
                removeDuplicates(asList(1,1,3,3,3,1,1), 3));

        assertEquals(asList(),
                removeDuplicates(asList(1,1,1,1,1,2,2,2,3,3,3,1,1,1), 3));

        assertEquals(asList(1, 1, 7, 7),
                removeDuplicates(asList(1,2,3,1,2,3,7,2,3,7), 3));
    }

    @Test
    void removeDuplicatesTestIllegalArgs() {
        assertThrows(IllegalArgumentException.class,
                () -> removeDuplicates(asList(1,1), 1));
        assertThrows(IllegalArgumentException.class,
                () -> removeDuplicates(null, 3));
        assertThrows(IllegalArgumentException.class,
                () -> removeDuplicates(asList(1,1, null), 3));
    }

}