class SortArr{
	public static void main(String[] args) {
		boolean tof = true;
		int[] array = {13,26,-3,4,54,26,37,18,69,-10};
		int j=5;
		for(int i=0;i<array.length;i++){
			System.out.printf("[%d] = %d  ",i,array[i]);
			j--;
			if(j==0){
				System.out.println();
				j=5;
			}
		}
		System.out.println();
		sort(array,tof);	//输出arr的升序排列
	}


	static void sort(int arr[], boolean isAsc) {
		if (isAsc==true){
			int temp = 0;				//升序排序,用选择排序法
			for (int i=0; i<arr.length-1; i++){
				int k = i;
				int min = arr[k];
				for(int j=i+1; j < arr.length; j++){
					if (arr[j] < min){
						min = arr[j];
						k = j;
					}
				}
				temp = arr[i];
				arr[i] = min;
				arr[k] = temp;	
			}
		}
		else{							//降序排序
			int temp = 0;				
			for (int i=0; i<arr.length-1; i++){
				int k = i;
				int max = arr[k];
				for(int j=i+1; j < arr.length; j++){
					if (arr[j] > max){
						max = arr[j];
						k = j;
					}
				}
				temp = arr[i];
				arr[i] = max;
				arr[k] = temp;
			}
		}
		for(int one:arr){
			System.out.printf("%d ",one);
		}
		System.out.println();
 	}
 	/**
	* 重载方法，将数组升序
	*
	* @param arr 目标数组
	*/
	static void sort(int arr[]) {
		int temp = 0;				//升序排序,用选择排序法
			for (int i=0; i<arr.length-1; i++){
				int k = i;
				int min = arr[k];
				for(int j=i+1; j < arr.length; j++){
					if (arr[j] < min){
						min = arr[j];
						k = j;
					}
				}
				temp = arr[i];
				arr[i] = min;
				arr[k] = temp;	
			}
			for(int one:arr){
			System.out.printf("%d ",one);
		}
		System.out.println();
	}


}



