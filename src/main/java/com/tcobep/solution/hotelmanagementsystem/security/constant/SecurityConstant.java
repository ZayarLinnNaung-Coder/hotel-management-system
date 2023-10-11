package com.tcobep.solution.hotelmanagementsystem.security.constant;

public class SecurityConstant {
    public static final String BEARER = "BEARER ";
    public static final String AUTHORITIES = "authorities";
    public static final long EXPIRATION_TIME = 1 * ( 60 * 60 * 24 * 1000);          // Expiration Time -> 1 Day
    public static final String SECRET_KEY = "AMDXGbO7gGwf3hoFPpm6GwQvFrqoCsn2";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
}
