import java.util.Scanner;
import java.io.*;

public class LargePrint{
	static String[][] arr = new String[10][109];
	public static void printState(int a, int b, int c, int k){
		int[] list = findChange(a, b, c);
		String s = "  ";
		String t = "      ";
		String h = "  ##  ";
		String center = "                                            ";
		String ss = t;
		int a1 = a/10, a2 = a%10, b1 = b/10, b2 = b%10, c1 = c/10, c2 = c%10;
		int aa = a, bb = b, cc = c + 1;
		if (cc == 60) {cc = 0; bb++;}
		if (bb == 60) {bb = 0; aa++;}
		if (aa == 24) aa = 0;
		int aa1 = aa/10, aa2 = aa%10, bb1 = bb/10, bb2 = bb%10, cc1 = cc/10, cc2 = cc%10;
		for (int i = 0; i < 17 - k; i++) System.out.println();
		for (int i = 0; i < k; i++) {
			System.out.print(center);
			System.out.println(String.format("%-15s", arr[a1][i + 50 - 50 * list[0]]) + s + String.format("%-15s", arr[a2][i + 50 - 50 * list[1]]) + ss + String.format("%-15s", arr[b1][i + 50 - 50 * list[2]]) + s + String.format("%-15s", arr[b2][i + 50 - 50 * list[3]]) + ss + String.format("%-15s", arr[c1][i + 50 - 50 * list[4]]) + s + String.format("%-15s", arr[c2][i + 50 - 50 * list[5]]));
		}
		for (int i = 0; i < 9; i++){
			System.out.print(center);
			if (i == 3 || i == 6) ss = h;
			else ss = t;	
			if (k + i < 26) System.out.println(String.format("%-15s", arr[a1][i + k * list[0]]) + s + String.format("%-15s", arr[a2][i + k * list[1]]) + ss + String.format("%-15s", arr[b1][i + k * list[2]]) + s + String.format("%-15s", arr[b2][i + k * list[3]]) + ss + String.format("%-15s", arr[c1][i + k * list[4]]) + s + String.format("%-15s", arr[c2][i + k * list[5]]));
			else System.out.println(String.format("%-15s", arr[aa1][i + (k - 26) * list[0]]) + s + String.format("%-15s", arr[aa2][i + (k - 26) * list[1]]) + ss + String.format("%-15s", arr[bb1][i + (k - 26) * list[2]]) + s + String.format("%-15s", arr[bb2][i + (k - 26) * list[3]]) + ss + String.format("%-15s", arr[cc1][i + (k - 26) * list[4]]) + s + String.format("%-15s", arr[cc2][i + (k - 26) * list[5]]));
		}
		for (int i = 0; i < 17 - k; i++) System.out.println();
		ss = t;
		if (k <= 17) {
			for (int i = 0; i < k; i++) {
				System.out.print(center);
				System.out.println(String.format("%-15s", arr[aa1][i + 50 - 50 * list[0]]) + s + String.format("%-15s", arr[aa2][i + 50 - 50 * list[1]]) + ss + String.format("%-15s", arr[bb1][i + 50 - 50 * list[2]]) + s + String.format("%-15s", arr[bb2][i + 50 - 50 * list[3]]) + ss + String.format("%-15s", arr[cc1][i + 50 - 50 * list[4]]) + s + String.format("%-15s", arr[cc2][i + 50 - 50 * list[5]]));
			}
		}
		else {
			for (int i = k - 17; i < 9; i++) {
				System.out.print(center);
				System.out.println(String.format("%-15s", arr[aa1][i + 50 - 50 * list[0]]) + s + String.format("%-15s", arr[aa2][i + 50 - 50 * list[1]]) + ss + String.format("%-15s", arr[bb1][i + 50 - 50 * list[2]]) + s + String.format("%-15s", arr[bb2][i + 50 - 50 * list[3]]) + ss + String.format("%-15s", arr[cc1][i + 50 - 50 * list[4]]) + s + String.format("%-15s", arr[cc2][i + 50 - 50 * list[5]]));
			}
			for (int i = 0; i < k - 9; i++) System.out.println();
		}
	}
	public static void printTime(int a, int b, int c){
		long curr = System.nanoTime();
		int k = 0;
		printState(a, b, c, 0);
		while (true) if (System.nanoTime() - curr >= 500000000) break;
		curr = System.nanoTime();
		while (k < 26) {
			if (System.nanoTime() - curr >= 10000000) k++;
			else continue;
			curr = System.nanoTime();
			printState(a, b, c, k);
		}
	}
	public static void setDigits() throws IOException {
		Scanner sc = new Scanner(new File("DigitASCIIArt.txt"));
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 9; j++) arr[i][j] = sc.nextLine();
			sc.nextLine(); //burn
			for (int j = 9; j < 109; j++) arr[i][j] = " ";
		}
	}
	public static int[] findChange(int a, int b, int c){
		int[] list = {0, 0, 0, 0, 0, 0};
		int aa = a, bb = b, cc = c;
		c++;
		if (c == 60) {c = 0; b++;}
		if (b == 60) {b = 0; a++;}
		if (a == 24) a = 0;
		int a1 = a/10, a2 = a%10, b1 = b/10, b2 = b%10, c1 = c/10, c2 = c%10;
		int aa1 = aa/10, aa2 = aa%10, bb1 = bb/10, bb2 = bb%10, cc1 = cc/10, cc2 = cc%10;
		if (a1 != aa1) list[0] = 1;
		if (a2 != aa2) list[1] = 1;
		if (b1 != bb1) list[2] = 1;
		if (b2 != bb2) list[3] = 1;
		if (c1 != cc1) list[4] = 1;
		if (c2 != cc2) list[5] = 1;
		return list;
	}
}
