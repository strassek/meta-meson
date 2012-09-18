DESCRIPTION = "TI DSP Code Generation Tools"
HOMEPAGE = "https://www-a.ti.com/downloads/sds_support/TICodegenerationTools/download.htm"
SECTION = "devel"
LICENSE = "TI"

require ../includes/ti-paths.inc
require ../includes/ti-staging.inc
require ../includes/ti-eula-unpack.inc

inherit native

PR = "r4"

S = "${WORKDIR}/cgt6x_${PV}"

SRC_URI = "http://install.source.dir.local/ti_cgt_c6000_${PVwithdots}_setup_linux_x86.bin;name=cgt6xbin"

BINFILE="ti_cgt_c6000_${PVwithdots}_setup_linux_x86.bin"
TI_BIN_UNPK_CMDS="Y:qY:workdir: : "
TI_BIN_UNPK_WDEXT="/cgt6x_${PV}"

do_install() {
    install -d ${D}${CODEGEN_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${CODEGEN_INSTALL_DIR_RECIPE}

    # Remove misc files
    rm -f ${D}${CODEGEN_INSTALL_DIR_RECIPE}/install.log
    rm -f ${D}${CODEGEN_INSTALL_DIR_RECIPE}/DefectHistory.txt
    rm -f ${D}${CODEGEN_INSTALL_DIR_RECIPE}/README.txt
    rm -f ${D}${CODEGEN_INSTALL_DIR_RECIPE}/LICENSE.txt
    rm -f ${D}${CODEGEN_INSTALL_DIR_RECIPE}/uninstall_cgt_c6000.bin
}

PACKAGES += "${PN}-bin"
FILES_${PN}-bin = "${CODEGEN_INSTALL_DIR_RECIPE}/bin/*"

PACKAGES += "${PN}-man"
FILES_${PN}-man = "${CODEGEN_INSTALL_DIR_RECIPE}/man/*"

FILES_${PN}-doc = " \ 
  ${CODEGEN_INSTALL_DIR_RECIPE}/doc/* \
  ${CODEGEN_INSTALL_DIR_RECIPE}/clt_tutorial/* \
"

FILES_${PN}-dev = " \ 
  ${CODEGEN_INSTALL_DIR_RECIPE}/lib/* \
  ${CODEGEN_INSTALL_DIR_RECIPE}/include/* \
  ${CODEGEN_INSTALL_DIR_RECIPE}/prelink/* \
"
