package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GenericApp {
    public static void main(String[] args) {
        List<String> stringList = null;
        //List<Object> objectList = stringList; //ERROR because List is a invariant.
        //List<Object> not a sub-type of List<String>
        //Collection<String> stringCollection = stringList; //Compile

        processList(Arrays.asList(1, 2, 3));
        processList(Arrays.asList(1.2, 2.2, 3.2));
        processListAnother(Arrays.asList(1, 2, 3));
        processListAnother(Arrays.asList(1.2, 2.2, 3.2));
        processListLowerBoundAnother(Arrays.asList(1, 2, 3));
        List<Double> doubles = Arrays.asList(1.2, 2.2, 3.2);
        //processListLowerBoundAnother(doubles);//ERROR

        List<EvenNumber> le = new ArrayList<>();
        List<? extends NaturalNumber> ln = le;
        /*
        following operations on the list are possible:
        You can add null.
        You can invoke clear.
        You can get the iterator and invoke remove.
        You can capture the wildcard and write elements that you've read from the list.
         */
        //ln.add(new NaturalNumber(35)); //Error
        //ln.add(new EvenNumber(1));
    }

    //Upper bounded
    //In Scala, An upper type bound T <: A declares that type variable T refers to a subtype of type A
    public static <T extends Number> void processList(Collection<T> collection) {
        System.out.println(collection);
    }

    public static void processListAnother(Collection<? extends Number> collection) {
        System.out.println(collection);
    }

    /*
    While upper type bounds limit a type to a subtype of another type, lower type bounds declare a type to be a supertype of another type. The term B >: A expresses that the type parameter B or the abstract type B refer to a supertype of type A. In most cases, A will be the type parameter of the class and B will be the type parameter of a method.
     */
    public static <T extends Integer> void processListLowerBound(Collection<T> collection) {
        System.out.println(collection);
    }

    //It can accept only List<Integer>, List<Number>, and List<Object>
    public static void processListLowerBoundAnother(Collection<? super Integer> collection) {
        System.out.println(collection);
    }
}

class NaturalNumber {
    private int i;

    public NaturalNumber(int i) {
        this.i = i;
    }
}

class EvenNumber extends NaturalNumber {
    public EvenNumber(int i) {
        super(i);
    }
}