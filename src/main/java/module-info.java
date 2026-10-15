module org.opentripplanner.ojp {
    requires transitive jakarta.xml.bind;
    requires transitive org.apache.commons.lang3;

    exports org.opentripplanner.ojp.schema.ojp;
    exports org.opentripplanner.ojp.schema.siri;
    exports org.opentripplanner.ojp.schema.datex2;
    exports org.opentripplanner.ojp.schema.gml;
    exports org.opentripplanner.ojp.schema.acsb;
    exports org.opentripplanner.ojp.schema.ifopt;
    exports org.opentripplanner.ojp.netex;
    exports org.opentripplanner.ojp.time;
    exports org.opentripplanner.ojp.util;

    opens org.opentripplanner.ojp.schema.ojp;
    opens org.opentripplanner.ojp.schema.siri;
    opens org.opentripplanner.ojp.schema.datex2;
    opens org.opentripplanner.ojp.schema.gml;
    opens org.opentripplanner.ojp.schema.acsb;
    opens org.opentripplanner.ojp.schema.ifopt;
    opens org.opentripplanner.ojp.time;
    opens org.opentripplanner.ojp.util;
}
