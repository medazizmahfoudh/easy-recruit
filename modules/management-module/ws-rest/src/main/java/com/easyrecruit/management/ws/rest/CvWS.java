package com.easyrecruit.management.ws.rest;

import com.easyrecruit.management.infra.model.Cv;
import com.easyrecruit.management.service.api.CvModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/cv")
public class CvWS {

    @Autowired
    private CvModule cvModule;

    @PutMapping(value = "/update/{cvUuid}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Cv> updateCv(@PathVariable("cvUuid") String cvUuid, @RequestPart("file") MultipartFile file) {
        return new ResponseEntity<>(cvModule.updateCv(cvUuid, file), HttpStatus.ACCEPTED);
    }
}
