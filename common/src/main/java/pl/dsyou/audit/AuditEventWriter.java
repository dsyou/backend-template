package pl.dsyou.audit;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AuditEventWriter {

    private final JdbcTemplate jdbcTemplate;

    AuditEventWriter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    void persistEvent(AuditEvent auditEvent) {
        String sqlStatement = createInsert(auditEvent);
        this.jdbcTemplate.update(sqlStatement,
                auditEvent.getAggregateClassName(),
                auditEvent.getAggregateClassName(),
                auditEvent.getCommandClassName(),
                auditEvent.getCommandJson());
    }

    private String createInsert(AuditEvent auditEvent) {
        String tableName = "AUDIT_" + auditEvent.getTableName();
        return "INSERT INTO " +
                tableName +
                "(AGGREGATE_CLASS_NAME, AGGREGATE_UUID, COMMAND_CLASS_NAME, COMMAND_JSON) " +
                "VALUES (?, ?, ?, ?)";
    }
}
