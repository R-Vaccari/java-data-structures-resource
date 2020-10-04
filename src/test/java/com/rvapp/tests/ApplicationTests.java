package com.rvapp.tests;

import com.rvapp.structures.ArrayElement;
import com.rvapp.structures.DynamicArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTests {

    @Nested
    @DisplayName("Dynamic Array tests.")
    class DynamicArrayTests {

        DynamicArray<ArrayElement> dynamicArray = new DynamicArray<>(10);

        @Test
        public void addTest() {
            ArrayElement el = new ArrayElement(1, "element");
            dynamicArray.add(el);
            assertEquals(1, dynamicArray.getLen());
        }

        @Test
        public void addManyTest() {
            while (dynamicArray.getLen() < 10) dynamicArray.add(new ArrayElement());
            assertEquals(10, dynamicArray.getLen());
        }

    }
}
