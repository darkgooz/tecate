package com.mir4.nftsearch.web.rest.dto;

public class SpiritDTO {
    public int transcend;
    public int grade;
    public String petName;
    public String petOrigin;
    public String iconPath;

    public SpiritDTO() {
    }

    public int getTranscend() {
        return transcend;
    }

    public void setTranscend(int transcend) {
        this.transcend = transcend;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetOrigin() {
        return petOrigin;
    }

    public void setPetOrigin(String petOrigin) {
        this.petOrigin = petOrigin;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }
}
