package com.mir4.nftsearch.service;

import com.mir4.nftsearch.service.external.ServiceExternal;
import com.mir4.nftsearch.web.rest.dto.DataDTO;
import com.mir4.nftsearch.web.rest.dto.RootDataDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class NFTService {

    private final ServiceExternal serviceExternal;

    public NFTService(ServiceExternal serviceExternal) {
        this.serviceExternal = serviceExternal;
    }


   public RootDataDTO getNftList() {
      return serviceExternal.getNftList();
   }


}
