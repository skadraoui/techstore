package org.sid.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.sid.service.CustomUserDetailsService;
import org.sid.util.JwtUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final CustomUserDetailsService  customUserDetailsService;

    private final JwtUtils jwtUtils;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // récupérer le token à partir du header
        final String autHeader= request.getHeader("Authorization");
        String username =null ;
        String jwt =null ;
        if(autHeader != null && autHeader.startsWith("Bearer ")){
// Lorsqu'on utilise un token jwt il faut tjrs précédé le token par la chaine 'Bearer ' ==>> token de type Bearer
            jwt = autHeader.substring(7); // la valeur du token jwt est la chaine de caract après 'Bearer ' (7 caractères)
            username = jwtUtils.extractUsername(jwt);
        }
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            // on vérifie qu'on a pas encore authentifé l'utilisateur ==> L'utilisateur n'est poas encore authentifié
            UserDetails userDetails= customUserDetailsService.loadUserByUsername(username);
            if(jwtUtils.isTokenValid(jwt, userDetails)){
                UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); // Ajouter les détails de l'authentification ( avec quelle requete l'utilisateur a été authentifié)
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response); // Pour permettre de passer au filtre suivant
    }
}
