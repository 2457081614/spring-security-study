package com.example.springsecurityoauthqq.client;

import org.springframework.security.oauth2.client.endpoint.AbstractOAuth2AuthorizationGrantRequest;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationExchange;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author : yangliu@tiduyun.com
 */
@Component
public class CustomerOAuth2AccessTokenResponseClient
    implements OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> {
    @Override
    public OAuth2AccessTokenResponse
        getTokenResponse(OAuth2AuthorizationCodeGrantRequest oAuth2AuthorizationCodeGrantRequest) {
        OAuth2AuthorizationExchange authorizationExchange =
            oAuth2AuthorizationCodeGrantRequest.getAuthorizationExchange();
        ClientRegistration clientRegistration = oAuth2AuthorizationCodeGrantRequest.getClientRegistration();
        String registrationId = clientRegistration.getRegistrationId();
        System.out.println(registrationId);
        return new DefaultAuthorizationCodeTokenResponseClient().getTokenResponse(oAuth2AuthorizationCodeGrantRequest);

    }
}
