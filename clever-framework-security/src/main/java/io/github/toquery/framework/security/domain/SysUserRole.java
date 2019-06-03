package io.github.toquery.framework.security.domain;

import io.github.toquery.framework.dao.entity.AppBaseEntityPrimaryKeyLong;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * A user.
 */
//@Entity
//@Getter
//@Setter
//@Table(name = "sys_user_role")
public class SysUserRole extends AppBaseEntityPrimaryKeyLong {

//    @Column(name = "user_id")
//     private Long userId;

//    @JsonView(SysRole.class)
//    @JsonIgnoreProperties("roles")
//    @LazyCollection(LazyCollectionOption.FALSE)
//    @JsonBackReference
//    @JsonManagedReference
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")


//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_role"))
//    private SysUser user;


//    @Column(name = "role_id")
//    private Long roleId;
//    @JsonView(SysUser.class)
//    @JsonIgnoreProperties("users")
//    @LazyCollection(LazyCollectionOption.FALSE)
//    @JsonBackReference
//    @JsonManagedReference
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "fk_role_user"))
//    private SysRole role;
}