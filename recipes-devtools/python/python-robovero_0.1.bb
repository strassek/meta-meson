DESCRIPTION = "Python Client Library for RoboVero."
HOMEPAGE = "http://robovero.org"
SECTION = "devel/python"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=52b7490557d2fd1a2c673d32aa5d4b8a"

PR = "r1"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/strassek/pyRoboVero.git;protocol=git"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = "python-pyserial python-threading"

inherit python-dir

FILES_${PN} = " \
  ${libdir}/${PYTHON_DIR}/site-packages/robovero/*.py \
"

do_install(){
 install -d ${D}/${libdir}/${PYTHON_DIR}/site-packages/robovero
 install -m 0755 ${S}/robovero/*.py \
                 ${D}/${libdir}/${PYTHON_DIR}/site-packages/robovero/
}
