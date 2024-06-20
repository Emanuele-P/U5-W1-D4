package ep2024.u5w1d4.exceptions;


public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(long id) {
        super("The item with id " + id + "has not been found!");
    }
}
