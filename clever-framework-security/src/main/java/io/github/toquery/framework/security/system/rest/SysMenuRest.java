package io.github.toquery.framework.security.system.rest;

import com.google.common.collect.Sets;
import io.github.toquery.framework.curd.controller.AppBaseCurdController;
import io.github.toquery.framework.security.system.domain.SysMenu;
import io.github.toquery.framework.security.system.service.ISysMenuService;
import io.github.toquery.framework.webmvc.domain.ResponseParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author toquery
 * @version 1
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuRest extends AppBaseCurdController<ISysMenuService, SysMenu, Long> {

    @GetMapping
    public ResponseParam query() {
        return super.query();
    }

    @GetMapping("/list")
    public ResponseParam list() {
        return super.list();
    }

    @GetMapping("/tree")
    public ResponseParam tree() {
        List<SysMenu> sysMenuList = service.findTree();
        return ResponseParam.builder().build().content(sysMenuList);
    }

    @GetMapping("/permission")
    public ResponseParam permission() {
        List<SysMenu> sysMenuList = service.permission();
        return ResponseParam.builder().build().content(sysMenuList);
    }

    @PostMapping
    public ResponseParam save(@Validated @RequestBody SysMenu sysMenu) {
        return super.handleResponseParam(service.saveMenu(sysMenu));
    }

    @PutMapping
    public ResponseParam update(@RequestBody SysMenu menu) {
        return super.update(menu, Sets.newHashSet("name", "code"));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("{id}")
    public ResponseParam detail(@PathVariable Long id) {
        return super.detail(id);
    }
}
