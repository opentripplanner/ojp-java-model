package org.rutebanken.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A wrapper type to represent the fact that xml xml dateTime can both include local and zoned
 * date times.
 */
public class XmlDateTime {

  private ZonedDateTime zonedDateTime;
  private LocalDateTime localDateTime;

  public XmlDateTime(ZonedDateTime zonedDateTime) {
    this.zonedDateTime = Objects.requireNonNull(zonedDateTime);
  }

  public XmlDateTime(LocalDateTime localDateTime) {
    this.localDateTime = Objects.requireNonNull(localDateTime);
  }

  public ZonedDateTime atZone(ZoneId zoneId) {
    return zonedDateTime != null ? zonedDateTime.withZoneSameInstant(zoneId) : localDateTime.atZone(zoneId);
  }

  /**
   * Returns true if the date time included a zone id (time zone).
   */
  public boolean isZoned() {
    return zonedDateTime != null;
  }

  /**
   * Returns true if the date time did no include a zone id (time zone).
   */
  public boolean isLocal() {
    return localDateTime != null;
  }

  @Override
  public String toString() {
    if(zonedDateTime != null) {
      return zonedDateTime.toString();
    }
    else {
      return localDateTime.toString();
    }
  }
}
