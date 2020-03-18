package nl.han.dea.persistence;

public class PersistenceException extends RuntimeException {

    public PersistenceException(String message, Exception cause) {
        super(message, cause);

    }
}
