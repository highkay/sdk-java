/**
 * Copyright 2018 The CloudEvents Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import java.time.ZonedDateTime;
import json.CloudEventJsonFastjsonBuilderImpl;

public final class Json {

  static {
    SerializeConfig.getGlobalInstance().put(ZonedDateTime.class, new ZonedDateTimeDeserializer());
    SerializeConfig.getGlobalInstance().put(ZonedDateTime.class, new ZonedDateTimeSerializer());
  }

  /**
   * Decode a given JSON string to a CloudEvent .
   *
   * @param str the JSON string.
   * @return an instance of CloudEvent
   * @throws IllegalStateException when there is a parsing or invalid mapping.
   */
  public static CloudEventJsonFastjsonBuilderImpl decodeCloudEvent(final String str)
      throws IllegalStateException {
    return decodeValue(str, CloudEventJsonFastjsonBuilderImpl.class);
  }

  /**
   * Decode a given JSON string to a POJO of the given class type.
   *
   * @param str the JSON string.
   * @param clazz the class to map to.
   * @param <T> the generic type.
   * @return an instance of T
   * @throws IllegalStateException when there is a parsing or invalid mapping.
   */
  protected static <T> T decodeValue(final String str, final Class<T> clazz)
      throws IllegalStateException {
    try {
      return JSON.parseObject(str, clazz);
    } catch (Exception e) {
      throw new IllegalStateException("Failed to decode: " + e.getMessage());
    }
  }

  /**
   * Decode a given JSON string to a POJO of the given type.
   *
   * @param str the JSON string.
   * @param type the type to map to.
   * @param <T> the generic type.
   * @return an instance of T
   * @throws IllegalStateException when there is a parsing or invalid mapping.
   */
  public static <T> T decodeValue(final String str, final TypeReference<T> type)
      throws IllegalStateException {
    try {
      return JSON.parseObject(str, type);
    } catch (Exception e) {
      throw new IllegalStateException("Failed to decode: " + e.getMessage(), e);
    }
  }

  private Json() {
    // no-op
  }
}
