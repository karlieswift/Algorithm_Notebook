#include<iostream>
using namespace std;
int main()
{
    int i=0,j=0;
    char P[11]={0},B[11]={0};
    int sum1=0,sum2=0,Pa,Ba,P1,B2;
    cin>>P>>Pa>>B>>Ba;
    while(P[i])
    {
        if(P[i]-'0'==Pa)
            sum1=10*sum1+Pa;
        i++;
     }
    while(B[j])
    {
        if(B[j]-'0'==Ba)
            sum2=sum2*10+Ba;
        j++;
    }
    cout<<sum1+sum2<<endl;
    return 0;
}