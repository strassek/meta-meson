DESCRIPTION = "Python Client Library for RoboVero."
HOMEPAGE = "http://robovero.org"
SECTION = "devel/python"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=52b7490557d2fd1a2c673d32aa5d4b8a"

PR = "r0"

SRCREV = "2f62bd409cd6eef807394c7fb1b0d42b3f5984d6"
SRC_URI = "git://github.com/robovero/python.git;protocol=git"

S = "${WORKDIR}/git"

DEPENDS += "python"
RDEPENDS_${PN} = "python-core python-pyserial"

inherit python-dir

FILES_${PN} = " \
  ${libdir}/${PYTHON_DIR}/site-packages/robovero/*.py \
"

do_install(){
 install -d ${D}/${libdir}/${PYTHON_DIR}/site-packages/robovero
 install -m 0755 ${S}/robovero/*.py \
                 ${D}/${libdir}/${PYTHON_DIR}/site-packages/robovero/
}
