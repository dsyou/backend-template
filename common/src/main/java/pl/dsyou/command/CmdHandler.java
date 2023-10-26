package pl.dsyou.command;

import pl.dsyou.result.Body;
import pl.dsyou.result.Result;

public interface CmdHandler<T extends Command, R extends Body> {
    Result<R> handle(T command);
}
