package com.rentit.enums

enum UserRoles {
    ROLE_USER("role_user"),
    ROLE_ADMIN("role_admin")

    String displayName

    UserRoles(String displayName){
        this.displayName = displayName
    }
}