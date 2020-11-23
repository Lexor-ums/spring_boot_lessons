package com.example.spring_lesson.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    private Set<Actor> actors;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_rermission",
            joinColumns = @JoinColumn(name = "permission_id")
            //            ,
//            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Permission> permissions;

}
