package org.example.generics;
interface Payable<T> {}

class  PayableImpl implements Payable<String> {}
// 类型擦除导致类型一致
//class SubPayableImpl extends PayableImpl implements Payable<Integer> {}
public class MultipleInterfaceVariants {
    public static void main(String[] args) {

    }
}
