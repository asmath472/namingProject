package _003_java.nazuke;

public class elementmanager {
    static private int elementMaxNumber=1000; // 최대로 넣을 수 있는 원자 개수 지정.

    public element[] elementList = new element[elementMaxNumber];

    public void elementInsert(String elementSign)
    {
        element objectElement =  new element(elementSign);
        int objectUniqueNumber = objectElement.getUniqueNumber();

        if (objectUniqueNumber < this.elementMaxNumber)
        {
            this.elementList[objectUniqueNumber] = objectElement;
        }
        else
        {
            System.out.println("공간이 부족합니다. *elementMaxNumber초과");
        }
    }

    public void bondElement(element element1, element element2,int bondDegree)
    {
        element2.bondingEstablish(element1,bondDegree);
        element1.bondingEstablish(element2,bondDegree);
    }

}
