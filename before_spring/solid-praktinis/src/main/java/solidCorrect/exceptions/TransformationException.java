package solidCorrect.exceptions;

import solidCorrect.TransformType;

public class TransformationException extends RuntimeException {
    public TransformationException(TransformType message) {
        super("Transformation type is not supported: " + message);
    }
}
