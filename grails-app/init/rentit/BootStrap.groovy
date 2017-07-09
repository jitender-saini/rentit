package rentit

import com.rentit.Role
import com.rentit.User
import com.rentit.UserRole
import com.rentit.enums.UserRoles

class BootStrap {

    def init = { servletContext ->
        createAdminUser()
        createUser()
        log.info("Application Running")
    }

    def createAdminUser() {
        Role role = Role.findByAuthority(UserRoles.ROLE_ADMIN) ?: (new Role(authority: UserRoles.ROLE_ADMIN).save(flush: true, failOnError: true))
        User adminUser = User.findByUsername("admin") ?: (new User(username: "admin", password: "12345", name: "admin", email: "admin@ttn.com").save(flush: true, failOnError: true))
        UserRole.findByUserAndRole(adminUser, role) ?: (new UserRole(user: adminUser, role: role).save(flush: true, failOnError: true))
    }

    def createUser() {
        Role role = Role.findByAuthority(UserRoles.ROLE_USER) ?: (new Role(authority: UserRoles.ROLE_USER).save(flush: true, failOnError: true))
        User user = User.findByUsername("user") ?: (new User(username: "jay", password: "12345", name: "jay", email: "jsaini.coder@gmail.com").save(flush: true, failOnError: true))
        UserRole.findByUserAndRole(user, role) ?: (new UserRole(user: user, role: role).save(flush: true, failOnError: true))
    }

    def destroy = {
        log.info("Application Stopped")
    }
}
