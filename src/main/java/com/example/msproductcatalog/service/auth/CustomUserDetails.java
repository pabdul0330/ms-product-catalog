//package com.example.msproductcatalog.service.auth;
//
//import com.example.msproductcatalog.dao.entity.UserEntity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//


//public class CustomUserDetails implements UserDetails {
//    private final String username;
//    private final String password;
//    private final List<GrantedAuthority> grantedAuthorities;
//
//    CustomUserDetails(UserEntity entity) {
//        this.username = entity.getUsername();
//        this.password = entity.getPassword();
//        this.grantedAuthorities = entity
//                .getRoles()
//                .stream()
//                .map(roleEntity ->
//                        new SimpleGrantedAuthority(roleEntity.getName()))
//                .collect(Collectors.toList());
//    }
//
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return grantedAuthorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
