package tasks;

public class Task02 {

    /**
     * @param dayOfWeek от 0 до 6 включительно
     * @return Возвращает "rest" для субботы и воскресенья.
     * Для остальных дней "work".
     * @throws IllegalArgumentException Если dayOfWeek не от 0 до 6.
     */
    public static String shouldIWork(int dayOfWeek) {
        if ((dayOfWeek < 5) & (dayOfWeek >= 0)) {
            return "work";
        } else {
            if((dayOfWeek >= 5) & (dayOfWeek < 7)){
                return "rest";
            } else {
                throw new IllegalArgumentException("Wrong day number");
            }
        }

    }
    //Надо switch с default
}