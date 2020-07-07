#include<iostream>
using namespace std;
int main(){
    int a[10]={0};
    int b[50]={0};
    int i,j=0;
for( i=0;i<10;i++)
cin>>a[i];
i=1;
while(i<=10)
{
if(a[i]!=0) 
{
    while(a[i]!=0)
    {
      b[j++]=i;a[i]--;
    while(a[0])
    {
        b[j]=0;  a[0]--;   j++;
    }
    }
}
i++;
}
for(i=0;i<j;i++)
cout<<b[i]; 
    return 0;
}