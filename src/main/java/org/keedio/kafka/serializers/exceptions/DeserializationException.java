package org.keedio.kafka.serializers.exceptions;

/**
 * Created by Luca Rosellini <lrosellini@keedio.com> on 7/7/15.
 */
public class DeserializationException extends RuntimeException {
    public DeserializationException() {
        super();
    }

    public DeserializationException(String message) {
        super(message);
    }

    public DeserializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeserializationException(Throwable cause) {
        super(cause);
    }

    protected DeserializationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
