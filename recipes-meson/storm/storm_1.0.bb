LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=052799322e1f595d169a8c05a5624327"

SRCREV = "7dccf7315f43398d3eefaff36044f390ef813872"
SRC_URI = "git://github.com/strassek/storm.git;protocol=git;branch=robo"

PR = "r2"

RDEPENDS_${PN} = "python-robovero python-logging python-xmlrpc"

S = "${WORKDIR}/git"

inherit setuptools
