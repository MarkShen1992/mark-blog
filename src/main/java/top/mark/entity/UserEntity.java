package top.mark.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "t_user")
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "create_user_id")
    private String createUserId;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Column(name = "update_user_id")
    private String updateUserId;

    @Column(name = "is_delete")
    private Boolean deleted;
}
