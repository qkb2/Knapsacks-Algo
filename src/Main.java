import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the knapsack capacity: ");
        Scanner scanner = new Scanner(System.in);
        int cap;

        while (true) {
            try {
                cap = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Capacity must be an integer.");
            }
        }

        Knapsacks[] objArr = new Knapsacks[3];
        objArr[0] = new KnapsacksBruteForce(cap);
        objArr[1] = new KnapsacksGreedy(cap);
        objArr[2] = new KnapsacksDynamic(cap);

        System.out.println(
                "Enter the items in the following way: weight price (both must be integers, one space separating them)");
        scanner.nextLine();

        String[] strArr;
        ArrayList<int[]> v = new ArrayList<>();

        while (true) {
            try {
                String str;
                str = scanner.nextLine();

                if (str.equals("stop")) {
                    break;
                }

                strArr = str.trim().split("\\s+");
                if (strArr.length < 2) {
                    throw new RuntimeException("not enough args");
                }

                int w = Integer.parseInt(strArr[0]);
                int p = Integer.parseInt(strArr[1]);

                v.add(new int[]{w, p});

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        ArrayList<ArrayList<Integer>> solArr = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            var x = objArr[i];
            x.setItems(v);
            x.setAnswer();
            x.setSolution();
            solArr.add(x.solution);
//            System.out.println(x.solution);
        }

        System.out.print(
                "Brute force algo. got: "+solArr.get(0).toString()+
                "\nGreedy algo. got: "+solArr.get(1).toString()+
                "\nDynamic algo. got: "+solArr.get(2).toString());

    }
}