package com.varun.khetiwala.domain;


import com.varun.khetiwala.helper.EnumOptionData;

public enum RoleEnum {

    INVALID(0, "role.invalid", "Invalid"),
    NORMAL_USER(1, "role.normal.user", "Normal User"),
    BUYER(2, "role.buyer", "Buyer"),
    SELLER(3, "role.seller", "Seller"),
    ADMIN(4, "role.admin", "Admin");

    private final Integer id;
    private final String value;
    private final String code;

    RoleEnum(Integer id, String value, String code) {
        this.id = id;
        this.value = value;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }

    public static RoleEnum fromInt(final Integer roleValue) {
        RoleEnum roleEnum = RoleEnum.INVALID;

        switch (roleValue) {
            case 1:
                roleEnum = RoleEnum.NORMAL_USER;
                break;
            case 2:
                roleEnum = RoleEnum.BUYER;
                break;
            case 3:
                roleEnum = RoleEnum.SELLER;
                break;
            case 4:
                roleEnum = RoleEnum.ADMIN;
                break;
        }

        return roleEnum;
    }

    public static EnumOptionData strategyEnum(final Integer id) {
        EnumOptionData roleData = null;
        for (RoleEnum role : RoleEnum.values()) {
            if (role.id.equals(id)) {
                roleData = new EnumOptionData(role.id.longValue(), role.value, role.code);
            }
        }
        return roleData;
    }
}

