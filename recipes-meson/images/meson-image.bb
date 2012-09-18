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

NETWORK_INSTALL = " \
  wpa-supplicant \
  wireless-tools \
"

TOOLS_INSTALL = " \
  gstreamer-ti \
  gst-plugins-good \
  procps \
  util-linux \
  media-ctl v4l-utils yavta \
"

MESON_INSTALL = " \
  python-robovero \
"

TI_DSP_INSTALL = " \
  ti-codec-engine \
  ti-dmai \
  ti-dspbios \
  ti-dsplink \
  ti-dsplink-module \
  ti-cmem-module \
"

IMAGE_INSTALL += " \
  ${MACHINE_EXTRA_RRECOMMENDS} \
  ${FIRMWARE_INSTALL} \
  ${NETWORK_INSTALL} \
  ${TOOLS_INSTALL} \
  ${MESON_INSTALL} \
  ${TI_DSP_INSTALL} \
"
