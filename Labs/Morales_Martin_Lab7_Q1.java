/*
Name: Martin Morales Arana
Student ID: 1172178
Lab 7, Q1

The program uses the IntegerImp class to store implement an integer as a class that supports multiple methods
isEven returns true if a certain value is even and false if not, equals returns true if two values are equal
and false if not. ParseInt returns the integer transformation of a cString (array of characters) or a string.
All methods are overloaded.
 */
class IntegerImp{
    private int value; // int value

    // Constructor
    public IntegerImp(int value) {
        this.value = value;
    }

    // Getter for value
    public int getValue() {
        return value;
    }

    // isEven overloaded methods
    public boolean isEven(){ return (value%2==0);}

    public static boolean isEven(int num){ return (num%2==0);}

    public static boolean isEven(IntegerImp val){ return (val.value%2==0);}

    // equals overloaded methods
    public boolean equals(int val){ return (value==val);}

    public boolean equals(IntegerImp val){ return (value==val.value);}

    // parseInt overloaded methods
    public static int parseInt(char[] arr){
        int pow=0, ans=0;
        for(int i=arr.length-1; i>=0; i--, pow++) ans+=Math.pow(10, pow)*(char)(arr[i]-'0'); // multiply the value of curChar to curPower and add it to ans
        return ans;
    }

    public static int parseInt(String str){
        int pow=0, ans=0;
        for(int i=str.length()-1; i>=0; i--, pow++) ans+=Math.pow(10, pow)*(char)(str.charAt(i)-'0'); // multiply the value of curChar to curPower and add it to ans
        return ans;
    }
}
public class Morales_Martin_Lab7_Q1 {
    public static void main(String[] args) {
        IntegerImp num1 = new IntegerImp(13);
        System.out.println("13 is " + ((num1.isEven())? "even" : "odd"));
        System.out.println("8 is " + ((IntegerImp.isEven(8))? "even" : "odd"));
        num1 = new IntegerImp(267);
        System.out.println("267 is " + ((IntegerImp.isEven(num1))? "even" : "odd"));
        System.out.println("num1 is " + ((num1.equals(267))? "equal " : "not equal ") + "to 267");
        IntegerImp num2 = new IntegerImp(13);
        System.out.println("num1 is " + (num1.equals(num2)? "equal " : "not equal ") + "to num2");

        char[] cStr = new char[5];
        for(int i=1, index=0; i<=5; i++, index++) cStr[index]=(char)(i+'0');
        System.out.println("cStr is " + ((IntegerImp.parseInt(cStr))));
        String javaStr = "98627";
        System.out.println("javaStr is " + ((IntegerImp.parseInt(javaStr))));
    }
}