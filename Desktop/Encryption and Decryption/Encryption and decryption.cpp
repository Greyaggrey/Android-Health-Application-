#include<iostream>
using namespace std;
int main(){
    int i,x;
    char str[75];

    cout<<"Please enter a string:\t";
    cin>>str;

    cout<<"\nPlease choose the following options:\n";
    cout<<"1 = Encrypt the string.\n";
    cout<<"2 = Decrypt the string.\n";
    cin>>x;

    //using switch case statements
    switch (x)
    {
        //first case for encrypting a string
    case 1:
       for(i=0; (i<75 && str[i]!='\0'); i++)
       str[i]=str[i]+2;//the key for encryption is 3 that is added to ASCII value
	    cout<<"\nEncrypted string: "<<str;
        break;

        //second case for decrypting a string

        case 2:
        for(i=0; (i<75 && str[i]!='\0'); i++)
        str[i]=str[i]-2;//the key for encryption is 3 that is subtracted to ASCII value
        cout<<"\nDecrypted string: "<<str;
        break;

    default:
    cout<<"\nInvalid Input!!!\n";
        break;
    }
    return 0;
}
