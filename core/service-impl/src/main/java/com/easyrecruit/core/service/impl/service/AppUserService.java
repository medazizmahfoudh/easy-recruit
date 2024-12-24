package com.easyrecruit.core.service.impl.service;

import com.easyrecruit.core.dal.entity.AppUserEntity;
import com.easyrecruit.core.dal.entity.AppUserRoleEntity;
import com.easyrecruit.core.dal.repository.AppUserEntityRepository;
import com.easyrecruit.core.dal.repository.AppUserRoleEntityRepository;
import com.easyrecruit.core.service.impl.converter.AppUserRoleConverter;
import com.easyrecruit.core.service.impl.converter.AppUserConverter;
import com.easyrecruit.core.ws.rest.model.entity.AppUser;
import com.easyrecruit.core.ws.rest.model.entity.AppUserRole;
import com.easyrecruit.core.ws.rest.model.payload.VersionResponse;
import net.thevpc.nuts.util.NAssert;
import net.thevpc.nuts.util.NMsg;
import net.thevpc.nuts.util.NOptional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {
    @Autowired
    AppUserRoleEntityRepository roleRepository;
    @Autowired
    AppUserEntityRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    public VersionResponse version() {
        return new VersionResponse();
    }

    public void addUser(AppUser user) {
        NAssert.requireNonNull(user, "user");
        NAssert.requireNull(user.getId(), "id");
        NAssert.requireNonBlank(user.getUsername(), "username");
        NAssert.requireNonBlank(user.getEmail(), "username");
        NAssert.requireNonBlank(user.getPassword(), "password");
        AppUserEntity entity = AppUserConverter.INSTANCE.toEntity(user);
        String p = user.getPassword();
        if (p != null) {
            entity.setPassword(encoder.encode(p));
        }
        userRepository.save(entity);
        user.setId(entity.getId());
    }

    public void updateUser(AppUser user) {
        AppUserEntity old = userRepository.findById(user.getId()).get();
        AppUserEntity entity = AppUserConverter.INSTANCE.toEntity(user);
        String p = entity.getPlainPassword();
        if (p != null) {
            entity.setPassword(encoder.encode(p));
        } else {
            entity.setPassword(old.getPassword());
        }
        userRepository.save(entity);
    }

    public NOptional<AppUser> findUserByNameOrEmail(String name, String email) {
        return NOptional.ofOptional(userRepository.findByUsernameOrEmail(name, email).map(x -> AppUserConverter.fromEntityNoPassword(x)), NMsg.ofC("user %s or %s", name, email));
    }

    public List<AppUser> findUsers() {
        return userRepository.findAll().stream().map(x -> AppUserConverter.fromEntityNoPassword(x)).toList();
    }

    public NOptional<AppUser> findUserByNameOrEmailWithPassword(String name, String email) {
        return NOptional.ofOptional(userRepository.findByUsernameOrEmail(name, email).map(x -> AppUserConverter.INSTANCE.fromEntity(x)), NMsg.ofC("user %s or %s", name, email));
    }

    public NOptional<AppUserRole> findRoleByName(String name) {
        AppUserRoleEntity modRole = name == null ? null : roleRepository.findByName(name).orElse(null);
        return NOptional.ofOptional(Optional.ofNullable(AppUserRoleConverter.INSTANCE.fromEntity(modRole)), NMsg.ofC("user role %s", name));
    }
}
