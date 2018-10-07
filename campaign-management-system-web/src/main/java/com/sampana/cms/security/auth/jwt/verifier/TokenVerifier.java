package com.sampana.cms.security.auth.jwt.verifier;

/**
 * 
 * @author Sudhanshu
 *
 */
public interface TokenVerifier {
    public boolean verify(String jti);
}
