DESCRIPTION = "GStreamer elements for TI's OMAP DSP"
HOMEPAGE = "http://code.google.com/pgst-dsp/"
SECTION = "multimedia"
LICENSE = "LGPL-2.1"
PR = "r0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=4fbd65380cdd255951079008b364516c"
PV = "git+${SRCREV}"
S = "${WORKDIR}/git"

SRCREV = "f2e7b9470918c6b764ee849134660985b8345c3d"
SRC_URI = " \
  git://github.com/felipec/gst-dsp;protocol=git;branch=master \
  file://baseimage.dof \
  file://conversions.dll64P \
  file://dctn_dyn.dll64P \
  file://h264vdec_sn.dll64P \
  file://jpegdec_sn.dll64P \
  file://jpegenc_sn.dll64P \
  file://m4venc_sn.dll64P \
  file://mp4vdec_sn.dll64P \
  file://mpeg4aacdec_sn.dll64P \
  file://qosdyn_3430.dll64P \
  file://ringio.dll64P \
  file://usn.dll64P \
  file://vpp_sn.dll64P \
  https://gforge.ti.com/gf/download/frsrelease/285/3260/DSPbinaries-3.09-Linux-x86-Install \
"

SRC_URI[md5sum] = "0d81872466aade5fa5f68d3b69d5704c"
SRC_URI[sha256sum] = "780d63c08ced0d8cdca041b39de65d8f3e47263757777510b89b864c6a44b721"

inherit autotools

DEPENDS = "gstreamer"

PACKAGES = "${PN} ${PN}-dbg"
FILES_${PN} += " \
  ${libdir}/gstreamer-0.10/libgstdsp.so \
  /lib/dsp/* \
"
FILES_${PN}-dbg += " \
  ${libdir}/gstreamer-0.10/.debug/libgstdsp.so \
"

do_install_prepend() {
	install -d ${D}/lib/dsp
	install -m 0755 ${WORKDIR}/baseimage.dof ${D}/lib/dsp
	install -m 0755 ${WORKDIR}/conversions.dll64P ${D}/lib/dsp
	install -m 0755 ${WORKDIR}/dctn_dyn.dll64P ${D}/lib/dsp
	install -m 0755 ${WORKDIR}/h264vdec_sn.dll64P ${D}/lib/dsp
	install -m 0755 ${WORKDIR}/jpegdec_sn.dll64P ${D}/lib/dsp
	install -m 0755 ${WORKDIR}/jpegenc_sn.dll64P ${D}/lib/dsp
	install -m 0755 ${WORKDIR}/m4venc_sn.dll64P ${D}/lib/dsp
	install -m 0755 ${WORKDIR}/mp4vdec_sn.dll64P ${D}/lib/dsp
	install -m 0755 ${WORKDIR}/mpeg4aacdec_sn.dll64P ${D}/lib/dsp
	install -m 0755 ${WORKDIR}/qosdyn_3430.dll64P ${D}/lib/dsp
	install -m 0755 ${WORKDIR}/ringio.dll64P ${D}/lib/dsp
	install -m 0755 ${WORKDIR}/usn.dll64P ${D}/lib/dsp
	install -m 0755 ${WORKDIR}/vpp_sn.dll64P ${D}/lib/dsp
}
