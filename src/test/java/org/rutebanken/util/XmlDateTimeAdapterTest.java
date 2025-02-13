package org.rutebanken.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class XmlDateTimeAdapterTest {

  @ParameterizedTest
  @ValueSource(strings = {
    "2025-02-13T17:30:15+02:00",
    "2025-02-13T17:30:15+0200",
    "2025-02-13T17:30:15Z",
    "2025-02-13T17:30:15.010+02:00",
    "2025-02-13T17:30:15.0+02:00",
    "2025-02-13T17:30:15.100+02:00",
    "2025-02-13T17:30:15.099+02:00",
    "2025-02-13T17:30:15.99+02:00",
  })
  void withZone(String input){
    var adapter = new XmlDateTimeAdapter();
    var time = adapter.unmarshal(input);
    assertTrue(time.isZoned());
  }

  @ParameterizedTest
  @ValueSource(strings = {
    "2025-02-13T17:30:15",
    "2025-02-13T17:30:15.10",
    "2025-02-13T17:30:15.999",
  })
  void withoutZone(String input){
    var adapter = new XmlDateTimeAdapter();
    var xmlDate = adapter.unmarshal(input);
    assertTrue(xmlDate.isLocal());
  }
}