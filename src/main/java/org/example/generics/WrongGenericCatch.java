package org.example.generics;

public class WrongGenericCatch {
}

//Error 这是错误的不可以的,因为Generic是泛型类他继承Exception
//class Generic<T> extends Exception {
//
//}

//Success 这是可以的因为Generic虽然是泛型类但是他没有继承Exception,它只是对T进行限定类型变量为Exception本身或子类
class Generic<T extends Exception>{

}

//try {
//    // may throws exception
//    doSomeStuff();
//    } catch (SomeException<Integer> e) {
//    doA();
//    } catch (SomeException<String> e) {
//    doB();
//}