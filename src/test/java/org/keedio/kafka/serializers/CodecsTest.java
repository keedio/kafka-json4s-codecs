package org.keedio.kafka.serializers;

import org.json4s.JsonAST;
import org.json4s.ReaderInput;
import org.json4s.jackson.JsonMethods$;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Luca Rosellini <lrosellini@keedio.com> on 7/7/15.
 */
public class CodecsTest {

    @Test
    public void testEncodeDecode() throws IOException {
        JValueDecoder decoder = new JValueDecoder();
        JValueEncoder encoder = new JValueEncoder();

        JsonAST.JValue jval = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/test/resources/example.json"))){
            jval = JsonMethods$.MODULE$.parse(new ReaderInput(br), false);
        }

        byte[] serialized = encoder.toBytes(jval);

        JsonAST.JValue deserialized = decoder.fromBytes(serialized);

        assertEquals(jval, deserialized);
    }
}
