package com.example.test.domain;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class GoogleRequest {
    private String clientId;
    private String clientSecret;
    private String code;
    private String redirectUri;
    private String grantType;

    // Builder pattern for constructing GoogleRequest objects
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private String clientId;
        private String clientSecret;
        private String code;
        private String redirectUri;
        private String grantType;

        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder redirectUri(String redirectUri) {
            this.redirectUri = redirectUri;
            return this;
        }

        public Builder grantType(String grantType) {
            this.grantType = grantType;
            return this;
        }

        public GoogleRequest build() {
            GoogleRequest request = new GoogleRequest(clientId,clientSecret,code,redirectUri,grantType);
            request.clientId = this.clientId;
            request.clientSecret = this.clientSecret;
            request.code = this.code;
            request.redirectUri = this.redirectUri;
            request.grantType = this.grantType;
            return request;
        }
    }

}