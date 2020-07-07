#include<iostream>
using namespace std;
int main()
{
    int num1,num2,D;
    cin>>num1>>num2>>D;
    int sum=num2+num1;
    int a[32]={0},i=0;
    while(sum!=0)
    {
        a[i]=sum%D;
        sum/=D;
        i++;
    }
    i--;
    for(int j=i;j>=0;j--)
    cout<<a[j];
    return 0;
}