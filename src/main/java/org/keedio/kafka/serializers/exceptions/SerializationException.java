package org.keedio.kafka.serializers.exceptions;

/**
 * Exception thrown by the encoder on serialization error.
 *
 * Created by Luca Rosellini lrosellini@keedio.com on 7/7/15.
 */
public class SerializationException extends RuntimeException {
    public SerializationException() {
        super();
    }

    public SerializationException(String message) {
        super(message);
    }

    public SerializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerializationException(Throwable cause) {
        super(cause);
    }

    protected SerializationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
