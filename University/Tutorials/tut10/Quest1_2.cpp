#include <iostream>
#include <cmath>
#include <vector>


using namespace std;

const int MAXX = 4;
const int MAXY = 4;

bool isMagicSquare(int[MAXX][MAXY]);
void transpose(int[MAXX][MAXY]);


int main() {

    int square[MAXX][MAXY];

    cout << "Enter a 4x4 matrix square: " << endl;

    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            cin >> square[i][j];
        }
    }
    int size = (sizeof square / sizeof square[0]) *
        (sizeof square[0] / sizeof(int));

   // cout << size << endl;

    if(isMagicSquare(square)) {
        cout << "This is a magic square" << endl;
    }
    else {
        cout << "This is not a magic square; each number from 1 and 16 does not occur in your input" << endl;
    }

    cout << "Transpose of array:" << endl;

    transpose(square);

    return 0;
}


bool isMagicSquare(int square[MAXX][MAXY]) {
    int row[4] = {0};
    int col[4] = {0};
    int d1 = 0, d2 = 0;
    vector<int> entries;

    // column
    for (int i = 0; i < MAXX; i++) {
        for (int j = 0; j < MAXY; j++) {
            col[i] += square[j][i];
        }
        entries.push_back(col[i]);
    }

    // row
    for (int i = 0; i < MAXY; i++) {
        for (int j = 0; j < MAXX; j++) {
            row[i] += square[i][j];
        }
        entries.push_back(row[i]);
    }

    for (int i = 0, j = 0; i < MAXX, j < MAXY; i++, j++) {
           d1 += square[i][j];
    }
    entries.push_back(d1);

    for (int i = MAXX-1, j = 0; i >= 0, j < MAXY; i--, j++) {
        d2 += square[i][j];
    }
    entries.push_back(d2);

    for (int i = 1; i < entries.size(); i++) {
        if (entries[i] != entries[i-1]) {
            cout << entries[i] << " " << entries[i - 1] << endl;
            return false;
        }
    }
    return true;
}

void transpose(int square[MAXX][MAXY]) {
    int arr1[MAXX][MAXY] = { 0 };

    for (int i = 0; i < MAXX; i++) {
        for (int j = 0; j < MAXY; j++) {
            arr1[i][j] = square[j][i];
        }
    }

    for (int i = 0; i < MAXX; i++) {
        for (int j = 0; j < MAXY; j++) {
            cout << arr1[i][j] << " "; 
        }
        cout << endl;
    }
    
}


