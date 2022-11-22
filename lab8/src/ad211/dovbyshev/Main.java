package ad211.dovbyshev;

public class Main {
    public static void main(String[] args) {
        ClassList<Number> firstArray = new ClassList<>(1, 2, 3);
        ClassList<Number> secondArray = new ClassList<>(43, 32, 68, 46, 34, 46);
        System.out.println("Group 1:");
        takeALook(firstArray);
        System.out.println("Group 2:");
        takeALook(secondArray);
        System.out.println("Crossing:");
        takeALook(calculateCrossing(firstArray, secondArray));

        firstArray = new ClassList<>(1, 2, 3, 4, 5, 6);
        secondArray = new ClassList<>(21, 2, 12, 44, 52, 67);
        System.out.println("Group 1:");
        takeALook(firstArray);
        System.out.println("Group 2:");
        takeALook(secondArray);
        System.out.println("Crossing:");
        takeALook(calculateCrossing(firstArray, secondArray));

        ClassList<?>[] groupGroup = new ClassList[] {new ClassList<>(1,2,3,4,5,6,7,8,9,10), new ClassList<>(1,25,34,4,52,6,7,81,9,10), new ClassList<>(2,2,3,10,5,6,78,4,5,24), new ClassList<>(3,24,38,4,5,36,7,58,96,102)};

        System.out.println();
        int groupIndex = 0;
        for (ClassList<?> group: groupGroup) {
            System.out.println("Group #" + ++groupIndex);
            takeALook(group);
        }

        System.out.println("Crossing:");
        takeALook(calculateCrossing(groupGroup));
    }

    static ClassList<Number> calculateCrossing(ClassList<? extends Number> firstGroup, ClassList<? extends Number> secondGroup) {
        ClassList<Number> answer = new ClassList<>();
        for (Object first: firstGroup.getList().toArray()) {
            for (Object second: secondGroup.getList().toArray()) {
                if(first.equals(second)) {
                    boolean isAdded = false;
                    for (Object start: answer.getList()) {
                        if (start.equals(first)) {
                            isAdded = true;
                            break;
                        }
                    }
                    if (isAdded) {
                        break;
                    }
                    answer.getList().add((Number)first);
                    break;
                }
            }
        }
        return answer;
    }

    @SafeVarargs
    static ClassList<Number> calculateCrossing(ClassList<? extends Number>... groups) {
        ClassList<Number> result = calculateCrossing(groups[0],groups[0]);
        for (ClassList<?> group: groups) {
            result = calculateCrossing(result, group);
        }
        return result;
    }

    static void takeALook(ClassList<? extends Number> list) {
        if(list.getList().size() == 0) {
            System.out.println("Group is not full");
        }
        for (Object obj: list.getList().toArray()) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}
