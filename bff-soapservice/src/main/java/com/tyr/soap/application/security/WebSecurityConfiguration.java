package com.tyr.soap.application.security;
/*
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.server.resource.introspection.NimbusOpaqueTokenIntrospector;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
*/
//@EnableWebSecurity
public class WebSecurityConfiguration {// extends WebSecurityConfigurerAdapter {

//private BCryptPasswordEncoder bCryptPasswordEncoder;

//private UserDetailsService userDetailsService;

/*


        @Value("${security.oauth2.resource.tokenInfoUri}") String tokenInfoUri;
        @Value("${security.oauth2.client.clientId}") String clientId;
        @Value("${security.oauth2.client.clientSecret}") String clientSecret;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                // @formatter:off
                http
                        .authorizeRequests((authorizeRequests) ->
                                authorizeRequests
                                        .antMatchers(HttpMethod.GET, "/message/**").hasAuthority("SCOPE_message:read")
                                        .antMatchers(HttpMethod.POST, "/message/**").hasAuthority("SCOPE_message:write")
                                        .anyRequest().authenticated()
                        )
                        .oauth2ResourceServer(OAuth2ResourceServerConfigurer::opaqueToken);
                // @formatter:on
        }
*/


      /*  @Bean
        OpaqueTokenIntrospector opaqueTokenIntrospector() {
                return new NimbusOpaqueTokenIntrospector(tokenInfoUri,clientId,clientSecret);
        }

*/

private static final String[] AUTH_WHITELIST = {
        "/v2/api-docs",
        "/swagger-resources",
        "/swagger-resources/**",
        "/configuration/ui",
        "/configuration/security",
        "/swagger-ui.html",
        "/webjars/**"
        };


public WebSecurityConfiguration()
        {

        }


/*
protected void configure(HttpSecurity httpSecurity) throws Exception

        {
           httpSecurity.cors().and().csrf().disable().authorizeRequests()
        .antMatchers(AUTH_WHITELIST).permitAll()
        .antMatchers(HttpMethod.POST, "/cachedemo/v1/users/signup").permitAll()
        .anyRequest().authenticated()
        .and().addFilter(new AuthenticationFilter(authenticationManager()))
        .addFilter(new AuthorizationFilter(authenticationManager()))
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        }*/
/*
public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception

        {

        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);


        }*/

      /*  @Bean
        CorsConfigurationSource corsConfigurationSource() {

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**",new CorsConfiguration().applyPermitDefaultValues());
                return source;
        }
*/


        }