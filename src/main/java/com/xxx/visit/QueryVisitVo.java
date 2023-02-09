package com.xxx.visit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import shz.orm.annotation.Where;
import shz.orm.enums.Condition;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class QueryVisitVo {
    @Where(condition = Condition.BETWEEN)
    private List<LocalDateTime> createTime;
    @Where
    private String appName;
    @Where(condition = Condition.BETWEEN)
    private List<LocalDateTime> destroyedTime;
    @Where(condition = Condition.BETWEEN)
    private List<Long> elapsedTime;
    @Where
    private Boolean login;
    @Where
    private Long userid;
    @Where(condition = Condition.LIKE)
    private String username;
    @Where
    private String ip;
    @Where
    private Integer port;
    @Where
    private String mac;
    @Where(condition = Condition.LIKE)
    private String path;
    @Where
    private String method;
    @Where(condition = Condition.LIKE)
    private String referer;
    @Where
    private Boolean exception;
    @Where
    private Integer exceptionCode;
    @Where(condition = Condition.LIKE)
    private String exceptionMsg;
    @Where(condition = Condition.LIKE)
    private String browser;
    @Where(condition = Condition.LIKE)
    private String browserVersion;
    @Where(condition = Condition.LIKE)
    private String os;
    @Where
    private Boolean ajax;
}
