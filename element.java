package _003_java.nazuke;

public class element {
    protected String element_sign;//수소, 탄소, 산소 등의 기호를 입력하는 칸.
    protected int BONDING_MAX; //최대 결합수
    public static int uniqueNumber=0; //식별번호를 넣어둔다.
    protected bonding[] bondingArray=new bonding[4];//bonding 에 대한 정보를 넣어두는 칸
    protected int bonding_index = 0; //bonding array 에 넣을 index

    public element(String element_sign_input) //element 의 생성자
    {    
        this.element_sign=element_sign_input; 
        //element sign 생성자. sign 은 반드시 소문자로만 입력하여야 한다.

        this.BONDING_MAX=bondingNumSet(element_sign);
        //가능한 bonding 수 set
        this.uniqueNumber++; //고유 번호를 부여한다. 0부터..
    }



    protected int bondingNumSet(String element_sign)
    {
        if(element_sign.equals("c")){
            System.out.println("This is carbon.");
            return 4;
        }
        else if(element_sign.equals("o")){
            System.out.println("This is Oxygen");
            return 2;
        }
        else if (element_sign.equals("h")){
            System.out.println("This is Hydrogen");
            return 1;
        }
        else if (element_sign.equals("n")){
            System.out.println("This is Nitrogen");
            return 3;
        }
        else if(element_sign.equals("cl")){
            System.out.println("This is cloride");
        }
        else{
            System.out.println("지원하지 않는 원소입니다.");
            return 0;
        }
        return 0;
    }

    public int getUniqueNumber(){
        return this.uniqueNumber;
    }

    public void bondingEstablish(element object,int bondDegree)
    {   //단방향 결합만 만듬
        int objectUniqueNumber=object.getUniqueNumber();
        bonding newBond = new bonding(objectUniqueNumber,bondDegree);
        if(this.bonding_index + bondDegree <= this.BONDING_MAX)//새로이 bonding 을 만들 수 있는 경우
        {
            for (int i=0;i<bondDegree;i++)
            {
                this.bondingArray[bonding_index]=newBond;
                this.bonding_index++;
            }
        }
        else 
        {
            System.out.println("결합 공간이 부족합니다.");
        }
    }
    /*
    public void bondingDeletation(element object)
    {
        int objectUniqueNumber=getUniqueNumber();
        for (int i=0;i<this.BONDING_MAX;i++)
        {
            //try 를 이용해서 바꿀 수 있을 듯 하다.
            if(this.bondingArray[i].counterNumber==objectUniqueNumber) //찾는 그것이 있다면
            {

            }
        }
    }
    */ // 이 부분은 나중에 구현하자. 당장의 실행에는 문제가 없을 듯 하다.

    



}
