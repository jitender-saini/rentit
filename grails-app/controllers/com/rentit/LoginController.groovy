package com.rentit

import grails.plugin.springsecurity.SpringSecurityUtils
import org.springframework.security.access.annotation.Secured

@Secured('permitAll')
class LoginController extends grails.plugin.springsecurity.LoginController {

    @Override
    def index() {
        if (springSecurityService.isLoggedIn()) {
            redirect uri: SpringSecurityUtils.securityConfig.successHandler.defaultTargetUrl
        } else {
            render view: 'index'
        }
    }

    @Override
    def auth() {
        def conf = getConf()
        if (springSecurityService.isLoggedIn()) {
            redirect uri: conf.successHandler.defaultTargetUrl
            return
        }

        String postUrl = request.contextPath + conf.apf.filterProcessesUrl
        render view: 'index', model: [postUrl            : postUrl,
                                      rememberMeParameter: conf.rememberMe.parameter,
                                      usernameParameter  : conf.apf.usernameParameter,
                                      passwordParameter  : conf.apf.passwordParameter,
                                      gspLayout          : conf.gsp.layoutAuth]
    }
}
