package com.sampana.cms.security.model.token;

/**
 * Scopes
 * 
 *@author Sudhanshu Chaturvedi
 *
 */
public enum Scopes {
    REFRESH_TOKEN;
    
    public String authority() {
        return "ROLE_" + this.name();
    }
}
