package com.qaprosoft.carinademo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url="${base_url}/delete/${id}", methodType = HttpMethodType.DELETE)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeleteEmployeeMethod extends AbstractApiMethodV2 {

    public DeleteEmployeeMethod(String id) {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("dummy_url"));
        replaceUrlPlaceholder("id",id);
    }
}
