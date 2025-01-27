package solidCorrect.exceptions;

import java.io.IOException;

public class ProcessExceptionUi extends RuntimeException {
    public ProcessExceptionUi(IOException message) {
        super("Failed to present user interface: " + message);
    }
}
