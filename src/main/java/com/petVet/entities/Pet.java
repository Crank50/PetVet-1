package com.petVet.entities;


public class Pet {
    public static enum PetType { DOG, CAT, FISH, BIRD }

    private String petId;
    private String name;
    private PetType petType;
    private String ownerId;

    public Pet() {

    }

    public Pet(String petId, String name, PetType petType, String ownerId) {
        this.petId = petId;
        this.name = name;
        this.petType = petType;
        this.ownerId = ownerId;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public PetType getPetType() {

        return petType;
    }

    public void setPetType(PetType petType) {

        this.petType = petType;
    }

    public String getOwnerId() {

        return ownerId;
    }

    public void setOwnerId(String ownerId) {

        this.ownerId = ownerId;
    }
}



