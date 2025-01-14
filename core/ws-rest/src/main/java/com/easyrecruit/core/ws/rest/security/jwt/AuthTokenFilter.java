package com.easyrecruit.core.ws.rest.security.jwt;

import com.easyrecruit.core.dal.repository.TokenRepository;
import com.easyrecruit.core.service.impl.security.UserDetailsServiceImpl;
import com.easyrecruit.core.service.impl.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {

  private static List<String> skipFilterUrls = Arrays.asList("/api/core/login", "/api/core/signup");


  @Autowired
  private JWTService jwtService;
  @Autowired
  private UserDetailsServiceImpl userDetailsService;
  @Autowired
  private TokenRepository tokenRepository;

  @Override
  protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

    return skipFilterUrls.stream().anyMatch(url -> new AntPathRequestMatcher(url).matches(request));
  }

  @Override
  protected void doFilterInternal(
          @NonNull HttpServletRequest request,
          @NonNull HttpServletResponse response,
          @NonNull FilterChain filterChain
  ) throws ServletException, IOException {
    final String authHeader = request.getHeader("Authorization");
    final String jwt;
    final String userName; //User email

    if (authHeader == null || !authHeader.startsWith("Bearer ")){
      filterChain.doFilter(request, response);
      return;
    }
    jwt = authHeader.substring(7);

    userName = jwtService.extractUsername(jwt);

    if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
      UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);

      var isTokenValid = tokenRepository.findByToken(jwt)
              .map(token -> !token.isExpired() &&!token.isRevoked())
              .orElse(false);

      if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid){
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities()
        );
        authToken.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );
        SecurityContextHolder.getContext().setAuthentication(authToken);
      }
    }
    filterChain.doFilter(request,response);
  }
}
