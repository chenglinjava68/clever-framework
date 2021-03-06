package com.toquery.framework.example.dao;

import com.toquery.framework.example.entity.BizNews;
import io.github.toquery.framework.dao.annotation.JpaParam;
import io.github.toquery.framework.dao.annotation.MybatisParam;
import io.github.toquery.framework.dao.annotation.MybatisQuery;
import io.github.toquery.framework.dao.repository.AppJpaBaseRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

/**
 * 通过
 *
 * @author toquery
 * @version 1
 */
@SuppressWarnings("MybatisMapperMethodInspection")
public interface IBizNewsRepository extends AppJpaBaseRepository<BizNews, Long> {

    /**
     * jpa 注解方式查询
     */
    @Query("from BizNews where title like :title")
    List<BizNews> findJpaByTitle(@JpaParam("title") String title);

    /**
     * jpa method 方式查询
     */
    List<BizNews> findByTitleLike(String title);

    /**
     * mybatis 方式查询
     */
    @Mapper
    @MybatisQuery
    List<BizNews> findMyBatisByTitle(@MybatisParam("title") String title);

    @Mapper
    @MybatisQuery
    void saveMyBatis(BizNews bizNews);

    @Query("from BizNews where id = :id")
    BizNews findJpaById(@JpaParam("id") Long id);

    @Mapper
    @MybatisQuery
    BizNews findMyBatisById(@MybatisParam("ids") Long id);

    @Mapper
    @MybatisQuery
    BizNews updateMyBatis(BizNews bizNews);

    @Modifying
    @Query("delete from BizNews where id = :id")
    void deleteJpa(@JpaParam("id") Long id);

    @Modifying
    @Query("delete from BizNews where id in :ids")
    void deleteJpaIds(@JpaParam("ids") Collection<Long> ids);

    void deleteBizNewsById(@JpaParam("id") Long id);

    @Mapper
    @MybatisQuery
    void deleteMyBatis(@MybatisParam("ids") Collection<Long> ids);

}

