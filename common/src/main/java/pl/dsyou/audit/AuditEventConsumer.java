package pl.dsyou.audit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
class AuditEventConsumer {

    private final AuditEventWriter auditEventWriter;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void consumeAuditEvents(AuditEvent auditEvent) {
        auditEventWriter.persistEvent(auditEvent);
    }
}
