LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit core-image

IMAGE_FEATURES = "package-management ssh-server-dropbear debug-tweaks"

IMAGE_INSTALL += "procps util-linux python-robovero"
