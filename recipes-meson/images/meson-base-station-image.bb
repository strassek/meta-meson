IMAGE_FEATURES += "apps-console-core ${SATO_IMAGE_FEATURES}"

inherit core-image

IMAGE_INSTALL += " \
    storm \
    "
RDEPENDS_storm += "storm-client"
