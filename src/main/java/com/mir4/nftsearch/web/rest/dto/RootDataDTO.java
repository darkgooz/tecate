package com.mir4.nftsearch.web.rest.dto;

public class RootDataDTO {
    public int code;
    public DataDTO data;

    public RootDataDTO() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }
}
