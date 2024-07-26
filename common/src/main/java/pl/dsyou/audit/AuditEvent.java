package pl.dsyou.audit;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@Getter
@ToString
public class AuditEvent extends ApplicationEvent {

    private final String aggregateClassName;
    private final String aggregateUUID;
    private final String commandClassName;
    private final String commandJson;
    private final String tableName;

    public AuditEvent(String aggregateClassName,
                      String aggregateUUID,
                      String commandClassName,
                      String commandJson,
                      String tableName) {

        super(new Object());
        this.aggregateClassName = aggregateClassName;
        this.aggregateUUID = aggregateUUID;
        this.commandClassName = commandClassName;
        this.commandJson = commandJson;
        this.tableName = tableName;
    }

}
