LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=052799322e1f595d169a8c05a5624327"

SRCREV = "f139a1c60c237e50acc6facc926f00f3dd6a7d1a"
SRC_URI = "git://github.com/strassek/storm.git;protocol=git;branch=robo \
           file://storm.conf \
           file://init \
"

RDEPENDS_${PN} = "python-robovero python-logging python-xmlrpc"

S = "${WORKDIR}/git"

inherit useradd update-rc.d

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "--system --no-create-home --home-dir /var/run/${PN} --shell /bin/false --user-group storm"
INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME_${PN} = "${PN}"
INITSCRIPT_PARAMS_${PN} = "defaults 9"

inherit setuptools

do_compile_append () {
        install -m 0644 ${WORKDIR}/${PN}.conf ${S}/
}

do_install_append () {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/${PN}
}

FILES_${PN} += "${sysconfdir}/init.d/${PN}"
FILES_${PN} += "${sysconfdir}/${PN}/${PN}.conf"

CONFFILES_${PN} = "${sysconfdir}/${PN}/${PN}.conf"
