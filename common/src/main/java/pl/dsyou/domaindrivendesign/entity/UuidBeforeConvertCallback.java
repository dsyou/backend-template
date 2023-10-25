package pl.dsyou.domaindrivendesign.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;

@Configuration
class UuidBeforeConvertCallback {

    @Bean
    BeforeConvertCallback<AggregateRootAbstract> beforeConvertCallback(){

        return null;
    }
}
