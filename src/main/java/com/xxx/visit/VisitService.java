package com.xxx.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shz.core.function.ActionRunner;
import shz.core.model.PageInfo;
import shz.jdbc.JdbcService;
import shz.orm.ClassInfo;
import shz.orm.record.RecordService;
import shz.spring.model.PageVo;
import shz.visit.entity.SysVisit;

import java.util.Comparator;

@Service
public class VisitService extends RecordService<SysVisit> {
    final JdbcService jdbcService;

    @Autowired
    public VisitService(JdbcService jdbcService) {
        this.jdbcService = jdbcService;
    }

    public PageInfo<SysVisit> page(PageVo<QueryVisitVo, SysVisit> pageVo) {
        QueryVisitVo reqVo = pageVo.getData();
        ClassInfo classInfo = jdbcService.nonNullClassInfo(SysVisit.class);
        ActionRunner<SysVisit> runner = runner(selectMap(new SysVisit()), null, null, null, 0, null, null, jdbcService.whereSql(classInfo, reqVo, null, false));
        return page(pageVo.map(), runner, classInfo, null, Comparator.comparing(SysVisit::getCreateTime));
    }
}
