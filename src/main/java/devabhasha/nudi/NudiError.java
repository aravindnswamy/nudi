package devabhasha.nudi;

public class NudiError extends RuntimeException {

    public NudiError(Throwable throwable) {
        super(throwable);
    }

    public NudiError(String message) {
        super(message);
    }
}
