package com.mir4.nftsearch.service.external;

import com.google.gson.Gson;
import com.mir4.nftsearch.config.ApplicationProperties;
import com.mir4.nftsearch.web.rest.dto.RootDataDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ServiceExternal {

    private final Integer TIMEOUT_SECONDS = 30;
    private final WebClient webClient;

    public ServiceExternal(ApplicationProperties applicationProperties) {
        this.webClient = WebClient.create(applicationProperties.getNft().getUrl());
    }

    public Object getSyncRest(String path, Class response) throws Exception {
        try {
            String json = webClient.get().uri(path).exchange()
                    .block().bodyToMono(String.class)
                .block();
            Object data = new Gson().fromJson(json, response);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public RootDataDTO getNftList(int page) {
        try {
            return (RootDataDTO) getSyncRest("/nft/lists?listType=sale&class=0&levMin=0&levMax=0&powerMin=0&powerMax=0&priceMin=0&priceMax=0&sort" +
                "=latest&page=" + page + "&languageCode=en", RootDataDTO.class);
        } catch (Exception e) {
            return null;
        }
    }

    public RootDataDTO getSpiritList(int transportID) {
        try {
            return (RootDataDTO) getSyncRest("/nft/character/spirit?transportID=" + transportID + "&languageCode=en", RootDataDTO.class);
        } catch (Exception e) {
            return null;
        }
    }


}
