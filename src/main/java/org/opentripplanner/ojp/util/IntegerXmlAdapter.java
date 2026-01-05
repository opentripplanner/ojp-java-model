package org.opentripplanner.ojp.util;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@code XmlAdapter} mapping xs:integer to Java Integer
 *
 * @see jakarta.xml.bind.annotation.adapters.XmlAdapter
 */
public class IntegerXmlAdapter extends XmlAdapter<String, Integer> {
    @Override
    public Integer unmarshal(String stringValue) {
        return stringValue != null ? Integer.parseInt(stringValue) : null;
    }

    @Override
    public String marshal(Integer value) {
        return value != null ? value.toString() : null;
    }
}
