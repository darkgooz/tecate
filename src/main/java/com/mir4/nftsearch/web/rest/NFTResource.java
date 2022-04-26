package com.mir4.nftsearch.web.rest;

import com.mir4.nftsearch.service.NFTService;
import com.mir4.nftsearch.web.rest.dto.NFTFilters;
import com.mir4.nftsearch.web.rest.dto.RootDataDTO;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api")
public class NFTResource {

    private final NFTService NFTService;


    public NFTResource(com.mir4.nftsearch.service.NFTService NFTService) {
        this.NFTService = NFTService;
    }
    @PostMapping("/nfts")
    public ResponseEntity<List<String>> getNFT(@RequestBody NFTFilters request) {
        List<String> response = NFTService.getNftList(request);
        return ResponseEntity.ok().body(response);
    }


}
