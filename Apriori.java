import java.io.*;
class Apriori
{ 
public static void main(String []arg)throws IOException
{
int i,j,m=0;//initalize variables
int t1=0;
BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
//Java BufferedReader class is used to read the text from a character-based input stream.
//It can be used to read data line by line by readLine() method.
System.out.println("Enter the number of transaction :");
int n=Integer.parseInt(b.readLine());//here n is the number of transactions
System.out.println("items :1--I1 2--I2 3--I3 4--I4 5--I5");
int item[][]=new int[n][10];//creating array of 10 items.
for(i=0;i<n;i++)//loop generating for number of transactions
 for(j=0;j<5;j++)//loop generating for items array 

   item[i][j]=0; //initailizing unique items with their frequency as 0.
String[] itemlist={"I1","I2","I3","I4","I5"};
//getting 10 items into array called itemlist.
int nt[]=new int[10];
int q[]=new int[10];
for(i=0;i<n;i++)
{ System.out.println("Transaction "+(i+1)+" :");//incrementing for each items in 'n' transactions.
  for(j=0;j<5;j++)
  {  
     System.out.println("Is Item "+itemlist[j]+" present in this transaction(1/0)? :");
     //checking whether items from itemlistis present in transaction or not where 0- not present,1-present.
     item[i][j]=Integer.parseInt(b.readLine());
     //reading for each items from itemlist in n transaction.
  }
}
 for(j=0;j<5;j++) 
  { for(i=0;i<n;i++)
    {if(item[i][j]==1)//checking whether atleast there would be multiple items repeated at each n transaction.
      nt[j]=nt[j]+1;//if condition is satisfied then we increment for all n transaction of items.
    }
    System.out.println("Number of Item "+itemlist[j]+" :"+nt[j]);
    //generating number of multiple items repeated at their transaction with frequency number.
  }

for(j=0;j<5;j++)
{ if(((nt[j]/(float)n)*100)>=50)//calculating items with their threshold values.
    q[j]=1;//segregating present items left after removal of items which is below threshold into array
  else
    q[j]=0;//segregating not present items removed as items are below the threshold values 

  if(q[j]==1)
   {t1++;//getting the count of repetitions of same items
    System.out.println("Item "+itemlist[j]+" is selected ");
    //generating particular item which is selected after threshold calculating.
   
   }
}
 for(j=0;j<5;j++) 
  { for(i=0;i<n;i++)
   {
     
     if(q[j]==0)
       { 
        item[i][j]=0;
       }
   }
   }

int nt1[][]=new int[10][10];//creating array for 2-frequency itemset
 for(j=0;j<5;j++) 
    {  for(m=j+1;m<5;m++)//generating unique items for 2-frequency itemlist 
       { for(i=0;i<n;i++)
         { if(item[i][j]==1 &&item[i][m]==1)
            //checking there would atleast 1 itemset in 1-frequency itemset and 2-frequency itemlist.
           { nt1[j][m]=nt1[j][m]+1;
           //incrementing for each items with all other items in 2-frequency itemset  
           }
         }
    if(nt1[j][m]!=0)//if 2-frequency itemlist is present 
         System.out.println("Number of Items of  "+itemlist[j]+"& "+itemlist[m]+" :"+nt1[j][m]);
         //printing number of items of each items with other items with their frequency.
    }
  
   }  
}
}