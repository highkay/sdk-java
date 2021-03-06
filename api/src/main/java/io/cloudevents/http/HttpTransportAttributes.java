/**
 * Copyright 2018 The CloudEvents Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.cloudevents.http;

import io.cloudevents.SpecVersion;

import static io.cloudevents.SpecVersion.V_01;

public interface HttpTransportAttributes {

    // required attrs
    String typeKey();
    String specVersionKey();
    String sourceKey();
    String idKey();

    // none-required attrs
    String timeKey();
    String schemaUrlKey();

    static HttpTransportAttributes getHttpAttributesForSpec(final SpecVersion specVersion) {

        switch (specVersion) {

            case V_01: return new V01HttpTransportMappers();
            case V_02:
            case DEFAULT: return new V02HttpTransportMappers();
        }

        // you should not be here!
        throw new IllegalArgumentException("Could not find proper version");
    }
}
