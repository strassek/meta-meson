DESCRIPTION = "Task for installing gstreamer plugins on TI platforms"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PACKAGE_ARCH = "${MACHINE_ARCH}"
PR = "r2"

DEPENDS = "gst-plugins-base gst-plugins-bad gst-plugins-good gst-plugins-ugly"

GST_CODEC_ELEMENT = " \
	gstreamer-ti \
"

GST_CODEC_ELEMENT_am3517-evm = "\
	gst-ffmpeg \
	gst-omapfb \
"

RDEPENDS_${PN} = " \
	gst-plugins-base-meta \
	gst-plugins-good-meta \
	gst-plugins-bad-meta \
	gst-plugins-ugly-meta \
	${GST_CODEC_ELEMENT} \
"

inherit task


