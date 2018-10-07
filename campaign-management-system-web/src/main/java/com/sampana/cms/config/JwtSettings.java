package com.sampana.cms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 
 *@author Sudhanshu
 *
 */
@Configuration
//@ConfigurationProperties(prefix = "ngex.security.jwt")
public class JwtSettings {
    /**
     * {@link JwtToken} will expire after this time.
     */
	@Value("${ngex.security.jwt.tokenExpirationTime}")
    private Integer tokenExpirationTime;

    /**
     * Token issuer.
     */
	@Value("${ngex.security.jwt.tokenIssuer}")
    private String tokenIssuer;
    
    /**
     * Key is used to sign {@link JwtToken}.
     */
	@Value("${ngex.security.jwt.tokenSigningKey}")
    private String tokenSigningKey;
    
    /**
     * {@link JwtToken} can be refreshed during this timeframe.
     */
	@Value("${ngex.security.jwt.refreshTokenExpTime}")
    private Integer refreshTokenExpTime;
    
    public Integer getRefreshTokenExpTime() {
        return refreshTokenExpTime;
    }

    public void setRefreshTokenExpTime(Integer refreshTokenExpTime) {
        this.refreshTokenExpTime = refreshTokenExpTime;
    }

    public Integer getTokenExpirationTime() {
        return tokenExpirationTime;
    }
    
    public void setTokenExpirationTime(Integer tokenExpirationTime) {
        this.tokenExpirationTime = tokenExpirationTime;
    }
    
    public String getTokenIssuer() {
        return tokenIssuer;
    }
    public void setTokenIssuer(String tokenIssuer) {
        this.tokenIssuer = tokenIssuer;
    }
    
    public String getTokenSigningKey() {
        return tokenSigningKey;
    }
    
    public void setTokenSigningKey(String tokenSigningKey) {
        this.tokenSigningKey = tokenSigningKey;
    }
}
