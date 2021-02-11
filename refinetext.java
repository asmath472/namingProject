package _003_java.nazuke;

import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class refinetext {
    private String compoundName;
    private ArrayList<String> suffixList = new ArrayList<String>();
    private ArrayList<String> prefixList = new ArrayList<String>();
    private ArrayList<motherchainsolution> motherChainList = new ArrayList<motherchainsolution>();
    final String nosuffix = "_NO_SUFFIX_";


    private void getName()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("화합물 명을 입력하세요. Please insert the name of compound.");
        this.compoundName=sc.next();
    }

    private void importMotherChain()
    {
        this.motherChainList.add(new motherchainsolution("meth", 1));
        this.motherChainList.add(new motherchainsolution("methan", 1));
        this.motherChainList.add(new motherchainsolution("eth", 2));
        this.motherChainList.add(new motherchainsolution("ethan", 2));
        this.motherChainList.add(new motherchainsolution("prop", 3));
        this.motherChainList.add(new motherchainsolution("propan", 3));
        this.motherChainList.add(new motherchainsolution("but", 4));
        this.motherChainList.add(new motherchainsolution("butan", 4));
    }

    /*
     * SUFFIX, PREFIX 관련 함수 시작.
     */

    private void importSuffix() {
        this.suffixList.add("ol");
        this.suffixList.add("ane");
        this.suffixList.add("ene");
    }

    private void importPrefix() {
        this.prefixList.add("di");
        this.prefixList.add("tri");
    }

    private String findSuffix(String word) {
        int suffixListSize = this.suffixList.size();
        for (int i = 0; i < suffixListSize; i++) {
            if (word.equals(suffixList.get(i))) {
                return word;
            }
        } // word가 suffix와 같다면 2 return

        for (int i = 0; i < suffixListSize; i++) {
            int suffixSize = this.suffixList.get(i).length();
            int wordSize = word.length();
            if (this.suffixList.get(i).equals(word.substring(wordSize - suffixSize, wordSize)))// 마지막에 붙은게 같다면
            {
                return this.suffixList.get(i);
            } // suffix 가 포함된 것이라면 return 1.
        }
        return nosuffix; // 아니면 -1
    }

    private String deleteSuffix(String word) {
        String objectSuffix = this.findSuffix(word);
        if (nosuffix.equals(objectSuffix)) 
        {
            return word;
        } 
        else 
        {
            return word.substring(0, word.length() - objectSuffix.length());
        }
    }

    private int hasSuffix(String word) {
        String findSuffixReturn = this.findSuffix(word);
        if (findSuffixReturn.equals(nosuffix)) {
            return -1;
        } else if (findSuffixReturn.equals(word)) {
            // word 자체가 suffix 인 경우
            return 2;
        } else {
            return 1;
        }
    }

    /*
     * SUFFIX, PREFIX 관련 함수 끝.
     */


    //모체 사슬의 길이를 알아내는 함수
    private int findMotherNum(String motherWord)
    {
        String mother_without_suffix = this.deleteSuffix(motherWord);
        
        for (int i=0; i<this.motherChainList.size();i++)
        {

            //뭔가 좀 긴데, 결국은 어머니 체인 리스트 내의 원소를 차례로 검사하면서,
            //suffix가 빠진 어머니 word 중 뒤에서 어머니 체인 내의 원소의 이름 만큼의 길이와
            //어머니 체인 내의 원소의 이름 문자열이 동등한지 확인하는 작업.

            //이를테면 butan-1-ol 에서 butan 은 4이고, 이는 List 의 Butan 원소에서 걸려서 4를 출력할 것.

            String objectString = this.motherChainList.get(i).motherName;
            if(mother_without_suffix.substring(mother_without_suffix.length()-objectString.length()+1).equals(objectString))
            {
                return this.motherChainList.get(i).number;    
            }
        }

        return -1;
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
        
        String motherWord; //모체사슬이 포함된 하이픈 사이의 단어.
        int motherNum; //모체사슬 길이.



        this.getName();
        elementmanager masterManager = new elementmanager();
        this.importSuffix();
        this.importPrefix();
        this.importMotherChain();

        motherWord = this.hyphenMethod();
        motherNum=this.findMotherNum(motherWord);

        
    }
}
