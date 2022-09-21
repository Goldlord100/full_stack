package fr.polytech.fsback.exception;

public class IdDoesntExistException extends RuntimeException {

    public IdDoesntExistException(String message){
        super(message);
    }
}
