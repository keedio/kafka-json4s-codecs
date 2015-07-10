package org.keedio.kafka.serializers;

import kafka.utils.VerifiableProperties;
import org.json4s.JsonAST;
import org.keedio.kafka.serializers.exceptions.DeserializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

/**
 * Created by Luca Rosellini <lrosellini@keedio.com> on 7/7/15.
 */
public class JValueDecoder implements kafka.serializer.Decoder<JsonAST.JValue>{
    private static final Logger LOG = LoggerFactory.getLogger(JValueDecoder.class);

    public JValueDecoder() {
        super();
    }

    public JValueDecoder(VerifiableProperties props){
    }


    @Override
    public JsonAST.JValue fromBytes(byte[] bytes) {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        try (ObjectInputStream ois = new ObjectInputStream(bais)){
            return (JsonAST.JValue) ois.readObject();
        } catch (Exception e){
            LOG.error("Caught exception: ",e);

            throw new DeserializationException(e);
        }
    }
}
