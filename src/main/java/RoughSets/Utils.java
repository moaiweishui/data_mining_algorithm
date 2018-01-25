package RoughSets;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Utils {

    public static ArrayList<Record> readDataFile(String fileName){
        File file = new File(fileName);
        ArrayList<Record> recordList = new ArrayList<Record>();

        try{
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str = in.readLine();
            String[] columns = str.split(" ");
            str = in.readLine();
            while(str != null){
                String[] values = str.split(" ");

                HashMap<String, String> attr = new HashMap<String, String>();
                attr.put(columns[1], values[1]);
                attr.put(columns[2], values[2]);
                attr.put(columns[3], values[3]);

                Record record = new Record(values[0], attr, values[4]);
                recordList.add(record);
                str = in.readLine();
            }
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return recordList;
    }

    public static KnowledgeSystem constructKnowledgeSystem(ArrayList<Record> recordList, ArrayList<String> attributes){

        KnowledgeSystem ks = new KnowledgeSystem();

        for(Record record : recordList){

            boolean matchFlag = false;

            for(RecordCollection recordCollection : ks.getRecordCollectionList()){

                if(isTagsMatch(record, recordCollection, attributes)){
                    matchFlag = true;
                    recordCollection.getRecordList().add(record);
                    break;
                }
            }

            if(!matchFlag){
                HashMap<String, String> newTags = new HashMap<String, String>();
                for(String attrName : attributes){
                    newTags.put(attrName, record.getAttr().get(attrName));
                }
                RecordCollection rc = new RecordCollection();
                rc.setTags(newTags);
                rc.getRecordList().add(record);

                ks.getRecordCollectionList().add(rc);
            }
        }

        return ks;
    }

    public static boolean isTagsMatch(Record record, RecordCollection recordCollection, ArrayList<String> attributes){
        for(String attrName : attributes){
            if(!recordCollection.getTags().get(attrName).equals(record.getAttr().get(attrName))){
                return false;
            }
        }
        return true;
    }

}