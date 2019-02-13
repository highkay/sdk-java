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
package json;

import io.cloudevents.CloudEvent;
import io.cloudevents.Extension;
import java.io.Serializable;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Default Java implementation of the CloudEvent API.
 *
 * @param <T> generic type of the underlying data field.
 */
public class CloudEventJsonFastjsonBuilderImpl<T> implements CloudEvent<T>, Serializable {

  private static final long serialVersionUID = 2L;

  private String specversion;
  private String type = null;
  private URI source = null;
  private String id = null;
  private ZonedDateTime time = null;
  private URI schemaURL = null;
  private String contentType = null;
  private T data = null;
  private List<Extension> extensions = null;

  public CloudEventJsonFastjsonBuilderImpl(final String type, final String specversion,
      final URI source,
      final String id, final ZonedDateTime time, final URI schemaURL, final String contentType,
      final T data, final List<Extension> extensions) {
    this.specversion = specversion;
    this.type = type;
    this.source = source;
    this.id = id;
    this.time = time;
    this.schemaURL = schemaURL;
    this.contentType = contentType;
    this.data = data;
    this.extensions = extensions;
  }

  CloudEventJsonFastjsonBuilderImpl() {
    // no-op
  }

  @Override
  public String getSpecVersion() {
    return specversion;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public URI getSource() {
    return source;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public Optional<ZonedDateTime> getTime() {
    return Optional.ofNullable(time);
  }

  @Override
  public Optional<URI> getSchemaURL() {
    return Optional.ofNullable(schemaURL);
  }

  @Override
  public Optional<String> getContentType() {
    return Optional.ofNullable(contentType);
  }

  @Override
  public Optional<T> getData() {
    return Optional.ofNullable(data);
  }

  @Override
  public Optional<List<Extension>> getExtensions() {
    return Optional.ofNullable(extensions);
  }

  // protected setters, used for (JSON) deserialization

  void setSpecversion(String specversion) {
    this.specversion = specversion;
  }

  void setType(String type) {
    this.type = type;
  }

  void setSource(URI source) {
    this.source = source;
  }

  void setId(String id) {
    this.id = id;
  }

  void setTime(ZonedDateTime time) {
    this.time = time;
  }

  void setSchemaURL(URI schemaURL) {
    this.schemaURL = schemaURL;
  }

  void setContentType(String contentType) {
    this.contentType = contentType;
  }

  void setData(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "CloudEventJsonFastjsonBuilderImpl{" +
        "specversion='" + specversion + '\'' +
        ", type='" + type + '\'' +
        ", source=" + source +
        ", id='" + id + '\'' +
        ", time=" + time +
        ", schemaURL=" + schemaURL +
        ", contentType='" + contentType + '\'' +
        ", data=" + data +
        '}';
  }
}
