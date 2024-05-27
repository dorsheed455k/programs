#include <Wire.h>
#include <Servo.h>
#include <MPU6050_tockn.h>

#define X_SERVO_PIN 4 // Connect X-axis servo to digital pin 9
#define Y_SERVO_PIN 5 // Connect Y-axis servo to digital pin 10

Servo xServo; // Define X-axis servo
Servo yServo; // Define Y-axis servo

MPU6050 mpu6050(Wire); // Initialize MPU6050

// PID parameters
#define Kp 0.1 // Proportional gain
#define Ki 0.0 // Integral gain
#define Kd 0.0 // Derivative gain

// Variables for PID control
double setpointX = 90.0; // Reference angle for X-axis
double setpointY = 90.0; // Reference angle for Y-axis
double inputX, outputX;
double inputY, outputY;
double errorX, lastErrorX;
double errorY, lastErrorY;
double integralX, integralY;
double derivativeX, derivativeY;

// Define PID constants
double dt = 0.01; // Time interval (seconds) - adjust as needed

void setup() {
  Wire.begin();
  Serial.begin(115200);

  mpu6050.begin();
  mpu6050.calcGyroOffsets(true);

  xServo.attach(X_SERVO_PIN); // Attach X-axis servo
  yServo.attach(Y_SERVO_PIN); // Attach Y-axis servo

  // Initialize variables
  inputX = 0;
  outputX = 0;
  errorX = 0;
  lastErrorX = 0;
  integralX = 0;
  derivativeX = 0;

  inputY = 0;
  outputY = 0;
  errorY = 0;
  lastErrorY = 0;
  integralY = 0;
  derivativeY = 0;
}

void loop() {
  mpu6050.update();

  // Read sensor data
  inputX = mpu6050.getAngleX();
  inputY = mpu6050.getAngleY();

  // Compute errors
  errorX = setpointX - inputX;
  errorY = setpointY - inputY;

  // Compute integral
  integralX += errorX * dt;
  integralY += errorY * dt;

  // Compute derivative
  derivativeX = (errorX - lastErrorX) / dt;
  derivativeY = (errorY - lastErrorY) / dt;

  // Compute PID output
  outputX = Kp * errorX + Ki * integralX + Kd * derivativeX;
  outputY = Kp * errorY + Ki * integralY + Kd * derivativeY;

  // Apply PID output to servos
  xServo.write(90 + outputX); // Adjust for servo neutral position
  yServo.write(90 + outputY); // Adjust for servo neutral position

  // Save current error for next iteration
  lastErrorX = errorX;
  lastErrorY = errorY;

  // Print values for debugging
  Serial.print("Input X: ");
  Serial.print(inputX);
  Serial.print("  Output X: ");
  Serial.print(outputX);
  Serial.print("  Error X: ");
  Serial.print(errorX);
  Serial.print("  Input Y: ");
  Serial.print(inputY);
  Serial.print("  Output Y: ");
  Serial.print(outputY);
  Serial.print("  Error Y: ");
  Serial.println(errorY);

  // Wait for the next time interval
  delay(dt * 1000); // Convert seconds to milliseconds
}
