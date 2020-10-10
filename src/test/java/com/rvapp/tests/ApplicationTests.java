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
        @DisplayName("Check array length after adding 01 element.")
        public void addOneLengthTest() {
            ArrayElement el = new ArrayElement(1, "element");
            dynamicArray.add(el);
            assertEquals(1, dynamicArray.getLen());
        }

        @Test
        @DisplayName("Check array length after filling length space.")
        public void fillLengthTest() {
            while (dynamicArray.getLen() < 10) dynamicArray.add(new ArrayElement());
            assertEquals(10, dynamicArray.getLen());
        }

        @Test
        @DisplayName("Assert that remove method returns true.")
        public void removeTrueTest() {
            ArrayElement el = new ArrayElement(1, "test");
            dynamicArray.add(el);
            assertTrue(dynamicArray.remove(el));
        }

        @Test
        @DisplayName("Assert that remove method returns false.")
        public void removeFalseTest() {
            ArrayElement el = new ArrayElement(1, "test");
            assertFalse(dynamicArray.remove(el));
        }

        @Test
        @DisplayName("Assert that element removed at given index is equal to one inserted.")
        public void removeAtTest() {
            ArrayElement el = new ArrayElement(1, "test");
            dynamicArray.add(el);
            ArrayElement removedEl = dynamicArray.removeAt(0);
            assertEquals(el, removedEl);
        }

        @Test
        @DisplayName("Assert that element removed at given index is equal to one inserted.")
        public void removeAtExceptionTest() {
            Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> dynamicArray.removeAt(11));
        }
    }
}
