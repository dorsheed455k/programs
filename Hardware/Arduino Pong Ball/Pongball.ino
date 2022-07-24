#include <Adafruit_GFX.h>
#include <Adafruit_ST7735.h>
#include <Fonts/FreeSerif18pt7b.h> 
#include <SPI.h>

// Rotary Encoder
#define TFT_CS 10
#define TFT_RST 9
#define TFT_DC 8
#define DT 3
#define CLK 2
#define SW 4


// Joy stick
#define SW_pin 5
#define X_pin  A0 
#define Y_pin A1



int counter = 0;
int points = 0;
int highScore = 0;
int currentCount = 0;
int currentStateCLK;
int lastStateCLK;
int height = 0;
String currentDir = "";
int Variable;
unsigned long lastButtonPress = 0;
unsigned long lastToggle = 0;
uint16_t color = 0xF800;

uint16_t ballColor = ST7735_WHITE;

int xPosition = 0;
int yPosition = 0;
int SW1_state = 0;
int mapX = 0;
int mapY = 0;

bool endGame = false;

int WIDTH = 128;
int HEIGHT = 160;

int ballX = WIDTH / 2;
int ballY = HEIGHT / 2;

int ballSpeedX = 5;
int ballSpeedY = 7;

int currentPos;
int prevPos;

int xPaddle;
int yPaddle;


Adafruit_ST7735 tft = Adafruit_ST7735(TFT_CS, TFT_DC, TFT_RST);

 uint16_t colors[9] = {
  0x0000,
  0xFFFF,
  0xF800,
  0x07E0,
  0x001F,
  0x07FF,
  0xF81F,
  0xFFE0,
  0xFC00
};

void setup() {
  pinMode(CLK, INPUT);
  pinMode(DT, INPUT);
  pinMode(SW, INPUT_PULLUP);

  tft.initR(INITR_BLACKTAB);
  tft.fillScreen(0x6C3F);
  tft.setTextWrap(false);


  Serial.begin(9600);

  pinMode(SW_pin, INPUT);
  digitalWrite(SW_pin, HIGH);
  
  lastStateCLK = digitalRead(CLK);

  xPaddle = (WIDTH / 2) - 20;
  yPaddle = 130;

  prevPos = analogRead(X_pin);

}

void loop() {
//  rotaryScreen();
  int address=0;
  tft.setTextSize(4);
  tft.setCursor(0,0);  
 
  if(!endGame) {
    
     tft.fillScreen(ST77XX_BLACK);
     joyStickControl();
     collisions();
     scoreBoard();
    // delay(100);
  } else {
    delay(100);
  //  tft.invertDisplay(true);
    textScreen();
    int btnState = digitalRead(SW_pin);
    if(btnState == LOW) {
      if(millis() - lastButtonPress > 50) {
        ballX = WIDTH / 2;
        ballY = HEIGHT / 2;
        xPaddle = (WIDTH / 2) - 20;
        yPaddle = 130;
        endGame = false;

        if(points > highScore) {
           highScore = points;
        }
        points = 0;
      }
      lastButtonPress = millis();
     }
  } 
}

void scoreBoard() {
  tft.setCursor(10, 10);
  tft.setTextSize(1.5);
  tft.setTextColor(ST77XX_YELLOW);
  tft.println("Points: ");
  tft.setCursor(60, 10);
  tft.print(points);

  tft.setCursor(10, 20);
  tft.setTextSize(1.5);
  tft.setTextColor(ST77XX_YELLOW);
  tft.println("High Score: ");
  tft.setCursor(80, 20);
  tft.print(highScore);
  delay(100);
}

void textScreen() {
  tft.setCursor(30, 40);
  tft.setTextSize(3);
  tft.setTextColor(ST77XX_RED);
  tft.println("GAME");
  tft.setCursor(30, 70);
  tft.print("OVER");
  delay(500);
  
  tft.setCursor(30, 40);
  tft.setTextColor(ST77XX_GREEN);
  tft.println("GAME");
  tft.setCursor(30, 70);
  tft.print("OVER");
  delay(500);
}

void joyStickControl() {
  int xPosition = analogRead(X_pin);
  int yPosition = analogRead(Y_pin);
  Serial.print("Switch:  ");
  Serial.print(digitalRead(SW_pin));
  Serial.print(" | ");
  Serial.print("X-axis: ");
  Serial.print(xPosition);
  Serial.print(" | ");
  Serial.print("Y-axis: ");
  Serial.print(yPosition);
  Serial.println(" | ");

  tft.fillCircle(ballX, ballY, 5, ballColor); 

 

  if(millis() - lastToggle > 50) {

    currentPos = xPosition;
  
    if(currentPos > 512 && (currentPos != 512 || prevPos != 512)) {
        xPaddle += 10;
      }
    
      if(currentPos < 512 && (currentPos != 512 || currentPos != 512)) {
        xPaddle -= 10;
      }
    
      if(xPaddle < 0) {
        xPaddle = 0;
      }
    
      if(xPaddle + 40 > WIDTH) {
        xPaddle = WIDTH - 40;
      }
  
    prevPos = currentPos;
  }

  lastToggle = millis();

 
  int btnState = digitalRead(SW_pin);

  if(btnState == LOW) {
    if(millis() - lastButtonPress > 50) {
      int rand = random(8);
      color = colors[rand];
    }

    lastButtonPress = millis();
  }

  tft.fillRect(xPaddle, yPaddle, 40, 10, color);
  
}

void collisions() {
  ballX += ballSpeedX;
  ballY += ballSpeedY;

  if(ballX+10 >= WIDTH || ballX-10 <= 0) {
    ballSpeedX *= -1;
  }

  if(ballY >= HEIGHT) {
    endGame = true;
  }

  if(ballY <= 0) {
    ballSpeedY *= -1;
  }

  if(ballX >= xPaddle && ballX <= xPaddle+40) {
    // ballColor = ST7735_RED;
    if(ballY >= yPaddle-10) {
     ballColor = ST7735_RED;
     points++;


      
      ballSpeedX *= -1;
      ballSpeedY = -7;

      ballSpeedX += 1;
      ballSpeedY += 1;
    } else {
      ballColor = ST7735_WHITE;
    }
  }
}

void rotaryScreen() {
   currentStateCLK = digitalRead(CLK);

  if(currentStateCLK != lastStateCLK && currentStateCLK == 1) {

    if(digitalRead(DT) != currentStateCLK) {
      counter--;
      currentDir = "CCW";
    } else {
      counter++;
      currentDir = "CW";
    }

    if(counter < 0) {
      counter = 0;
    }

    if(counter > 160) {
      counter = 160;
    }

    Serial.print("Direction: ");
    Serial.print(currentDir);
    Serial.print(" | Counter: ");
    Serial.println(counter);
  }

  lastStateCLK = currentStateCLK;

  int btnState = digitalRead(SW);

  if(btnState == LOW) {
    if(millis() - lastButtonPress > 50) {
      Serial.println("Button pressed!");
      int rand = random(8);
      color = colors[rand];
    }

    lastButtonPress = millis();
  }

  tft.fillRect(0, 0, 128, (counter*10), color);

  delay(1);
}
