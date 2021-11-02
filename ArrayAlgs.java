import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class ArrayAlgs
{
  private String algName;
  
  public ArrayAlgs( String algName )
  {
    this.algName = algName;
  }
  
  public void executeAlg( File testData ) throws FileNotFoundException
  {
    if( algName.equals("insertionSortInitial") )
      insertionSortInitial(testData);
    
    if( algName.equals("quickSortOptInitial") )
      quickSortOptInitial(testData);
    
    if( algName.equals("mysteryRuntime1") )
      mysteryRuntime1(testData);
    
    if( algName.equals("mysteryRuntime2") )
      mysteryRuntime2(testData);
    
    if( algName.equals("mysteryRuntime3") )
      mysteryRuntime3(testData);
  }
  
  /*
   * Provided code - DO NOT CHANGE THIS METHOD 
   */ 
  static void mysteryRuntime1(File input) throws FileNotFoundException
  {
    int temp;
    int size;
    int i = 0;
    int[] array;
    
    Scanner sc = new Scanner(input);
    size = sc.nextInt();
    array = new int[size];
    while(sc.hasNextInt() && i<size)
    {
      temp = sc.nextInt();
      array[i] = temp;
      i++;
    }
    sc.close();
    while (size > 1)
    {
      size = size/2;
      array[size/2] = array[size];
    }
  }
  
  /*
   * Provided code - DO NOT CHANGE THIS METHOD 
   */ 
  static void mysteryRuntime2(File input) throws FileNotFoundException
  {
    int temp;
    int size;
    int i = 0, j = 0;
    int[] array;
    
    Scanner sc = new Scanner(input);
    size = sc.nextInt();
    array = new int[size];
    
    while(sc.hasNextInt() && i<size)
    {
      temp = sc.nextInt();
      array[i] = temp;
      i++;
    }
    sc.close();
    i = 0;
    while(j < size)
    {
      array[j] = array[i];
      i++;
      if(i >= size)
      {
        j++;
        i = 0;
      }
    }
    
    
    
  }
  
  /*
   * Provided code - DO NOT CHANGE THIS METHOD 
   */ 
  static void mysteryRuntime3(File input) throws FileNotFoundException
  {
    int temp;
    int size;
    int n;
    int i = 0;
    int[] array;
    
    Scanner sc = new Scanner(input);
    size = sc.nextInt();
    array = new int[size];
    
    while(sc.hasNextInt() && i<size)
    {
      temp = sc.nextInt();
      array[i] = temp;
      i++;
    }
    
    sc.close();
    
    for(i = 0; i < size; i++)
    {
      for(n = size-1; n>1; n/=1.01)
      {
        array[n-1] = array[n];
      }
    }
  }
  
  /*
   * Provided code - DO NOT CHANGE THIS METHOD 
   */ 
  static void insertionSortInitial(File input) throws FileNotFoundException
  {
    int i;
    int size;
    int[] array;
    
    Scanner sc = new Scanner(input);
    size = sc.nextInt();
    array = new int[size];
    
    for(i = 0; i < size; i++)
    {
      array[i] = sc.nextInt();
    }
    insertionSort(array, 0, size-1);
    
    sc.close();
    
    // Error check to verify the array is sorted
    /*for(i = 1; i < size; i++)
     {
     if(array[i-1] > array[i])
     {
     System.out.printf("Not sorted!");
     System.exit(-1);
     }
     }*/
  }
  
  /*
   * Provided code - DO NOT CHANGE THIS METHOD 
   */ 
  static void insertionSort(int[] points, int low, int high) 
  {
    int i, j;
    int temp; // fixed from double temp;
    for (i = low+1; i < high; i++)
    {
      for (j = i; j > low && points[j] < points[j-1]; j--)
      {
        temp = points[j];
        points[j] = points[j-1];
        points[j-1] = temp;
      }
    }
  }
  
  /*
   * Provided code - DO NOT CHANGE THIS METHOD 
   */ 
  static void quickSortOptInitial(File input) throws FileNotFoundException
  {
    int i;
    int size;
    int[] array;
    
    Scanner sc = new Scanner(input);
    size = sc.nextInt();
    array = new int[size];
    
    for(i = 0; i < size; i++)
    {
      array[i] = sc.nextInt();
    }
    quickSortOpt(array,0, size-1);
    
    sc.close();
    
    // Error check to verify the array is sorted
    /*for(i = 1; i < size; i++)
     {
     if(array[i-1] > array[i])
     {
     System.out.printf("Not sorted!");
     System.exit(-1);
     }
     }*/
  }
  
  /*
   * Provided code - DO NOT CHANGE THIS METHOD 
   */ 
  static void quickSortOpt(int[] points, int low, int high)
  {
    if (high < low + 30)
    {
      insertionSort(points, low, high);
    }
    else 
    {
      int pivot = partition(points, low, high);
      quickSortOpt(points, low, pivot -1);
      quickSortOpt(points, pivot+1, high);
    }
  }
  
  /*
   * Provided code - DO NOT CHANGE THIS METHOD 
   */ 
  static int partition(int[] points, int low, int high)
  {
    Random rand = new Random();
    int pivot = rand.nextInt(high - low + 1) + low;
    int pivotValue = points[pivot];
    int i = low + 1;
    int j = high;
    int temp;
    
    points[pivot] = points[low];
    points[low] = pivotValue;
    
    while( i<j )
    {
      while( i<=high && points[i] <= pivotValue )
      {
        i++;
      }
      while( j>=low && points[j] > pivotValue )
      {
        j--;
      }
      if(i<j)  //swap out of order elements
      {
        temp = points[i];
        points[i] = points[j];
        points[j] = temp;
      }
    }
    if( i<=high && points[i] <= pivotValue )
    {
      i++;
    }
    
    points[low] = points[i-1];
    points[i-1] = pivotValue;
    
    return i-1;
  }
}