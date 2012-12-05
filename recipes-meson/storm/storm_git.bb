DESCRIPTION = "Blimp demo control application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0d5dcf559771b5142692b137fa69bae9"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/strassek/${PN};protocol=git \
           file://storm.conf \
           file://init"

RDEPENDS_${PN} = "python-logging python-xmlrpc python-gst"

S = "${WORKDIR}/git"

INITSCRIPT_NAME = "${PN}"
INITSCRIPT_PARAMS = "start 99 5 3 2 . stop 10 0 1 6 ."

inherit setuptools update-rc.d

do_install_append () {
	install -d ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/${PN}
	install -m 0655 ${WORKDIR}/${PN}.conf ${D}${sysconfdir}/${PN}/
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/${PN}
}

FILES_${PN}-server += "${sysconfdir}/init.d/${PN} \
                       ${sysconfdir}/${PN}/${PN}.conf"

PACKAGES =+ "${PN}-client ${PN}-server"

DEPENDS_${PN}-client = "${PN}"
RDEPENDS_${PN}-client = " \
    python-pygtk \
    gst-plugins-good \
    gst-ffmpeg\
    "
RDEPENDS_storm-server = "python-robovero"
