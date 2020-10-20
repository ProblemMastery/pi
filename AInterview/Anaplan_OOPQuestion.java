//// 1. you cannnot use the java clone
//// 2. you cannot change the access to private (no getter/ setter / new c'tor with params)
//// 3. you cannot overload the myClone()
//// 4. you can add any other helper method in any access level (pu/pri/pro)
//
//public class Clone {
//    public static void main(String[] args) {
//        A aa = new B();
//        aa.print(); // "a: 5, b: 9,
//
//        A cloned = aa.myClone();
//        cloned.print();  // "a: anyInteger, b: 9,
//
//    }
//}
//
//class A {
//    private int a;
//    A() {
//        a = rand();
//    }
//
//    A getInstance(){
//        return new A();
//    }
//
//
//    A myClone() {
//        A newObj =  getInstance() ;
//        newObj.a = this.a;
//        return newObj;
//    }
//
//    public void print() {
//        System.out.print("a: " + a);
//    }
//}
//
//
//class B extends A {
//    private int b;
//    B() {
//        b = rand();
//    }
//
//    @Override
//    A getInstance() {
//
//        return new B();
//    }
//
//    A myClone() {
//
//        B obj = (B)super.myClone(); // A a=5 ;
//        obj.b = b;
//        return obj;
//
//    }
//
//    public void print() {
//        super.print();
//        System.out.print(",b: " + b);
//    }
//
//}
//
//class C extends B {
//    private int c;
//    C() {
//        c = rand();
//    }
//    A myClone() {
//    }
//
//    public void print() {
//        super.print();
//        System.out.print(",c: " + c);
//    }
//}