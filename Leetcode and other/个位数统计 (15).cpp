#include<iostream>
#include<string>
using namespace std;
int main()
{
    string a;
    int i=0,j;
    int times[10]={0};
    cin>>a;
    int size=a.size();
    while(i<size)
    {
        int j=a[i]-'0';
    switch(j)
    {
    case 0: times[0]++; break;
    case 1: times[1]++; break;
    case 2: times[2]++; break;
    case 3: times[3]++; break;
    case 4: times[4]++; break;
    case 5: times[5]++; break;
    case 6: times[6]++; break;
    case 7: times[7]++; break;
    case 8: times[8]++; break;
    case 9: times[9]++; break;
    }
    i++;
    }
    for(i=0;i<10;i++)
        if(times[i]!=0)
        cout<<i<<":"<<times[i]<<endl;
    return 0;
}