package io.github.toquery.framework.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.toquery.framework.dao.entity.AppBaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.HashSet;

/**
 * An authority (a security role) used by Spring Security.
 */
@Entity
@Getter
@Setter
@Table(name = "sys_role")
//@JsonIgnoreProperties("authors")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class SysRole extends AppBaseEntity implements GrantedAuthority {


    @NotBlank
    @Length(min = 2, max = 50)
    @Column(length = 50)
    private String name;


    /**
     * @deprecated 2020.05.11 不使用角色的code
     */
    @Deprecated
    @NotBlank
    @Length(min = 4, max = 50)
    @Column(length = 50)
    private String code;

/*
    @JsonIgnoreProperties("roles")
//    @JsonBackReference
//    @JsonBackReference
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private Collection<SysUserRole> users = new HashSet<>();
*/

    @JsonIgnoreProperties({"roles", "lastUpdateDatetime", "createDatetime"})
    @ManyToMany // (cascade = CascadeType.ALL)
    @JoinTable(
            name = "sys_user_role",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    @BatchSize(size = 20)
    private Collection<SysUser> users = new HashSet<>();


    @JsonIgnoreProperties({"roles", "lastUpdateDatetime", "createDatetime"})
//    @ManyToMany(cascade={CascadeType.MERGE,CascadeType.REFRESH})

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sys_role_menu",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "menu_id", referencedColumnName = "id")})
    @BatchSize(size = 20)
    private Collection<SysMenu> menus = new HashSet<>();

    @Override
    public String getAuthority() {
        return getCode();
    }
}
