/*
 * Copyright 2015 Stormpath, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stormpath.sdk.impl.ds;

import com.stormpath.sdk.impl.http.CanonicalUri;
import com.stormpath.sdk.lang.Assert;
import com.stormpath.sdk.lang.Collections;
import com.stormpath.sdk.resource.Resource;

import java.util.Map;

public class DefaultResourceDataRequest extends DefaultResourceMessage implements ResourceDataRequest {

    private final ResourceAction action;

    public DefaultResourceDataRequest(ResourceAction action, CanonicalUri uri, Class<? extends Resource> resourceClass, Map<String,Object> data) {
        super(uri, resourceClass, data);
        Assert.notNull(action, "resource action cannot be null.");
        Assert.isTrue(action == ResourceAction.READ || action == ResourceAction.DELETE || !Collections.isEmpty(data),
                      "CREATE or UPDATE requests cannot have null or empty data.");
        this.action = action;
    }

    @Override
    public ResourceAction getAction() {
        return action;
    }
}
