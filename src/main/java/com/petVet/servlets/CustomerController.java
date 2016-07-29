package com.petVet.servlets;

import com.petVet.data.DataCache;
import com.petVet.data.DataCacheJson;
import com.petVet.entities.Owner;
import com.petVet.entities.Pet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerController extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {

        String uri = request.getRequestURI();
        System.out.println("Requested URI: " + uri);

        String jspName = uri.substring(uri.lastIndexOf('/') + 1);
        System.out.println("JSP Name: " + jspName);

        if (jspName.equalsIgnoreCase("viewAllPets")) {
            ArrayList<Pet> pets = DataCacheJson.getPets();
            request.setAttribute("pets", pets);

        } else if (jspName.equalsIgnoreCase("viewPet") || (jspName.equalsIgnoreCase("editPet"))) {
            String petId = request.getParameter("petId");
            Pet pet = DataCacheJson.getPet(petId);
            request.setAttribute("pet", pet);
            request.setAttribute("petTypes", Pet.PetType.values());

        } else if (jspName.equalsIgnoreCase("addNewPet")) {
            request.setAttribute("petTypes", Pet.PetType.values());

        } else if (jspName.equalsIgnoreCase("viewAllOwners")) {
            ArrayList<Owner> owners = DataCacheJson.getOwners();
            request.setAttribute("owners", owners);


        } else if ((jspName.equalsIgnoreCase("viewOwner") || (jspName.equalsIgnoreCase("editOwner")))) {
            String ownerId = request.getParameter("ownerid");
            Owner owner = DataCacheJson.getOwner(ownerId);
            request.setAttribute("owner", owner);


        } else if (jspName.equalsIgnoreCase("addNewOwner")) {

        } else if (jspName.equalsIgnoreCase("saveNewOwner")) {
            Owner saveNewOwner = new Owner();
            saveNewOwner.setFirstName(request.getParameter("firstname"));
            saveNewOwner.setLastName(request.getParameter("lastname"));
            saveNewOwner.setPhone(request.getParameter("phone"));
            saveNewOwner.setAddress(request.getParameter("address"));
            saveNewOwner.setOwnerId(System.currentTimeMillis() + "-" + saveNewOwner.getFirstName().charAt(0) + saveNewOwner.getLastName().charAt(0));
            DataCacheJson.setOwner(saveNewOwner);
            jspName = "viewAllOwners";

        }else if (jspName.equalsIgnoreCase("saveNewPet")) {
            Pet saveNewPet = new Pet();
            saveNewPet.setName(request.getParameter("name"));
            saveNewPet.setPetType(Pet.PetType.valueOf(request.getParameter("petType")));
            saveNewPet.setOwnerId(request.getParameter("ownerId"));
            saveNewPet.setPetId(System.currentTimeMillis() + "-" + saveNewPet.getName().charAt(0));
            DataCacheJson.setPet(saveNewPet);
            jspName = "viewAllPets";

        } else if (jspName.equalsIgnoreCase("updateOwner")) {
            String ownerId = request.getParameter("ownerid");
            Owner updateOwner = DataCacheJson.getOwner(ownerId);
            updateOwner.setFirstName(request.getParameter("firstname"));
            updateOwner.setLastName(request.getParameter("lastname"));
            updateOwner.setPhone(request.getParameter("phone"));
            updateOwner.setAddress(request.getParameter("address"));
            DataCacheJson.setOwner(updateOwner);
            jspName = "viewAllOwners";

        } else if(jspName.equalsIgnoreCase("updatePet")) {
            String petId = request.getParameter("petId");
            Pet updatePet = DataCacheJson.getPet(petId);
            updatePet.setOwnerId(request.getParameter("ownerId"));
            updatePet.setName(request.getParameter("name"));
            updatePet.setPetType(Pet.PetType.valueOf(request.getParameter("petType")));
            DataCacheJson.setPet(updatePet);
            jspName = "viewAllPets";

        }


        // ... add the if-else logic for the owner views...


        RequestDispatcher view = request.getRequestDispatcher("/customer/" + jspName + ".jsp");
        view.forward(request, response);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }
}

