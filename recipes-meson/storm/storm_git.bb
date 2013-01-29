LICENSE = "LGPL-3.0 & MIT"
LIC_FILES_CHKSUM = "file://COPYING.MIT;md5=0d5dcf559771b5142692b137fa69bae9 \
                    file://COPYING;md5=d32239bcb673463ab874e80d47fae504 \
                    file://COPYING.LESSER;md5=e6a600fd5e1d9cbde2d983680233ad02"

SRCREV = "39236ed9f6415d6828e4e7519518c4ab24248702"
SRC_URI = "git://github.com/strassek/${PN}.git;protocol=git \
           file://storm.conf \
           file://init"

RDEPENDS_${PN} = "python-robovero python-logging python-xmlrpc python-gst"

S = "${WORKDIR}/git"

INITSCRIPT_NAME = "${PN}"
INITSCRIPT_PARAMS = "start 99 5 3 2 . stop 10 0 1 6 ."

inherit setuptools update-rc.d

do_configure_prepend () {
    cp ${WORKDIR}/${PN}.conf ${S}/packaging/files/
    cp ${WORKDIR}/init ${S}/packaging/files/
}

do_install_append () {
	install -d ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/${PN}
	install -m 0655 packaging/files/${PN}.conf ${D}${sysconfdir}/${PN}/
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 packaging/files/init ${D}${sysconfdir}/init.d/${PN}
}

FILES_${PN} += "${sysconfdir}/init.d/${PN} \
                ${sysconfdir}/${PN}/${PN}.conf"

