package RoughSets;

import java.util.ArrayList;

public class App {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String filePath = "E:\\IdeaProjects\\RoughSets\\src\\main\\resources\\input.txt";

        //获取数据集
        ArrayList<Record> recordList =  Utils.readDataFile(filePath);
        System.out.println(recordList);

        ArrayList<String> attributes = new ArrayList<String>();

        //约简了Color
        attributes.add("Shape");
        attributes.add("Size");

        //构建知识系统
        KnowledgeSystem ks = Utils.constructKnowledgeSystem(recordList, attributes);

    }
}
