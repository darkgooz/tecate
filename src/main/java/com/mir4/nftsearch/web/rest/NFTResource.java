package com.mir4.nftsearch.web.rest;

import com.mir4.nftsearch.service.NFTService;
import com.mir4.nftsearch.web.rest.dto.RootDataDTO;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NFTResource {

    private final NFTService NFTService;


    public NFTResource(com.mir4.nftsearch.service.NFTService NFTService) {
        this.NFTService = NFTService;
    }
    @GetMapping("/nfts")
    public ResponseEntity<RootDataDTO> getAllRegions() {
        RootDataDTO response = NFTService.getNftList();
        return ResponseEntity.ok().body(response);
    }


}
