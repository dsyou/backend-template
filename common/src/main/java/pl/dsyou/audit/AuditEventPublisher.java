package pl.dsyou.audit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dsyou.command.Command;

@Component
@RequiredArgsConstructor
public class AuditEventPublisher {

    private final ObjectMapper objectMapper;

    public void publishEvent(Class<?> aggregate, String aggregateUUID, Command command, String tableName) {
        String aggregateClassName = aggregate.getCanonicalName();
        String commandToJson = mapCommandToJson(command);
        String commandClassName = command.getClass().getCanonicalName();
        new AuditEvent(aggregateClassName, aggregateUUID, commandClassName, commandToJson, tableName);
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
