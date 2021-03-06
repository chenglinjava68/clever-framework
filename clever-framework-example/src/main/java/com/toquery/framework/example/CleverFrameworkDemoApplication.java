package com.toquery.framework.example;


import io.github.toquery.framework.dao.EnableAppJpaRepositories;
import io.github.toquery.framework.data.rest.annotation.EnableAppRepositoryRest;
import io.github.toquery.framework.web.dict.annotation.AppDictScan;
import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author toquery
 * @version 1
 */
//@Import(AppRepositoryRestMvcConfiguration.class)
//@SpringBootApplication  (exclude = RepositoryRestMvcAutoConfiguration.class)
//@EntityScan // (basePackages = {"io.github.toquery.framework.security.domain", "com.toquery.framework.demo.entity"})
//@EnableAppJpaRepositories //(basePackages = {"io.github.toquery.framework.security", "com.toquery.framework.demo"})
//@EnableAppRepositoryRest

@AppDictScan
//@AppDictScan(basePackage = "com.toquery.framework.demo.constant")
@EntityScan
@EnableAppRepositoryRest
@EnableAppJpaRepositories
@SpringBootApplication //(scanBasePackages = "com.toquery.framework.demo")
public class CleverFrameworkDemoApplication {
    public static void main(String[] args) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        SpringApplication.run(CleverFrameworkDemoApplication.class, args);
    }
}
