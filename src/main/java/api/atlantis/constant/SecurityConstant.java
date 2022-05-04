package api.atlantis.constant;

// constants for the jwt token
public class SecurityConstant {
    public static final long EXPIRATION_TIME= 432_000_000; // 5 days in ms
    public static final String TOKEN_PREFIX="Bearer ";
    public static final String JWT_TOKEN_HEADER="Jwt-Token";
    public static final String TOKEN_CANNOT_BE_VERIFIED="Token cannot be verified";
    public static final String ATLANTIS="Atlantis";
    public static final String ATLANTIS_ADMINISTRATION="Admin Portal";
    public static final String AUTHORITIES="Authorities";
    public static final String FORBIDDEN_MESSAGE="You need to log in to access this page"; // translated
    public static final String ACCESS_DENIED_MESSAGE="You do not have permission to access this page"; // translated
    public static final String OPTIONS_HTTP_METHOD="OPTIONS";
    public static final String[] PUBLIC_URLS={
            "/api/user/login",
            "/api/user/signup",
            "/api/user/forgotpassword/{email}",
            "/api/user/usernameexists/{username}",
            "/api/user/useremailexists/{useremail}"
    };
}
