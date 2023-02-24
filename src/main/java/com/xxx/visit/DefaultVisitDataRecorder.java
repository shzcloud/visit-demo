package com.xxx.visit;

import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import shz.kafka.KafkaAcceptor;
import shz.visit.entity.SysVisitData;
import shz.visit.recorder.VisitDataRecorder;
import shz.visit.service.VisitDataService;

import java.util.List;

@Component
class DefaultVisitDataRecorder extends KafkaAcceptor<SysVisitData> implements VisitDataRecorder {
    final VisitTaskExecutor executor;
    final VisitDataService service;

    @Autowired
    DefaultVisitDataRecorder(@Value("${kafka.bootstrap-servers}") String servers, VisitTaskExecutor executor, VisitDataService service) {
        super("topic-visit-data", servers, "group-visit-data");
        this.executor = executor;
        this.service = service;
    }

    @Override
    public void accept(SysVisitData entity) {
        push(entity);
    }

    @Override
    protected void saveOffsetAndExecute(List<SysVisitData> entities, TopicPartition partition, long offset) {
        executor.execute(() -> execute0(entities, partition, offset));
    }

    private void execute0(List<SysVisitData> entities, TopicPartition partition, long offset) {
        saveOffset(partition, offset);
        service.batchInsert(entities);
    }
}
