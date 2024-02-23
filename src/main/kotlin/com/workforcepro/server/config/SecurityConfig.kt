package com.workforcepro.server.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.HttpSecurityBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer


@Configuration
@EnableWebSecurity
//class SecurityConfig : HttpSecurityBuilder<SecurityConfig> {
//    fun init(builder: HttpSecurity?) {
//        builder!!.
//    }
//
//
//}
class SecurityConfig : WebSecurityCustomizer{

    override fun customize(web: WebSecurity?) {
        web!!.ignoring().anyRequest()
    }
}