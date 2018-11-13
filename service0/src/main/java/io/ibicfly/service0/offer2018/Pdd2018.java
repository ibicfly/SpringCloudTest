package io.ibicfly.service0.offer2018;

import java.util.Scanner;

public class Pdd2018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        int offset = 0, n = 0, l1 = 0, l2 = 0;
        //最好将参数赋予意义，不要给无意义的命名
        while (scanner.hasNextInt()) {
            switch (i) {
                case 0:
                    offset = scanner.nextInt();
                    break;
                case 1:
                    n = scanner.nextInt();
                    break;
                case 2:
                    l1 = scanner.nextInt();
                    break;
                case 3: {
                    l2 = scanner.nextInt();
                    int start1, start2, end1, end2;
                    if (offset >= l1) {
                        start1 = end1 = l1;
                        offset -= l1;
                    } else {
                        start1 = offset;
                        end1 = l1 - offset >= n ? offset + n : l1;
                        offset = 0;
                        n -= end1 - start1;
                    }
                    if (offset >= l2)
                        start2 = end2 = l2;
                    else {
                        start2 = offset;
                        end2 = l2 - offset >= n ? offset + n : l2;
                    }
                    System.out.println(start1 + " " + end1 + " " + start2 + " " + end2);
                    i = 0;
                }
                break;
            }
            i++;
        }

    }
}