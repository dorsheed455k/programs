/*
*
*  Problem 1. Triangle Sum
*  Feb 15 2022
*/


#include <iostream>
#include <cmath>

using namespace std;

 int main() {
	float base, height;

	cout << "Enter base: ";
	cin >> base;

	cout << "Enter height: ";
	cin >> height;

	float area = base * height;
	area *= 0.5;

	cout << "The area of the triangle is " << area << " square inches " << endl;


	return 0;
} 
