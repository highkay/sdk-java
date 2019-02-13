package io.cloudevents.json;

import io.cloudevents.CloudEvent;
import io.cloudevents.Extension;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * spi impl of CloudEventJsonProvider
 *
 * @author
 * @create 2019-01-22 21:15
 **/
public class CloudEventJsonJacksonProvider<T> implements CloudEventJsonProvider<T> {

  @Override
  public CloudEvent<T> buildCloudEvent(String type, String specversion,
      URI source, String id, ZonedDateTime time, URI schemaURL,
      String contentType, T data, List<Extension> extensions) {
    return new CloudEventJsonJackBuilderImpl<T>(type, specversion, source, id, time, schemaURL,
        contentType,
        data, extensions);
  }
}
