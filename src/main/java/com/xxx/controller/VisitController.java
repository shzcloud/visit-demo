package com.xxx.controller;

import com.xxx.visit.QueryVisitVo;
import com.xxx.visit.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shz.core.model.PageInfo;
import shz.core.model.Response;
import shz.spring.model.PageVo;
import shz.visit.entity.SysVisit;

import javax.validation.Valid;

/**
 * 系统访问记录
 */
@RestController
@RequestMapping("/system/v1/visit")
public class VisitController {
    @Autowired
    VisitService visitService;

    /**
     * 系统访问记录分页列表
     */
    @PostMapping("page")
    public Response<PageInfo<SysVisit>> page(@RequestBody @Valid PageVo<QueryVisitVo, SysVisit> pageVo) {
        PageInfo<SysVisit> page = visitService.page(pageVo);
        return Response.ok(page);
    }
}
