/* Disjoint Set By Array 
   28 Feb,2019 
   @ABHISHEK SINGH */

import java.util.*;

class DisjointSet
{
     private int root[];
     private int size[];
     DisjointSet(int n)
     {
         root=new int[n];
         size=new int[n];
     }
     
     public void makeSet(int n)
     {
         for(int i=1;i<=n;i++)
         {
             root[i]=i;
             size[i]=1;
         }
     }
     
     public int findSet(int n)
     {
         if(root[n]==n)
         {
         return root[n];
         }
         else
         {
          root[n]=findSet(root[n]);
          return root[n];
         }
     }
     public void union(int a,int b)
     {
         int x=findSet(a);
         int y=findSet(b);
         
         if(x==y)
         return;
         else 
         {
             if(size[x]>size[y])
             {
                 root[y]=x;
                 size[x]+=size[y]; 
             }
             else
             {
                 root[x]=y;
                 size[y]+=size[x]; 
                
             }
         }
     }
     public int getSize(int i)
     {
         return size[findSet(i)];
     }
   
     //@Override
     public String toString()
     {
         return Arrays.toString(root)+"\n"+Arrays.toString(size);
     }
}
