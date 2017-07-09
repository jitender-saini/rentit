package com.rentit


class ApplicationInterceptor {

    ApplicationInterceptor() {
        matchAll()
        match(controller: '*')
    }

    boolean before() {
        log.info "Params : ${params}"
        return true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
