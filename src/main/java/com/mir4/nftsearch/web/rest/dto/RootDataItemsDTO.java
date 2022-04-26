package com.mir4.nftsearch.web.rest.dto;
import java.util.List;

public class RootDataItemsDTO {
    public int code;
    public List<NFTItemDTO> data;
    public RootDataItemsDTO() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<NFTItemDTO> getData() {
        return data;
    }

    public void setData(List<NFTItemDTO> data) {
        this.data = data;
    }
}
