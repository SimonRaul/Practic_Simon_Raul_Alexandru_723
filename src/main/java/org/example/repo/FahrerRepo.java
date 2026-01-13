package org.example.repo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Fahrer;

import java.io.File;
import java.util.List;

public class FahrerRepo {
    private List<Fahrer> fahrers;

    public FahrerRepo(String filename) {
        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);

        try{
            fahrers = mapper.readValue(new File(filename), new TypeReference<List<Fahrer>>() {});
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Fahrer> getFahrers() {
        return fahrers;
    }
}
