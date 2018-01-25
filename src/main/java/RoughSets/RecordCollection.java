package RoughSets;

import java.util.ArrayList;
import java.util.HashMap;

public class RecordCollection {
    private HashMap<String, String> tags;
    private ArrayList<Record> recordList;

    public HashMap<String, String> getTags() {
        return tags;
    }

    public void setTags(HashMap<String, String> tags) {
        this.tags = tags;
    }

    public ArrayList<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(ArrayList<Record> recordList) {
        this.recordList = recordList;
    }

    public RecordCollection(){
        this.tags = new HashMap<String, String>();
        this.recordList = new ArrayList<Record>();
    }

    public RecordCollection(HashMap<String, String> tags, ArrayList<Record> recordList) {
        this.tags = tags;
        this.recordList = recordList;
    }




}

