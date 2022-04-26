package com.mir4.nftsearch.service;

import com.mir4.nftsearch.service.external.ServiceExternal;
import com.mir4.nftsearch.web.rest.dto.*;
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


    public List<String> getNftList(NFTFilters request) {
        List<String> results = new ArrayList<>();
        int containsAll = 0;
        int sizeTreasure = 0;
        for (int i = 1; i <= request.getPages(); i++) {
            RootDataDTO rootDataDTO = serviceExternal.getNftList(i);
            if (rootDataDTO.getCode() == 200) {
                DataDTO data = rootDataDTO.getData();
                if (data.getLists() != null)
                    for (NFTElementDTO element : data.getLists()) {
                        RootDataDTO spirit = serviceExternal.getSpiritList(element.getTransportID());
                        if (spirit.getCode() == 200) {
                            if (spirit.getData() != null) {
                                if (spirit.getData().getInven() != null) {
                                    List<String> allPets =
                                        spirit.getData().getInven().stream().map(SpiritDTO::getPetName).collect(Collectors.toList());
                                    for (String spiritElement : request.getPets()) {
                                        if (allPets.contains(spiritElement)) {
                                            containsAll++;
                                        }
                                    }
                                }
                            }
                        }
                        RootDataItemsDTO treasures = serviceExternal.getItemList(element.getTransportID());
                        if (treasures.getCode() == 200){
                            if (treasures.getData() != null){
                                for (TreasureDetails treasure : request.getTreasures()){
                                    Long count = treasures.getData().stream().filter(value -> {
                                        boolean b =
                                            value.getGrade().equalsIgnoreCase(treasure.getGrade()) && value.getItemName().equalsIgnoreCase(treasure.getName());
                                        return b;
                                    }).count();
                                    if (count.intValue() >= treasure.getAmount())
                                        sizeTreasure++;
                                }
                            }
                        }
                        if (containsAll == request.getPets().size() && sizeTreasure == request.getTreasures().size()) {
                            results.add("https://www.xdraco.com/nft/trade/" + element.getSeq());
                        }
                    }
            }
        }
        return results;
    }


}
