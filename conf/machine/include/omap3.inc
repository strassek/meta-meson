SOC_FAMILY = "omap3"
require conf/machine/include/soc-family.inc

require conf/machine/include/tune-cortexa8.inc

TOOLCHAIN_PATH ?= "${STAGING_DIR_NATIVE}${prefix_native}/bin/${TUNE_PKGARCH}${HOST_VENDOR}-${HOST_OS}"
TOOLCHAIN_SYSPATH ?= "${TOOLCHAIN_PATH}/${TARGET_SYS}" 

# Increase this everytime you change something in the kernel
MACHINE_KERNEL_PR = "r1"

KERNEL_IMAGETYPE = "uImage"

UBOOT_ENTRYPOINT = "0x80008000"
UBOOT_LOADADDRESS = "0x80008000"

EXTRA_IMAGEDEPENDS += "u-boot-sakoman"
