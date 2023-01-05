package com.qaprosoft.carinademo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/update/${id}", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/employee/_put/rq.json")
@ResponseTemplatePath(path = "api/employee/_put/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PutEmployeeMethod extends AbstractApiMethodV2 {

    public PutEmployeeMethod(String id) {
        super("api/employee/_put/rq.json", "api/employee/_put/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("dummy_url"));
        replaceUrlPlaceholder("id", id);
    }
}
