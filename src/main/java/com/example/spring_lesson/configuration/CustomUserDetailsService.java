package com.example.spring_lesson.configuration;

import com.example.spring_lesson.model.Actor;
import com.example.spring_lesson.model.Permission;
import com.example.spring_lesson.model.Role;
import com.example.spring_lesson.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final ActorRepository actorRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        try {
            Actor actor = actorRepository.findByLogin(username);

            return new CustomUserDetails(actor.getLogin(),
                    actor.getPassword(), true, true,
                    true, true,
                    getAuthorities(actor.getRoles()));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static class SimpleGrantedAuthorityComparator implements
            Comparator<SimpleGrantedAuthority> {

        @Override
        public int compare(SimpleGrantedAuthority o1, SimpleGrantedAuthority o2) {
            return o1.equals(o2) ? 0 : -1;
        }
    }

    /**
     * Retrieves a collection of {@link GrantedAuthority} based on a list of
     * roles
     *
     * @param roles
     *            the assigned roles of the user
     * @return a collection of {@link GrantedAuthority}
     */
    public Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {

        Set<SimpleGrantedAuthority> authList = new TreeSet<SimpleGrantedAuthority>(
                new SimpleGrantedAuthorityComparator());

        for (Role role : roles) {
            authList.addAll(getGrantedAuthorities(role));
        }

        return authList;
    }

    /**
     * Wraps a {@link Role} role to {@link SimpleGrantedAuthority} objects
     *
     * @param roles
     *            {@link String} of roles
     * @return list of granted authorities
     */
    public static Set<SimpleGrantedAuthority> getGrantedAuthorities(Role role) {

        Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();

        Set<Permission> rolePermissions = role.getPermissions();
        for (Permission permission : rolePermissions) {
            authorities.add(new SimpleGrantedAuthority(permission.getName()));
        }

        return authorities;
    }
}