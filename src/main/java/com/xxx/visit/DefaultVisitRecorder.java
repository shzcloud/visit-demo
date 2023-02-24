package com.xxx.visit;

import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import shz.kafka.KafkaAcceptor;
import shz.visit.entity.SysVisit;
import shz.visit.recorder.VisitRecorder;
import shz.visit.service.VisitService;

import java.util.List;

@Component
class DefaultVisitRecorder extends KafkaAcceptor<SysVisit> implements VisitRecorder {
    final VisitTaskExecutor executor;
    final VisitService service;

    @Autowired
    DefaultVisitRecorder(@Value("${kafka.bootstrap-servers}") String servers, VisitTaskExecutor executor, VisitService service) {
        super("topic-visit", servers, "group-visit");
        this.executor = executor;
        this.service = service;
    }

    @Override
    public void accept(SysVisit entity) {
        push(entity);
    }

    @Override
    protected void saveOffsetAndExecute(List<SysVisit> entities, TopicPartition partition, long offset) {
        executor.execute(() -> execute0(entities, partition, offset));
    }

    private void execute0(List<SysVisit> entities, TopicPartition partition, long offset) {
        saveOffset(partition, offset);
        service.batchInsert(entities);
    }
}
