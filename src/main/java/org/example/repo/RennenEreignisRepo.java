package org.example.repo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.RennenEreignis;

import java.io.File;
import java.util.List;

public class RennenEreignisRepo {
    private List<RennenEreignis> rennenEreignis;

    public RennenEreignisRepo(String filename){
        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);

        try{
            rennenEreignis =mapper.readValue(new File(filename), new TypeReference<List<RennenEreignis>>() {});
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<RennenEreignis> getEvents() {
        return rennenEreignis;
    }
}
