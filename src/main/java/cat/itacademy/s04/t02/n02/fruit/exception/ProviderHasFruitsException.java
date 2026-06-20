package cat.itacademy.s04.t02.n02.fruit.exception;

public class ProviderHasFruitsException extends RuntimeException {

    public ProviderHasFruitsException() {
        super("Provider cannot be deleted because it has associated fruits");
    }
}
