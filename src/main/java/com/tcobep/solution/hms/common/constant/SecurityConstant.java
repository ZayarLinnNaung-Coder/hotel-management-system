package com.tcobep.solution.hms.common.constant;

public class SecurityConstant {
    public static final long EXPIRATION_TIME = 5*(60*60*24*1000);  //5 days expressed in milliseconds
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
    public static final String TOCOBEP_LLC = "TOCOBEP, LLC";
    public static final String TOCOBEP_ADMINISTRATION = "TOCOBEP ADMINISTRATION";
    public static final String AUTHORITIES = "Authorities";
    public static final String FORBIDDEN_MESSAGE = "You need to login to access this page";
    public static final String ACCESS_DENIED_MESSAGE = "You do not have permission to access this page";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
    /*public static final String [] PUBLIC_URLS = {"/api/v1/user/login", "/api/v1/user/register", "/api/v1/user/resetPassword/**", "/api/v1/user/image/**",
            "/v3/api-docs/**", "/v3/api-docs.yaml", "/swagger-ui/**", "/swagger-ui.html"
    };*/
    public static final String [] PUBLIC_URLS = {"**"};
}
