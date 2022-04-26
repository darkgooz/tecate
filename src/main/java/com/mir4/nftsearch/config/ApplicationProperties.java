package com.mir4.nftsearch.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Mir 4 Nftsearch.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private final GenericConfig nft = new GenericConfig();


    public static class GenericConfig {

        private String url = "https://webapi.mir4global.com";
        private String accessToken = "";

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }
    }

    public GenericConfig getNft() {
        return nft;
    }
}
