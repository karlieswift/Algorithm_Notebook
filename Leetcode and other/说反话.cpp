#include<iostream>
#include<cstring>
using namespace std;
int main()
{
    char a[90];
    char b[90][90];
    gets(a);
    int n=0,h=0;
    int len=strlen(a);
    for(int i=0;i<len;i++)
    {
        if(a[i]!=' ')
        {
            b[n][h++]=a[i];
        }
        else
        {
            b[n][h]='\0';
            n++;
            h=0;
        }
    }
    for(int i=n;i>=0;i--)
    {
        cout<<b[i];
        if(i>0)
            cout<<" ";
    }
    return 0;
}