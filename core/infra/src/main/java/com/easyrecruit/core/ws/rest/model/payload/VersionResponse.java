package com.easyrecruit.core.ws.rest.model.payload;

import com.easyrecruit.core.ws.rest.App;
import lombok.Data;

@Data
public class VersionResponse {
    private String version= App.API_VERSION;
}
