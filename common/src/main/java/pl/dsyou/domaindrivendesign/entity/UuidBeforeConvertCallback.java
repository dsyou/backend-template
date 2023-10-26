package pl.dsyou.domaindrivendesign.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;

import java.util.UUID;

@Configuration
class UuidBeforeConvertCallback {

    @Bean
    BeforeConvertCallback<AggregateRootAbstract> beforeConvertCallback(){
        return (entity) -> {
            if (entity.uuid == null) {
                entity.uuid = UUID.randomUUID().toString().toUpperCase();
            }
            return entity;
        };
    }
}
