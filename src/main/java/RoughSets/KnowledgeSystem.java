package RoughSets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

    HashSet<Record> getUpSimilarRC(HashSet<Record> originalRecordSet){
        HashSet<Record> upSimilarRecordSet = new HashSet<>();
        for(RecordCollection rc : this.recordCollectionList){
            //判断是否有交集
            HashSet<Record> tempRecordSet = new HashSet<>(rc.getRecordList());
            tempRecordSet.retainAll(originalRecordSet);
            if(!tempRecordSet.isEmpty()){
                upSimilarRecordSet.addAll(rc.getRecordList());
            }
        }

        return upSimilarRecordSet;
    }

    HashSet<Record> getDownSimilarRC(HashSet<Record> originalRecordSet){
        HashSet<Record> downSimilarRecordSet = new HashSet<>();
        for(RecordCollection rc : this.recordCollectionList){
            HashSet<Record> tempRecordSet = new HashSet<>(rc.getRecordList());
            tempRecordSet.removeAll(originalRecordSet);
            if(tempRecordSet.isEmpty()){
                downSimilarRecordSet.addAll(rc.getRecordList());
            }
        }

        return downSimilarRecordSet;
    }
}
