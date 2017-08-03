package com.bb.hackerRank.solutionTester;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ClassReloaderTest {
    @Test
    void shouldReturnDifferentClass() {
        Class<?> clazz = ClassReloader.class;
        Class<?> reloaded = new ClassReloader().reloadClass(clazz);
        assertEquals(clazz.getName(), reloaded.getName());
        assertFalse(clazz.equals(reloaded));
        assertFalse(clazz.getClassLoader().equals(reloaded.getClassLoader()));
    }
}