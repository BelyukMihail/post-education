package com.qaprosoft.carinademo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url="${base_url}/create", methodType = HttpMethodType.POST)
@RequestTemplatePath(path="api/employee/_post/rq.json")
@ResponseTemplatePath(path="api/employee/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostEmployeeMethod extends AbstractApiMethodV2 {

    public PostEmployeeMethod() {
        super("api/employee/_post/rq.json", "api/employee/_post/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("dummy_url"));
    }
}
