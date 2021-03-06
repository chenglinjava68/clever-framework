package com.toquery.framework.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.toquery.framework.example.constant.BizNewsShowStatus;
import io.github.toquery.framework.common.constant.AppCommonConstant;
import io.github.toquery.framework.core.log.annotation.AppLogEntity;
import io.github.toquery.framework.core.log.annotation.AppLogField;
import io.github.toquery.framework.dao.entity.AppBaseEntity;
import io.github.toquery.framework.dao.entity.AppEntitySoftDel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * @author toquery
 * @version 1
 */
@Slf4j
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@AppLogEntity

@Where(clause = "deleted = false")

@FilterDef(
        name = "gt100",
        parameters = {
                @ParamDef(name = "showNum", type = "int"),
                @ParamDef(name = "likeNum", type = "int")
        }
)
@Filters(value = {
        @Filter(name = "gt100",
                condition = "showNum > :showNum"
        ),
        @Filter(name = "gt100",
                condition = "likeNum > :likeNum"
        )
})


@Entity
@Table(name = "biz_news")
public class BizNews extends AppBaseEntity implements AppEntitySoftDel {


    public BizNews(String title, Date showTime) {
        this.title = title;
        this.showTime = showTime;
    }

    public BizNews(Long id, String title, Date showTime) {
        this.id = id;
        this.title = title;
        this.showTime = showTime;
    }

    @AppLogField("标题")
    @Column
    private String title;

    @AppLogField("查看次数")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "show_num")
    private Long showNum;

    @AppLogField("点赞次数")
    @Column(name = "like_num")
    private Integer likeNum;


    @AppLogField("展示状态")
    @Enumerated(EnumType.STRING)
    @Column(name = "show_status")
    private BizNewsShowStatus showStatus;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "biz_news_type",
            joinColumns = {@JoinColumn(name = "news_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "type_id", referencedColumnName = "id")})
    @BatchSize(size = 20)
    private Collection<BizType> roles = new HashSet<>();

    @AppLogField("显示时间")
    @JsonFormat
    // @JsonFormat(pattern = AppCommonConstant.DATE_TIME_PATTERN, timezone = "GMT+8")
    @Column(name = "show_time")
    private Date showTime;


//    @AppLogField("instant")
//    @DateTimeFormat(pattern = AppCommonConstant.DATE_TIME_PATTERN)
//    @JsonFormat(pattern = AppCommonConstant.DATE_TIME_PATTERN)
//    @Column(name = "instant")
//    private Instant instant;


//    @DateTimeFormat(pattern = AppCommonConstant.DATE_TIME_PATTERN)
//    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
//    @JsonFormat(pattern = AppCommonConstant.DATE_TIME_PATTERN)
//    @Column(name = "local_time")
//    private LocalTime localTime;


//    @DateTimeFormat(pattern = AppCommonConstant.DATE_TIME_PATTERN)
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    @JsonFormat(pattern = AppCommonConstant.DATE_TIME_PATTERN)
//    @Column(name = "local_date")
//    private LocalDate localDate;


//    @DateTimeFormat(pattern = AppCommonConstant.DATE_TIME_PATTERN)
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)

    @JsonFormat(pattern = AppCommonConstant.DATE_TIME_PATTERN)
    @Column(name = "local_date_time")
    private LocalDateTime localDateTime;


//    @DateTimeFormat(pattern = AppCommonConstant.DATE_TIME_PATTERN)
//    @JsonFormat(pattern = AppCommonConstant.DATE_TIME_PATTERN)
//    @Column(name = "offset_time")
//    private OffsetTime offsetTime;

    //    @DateTimeFormat(pattern = AppCommonConstant.DATE_TIME_PATTERN)
    @JsonFormat(pattern = AppCommonConstant.DATE_TIME_PATTERN)
    @Column(name = "offset_date_time")
    private OffsetDateTime offsetDateTime;

    /**
     * 是否删除：1已删除；0未删除
     */
    @ColumnDefault("false")
    @Column(name = "deleted")
    private boolean deleted = false;

    @Override
    public boolean getDeleted() {
        return deleted;
    }


    /*
    @Override
    public void domainEvents() {
        super.domainEvents();
    }

    @Override
    public void afterDomainEventPublication() {
        super.afterDomainEventPublication();
    }
    */
}
