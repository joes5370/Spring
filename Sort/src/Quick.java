import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Quick {
	
	private static void swap(int[] temp, int a, int b) {
		int tmp = temp[a];
		temp[a] = temp[b];
		temp[b] = tmp;
	}
	
	public static void sort(int[] list, int left, int right) {
        if (left >= right) return;

        int mid = partition(list, left, right);
        sort(list, left, mid - 1);
        sort(list, mid, right);
    }
	
	public static int partition(int[] list, int left, int right) {
		int pivot = list[(left + right) / 2]; //pivot설정
		do{
			while (list[left] < pivot) { //pivot기준으로 추가 변환
				left++;
			}
			while(list[right] > pivot) {
				right--;
			}
			
			if(left <= right) {
				System.out.println("스왑한다");
				swap(list,left,right);
				left++;
				right--;
			}
			System.out.println(Arrays.toString(list)+"  "+"중앙값은 : "+pivot);
            System.out.println("left : " + left + " right : " + right);
		} while (left <= right);
 
        if (left < right) {//분할정복시 더 이상 분할 것이 없는 경우 체크 (왼쪽 분할할 수 있는지 체크)
            System.out.println("l : " + left + " end: " + right);
            sort(list, left, right);
        }
        if (right > left) {//분할정복시 더 이상 분할 것이 없는 경우 체크 (오른쪽 분할할 수 있는지 체크)
            System.out.println("l : " + left + " end: " + right);
            sort(list, left, right);
 
        }
		return left;

		
	}
	
	public static void main(String[] args) {
		int data[] = { 9,8,3,4,7,6,5,2,1};
		 
		Quick quick = new Quick();
        quick.sort(data, 0, data.length - 1);
 
        System.out.println(Arrays.toString(data));
 
	}
}

