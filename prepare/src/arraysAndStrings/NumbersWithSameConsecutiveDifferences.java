/*
 * package arraysAndStrings;
 * 
 * import java.util.ArrayList; import java.util.HashSet; import java.util.List;
 * import java.util.Set;
 * 
 * public class NumbersWithSameConsecutiveDifferences { public static int[]
 * smallmatrix = { 0, 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000,
 * 100000000 }; public static int[] bigmatrix = { 0, 9, 99, 999, 9999, 99999,
 * 999999, 9999999, 99999999, 999999999 }; public static Set<String> set;
 * 
 * public static void main(String[] args) { int n = 3; int k = 1;
 * 
 * set = new HashSet<>();
 * 
 * // System.out.println(solve(n, k));
 * 
 * System.out.println(set);
 * 
 * int[] result = new int[set.size()]; int counter = 0; solveRecursion(n, k, new
 * StringBuilder());
 * 
 * for (String i : set) { result[counter] = Integer.valueOf(i); counter++; }
 * 
 * System.out.println(result); }
 * 
 * private static void solveRecursion(int n, int k, StringBuilder sb) { if
 * (sb.length() == n) { set.add(new String(sb.toString()));
 * sb.deleteCharAt(sb.length() - 1); return; }
 * 
 * for (int i = 0; i < 10; i++) { if (i == 0 && sb.length() == 0) { continue; }
 * 
 * else if (sb.length() == 0) { sb.append(String.valueOf(i)); solveRecursion(n,
 * k, sb); } else { int lastElement =
 * Character.getNumericValue(sb.charAt(sb.length() - 1)); int add = lastElement
 * + k; int sub = lastElement - k;
 * 
 * if (add <= 9) { sb.append(add); solveRecursion(n, k, sb); } if (sub >= 0) {
 * sb.append(sub); solveRecursion(n, k, sb); } }
 * 
 * }
 * 
 * }
 * 
 * private static int[] solve(int n, int k) { List<Integer> list = new
 * ArrayList<>(); int smallNumber = smallmatrix[n]; int largeNumber =
 * bigmatrix[n];
 * 
 * for (int i = smallNumber; i <= largeNumber; i++) { if (validate(i, k)) {
 * list.add(i); } }
 * 
 * int[] result = new int[list.size()];
 * 
 * for (int i = 0; i < list.size(); i++) { result[i] = list.get(i); }
 * 
 * return result;
 * 
 * }
 * 
 * private static boolean validate(int number, int key) { int first = -1; int
 * second = -1; int counter = 0; while (number > 0) { counter++; if (first ==
 * -1) { first = number % 10; } else { second = number % 10; }
 * 
 * if (counter == 2) { if (Math.abs(first - second) != key) { return false; }
 * else { counter--; first = second; } } number = number / 10; } return true; }
 * 
 * }
 */