LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=052799322e1f595d169a8c05a5624327"

SRCREV = "f139a1c60c237e50acc6facc926f00f3dd6a7d1a"
SRC_URI = "git://github.com/strassek/storm.git;protocol=git;branch=robo"

RDEPENDS_${PN} = "python-robovero python-logging python-xmlrpc"

S = "${WORKDIR}/git"

inherit setuptools
