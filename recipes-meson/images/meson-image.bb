LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit core-image

MESON_INSTALL = " \
  media-ctl \
  v4l-utils \
  python-robovero \
  storm \
"

IMAGE_INSTALL += " \
  ${MACHINE_EXTRA_RRECOMMENDS} \
  ${MESON_INSTALL} \
"
