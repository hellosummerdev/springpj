package hello.core.singleton;

public class StatefulService {
    private int price; // 상태를 유지하는 필드

     // stateful하게 개발한 경우
//    public void order(String name, int price) {
//        System.out.println("name = " + name + ", price = " + price);
//        this.price = price;// 여기가 문제가 됨!
//    }

    // stateless하게 개발한 경우
    public int order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
