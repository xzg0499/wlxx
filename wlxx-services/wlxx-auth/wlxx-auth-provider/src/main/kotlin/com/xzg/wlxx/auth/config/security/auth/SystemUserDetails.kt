package com.xzg.wlxx.auth.config.security.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

/**
 * @author XiaoZG
 */
class SystemUserDetails(
    private var username: String? = null,
    private var password: String? = null
) : UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority?>? {
        return null
    }

    override fun getPassword(): String {
        return password!!
    }

    override fun getUsername(): String {
        return username!!
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}
