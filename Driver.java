
public class Driver
{
  public static void main(String[] args)
  {
    Array2d A = new Array2d(5,10);

    fillArray(A);
    printArray(A);

   }

   public static void fillArray(Array2d A)
   {
     /* fill in the array */
     int i, j;
     double value=0;

     for (i=0;i<A.rows;i++)
     {
       for(j=0;j<A.cols;j++)
       {
         double dec = j;
         while(dec>=1)
           dec=dec/10.0;
         A.arrayData[i][j] = i+dec;
         //inner loop
       }
       //outer loop
     }
   }

   public static void printArray(Array2d A)
   {
     int i, j;

     for(i = 0; i < A.rows; i++)
     {
       for(j = 0; j < A.cols; j++)
       {
         System.out.printf("%-7.2f", A.arrayData[i][j]);
       }
       System.out.println();
     }
   }
 }