LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit core-image

IMAGE_FEATURES += " \
  package-management \
  ssh-server-dropbear \
"

FIRMWARE_INSTALL = " \
  linux-firmware-sd8686 \  
  linux-firmware-rtl8192cu \  
  linux-firmware-rtl8192ce \  
  linux-firmware-rtl8192su \  
  linux-firmware-wl12xx \
"  

TOOLS_INSTALL = " \
  procps \
  util-linux \
"

MESON_INSTALL = " \
  python-robovero \
  storm \
"

IMAGE_INSTALL += " \
  ${MACHINE_EXTRA_RRECOMMENDS} \
  ${FIRMWARE_INSTALL} \
  ${TOOLS_INSTALL} \
  ${MESON_INSTALL} \
"
