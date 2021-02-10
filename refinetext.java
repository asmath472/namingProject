package _003_java.nazuke;

import java.util.ArrayList;
import java.util.Scanner;

public class refinetext {
    private String compoundName;
    private ArrayList<String> suffixList = new ArrayList<String>();
    private ArrayList<String> prefixList = new ArrayList<String>();

    private void getName()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("화합물 명을 입력하세요. Please insert the name of compound.");
        this.compoundName=sc.next();
    }

    private void importSuffix()
    {
        this.suffixList.add("ol");
        this.suffixList.add("ane");
        this.suffixList.add("ene");
    }
    private void importPrefix()
    {
        this.prefixList.add("di");
        this.prefixList.add("tri");
    }

    private int hasSuffix(String word)
    {
        
        int suffixListSize = this.suffixList.size();
        
        for (int i=0;i<suffixListSize;i++)
        {
            if(word.equals(suffixList.get(i)))
            {
                return 2;
            }
        }//word가 suffix와 같다면 2 return

        for (int i=0;i<suffixListSize;i++)
        {
            int suffixSize = this.suffixList.get(i).length();
            int wordSize   = word.length();
            if(this.suffixList.get(i).equals(word.substring(wordSize-suffixSize,wordSize)))//마지막에 붙은게 같다면
            {
                return 1;
            } //suffix 가 포함된 것이라면 return 1.
        }
        return -1; // 아니면 -1
    }

    private String hyphenMethod()
    {
        String[] compoundWord = this.compoundName.split("-");
        int index = compoundWord.length;
        for (int j = 0 ; j < index ;j++)
        {
            int hasSuffixResult=this.hasSuffix(compoundWord[j]);
            if(hasSuffixResult == 1)//suffix 와 같지 않으면서 suffix가 포함된 word 발견 
            {
                //여기에 모체사슬 있다.
                return compoundWord[j];
            }
            else if(hasSuffixResult == 2) //suffix 와 정확히 같은 word 발견. 숫자가 포함되어있는 형태이다.
            {
                //고로 2개 전에 모체사슬이 있다. 숫자 word가 있으므로.

                return compoundWord[j-2];
            }
            else{
                continue;
            }
        }
        //끝까지 suffix가 나오지 않았다.
        return "error";

        /*
        while ((index = copiedName.lastIndexOf("-"))!= -1)
        {


            //그러니까, 지금 확인한 하이픈 전의 word가 suffix가 있다면, 넘어간다.
            if(this.hasSuffix(copiedName.substring(index+1,copiedName.length())) == true)
            {   
                continue;
            }
            else if(copiedName.)// 숫자로 구성되어있어도 넘어간다.
            {

            }
            else //둘 중 어느것도 아니라면, 이미 지나친 word중 숫자가 아닌 제일 앞에 있는 word 에서 모체사슬 찾을 수 있다.
            {
                //이 경우, 모체사슬이 포함된 word를 제출한다.
            }

            copiedName=copiedName.substring(0, index-1);

        }
        */
        //그냥 나왔다면, 제일 앞의 word가 모체사슬이다. 제일 앞의 word를 제출한다.

    }
    
    


    public void refinetextExecute() //대장함수이다. 차후 this.refinetextExecute 하나면 이 파일 전체가 실행된다.
    {
        this.getName();
        elementmanager masterManager = new elementmanager();
        this.importSuffix();
        this.importPrefix();

        String motherWord = this.hyphenMethod();


        
    }
}
