package pl.dsyou.command;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Command {
    private final String uuid;
    private final LocalDateTime createdAt;

    public Command() {
        this.uuid = UUID.randomUUID().toString().toUpperCase();
        this.createdAt = LocalDateTime.now();
    }
}
