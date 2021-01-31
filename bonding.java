package _003_java.nazuke;

public class bonding {
    public int bondDegree;
    public int counterNumber;//상대쪽의 
    
    public bonding(int num,int bond) //bond 차수가 뒤쪽에 위치한다. 바꿀까?
    {
        this.bondDegree=bond;
        this.counterNumber=num;
    }
    
}
