LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=052799322e1f595d169a8c05a5624327"

SRCREV = "a9c75138d2572fa425277a2401eb2e9672be10a5"
SRC_URI = "git://github.com/strassek/storm.git;protocol=git;branch=robo"

PR = "r1"

RDEPENDS_${PN} = "python-robovero python-logging python-xmlrpc"

S = "${WORKDIR}/git"

inherit setuptools
