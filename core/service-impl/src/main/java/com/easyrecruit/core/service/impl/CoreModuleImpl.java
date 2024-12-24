package com.easyrecruit.core.service.impl;

import com.easyrecruit.core.service.api.CoreModule;
import com.easyrecruit.core.service.impl.service.AppUserService;
import com.easyrecruit.core.service.impl.service.AuthService;

//@Service
public abstract class CoreModuleImpl implements CoreModule {
//    @Delegate
    private AuthService authService;
//    @Delegate
    private AppUserService appUserService;

}
