package com.qaprosoft.carinademo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/employee/${id}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/employee/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetEmployeeMethod extends AbstractApiMethodV2 {

    public GetEmployeeMethod(String id) {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("dummy_url"));
        replaceUrlPlaceholder("id", id);
    }
}
