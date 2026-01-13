package org.example.repo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Strafe;

import java.io.File;
import java.util.List;

public class StrafeRepo {
    private List<Strafe> penalties;

    public StrafeRepo(String filename) {
        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);

        try{
            penalties =mapper.readValue(new File(filename), new TypeReference<List<Strafe>>() {});
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Strafe> getPenalties() {
        return penalties;
    }
}
