package com.easyrecruit.core.service.impl.security;

import com.easyrecruit.core.dal.entity.AppUserEntity;
import com.easyrecruit.core.dal.repository.AppUserEntityRepository;
import com.easyrecruit.core.service.impl.converter.AppUserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AppUserEntityRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found" + username));
        return new UserDetailsImpl(AppUserConverter.INSTANCE.fromEntity(user));
    }

}
