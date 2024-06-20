package ep2024.u5w1d4.exceptions;

public class ItemAlreadyExistsException extends RuntimeException {
    public ItemAlreadyExistsException(String name) {
        super("The item with name " + name + " already exists!");
    }
}
