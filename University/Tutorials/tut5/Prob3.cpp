/*
* 
*  Problem 3. Maximum Load
*  Feb 15 2022
*/

#include <iostream>
#include <cmath>

using namespace std;

  double calculateStressLoad(int D, int B, int H, int S) {
	int c = H / 2;

	double I = (B * pow(H, 3)) / 12;

	double L = (S * I) / ((double)D * c);

	return L;
}


 int main() {

	// a)
		double load1 = calculateStressLoad(96, 2, 4, 3000);
		cout << "The maximum load for Exercise 3a is " << load1 << " lb" << endl;

	// b)
		double load2 = calculateStressLoad(96, 3, 6, 3000);
		cout << "The maximum load for Exercise 3b is " << load2 << " lb" << endl;

	return 0;

}   
