package com.mir4.nftsearch.web.rest.dto;

import java.util.List;

public class DataDTO {
    public int firstID;
    public int totalCount;
    public int more;
    public List<NFTElementDTO> lists;

    public DataDTO() {
    }

    public int getFirstID() {
        return firstID;
    }

    public void setFirstID(int firstID) {
        this.firstID = firstID;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getMore() {
        return more;
    }

    public void setMore(int more) {
        this.more = more;
    }

    public List<NFTElementDTO> getLists() {
        return lists;
    }

    public void setLists(List<NFTElementDTO> lists) {
        this.lists = lists;
    }
}
