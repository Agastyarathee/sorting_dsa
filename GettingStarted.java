import java.util.Arrays;
import java.util.Random;

public class GettingStarted{
  
  public static void main(String[] args) {
    
    int[] arr= new int[10];
    Random ran= new Random();
    for( int c=0; c<arr.length;c++) {
      arr[c]= ran.nextInt(100);
    }
    
    System.out.println(Arrays.toString(arr));
    //selectsort(arr);
    //insertionsort(arr);
   //mergesort(arr);
   quicksort(arr);
    System.out.println(Arrays.toString(arr));
    
  }
  
  
  private static void quicksort(int[] arr) {
    // TODO Auto-generated method stub
    quicksort(arr,0,arr.length-1);
  }
  
  
  private static void quicksort(int[] arr,int low, int high ) {
    // TODO Auto-generated method stub
    if(low>=high) {
      return;
    }
    
    //choose a pivot
    int pivot= arr[high];
    
    int leftp=low ;
    int rightp=high;
    
    while(leftp<rightp) {
      while (arr[leftp]<=pivot && leftp<rightp) {
        leftp++;
        
      }
      while(arr[rightp]>=pivot && leftp<rightp) {
        rightp --;
        
      }
      
      swap(arr,leftp,rightp);
      
      
    }
    
    swap(arr,leftp,high);
    quicksort(arr,low,leftp-1);
    quicksort(arr,leftp+1,high);
  }
  


  private static void mergesort(int[] arr) {
    // TODO Auto-generated method stub
    //base case
    int length= arr.length;
    if(length<2) {
     return;
    }
    
    int mid = length/2;
    int[] left = new int[mid];
    int [] right = new int[length-mid];
    for(int i =0; i<mid;i++) {
      left[i]= arr[i];
      
      
    }
    for(int i =mid; i<length;i++) {
      right[i-mid]=arr[i];
    }
    
    mergesort(left);
    mergesort(right);
    //merge
    merge(arr, left, right);
    
    
  }


  private static void merge(int[] arr, int[] l, int[] r) {
    int ll= l.length;
    int rl= r.length;
    
    // make 3 iterator (pointer)
    
    int i=0, j=0,k=0;
    
    //while lopp
    while(i< ll && j <rl) {
      
      if(l[i]<=r[j]) {
        arr[k]= l[i];
        i++;
      }
      else {
        arr[k]=r[j];
        j++;
      }
    
    k++;
    }
    
    
    while(i<ll) {
      arr[k]=l[i];
      i++;
      k++;
    }
    while(j<rl) {
      arr[k]=r[j];
      j++;
      k++;
    }
  }


  private static void insertionsort(int[] arr) {
    
    int length= arr.length;
    
    
    
    for(int i =1; i<length ;i++) {
      int currentvalue= arr[i];
      int j =i-1;
      while (j>=0 && arr[j]>currentvalue) {
        arr[j+1]=arr[j];
        j--;
        
      }
      arr[j+1]=currentvalue;
    }
    
    // TODO Auto-generated method stub
    
  }

  private static void selectsort(int[]arr) {
    
    
    // important thing length 
    int length = arr.length;
    
    for (int i =0; i<length-1; i++) {
      int minval= arr[i];
      int minindex=i;
      for( int j=i+1 ; j<length;j++) {
        if (arr[j]<minval) {
          minval= arr[j];
          minindex=j;
          
          
        }
        
        
      }
      swap(arr,i,minindex);
    }
    
 
    
    
    
  }

  private static void swap(int[] arr, int s, int m) {
    // TODO Auto-generated method stub
    int temp= arr[s];
    arr[s]=arr[m];
    arr[m]=temp;
    
    
    
  }
  
  
  
}