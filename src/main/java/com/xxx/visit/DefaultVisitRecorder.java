package com.xxx.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shz.visit.entity.SysVisit;
import shz.visit.recorder.VisitRecorder;

@Component
class DefaultVisitRecorder implements VisitRecorder {
    final VisitService service;

    @Autowired
    DefaultVisitRecorder(VisitService service) {
        this.service = service;
    }

    @Override
    public void accept(SysVisit visit) {
        //TODO 这里应该先到MQ再插入数据库避免突发流量的冲击,此处省略
        service.insert(visit);
    }
}
