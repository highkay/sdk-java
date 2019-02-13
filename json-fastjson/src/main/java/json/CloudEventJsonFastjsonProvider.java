package json;

import io.cloudevents.CloudEvent;
import io.cloudevents.Extension;
import io.cloudevents.json.CloudEventJsonProvider;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * spi impl of CloudEventJsonProvider
 *
 * @author
 * @create 2019-01-22 21:15
 **/
public class CloudEventJsonFastjsonProvider<T> implements CloudEventJsonProvider<T> {

  @Override
  public CloudEvent<T> buildCloudEvent(String type, String specversion,
      URI source, String id, ZonedDateTime time, URI schemaURL,
      String contentType, T data, List<Extension> extensions) {
    return new CloudEventJsonFastjsonBuilderImpl<T>(type, specversion, source, id, time, schemaURL,
        contentType,
        data, extensions);
  }
}
