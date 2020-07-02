package com.corvusinfo.registrationapi.security;

import com.corvusinfo.registrationapi.model.ResponseObject;
import com.google.gson.Gson;
import io.jsonwebtoken.ExpiredJwtException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private MyUserDetailsService service;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

       try{
           String authorizationHeader = httpServletRequest.getHeader("Authorization");

           String token = null;
           String userName = null;

           if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
               token = authorizationHeader.substring(7);
               userName = jwtUtil.extractUsername(token);
           }

           if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

               UserDetails userDetails = service.loadUserByUsername(userName);

               if (jwtUtil.validateToken(token, userDetails)) {

                   UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                           new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                   usernamePasswordAuthenticationToken
                           .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                   SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
               }
           }
           filterChain.doFilter(httpServletRequest, httpServletResponse);
       }catch(ExpiredJwtException e){
           ResponseObject responseObject= new ResponseObject("This token has expired. User must be authenticated", "/authenticate");
           ((HttpServletResponse)httpServletResponse).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
           ((HttpServletResponse)httpServletResponse).setContentType("application/json");
           ((HttpServletResponse)httpServletResponse).getWriter().print(new Gson().toJson(responseObject));
       }
    }
}
