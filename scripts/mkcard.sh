#!/bin/sh
# Simple script to quickly install a distro to sdcard
# Please use at the root level of the build directory

IMAGE_DIR=tmp/deploy/images
BOOT_DEV=/dev/sdb1
BOOT_MNT=/media/boot
ROOTFS_DEV=/dev/sdb2
ROOTFS_MNT=/media/rootfs
MACHINE=overo
IMAGE=meson-image

umount ${BOOT_DEV}
umount ${ROOTFS_DEV}

mkfs.vfat -F 32 -n boot ${BOOT_DEV}
mke2fs -j -L rootfs ${ROOTFS_DEV}

if [ ! -d $BOOT_MNT ]; then
	if ! mkdir $BOOT_MNT; then
		echo "Could not create $BOOT_MNT"
		exit 1;
	fi
fi
if [ ! -d $ROOTFS_MNT ]; then
	if ! mkdir $ROOTFS_MNT; then
		echo "Could not create $ROOTFS_MNT"
		exit 1;
	fi
fi

mount -t vfat ${BOOT_DEV} ${BOOT_MNT}
mount -t ext3 ${ROOTFS_DEV} ${ROOTFS_MNT}

cp ${IMAGE_DIR}/MLO ${BOOT_MNT}
cp ${IMAGE_DIR}/u-boot.img ${BOOT_MNT}
cp ${IMAGE_DIR}/uImage-${MACHINE}.bin ${BOOT_MNT}/uImage
tar xaf ${IMAGE_DIR}/${IMAGE}-${MACHINE}.tar.bz2 -C ${ROOTFS_MNT}

sync

umount ${BOOT_DEV}
umount ${ROOTFS_DEV}
