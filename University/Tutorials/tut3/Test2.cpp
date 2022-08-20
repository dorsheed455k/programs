/*
*  Height of a Cylinder
*/

#define _USE_MATH_DEFINES
#include <iostream>
#include <cmath>

using namespace std;

 int main() {

	// a)

	double radius;
	double surface;
	double height;

	cout << "Enter the surface of the cylinder: ";
	cin >> surface;
	cout << "Enter the radius of the cylinder: ";
	cin >> radius;

	height = surface - (2 * M_PI * pow(radius, 2));
	height /= 2 * M_PI * radius;

	if(height < 0) {
	  cout << "Height is not possible" << endl;
	}  else {
	  cout << "Height of the cylinder: " << height;
	}


	return 0;
}   