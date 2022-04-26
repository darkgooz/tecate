package com.mir4.nftsearch.service;

import com.mir4.nftsearch.service.external.ServiceExternal;
import com.mir4.nftsearch.web.rest.dto.DataDTO;
import com.mir4.nftsearch.web.rest.dto.NFTElementDTO;
import com.mir4.nftsearch.web.rest.dto.RootDataDTO;
import com.mir4.nftsearch.web.rest.dto.SpiritDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class NFTService {

    private final ServiceExternal serviceExternal;

    public NFTService(ServiceExternal serviceExternal) {
        this.serviceExternal = serviceExternal;
    }


    public List<String> getNftList(List<String> pets) {
        List<String> results = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            RootDataDTO rootDataDTO = serviceExternal.getNftList(i);
            if (rootDataDTO.getCode() == 200) {
                DataDTO data = rootDataDTO.getData();
                if (data.getLists() != null)
                    for (NFTElementDTO element : data.getLists()) {
                        RootDataDTO spirit = serviceExternal.getSpiritList(element.getTransportID());
                        if (spirit.getCode() == 200) {
                            if (spirit.getData() != null) {
                                if (spirit.getData().getInven() != null) {
                                    int containsAll = 0;
                                    List<String> allPets =
                                        spirit.getData().getInven().stream().map(SpiritDTO::getPetName).collect(Collectors.toList());
                                    for (String spiritElement : pets) {
                                        if (allPets.contains(spiritElement)) {

                                            containsAll++;
                                        }
                                    }
                                    if (containsAll == pets.size()) {
                                        results.add("https://www.xdraco.com/nft/trade/" + element.getSeq());
                                    }
                                }
                            }
                        }
                    }
            }
        }
        return results;
    }


}
