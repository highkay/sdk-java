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

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.time.DateTimeException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeDeserializer implements ObjectDeserializer {

  @Override
  public ZonedDateTime deserialze(DefaultJSONParser defaultJSONParser, Type type, Object object) {
    try {
      return ZonedDateTime
          .parse(defaultJSONParser.getInput(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    } catch (DateTimeException e) {
      throw new IllegalArgumentException("could not parse");
    }
  }

  @Override
  public int getFastMatchToken() {
    return 0;
  }
}
