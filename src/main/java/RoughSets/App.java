package RoughSets;

import java.util.ArrayList;
import java.util.HashSet;

public class App {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String filePath = "E:\\IdeaProjects\\RoughSets\\src\\main\\resources\\input.txt";

        //获取数据集
        ArrayList<Record> recordList =  Utils.readDataFile(filePath);
        //System.out.println(recordList);

        ArrayList<String> attributes = new ArrayList<String>();

        //约简了Color
        attributes.add("Shape");
        attributes.add("Size");

        //构建知识系统
        KnowledgeSystem ks = Utils.constructKnowledgeSystem(recordList, attributes);

        //测试集合：｛X1,X3,X4,X5｝
        HashSet<Record> originalRecordSet = new HashSet<>();
        originalRecordSet.add(recordList.get(0));
        originalRecordSet.add(recordList.get(2));
        originalRecordSet.add(recordList.get(3));
        originalRecordSet.add(recordList.get(4));

        System.out.println("====== 上近似集合 ======");
        HashSet<Record> upSimilarRecordSet = ks.getUpSimilarRC(originalRecordSet);
        for(Record record : upSimilarRecordSet){
            System.out.println(record);
        }
        System.out.println("====== 下近似集合 ======");
        HashSet<Record> downSimilarRecordSet = ks.getDownSimilarRC(originalRecordSet);
        for(Record record : downSimilarRecordSet){
            System.out.println(record);
        }
    }
}
