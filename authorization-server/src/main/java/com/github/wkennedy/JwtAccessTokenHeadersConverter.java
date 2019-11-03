package com.github.wkennedy;


import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.util.JsonParser;
import org.springframework.security.oauth2.common.util.JsonParserFactory;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.Map;

public class JwtAccessTokenHeadersConverter extends JwtAccessTokenConverter {

    private Map<String, String> headers;
    private JsonParser objectMapper = JsonParserFactory.create();
    private final RsaSigner signer;

    JwtAccessTokenHeadersConverter(Map<String, String> headers, KeyPair keyPair) {
        super();
        super.setKeyPair(keyPair);
        this.signer = new RsaSigner((RSAPrivateKey) keyPair.getPrivate());
        this.headers = headers;
    }

    @Override
    protected String encode(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        String content = this.objectMapper.formatMap(getAccessTokenConverter().convertAccessToken(accessToken, authentication));

        return JwtHelper.encode(content, signer, headers).getEncoded();
    }

}