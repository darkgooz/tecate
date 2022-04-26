package com.mir4.nftsearch.web.rest.dto;

import java.util.List;
import java.util.Map;

public class NFTFilters {
    private List<String> pets;
    private List<TreasureDetails> treasures;
    private Integer pages;

    public NFTFilters() {
    };

    public List<String> getPets() {
        return pets;
    }

    public void setPets(List<String> pets) {
        this.pets = pets;
    }

    public List<TreasureDetails> getTreasures() {
        return treasures;
    }

    public void setTreasures(List<TreasureDetails> treasures) {
        this.treasures = treasures;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
