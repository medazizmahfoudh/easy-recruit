package com.easyrecruit.management.service.api;

import com.easyrecruit.management.infra.model.document.Cv;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CvModule {

    void saveCv(Cv cv);
    Cv updateCv(String cvUuid, MultipartFile file);
    Cv getCvByApplicationUuid(String applicationUuid);
    Cv getCvByUuid(String uuid);
    List<Cv> getAllCvs();
    DeleteResponse deleteCv(Cv cv);
    DeleteResponse deleteCvByApplicationUuid(String applicationUuid);
    DeleteResponse deleteAll();


}
