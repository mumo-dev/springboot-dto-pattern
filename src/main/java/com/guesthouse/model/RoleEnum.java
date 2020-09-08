package com.guesthouse.model;

public enum RoleEnum {
    SUPER_ADMIN(1L),
    ADMIN(2L),
    HOUSE_OWNER(3L),
    CUSTOMER(4L);


    private Long id;
    private RoleEnum(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
