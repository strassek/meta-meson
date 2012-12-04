LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

IMAGE_FEATURES += "apps-console-core ${SATO_IMAGE_FEATURES}"

inherit core-image

IMAGE_INSTALL += "storm"
RDEPENDS_storm += "storm-client"
