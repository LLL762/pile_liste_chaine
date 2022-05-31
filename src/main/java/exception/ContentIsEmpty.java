package exception;

/**
 * 30/05/2022.
 *
 * @author Laurent Lamiral
 */
public class ContentIsEmpty extends RuntimeException {

    public ContentIsEmpty() {
    }

    public ContentIsEmpty(String message) {
        super(message);
    }

    public ContentIsEmpty(String message, Throwable cause) {
        super(message, cause);
    }

    public ContentIsEmpty(Throwable cause) {
        super(cause);
    }

    public ContentIsEmpty(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
