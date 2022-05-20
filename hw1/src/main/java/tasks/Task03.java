package tasks;

public class Task03 {

    /**
     * Реализовать сериализацию boolean.
     * Главное требование, чтобы {@link tasks.Task03#booleanDeserialize(int)}
     * возвращал тот же boolean по значению int.
     * Tip: в Java есть тернарный оператор:
     * int x = condition ? trueValue : falseValue;
     */

    // Просто кастить как в С++ нельзя, нужна проверка.
    public static int booleanSerialize(boolean b){
        return b ? 1 : 0;
        // чтобы не было кастов и проблем с приоритетом, писать скобки.
    }

    public static boolean booleanDeserialize(int i) {
        if (i != 0){
            if (i != 1){
                throw new IllegalArgumentException();
            }
        }
        return i != 0;
    }

    public static void main(String[] args) {
        boolean test = true;
        if(test == booleanDeserialize(booleanSerialize(test))){
            System.out.println("OK");
        } else {
            System.out.println("Error");
        }
        test = false;
        if(test == booleanDeserialize(booleanSerialize(test))){
            System.out.println("OK");
        } else {
            System.out.println("Error");
        }
    }
}
