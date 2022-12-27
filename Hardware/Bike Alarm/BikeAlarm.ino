#include "Wire.h"
#include "math.h"
#include "pitches.h"

const int MPU_ADDR = 0x68;

const int ON = 2;
const int OFF = 3;

int16_t accelerometer_x, accelerometer_y, accelerometer_z;

int ledGreen = 11;
int ledRed = 12;


int speakerPin1 = 6;
int speakerPin2 = 7;

int16_t previousPositionX;
int16_t previousPositionY;
int16_t previousPositionZ;

#define switchPin 8

char temp_str[7];

char* convert_int16_to_str(int16_t i) {
  sprintf(temp_str, "%6d", i);
  return temp_str;
}

void setup() {
  Serial.begin(9600);
  Wire.begin();
  Wire.begin();
  Wire.beginTransmission(MPU_ADDR);
  Wire.write(0X6B);
  Wire.write(0);
  Wire.endTransmission(true);

  pinMode(switchPin, INPUT_PULLUP);
 // pinMode(ON, INPUT_PULLUP);
 // pinMode(OFF, INPUT_PULLUP);
  pinMode(ledGreen, OUTPUT);
  pinMode(ledRed, OUTPUT);

  previousPositionX = Wire.read() << 8 | Wire.read();
  previousPositionY = Wire.read() << 8 | Wire.read();
  previousPositionZ = Wire.read() << 8 | Wire.read();

}

void loop() {
  Wire.beginTransmission(MPU_ADDR);
  Wire.write(0x3B);
  Wire.endTransmission(false);
  Wire.requestFrom(MPU_ADDR, 7*2, true);

  accelerometer_x = Wire.read() << 8 | Wire.read();
  accelerometer_y = Wire.read() << 8 | Wire.read();
  accelerometer_z = Wire.read() << 8 | Wire.read();

/*  Serial.print("aX = "); 
  Serial.print(convert_int16_to_str(accelerometer_x));

  Serial.print(" | aY = "); 
  Serial.print(convert_int16_to_str(accelerometer_y));

  Serial.print(" | aZ = "); 
  Serial.println(convert_int16_to_str(accelerometer_z)); */

 // Serial.println(convert_int16_to_str(accelerometer_z));


   if(digitalRead(switchPin) == LOW) {
    Serial.println("OFF");
    digitalWrite(ledGreen, LOW);
    digitalWrite(ledRed, HIGH);
  } else if(digitalRead(switchPin) == HIGH){
    Serial.println("ON");
    digitalWrite(ledRed, LOW);
    digitalWrite(ledGreen, HIGH);

    //Serial.print(convert_int16_to_str(accelerometer_z));
   // Serial.print(" ");
  //  Serial.println(convert_int16_to_str(previousPositionZ));
    String diffz = convert_int16_to_str(abs(previousPositionZ - accelerometer_z));
    String diffx = convert_int16_to_str(abs(previousPositionX - accelerometer_x));
    String diffy = convert_int16_to_str(abs(previousPositionY - accelerometer_y));
     Serial.println("z: " + diffz.toInt());
     Serial.print(" x: ");
     Serial.println(diffx.toInt());
     Serial.println(" y: " + diffy.toInt());

      if(diffz.toInt() >= 500  || diffx.toInt() >= 500 || diffy.toInt() >= 500 ) {
       // Serial.println(true);
        digitalWrite(ledRed, HIGH);
        delay(200);
        digitalWrite(ledRed, LOW);
        
        tone(speakerPin1, 3000, 1000);
        delay(200);
        noTone(speakerPin1); 
        delay(500);
        
        tone(speakerPin2, 3000, 1000);
        delay(200);
        noTone(speakerPin2); 
        delay(500);

        digitalWrite(ledRed, HIGH);
        delay(200);
        digitalWrite(ledRed, LOW);
        
        tone(speakerPin1, 3000, 1000);
        delay(200);
        noTone(speakerPin1); 
        delay(500);
        
        tone(speakerPin2, 3000, 1000);
        delay(200);
        noTone(speakerPin2); 
        delay(500);
      
      /*
        tone(speakerPin1, 3000, 1000);
        digitalWrite(ledRed, HIGH);
        delay(200);
        noTone(speakerPin1);
        delay(1000); 
        
        tone(speakerPin2, 3000, 1000);
        digitalWrite(ledRed, LOW);
        delay(200); 
        noTone(speakerPin2); 
        delay(1000); */

       // noTone(speakerPin1); 
      }
    
   }
    
    previousPositionZ = accelerometer_z;
    previousPositionX = accelerometer_x;
    previousPositionY = accelerometer_y;

  

  delay(1000);
}
