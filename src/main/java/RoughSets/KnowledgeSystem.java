package RoughSets;

import java.util.ArrayList;

public class KnowledgeSystem {
    private ArrayList<RecordCollection> recordCollectionList;

    public ArrayList<RecordCollection> getRecordCollectionList() {
        return recordCollectionList;
    }

    public void setRecordCollectionList(ArrayList<RecordCollection> recordCollectionList) {
        this.recordCollectionList = recordCollectionList;
    }

    public KnowledgeSystem() {
        this.recordCollectionList = new ArrayList<RecordCollection>();
    }

    public KnowledgeSystem(ArrayList<RecordCollection> recordCollectionList) {
        this.recordCollectionList = recordCollectionList;
    }
}
