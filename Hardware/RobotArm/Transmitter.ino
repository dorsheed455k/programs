#include <SPI.h>
#include <nRF24L01.h>
#include <RF24.h>
#include <Encoder.h>

#define CLK 5
#define DT 4
#define SW 3

int counter = 0;
int currentStateCLK;
int lastStateCLK;
String currentDir = "";


const int homePosition = 90;
const int stepValue = 5;
const int servoPin = 9;

int servoAngle = homePosition;


Encoder myEnc(CLK, DT);
const int buttonPin = 2;  // the number of the pushbutton pin
int buttonState = 0;  // variable for reading the pushbutton status
int count = 0;

RF24 radio(9, 10); // CE, CSN on Blue Pill 
const uint64_t address = 0xE7E7E7E7E7;

String message = "";
 
void setup() 
{
  radio.begin();
  radio.setAutoAck(false); 
  Serial.print("ADDRESS :");
  radio.openReadingPipe(0, address);   //Setting the address at which we will receive the data
  radio.setPALevel(RF24_PA_MIN);       //You can set this as minimum or maximum depending on the distance between the transmitter and receiver.
  radio.stopListening();              //This sets the module as receiver

  pinMode(CLK, INPUT);
  pinMode(DT, INPUT);
  pinMode(SW, INPUT_PULLUP);

  pinMode(buttonPin, INPUT_PULLUP);
  Serial.begin(9600);

}


 long oldPosition  = -999;

void loop()
{

  static uint16_t state = 0;

  delayMicroseconds(100);
  state = (state << 1) | digitalRead(CLK)| 0xe000;
  if (state == 0xf000) {
    state = 0x0000;
    if (digitalRead(DT)) {
      servoAngle+=5;
   } else  {
      servoAngle-=5;
   }

    if (servoAngle <= 0) {
      servoAngle = 0;
    }  

    if (servoAngle > 180) {
      servoAngle = 180;
    }
    //  Serial.println(counter);
    buttonState = digitalRead(buttonPin);

    // check if the pushbutton is pressed. If it is, the buttonState is HIGH:
    if (buttonState == HIGH) {
      // turn LED on:
    //  Serial.println("Button Pressed");
      count++;
      if (count > 5) {
        count = 0;
      }
    } else {
      // turn LED off:
    }

    Serial.print(digitalRead(DT));
   // Serial.print(servoAngle);
    Serial.print(" ");
    Serial.println(count);

    int dataToSend[2];

    dataToSend[0] = digitalRead(DT);
    dataToSend[1] = count;

    //Serial.println(servoAngle);
    radio.write(&dataToSend, sizeof(dataToSend)); 
  }

  long newPosition = myEnc.read();
  if (newPosition != oldPosition) {
    if (newPosition > oldPosition) {
      int newStep = abs(newPosition - oldPosition);
      servoAngle -= stepValue;
      if (servoAngle < 0)
        servoAngle = 0;
      
    }

    if (newPosition < oldPosition) {
      servoAngle += stepValue;
      if (servoAngle > 180)
          servoAngle = 180;
    }

    if (digitalRead(SW) == LOW) {
      servoAngle = homePosition;      
    }
    oldPosition = newPosition;
  }
}
