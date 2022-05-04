package api.atlantis.utility;

import api.atlantis.constant.SecurityConstant;
import api.atlantis.domain.user.UserPrincipal;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Component
public class JWTTokenProvider {

    @Value("${jwt.secret}")
    private String secret;

    public String generateJwtToken(UserPrincipal userPrincipal) {
        String[] claims=getClaimsFromUser(userPrincipal);
        return JWT.create()
                .withIssuer(SecurityConstant.ATLANTIS)
                .withAudience(SecurityConstant.ATLANTIS_ADMINISTRATION)
                .withIssuedAt(new Date())
                .withSubject(userPrincipal.getUsername())
                .withArrayClaim(SecurityConstant.AUTHORITIES, claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstant.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(secret.getBytes()));
    }

    public List<GrantedAuthority> getAuthorities(String token) {
        String[] claims = getClaimsFromToken(token);
        return stream(claims).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    public Authentication getAuthentication(String userName, List<GrantedAuthority> authorities,
                                            HttpServletRequest request) {
        UsernamePasswordAuthenticationToken userPasswordAuthToken =
                new UsernamePasswordAuthenticationToken(userName, null, authorities);
        userPasswordAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        return userPasswordAuthToken;
    }

    public boolean isTokenValid(String userName, String token) {
        JWTVerifier jwtVerifier = getJwtVerifier();
        return StringUtils.isNotEmpty(userName) && !isTokenExpired(jwtVerifier, token);
    }

    public String getSubject(String token) {
        JWTVerifier jwtVerifier = getJwtVerifier();
        return jwtVerifier.verify(token).getSubject();
    }

    private boolean isTokenExpired(JWTVerifier jwtVerifier, String token) {
        Date expiration = jwtVerifier.verify(token).getExpiresAt();
        return expiration.before(new Date());
    }

    private String[] getClaimsFromToken(String token) {
        JWTVerifier jwtVerifier = getJwtVerifier();
        return jwtVerifier.verify(token).getClaim(SecurityConstant.AUTHORITIES).asArray(String.class);
    }

    private JWTVerifier getJwtVerifier() {
        JWTVerifier jwtVerifier;
        try {
            Algorithm algorithm = Algorithm.HMAC512(secret);
            jwtVerifier = JWT.require(algorithm).withIssuer(SecurityConstant.ATLANTIS).build();
        } catch (JWTVerificationException exception) {
            throw new JWTVerificationException(SecurityConstant.TOKEN_CANNOT_BE_VERIFIED);
        }

        return jwtVerifier;
    }

    private String[] getClaimsFromUser(UserPrincipal user) {
        List<String> authorities=new ArrayList<>();
        for (GrantedAuthority grantedAuthority : user.getAuthorities()) {
            authorities.add(grantedAuthority.getAuthority());
        }

        return authorities.toArray(new String[0]);
    }
}
