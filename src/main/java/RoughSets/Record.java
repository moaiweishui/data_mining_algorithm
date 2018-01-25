package RoughSets;

import java.util.HashMap;

public class Record {
    private String id;
    private HashMap<String, String> attr;
    private String classification;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, String> getAttr() {
        return attr;
    }

    public void setAttr(HashMap<String, String> attr) {
        this.attr = attr;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }


    public Record(String id, HashMap<String, String> attr, String classification){
        this.id = id;
        this.attr = attr;
        this.classification = classification;
    }

    public boolean isAttrMatch(String attrName, String attrValue) {
        return attr.containsKey(attrName) && attr.get(attrName).equals(attrValue);
    }


}