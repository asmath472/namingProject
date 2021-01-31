package _003_java.nazuke;

public class element {
    protected String element_sign;//수소, 탄소, 산소 등의 이름을 입력하는 칸.
    protected int BONDING_MAX;
    public static int uniqueNumber=0; //식별번호를 넣어둔다.
    protected bonding[] bondingArray=new bonding[4];//bonding 에 대한 정보를 넣어두는 칸
    protected int bonding_index = 0; //bonding array 에 넣을 index

    public element(String element_sign_input)
    {    
        this.element_sign=element_sign_input; 
        //element sign 생성자. sign 은 반드시 소문자로만 입력하여야 한다.

        this.BONDING_MAX=bondingSet(element_sign);
        //가능한 bonding 수 set
        this.uniqueNumber++; //고유 번호를 부여한다. 0부터..
    }

    protected int bondingSet(String element_sign)
    {
        if(element_sign=="c"){
            System.out.println("This is carbon.");
            return 4;
        }
        else if(element_sign=="o"){
            System.out.println("This is Oxygen");
            return 2;
        }
        else if (element_sign=="h"){
            System.out.println("This is Hydrogen");
            return 1;
        }
        else if (element_sign=="n"){
            System.out.println("This is Nitrogen");
            return 3;
        }
        else if(element_sign=="cl"){
            System.out.println("This is cloride");
        }
        else{
            System.out.println("지원하지 않는 원소입니다.");
            return 0;
        }
        return 0;
    }


}
