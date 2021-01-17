package com.example.springsecurityoauthqq.config;

import com.example.springsecurityoauthqq.client.CustomerOAuth2AccessTokenResponseClient;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;

/**
 * @Author : yangliu@tiduyun.com
 */
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login/oauth2").permitAll().anyRequest().authenticated();

        http.oauth2Login().redirectionEndpoint().baseUri("/redirect").and().tokenEndpoint()
            .accessTokenResponseClient(this.accessTokenResponseClient());

        ;

        // 自定义登录页
        // http.oauth2Login().loginPage("");
    }

    private OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> accessTokenResponseClient() {
        return new CustomerOAuth2AccessTokenResponseClient();
    }
}
