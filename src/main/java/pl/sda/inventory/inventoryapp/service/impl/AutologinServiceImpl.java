package pl.sda.inventory.inventoryapp.service.impl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pl.sda.inventory.inventoryapp.service.AutologinService;

@Slf4j
@Service
public class AutologinServiceImpl implements AutologinService {

    private final UserDetailsService userDetailsService;

    public AutologinServiceImpl(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void autologin(String username) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());

        if(token.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(token);
            log.info("Successfully autologin user with username: " + username);

        }
    }
}