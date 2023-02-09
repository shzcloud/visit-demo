package com.xxx.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shz.visit.entity.SysVisitData;
import shz.visit.recorder.VisitDataRecorder;

@Component
class DefaultVisitDataRecorder implements VisitDataRecorder {
    final VisitDataService service;

    @Autowired
    DefaultVisitDataRecorder(VisitDataService service) {
        this.service = service;
    }

    @Override
    public void accept(SysVisitData visitData) {
        //TODO 这里应该先到MQ再插入数据库避免突发流量的冲击,此处省略
        service.insert(visitData);
    }
}
