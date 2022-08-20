/*
* Question 1
*/

#include <iostream>
#include <string>
#include <cstring>

using namespace std;

string convertMessage(string);

string words[9];

int main() {

    string message = "";

    cout << "Enter a message: ";

    int i = 0;
    getline(cin, message);
   

    cout << "Reversed case string: ";
    cout << convertMessage(message) << " " << endl;  
} 

string convertMessage(string txt) {
    string newtxt = "";
    for (int i = 0; i < txt.length(); i++) {
        if (isupper(txt.at(i))) {
            newtxt += char(tolower(txt.at(i)));
        }
        else {
            newtxt += char(toupper(txt.at(i)));
        }
    }

    return newtxt;

}
