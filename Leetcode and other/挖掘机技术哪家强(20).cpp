 #include<iostream>
using namespace std;
int main()
{
    int ID,score;
    int school[100010]={0};
    int number,maxID=0;
    cin>>number ;
    for(int i=0;i<number;i++)
    {
        cin>>ID>>score;
        school[ID]+=score;
        if(maxID<ID)
        maxID=ID;
    }
    int maxscore=school[1];
    for(int i=2;i<=maxID;i++)
    {
        if(maxscore<school[i])
        {
        maxscore=school[i];
        ID=i;
        }
    }
    cout<<ID<<" "<<maxscore<<endl;
    return 0;
}