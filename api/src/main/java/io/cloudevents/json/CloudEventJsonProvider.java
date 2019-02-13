package io.cloudevents.json;

import io.cloudevents.CloudEvent;
import io.cloudevents.Extension;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * spi of cloudevent json.
 *
 * @author
 * @create 2019-01-22 20:49
 **/
public interface CloudEventJsonProvider<T> {

  CloudEvent<T> buildCloudEvent(final String type, final String specversion, final URI source,
      final String id, final ZonedDateTime time, final URI schemaURL, final String contentType,
      final T data, final List<Extension> extensions);
}
