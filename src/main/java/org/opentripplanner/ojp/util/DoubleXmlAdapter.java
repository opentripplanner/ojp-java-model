package org.opentripplanner.ojp.util;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.math.BigDecimal;

/**
 * {@code XmlAdapter} mapping xs:decimal to Java double
 *
 * @see jakarta.xml.bind.annotation.adapters.XmlAdapter
 */
public class DoubleXmlAdapter extends XmlAdapter<String, Double> {
    @Override
    public Double unmarshal(String stringValue) {
        return stringValue != null ? Double.parseDouble(stringValue) : null;
    }

    @Override
    public String marshal(Double value) {
        return value != null ? value.toString() : null;
    }
}
