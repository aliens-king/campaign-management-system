package com.sampana.cms.security.auth.jwt.extractor;

/**
 * Implementations of this interface should always return raw base-64 encoded
 * representation of JWT Token.
 * 
 * @author Sudhanshu
 *
 */
public interface TokenExtractor {
    public String extract(String payload);
}
