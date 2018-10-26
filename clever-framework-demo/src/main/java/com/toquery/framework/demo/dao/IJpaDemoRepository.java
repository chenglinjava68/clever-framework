package com.toquery.framework.demo.dao;

import com.toquery.framework.demo.entity.TbJpaDemo;
import io.github.toquery.framework.dao.repository.AppJpaBaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author toquery
 * @version 1
 */
//@Repository
//public interface IJpaDemoRepository extends JpaRepository<TbJpaDemo, Long> {

@RepositoryRestResource(path = "test2")
public interface IJpaDemoRepository extends AppJpaBaseRepository<TbJpaDemo, Long> {

    @Query("from TbJpaDemo where name = :name")
    public TbJpaDemo getByName(@Param("name") String name);
}