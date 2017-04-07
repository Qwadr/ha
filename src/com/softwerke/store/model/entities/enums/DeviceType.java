package com.softwerke.store.model.entities.enums;

/**
 * All variations of device types.
 */
public enum DeviceType {
    PHONE,
    TABLET,
    LAPTOP,
    PLAYER,
    NOT_INITIALIZED;

    public static DeviceType getDeviceType(String stringDeviceType) {
        DeviceType answer = NOT_INITIALIZED;
        for (DeviceType deviceType : DeviceType.values()) {
            if (stringDeviceType.trim().toLowerCase()
                    .equals(deviceType.name().toLowerCase())) {
                answer = deviceType;
            }
        }
        return answer;
    }
}
