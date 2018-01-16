package com.devbadger.securityapp.security;

import com.devbadger.securityapp.model.JwtAuthenticationToken;
import com.devbadger.securityapp.model.JwtUserDetails;
import com.devbadger.securityapp.service.APPSecurityValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {


    @Autowired
    private APPSecurityValidationService service;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
        String jwt = jwtAuthenticationToken.getToken();

        com.devbadger.security.model.User flexUser = service.validateAndMore(jwt);

        if (flexUser == null) {
            throw new RuntimeException("JWT Token is incorrect");
        }

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("admin");
        return new JwtUserDetails(flexUser.getSessionId(), flexUser.getStoreId(),
                jwt,
                grantedAuthorities);


//
//  TODO from example....
//        FlexUser flexUser = validator.validate(token);
//
//        if (flexUser == null) {
//            throw new RuntimeException("JWT Token is incorrect");
//        }
//
//        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
//                .commaSeparatedStringToAuthorityList(flexUser.getRole());
//        return new JwtUserDetails(flexUser.getSessionId(), flexUser.getRepId(),
//                token,
//                grantedAuthorities);

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
    }
}
