package exceptions;

public class ApiRequestExeption extends RuntimeException {
    public ApiRequestExeption(String mensaje, Throwable cause){
        super(mensaje, cause);
    }
}
