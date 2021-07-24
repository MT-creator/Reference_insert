package references;

import javax.lang.model.SourceVersion;

class InsertNumber {
	public int[] insertArray(int index, int[] arr, int value) {
		int[] newArray = new int[arr.length + 1];
		System.arraycopy(arr, 0, newArray, 0, index);
		System.arraycopy(arr, index, newArray, index + 1, 
                   arr.length - index);
		newArray[index] = value;
		arr = newArray;
		return newArray;
	}

	public int[] deleteFromArray(int index, int[] arr, int value) {
		boolean[] deleteNumber = new boolean[arr.length];
		int size = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				deleteNumber[i] = true;
			} else {
				deleteNumber[i] = false;
				size++;
			}
		}
		int[] newArr = new int[size];
		int in = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!deleteNumber[i]) {
				newArr[in++] = arr[i];
			}
		}
		return newArr;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		InsertNumber in = new InsertNumber();
		System.out.println("After adding an element to Array arr[], array becomes:");
		int num[] = in.insertArray(1, arr, 8);
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
		System.out.println("After removing an element from  Array arr[], array becomes:");
		int newArr[] = in.deleteFromArray(1, arr, 2);
		for (int i = 0; i < newArr.length; i++) {
			System.out.println(newArr[i]);
		}
	}

    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }
}
