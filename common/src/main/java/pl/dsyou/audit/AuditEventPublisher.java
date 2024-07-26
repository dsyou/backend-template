package pl.dsyou.audit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import pl.dsyou.command.Command;

@Component
@RequiredArgsConstructor
public class AuditEventPublisher {

    private final ObjectMapper objectMapper;
    private final ApplicationEventPublisher eventPublisher;

    public void publishEvent(Class<?> aggregate, String aggregateUUID, Command command, String tableName) {
        String aggregateClassName = aggregate.getCanonicalName();
        String commandToJson = mapCommandToJson(command);
        String commandClassName = command.getClass().getCanonicalName();
        AuditEvent auditEvent = new AuditEvent(aggregateClassName, aggregateUUID, commandClassName, commandToJson, tableName);
        eventPublisher.publishEvent(auditEvent);
    }

    private String mapCommandToJson(Command command) {
        try {
            return objectMapper.writeValueAsString(command);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
