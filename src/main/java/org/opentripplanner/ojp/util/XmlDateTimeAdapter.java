/*
 * Licensed under the EUPL, Version 1.2 or - as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 *   https://joinup.ec.europa.eu/software/page/eupl
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */

package org.opentripplanner.ojp.util;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import org.opentripplanner.ojp.time.XmlDateTime;

public class XmlDateTimeAdapter extends XmlAdapter<String, XmlDateTime> {

	public static final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
		.parseCaseInsensitive()
		.parseLenient()
		.append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
		.optionalStart()
		.parseStrict()
		.appendOffset("+HH:MM:ss", "Z")
		.parseLenient()
		.optionalEnd()
		.optionalStart()
		.appendOffset("+HHmmss", "Z")
		.optionalEnd()
		.toFormatter();

	@Override
	public XmlDateTime unmarshal(String inputDate) {
		var temporal = formatter.parse(inputDate);
		if(temporal.isSupported(ChronoField.OFFSET_SECONDS)) {
			var zdt = ZonedDateTime.from(temporal);
			return new XmlDateTime(zdt);
		}
		else {
			var ldt = LocalDateTime.from(temporal);
			return new XmlDateTime(ldt);
		}
	}

	@Override
	public String marshal(XmlDateTime inputDate) {
		if(inputDate != null) {
			return inputDate.toString();
		} else {
			return null;
		}
	}

}
