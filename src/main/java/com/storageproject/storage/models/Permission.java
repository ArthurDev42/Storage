package com.storageproject.storage.models;

public enum Permission {
    USE_STORAGE("storage:use"),
    REGISTER_EMPLOYEE("register:employee"),
    REGISTER_PROVIDER("register:provider");
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
