package com.easyrecruit.core.service.impl.service;

import com.easyrecruit.core.dal.repository.AppLogEntityRepository;
import com.easyrecruit.core.service.impl.converter.AppLogConverter;
import com.easyrecruit.core.ws.rest.App;
import com.easyrecruit.core.ws.rest.model.common.AppException;
import com.easyrecruit.core.ws.rest.model.common.AppLogLevel;
import com.easyrecruit.core.ws.rest.model.common.AppLogVerb;
import com.easyrecruit.core.ws.rest.model.common.AppPrincipal;
import com.easyrecruit.core.ws.rest.model.entity.AppLog;
import com.easyrecruit.core.ws.rest.util.ValidationUtils;
import net.thevpc.nuts.util.NBlankable;
import net.thevpc.nuts.util.NStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class LogService {
    private static final Logger LOG = LoggerFactory.getLogger(LogService.class);
    @Autowired
    @Lazy
    private AppLogEntityRepository logRepository;
    public void doLogError(Throwable throwable, String groupName) {
        AppLog log = new AppLog();
        throwable = ValidationUtils.rootException(throwable);
        log.setDescription(ValidationUtils.stacktrace(throwable));
        log.setMessage(NStringUtils.firstNonBlank(throwable.getMessage(), "Error"));
        if (throwable instanceof AppException) {
            String code = ((AppException) throwable).getInfo().getCode();
            if (code != null) {
                log.setCode(code);
            }
        }
        if (log.getCode() == null) {
            log.setCode("Exception::" + throwable.getClass().getName());
        }
        log.setGroupName(groupName);
        log.setLevel(AppLogLevel.SEVERE);
    }

    public void doLog(AppLog log) {
        if (log.getAccount() == null) {
            AppPrincipal principal = App.principal().orNull();
            log.setAccount(principal==null?null:principal.getUsername());
        }
        if (log.getVerb() == null) {
            log.setVerb(AppLogVerb.DEFAULT);
        }
        if (NBlankable.isBlank(log.getCode())) {
            log.setCode("DEFAULT");
        }
        if (NBlankable.isBlank(log.getGroupName())) {
            log.setGroupName("DEFAULT");
        }
        if (NBlankable.isBlank(log.getCode())) {
            log.setCode("DEFAULT");
        }
        if (NBlankable.isBlank(log.getLevelValue())) {
            log.setLevel(AppLogLevel.FINE);
        }
        log.setDate(Instant.now());
        log.setLevelValue(log.getLevel().ordinal());
        log.setCode(ValidationUtils.truncate(log.getCode(), 255));
        log.setMessage(ValidationUtils.truncate(log.getMessage(), 1024));
        log.setDescription(ValidationUtils.truncate(log.getDescription(), 8192));
        logRepository.save(AppLogConverter.INSTANCE.toEntity(log));
        LOG.atLevel(convertJULToSLF4J(log.getLevel().toJULLevel())).log("[{}][{}][{}][{}]{}",log.getTenant(), log.getGroupName(), log.getCode(), log.getVerb(), log.getMessage());
    }
    public static Level convertJULToSLF4J(java.util.logging.Level julLevel) {
        int logLevel = julLevel.intValue();
        if(logLevel<=300){
            //FINEST
            return Level.DEBUG;
        }
        if(logLevel<=400){
            return Level.DEBUG;
        }
        if(logLevel<=500){
            return Level.TRACE;
        }
        if(logLevel<=700){
            //CONFIG
            return Level.INFO;
        }
        if(logLevel<=800){
            return Level.INFO;
        }
        if(logLevel<=900){
            return Level.WARN;
        }
        if(logLevel<=1000){
            return Level.ERROR;
        }
        //ALL
        return Level.ERROR;
    }

}
