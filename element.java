package _003_java.nazuke;

public class element {
    protected String element_sign;//수소, 탄소, 산소 등의 이름을 입력하는 칸.
    protected int BONDING_MAX;
    public element(String element_sign_input)
    {    
        element_sign=element_sign_input; 
        //element sign 생성자. sign 은 반드시 소문자로만 입력하여야 한다.

        BONDING_MAX=bondingSet(element_sign);
        //가능한 bonding 수 set
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
        else{
            System.out.println("지원하지 않는 원소입니다.");
            return 0;
        }
    }
}
