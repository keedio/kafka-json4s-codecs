package org.keedio.kafka.serializers;

import org.json4s.JsonAST;
import org.keedio.kafka.serializers.exceptions.SerializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Luca Rosellini <lrosellini@keedio.com> on 7/7/15.
 */
public class JValueEncoder implements kafka.serializer.Encoder<JsonAST.JValue> {
    private static final Logger LOG = LoggerFactory.getLogger(JValueEncoder.class);

    public byte[] toBytes(JsonAST.JValue jValue) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(jValue);

            return baos.toByteArray();

        } catch (IOException e) {
            LOG.error("Exception", e);

            throw new SerializationException(e);
        }
    }
}
