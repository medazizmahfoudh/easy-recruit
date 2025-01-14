package com.easyrecruit.core.service.impl.service;

import com.easyrecruit.core.dal.entity.AppUserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {


  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }


  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }
  public String generateToken(UserDetails userDetails){

    Map<String, Object> extraClaims = new HashMap<>();
    AppUserEntity user = (AppUserEntity) userDetails;
    extraClaims.put("role", user.getRole().name());
    extraClaims.put("email", user.getEmail());
    extraClaims.put("username", user.getUsername());

    return generateToken(extraClaims, userDetails);
  }
  public String generateToken(
          Map<String, Object> extraClaims,
          UserDetails userDetails
  )
  {
    return buildToken(extraClaims, userDetails, 239329999);
  }


  private String buildToken(
          Map<String, Object> extraClaims,
          UserDetails userDetails,
          long expiration
  )
  {
    return Jwts
            .builder()
            .setClaims(extraClaims)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(getSignInKey(), SignatureAlgorithm.HS256)
            .compact();
  }


  public boolean isTokenValid(String token, UserDetails userDetails) {
    final String username = extractUsername(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));

  }

  public boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  public Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }
  public Claims extractAllClaims(String token) {
    return Jwts
            .parserBuilder()
            .setSigningKey(getSignInKey())
            .build()
            .parseClaimsJws(token)
            .getBody();

  }
  private Key getSignInKey() {
    byte[] keyBytes = Decoders.BASE64.decode("3e58950f9b875dddf66b25bd1b846e78c8c2bb923ee8cbd7f72695aefb626be3");
    return Keys.hmacShaKeyFor(keyBytes);
  }
//  public String createToken(Authentication authentication) {
//
//    UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
//    int jwtExpirationSeconds= NLiteral.of(confService.getConfValue("security.jwt","expirationSeconds").orNull())
//            .asInt().orElse(3600);
//    return Jwts.builder()
//        .setSubject((userPrincipal.getUsername()))
//        .setIssuedAt(new Date())
//        .setExpiration(new Date((new Date()).getTime() + jwtExpirationSeconds *1000))
//        .signWith(key(), SignatureAlgorithm.HS256)
//        .compact();
//  }
//
//  private Key key() {
//    String secret= NLiteral.of(confService.getConfValue("security.jwt","secret").orNull())
//            .asString().orElse("3e58950f9b875dddf66b25bd1b846e78c8c2bb923ee8cbd7f72695aefb626be3");
//    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
//  }
//
//  public String getUserNameFromJwtToken(String token) {
//    return Jwts.parserBuilder().setSigningKey(key()).build()
//               .parseClaimsJws(token).getBody().getSubject();
//  }
//
//  public boolean validateJwtToken(String authToken) {
//    try {
//      Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
//      return true;
//    } catch (MalformedJwtException e) {
//      logger.error("Invalid JWT token: {}", e.getMessage());
//    } catch (ExpiredJwtException e) {
//      logger.error("JWT token is expired: {}", e.getMessage());
//    } catch (UnsupportedJwtException e) {
//      logger.error("JWT token is unsupported: {}", e.getMessage());
//    } catch (IllegalArgumentException e) {
//      logger.error("JWT claims string is empty: {}", e.getMessage());
//    }
//
//    return false;
//  }
}
