package com.petVet.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petVet.entities.Owner;
import com.petVet.entities.Pet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;



/**
 * Created by Justin on 7/28/16.
 */
public class DataCacheJson {
    private static DataCacheJson instance = null;

    private static HashMap<String, Pet> petsHashMap;
    private static HashMap<String, Owner> ownersHashMap;
    private static Path petsFilePath = Paths.get("/Users/Justin/pet.json");
    private static Path ownersFilePath = Paths.get("/Users/Justin/owners.json");

    private DataCacheJson() {
        // Exists only to defeat instantiation.
    }

    public static synchronized DataCacheJson getInstance() {
        if(instance == null) {
            instance = new DataCacheJson();
        }
        return instance;
    }

    private static void checkLoaded() {
        if(petsHashMap==null || petsHashMap.isEmpty()) {
            loadDataCache();
        }
    }

    public static ArrayList<Pet> getPets() {
        checkLoaded();
        return new ArrayList<>(petsHashMap.values());
    }

    public static Pet getPet(String petId) {
        checkLoaded();
        Pet pet = null;
        if(petsHashMap.containsKey(petId)) {
            pet = petsHashMap.get(petId);
        }
        return pet;
    }

    public static void setPet(Pet pet) {
        checkLoaded();
        petsHashMap.put(pet.getPetId()+"",pet);
        saveAllToFiles();
    }

    public static ArrayList<Owner> getOwners() {
        checkLoaded();
        return new ArrayList<>(ownersHashMap.values());
    }

    public static Owner getOwner(String ownerId) {
        checkLoaded();
        Owner owner = null;
        if(ownersHashMap.containsKey(ownerId)) {
            owner = ownersHashMap.get(ownerId);
        }
        return owner;
    }

    public static void setOwner(Owner owner) {
        checkLoaded();
        ownersHashMap.put(owner.getOwnerId()+"",owner);
        saveAllToFiles();
    }

    private static void saveAllToFiles() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(Files.newOutputStream(petsFilePath), petsHashMap);
            mapper.writeValue(Files.newOutputStream(ownersFilePath), ownersHashMap);
        } catch (IOException ioe) {
            System.out.println("Issue writing HashMaps to JSON files in DataCacheJson.saveAllToFiles()");
            ioe.printStackTrace();
        }
    }

    private static void loadDataCache() {
        if(!Files.exists(petsFilePath)) {
            initialLoadDataCache();
            saveAllToFiles();
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            petsHashMap = mapper.readValue(Files.newInputStream(petsFilePath), new TypeReference<HashMap<String,Pet>>(){});
            ownersHashMap = mapper.readValue(Files.newInputStream(ownersFilePath), new TypeReference<HashMap<String,Owner>>(){});
        } catch (IOException ioe) {
            System.out.println("Issue reading HashMaps from JSON files in DataCacheJson.loadDataCache()");
            ioe.printStackTrace();
        }
    }

    private static void initialLoadDataCache() {
        petsHashMap = new HashMap<>();
        ownersHashMap = new HashMap<>();

        String ownerId = System.currentTimeMillis()+"-bd";
        ownersHashMap.put(ownerId,new Owner(ownerId,"Bob","Denver","801-111-2222","123 Desert Island"));

        String petId = System.currentTimeMillis()+"-n";
        petsHashMap.put(petId, new Pet(petId,"Nemo",Pet.PetType.FISH,ownerId));

        ownerId = System.currentTimeMillis()+"-jd";
        ownersHashMap.put(ownerId,new Owner(ownerId,"Jane","Doe","801-333-4444","345 Avenue A."));

        petId = System.currentTimeMillis()+"-k";
        petsHashMap.put(petId, new Pet(petId,"Kat",Pet.PetType.CAT,ownerId));

        ownerId = System.currentTimeMillis()+"-mc";
        ownersHashMap.put(ownerId,new Owner(ownerId,"Master","Chief","801-555-6666","678 Halo Way"));

        petId = System.currentTimeMillis()+"-c";
        petsHashMap.put(petId, new Pet(petId,"Cortana",Pet.PetType.BIRD,ownerId));

        ownerId = System.currentTimeMillis()+"-sc";
        ownersHashMap.put(ownerId,new Owner(ownerId,"Santa","Clause","801-777-8888","1 North Pole"));

        petId = System.currentTimeMillis()+"-r";
        petsHashMap.put(petId, new Pet(petId,"Rudolph",Pet.PetType.DOG,ownerId));
    }

}
