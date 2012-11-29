FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-add-UYVY-for-caspa-support.patch"

RDEPENDS= " \
	gst-plugins-good-udp \
	gst-plugins-good-rtp \
	gst-ffmpeg \
	"
