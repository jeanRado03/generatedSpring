package com.generated.project.pagination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Pagination {
    public Iterable<?> objects;
    public int numeroPage;
    public int taille;


    public Iterable<?> getObjects() {
        return objects;
    }

    public void setObjects(Iterable<?> objects) {
        this.objects = objects;
    }

    public int getNumeroPage() {
        return numeroPage;
    }

    public void setNumeroPage(int numeroPage) {
        this.numeroPage = numeroPage;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public Pagination(Iterable<?> objects, int numeroPage) {
        this.setObjects(objects);
        this.setNumeroPage(numeroPage-1);
        this.setTaille(5);
    }

    public HashMap<String,Object> getPagination() {
        HashMap<String,Object> values = new HashMap<>();
        List<Object> pagination = new ArrayList<Object>();
        this.getObjects().forEach(pagination::add);
        int startIndex = this.getNumeroPage() * this.getTaille();
        int endIndex = Math.min(startIndex + this.getTaille(), pagination.size());

        if (startIndex > endIndex && this.getNumeroPage() != 0) {
            values.put("data", Collections.emptyList());
            return values;
        }

        values.put("statut", 200);
        values.put("error", null);
        values.put("page", (int)Math.ceil((double)pagination.size()/this.getTaille()));
        if(this.getNumeroPage() == -1)
            values.put("donnees", pagination);
        else
            values.put("donnees", pagination.subList(startIndex, endIndex));

        return values;
        //return pagination.subList(startIndex, endIndex);
    }
}
