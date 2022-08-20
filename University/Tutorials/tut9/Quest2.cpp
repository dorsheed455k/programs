#include <iostream>
#include <fstream>
#include <cmath>
#include <vector>

using namespace std;

vector<int> extractodd(int[], int[], int, int);
vector<int> extraceven(int[], int[], int, int);

vector<int> merge(int[], int[], int, int);
vector<int> mergeSort(int[], int[], int, int);
void display(vector<int>);

int main() {

    int m, n;

    cout << "Enter size for list 1 and list 2: ";
    cin >> m >> n;

    int* list1 = new int[m];
    int* list2 = new int[n];


    cout << "Enter integers for list 1: ";

    for (int i = 0; i < m; i++) {
        cin >> list1[i];
    }
    cout << endl;

    cout << "Enter integers for list 2: ";

    for (int i = 0; i < n; i++) {
        cin >> list2[i];
    }

    cout << "Merged List: ";
    display(merge(list1, list2, m, n));

    cout << "Sorted Merged List: ";
    display(mergeSort(list1, list2, m, n));

    cout << "Even List: ";
    display(extraceven(list1, list2, m, n));

    cout << "Odd List: ";
    display(extractodd(list1, list2, m, n));

    return 0;
}

vector<int> extractodd(int l1[], int l2[], int m, int n) {
     vector<int> list3;

    int x = 0;
    for (int i = 0; i < m; i++) {
        if (l1[i] % 2 != 0) {
            list3.push_back(l1[i]);
        }
    }

    for (int i = 0; i < n; i++) {
        if (l2[i] % 2 != 0) {
            list3.push_back(l2[i]);
        }
    }


    return list3;
}

vector<int> extraceven(int l1[], int l2[], int m, int n) {
    vector<int> list3;

    int x = 0;
    for (int i = 0; i < m; i++) {
        if (l1[i] % 2 == 0) {
            list3.push_back(l1[i]);
        }
    }

    for (int i = 0; i < n; i++) {
        if (l2[i] % 2 == 0) {
           list3.push_back(l2[i]);
        }
    }

    return list3;
}


vector<int> merge(int l1[], int l2[], int m, int n) {
    vector<int> list3;

    int i = 0, j = 0;
    while (i < m) {
        list3.push_back(l1[i]);
        i++;
    }
    while (j < n) {
        list3.push_back(l2[j]);
        j++;
    }
    return list3;
}

vector<int> mergeSort(int l1[], int l2[], int m, int n) {
    vector<int> list3;

    int i = 0, j = 0;
    while (i < m) {
        list3.push_back(l1[i]);
        i++;
    }
    while (j < n) {
        list3.push_back(l2[j]);
        j++;
    }

    for (int i = 0; i < list3.size(); i++) {
        for (int j = i + 1; j < list3.size(); j++) {
            if (list3[j] < list3[i]) {
                float temp = list3[i];
                list3[i] = list3[j];
                list3[j] = temp;
            }
        }
    }

    return list3;
}


void display(vector<int> arr) {
    for (int i = 0; i < arr.size(); i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}