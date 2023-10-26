package pl.dsyou.result;

import java.util.Optional;

public class Result<T extends Body> {

    private final boolean status;
    private Optional<T> body;

    private Result(boolean status) {
        this.status = status;
    }

    private Result(boolean status, T body) {
        this.status = status;
        this.body = Optional.ofNullable(body);
    }

    public static <T extends Body> Result<T> success() {
        return new Result<>(true);
    }

    public static <T extends Body> Result<T> success(T body) {
        return new Result<>(true, body);
    }

    public static <T extends Body> Result<T> failure() {
        return new Result<>(false);
    }

    public T getBody() {
        return this.body.orElseThrow(ResultEmptyException::new);
    }

    public boolean isSuccess() {
        return this.status;
    }

}
