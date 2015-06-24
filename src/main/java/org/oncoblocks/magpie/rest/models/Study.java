package org.oncoblocks.magpie.rest.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;

@Document(collection = "study")
public class Study {

    @Id
    private String studyId;

    private String description;
    private ArrayList< HashMap<String, String> > attributes;
    public String getStudyId() {
        return studyId;
    }

    public void setStudyId(String studyId) {
        this.studyId = studyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<HashMap<String, String>> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<HashMap<String, String>> attributes) {
        this.attributes = attributes;
    }


    @Override
    public String toString(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}