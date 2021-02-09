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

    private boolean hasSuffix(String word)
    {
        int suffixListSize = this.suffixList.size();
        for (int i=0;i<suffixListSize;i++)
        {
            int suffixSize = this.suffixList.get(i).length();
            int wordSize   = word.length();
            if(this.suffixList.get(i).equals(word.substring(wordSize-suffixSize,wordSize)))//마지막에 붙은게 같다면
            {
                return true;
            }
        }
        return false;
    }

    private String hyphenMethod(int compoundNameLength)
    {
        int index;
        String copiedName = this.compoundName;
        while ((index = copiedName.lastIndexOf("-"))!= -1)
        {
            //그러니까, 지금 확인한 하이픈 전의 word가 suffix가 있다면, 넘어간다.
            if(this.hasSuffix(copiedName.substring(index+1,copiedName.length())) == true)
            {   
                continue;
            }
            else if()// 숫자로 구성되어있어도 넘어간다.
            {

            }
            else //둘 중 어느것도 아니라면, 이미 지나친 word중 숫자가 아닌 제일 앞에 있는 word 에서 모체사슬 찾을 수 있다.
            {
                //이 경우, 모체사슬이 포함된 word를 제출한다.
            }
        }
        //그냥 나왔다면, 제일 앞의 word가 모체사슬이다. 제일 앞의 word를 제출한다.

    }
    


    public void refinetextExecute() //대장함수이다. 차후 this.refinetextExecute 하나면 이 파일 전체가 실행된다.
    {
        this.getName();
        elementmanager masterManager = new elementmanager();
        this.importSuffix();
        this.importPrefix();


        int compoundNameLength = this.compoundName.length()
    }
}
