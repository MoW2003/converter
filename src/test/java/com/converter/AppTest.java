package com.converter;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.converter.type.Binary;
import com.converter.type.Morse;

public class AppTest {

    @Test
    public void  toMorseTest() {
        assertEquals(".- ", Morse.convertToMorse("a"));
        assertEquals(".- -... ", Morse.convertToMorse("aB"));
        assertEquals(".- / -... / -.-. ", Morse.convertToMorse("a b c"));
        assertEquals(".- . ", Morse.convertToMorse("a."));
        assertEquals(".... . .-.. .-.. --- / ..--- ----- ..--- ...-- ! ", Morse.convertToMorse("hello 2023!"));
    }

    @Test
    public void fromMorseTest() {
        assertEquals("a", Morse. convertFromMorse(".- "));
        assertEquals("ab", Morse. convertFromMorse(".- -... "));
        assertEquals("a b c", Morse. convertFromMorse(".- / -... / -.-. "));
        // assertEquals("a.", MorseCode. convertFromMorse(".- . "));
        assertEquals("hello 2023!", Morse. convertFromMorse(".... . .-.. .-.. --- / ..--- ----- ..--- ...-- ! "));
    }

    @Test
    public void toBinaryTest() {
        assertEquals("01100001 00100000 ", Binary.convertToBinary("a "));
        assertEquals("01001000 01100101 01101100 01101100 01101111 ", Binary.convertToBinary("Hello"));
    }

    @Test
    public void fromBinaryTest() {
        assertEquals("a", Binary.convertFromBinary("01100001"));
        assertEquals("hello", Binary.convertFromBinary("01101000 01100101 01101100 01101100 01101111"));
    }
}
