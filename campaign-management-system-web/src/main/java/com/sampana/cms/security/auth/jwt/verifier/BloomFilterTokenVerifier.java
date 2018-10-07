package com.sampana.cms.security.auth.jwt.verifier;

import org.springframework.stereotype.Component;

/**
 * BloomFilterTokenVerifier
 * 
 * @author Sudhanshu
 *
 */
@Component
public class BloomFilterTokenVerifier implements TokenVerifier {
    @Override
    public boolean verify(String jti) {
        return true;
    }
}
