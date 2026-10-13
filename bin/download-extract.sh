# !/bin/bash -e

# Downloads and extracts VDVDE

PROFILE_PATH="./profile"

ZIPFILE="v${GIT_BRANCH}.zip"

if [ -f $ZIPFILE ]; then
  rm $ZIPFILE
fi

echo "${GITHUB_URL}/archive/$ZIPFILE"

wget -q "${GITHUB_URL}/archive/$ZIPFILE"

echo "Removing contents in $PROFILE_PATH"
rm -rf $PROFILE_PATH/*

unzip $ZIPFILE "${VDVDE_REPO}-${GIT_BRANCH}/*" -d $PROFILE_PATH

rm -r $DESTINATION_PATH
mkdir -p $DESTINATION_PATH

echo $PROFILE_PATH/${VDVDE_REPO}-${GIT_BRANCH}

cp -r $PROFILE_PATH/${VDVDE_REPO}-${GIT_BRANCH}/* $DESTINATION_PATH/.
#cp -r ./xml $DESTINATION_PATH/.

# SIRI ships the xml namespace schema (xml.xsd) under the name XMLSchema.xsd. Since JDK 24 the
# built-in JDK catalog maps every systemId ending in "XMLSchema.xsd" to the W3C schema-for-schemas,
# which breaks the import of xml:lang. Rename the file so the catalog no longer hijacks it.
SIRI_XSD_PATH="$DESTINATION_PATH/siri/xsd"
mv "$SIRI_XSD_PATH/xml/2009/01/XMLSchema.xsd" "$SIRI_XSD_PATH/xml/2009/01/xml.xsd"
sed -i 's#xml/2009/01/XMLSchema.xsd#xml/2009/01/xml.xsd#' "$SIRI_XSD_PATH/siri_utility/siri_types.xsd"

# rm $ZIPFILE
