/*
*  Question 2
*/

#include <iostream>
#include <cstring>
#include <cmath>

using namespace std;

string ones[] = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

string teens[] = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixten", "seventeen", "eighteen", "nineteen"
};

string tens[] = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
};


int places[3];

string numeber_to_txt(int, int);

int main() {

    int a;

    int size = sizeof(places) / sizeof(places[0]);


    cout << "Enter an amount of money: ";

    double n;

    cin >> n;

    a = n;

    float whole = floor(n);
    float decimal = n - whole;


    if (n <= 0) {
        cout << "zero dollars";
    }
    else {
        int i = 1;
        while (a > 0) {
            int num = 1000 * ((double(a) / 1000) - (a / 1000));
            a = a / 1000;
            places[i] = num;

            i--;
        }
        places[2] = decimal * 100;

        cout << "Number to text: ";

        for (int j = 0; j < size; j++) {
            if (places[j] == 0) {
                continue;
            }
            if (j == 2 && (places[0] != 0 || places[1] != 0)) {
                cout << "and ";
            }
            cout << numeber_to_txt(places[j], j);
            if (j == 1) {
                cout << "dollars ";
            }
            else if (j == 2) {
                cout << "cents ";
            }

        }
    }
    return 0;
} 

string numeber_to_txt(int n, int i) {
    int temp = n;

    string word = "";

    int b = n % 10;
    n = n / 10;

    int c = n % 10;
    n = n / 10;


    int d = n % 10;
    n = n / 10;

    if (i != 2) {

        if (d > 0) {
            word += ones[d] + " hundred ";
        }

        if (c == 1) {
            word += teens[b] + " ";
        } else if (c == 0) {
            word += ones[b] + " ";
        } else {
            word += tens[c] + " " + ones[b] + " ";
        }
        if (i == 0) {
            word += "thousand ";
        }
    }
    else {
        if (c == 1) {
            word += teens[b] + " ";
        }
        else {
            if (b == 0) {
                word += tens[c] + " ";
            }else {
                if (c != 0) {
                    word += tens[c] + "-" + ones[b] + " ";
                }
                else {
                    word += ones[b] + " ";
                }
            }
        }
    }

    return word;
}