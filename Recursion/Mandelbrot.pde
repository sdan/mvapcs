int resolution = 0;
int escape_velocity;
//This sets the size that defines the Mandelbrot set. 
//Any points, after iteration, that stay with a size under 2 are in the
//Mandelbrot set.
float escape_radius = 2;
int color_mode = 0;

void setup()
{
  colorMode(HSB,100);
  size(700,750);
  background(0,0,100);
  drawfractal();
}

void draw()
{
  drawUI();
}

float calculate_mandelbrot(float c_a, float c_b)
{
  escape_velocity = 0;
  //start with 0+0i
  float a = 0;
  float b = 0;
  
  float next_a;
  float next_b;
  
  float size_of_number = 0;
  
  while ((escape_velocity < resolution) && (size_of_number < escape_radius))
  {
      //this function is for x_(n+1) = x_n^2 + c, where x_n and c are complex numbers
      //exercise left to the reader to see why (a+bi)^2 = (a^2-b^2)+(2ab)i
      next_a = a*a - b*b + c_a;
      next_b = 2*a*b + c_b;
      a = next_a;
      b = next_b;
      escape_velocity++;
      size_of_number = sqrt(a*a + b*b);
  }
  return size_of_number;
}

void drawfractal()
{
  loadPixels();
  color c = color(0,0,100);;
  for (int i = 0; i < pixels.length; i++)
  {
    //these 4 lines of code map the 1 dimensional pixel array to a start cx and cy
    float startc_a = float(i % width) / width;
    float startc_b = float(floor(float(i) / width)) / (height-50);
    startc_a = map(startc_a,0.0,1.0,-2.0,2.0);
    startc_b = map(startc_b,0.0,1.0,-2.0,2.0);
    
    float size_of_number = calculate_mandelbrot(startc_a,startc_b);

    if (size_of_number < escape_radius)
    {
      c = color(0,100,0);
    }
    else
    {
      //Each of these is a different coloring mode... try them out!
      if (color_mode == 0)
      {
        c = color(0,0,100);
      }
      else if (color_mode == 1)
      {
        c = color(100-10*log(escape_velocity),100-20*log(escape_velocity),100);
      }
      else if (color_mode == 2)
      {
        c = color(100-50*log(size_of_number),100-20*log(size_of_number),100);
      }
      else if (color_mode == 3)
      {
        c = color(100-100*float(escape_velocity)/resolution,100,100);
      }
      else if (color_mode == 4)
      {
        c = color(100-(2*escape_velocity)%100,random(30)+70,100);
      }
      else if (color_mode == 5)
      {
        c = color(50*sin(0.1*escape_velocity)+50,5*sin(escape_velocity)+65,100);
      }
    }
    pixels[i] = c;
  }
  updatePixels();
}


void drawUI()
{
  PFont f;
  f = createFont("Arial",16,true);
  textFont(f,16);
  
  //Clear bottom UI
  fill(0,100,0);
  rect(0,height-55,width,55);
  
  //Info
  fill(0,0,100);
  text("Resolution " + str(resolution),3,height-20);

  //Resolution Tag
  fill(0,0,100);
  text("Resolution",179,height-21);
  
  //Resolution Buttons
  fill(0,100,0);
  stroke(0,0,100);
  rect(256,height-54,75,20);
  fill(0,0,100);
  text("+ 1",281,height-39);
  
  fill(0,100,0);
  stroke(0,0,100);
  rect(256,height-34,75,17);
  fill(0,0,100);
  text("- 5",285,height-20);
  
  fill(0,100,0);
  stroke(0,0,100);
  rect(256,height-17,75,16);
  fill(0,0,100);
  text("+ 10",281,height-3);
  
  
  //Reset All
  fill(0,100,0);
  stroke(0,0,100);
  rect(544,height-54,75,53);
  fill(0,0,100);
  text("Reset All",550,height-21);
  
  //colormode
  fill(0,100,0);
  stroke(0,0,100);
  rect(619,height-54,75,53);
  fill(0,0,100);
  text("Change",627,height-37);
  text("color",637,height-22);
  text("mode",635,height-8);
  
  String xcoord = str(float(mouseX)/width*4.0-2.0);
  if (xcoord.length() > 4)
  {
    xcoord = xcoord.substring(0,4);
  }
  String ycoord = str(float(height-mouseY)/height*4.0-2.0);
  if (ycoord.length() > 4)
  {
    ycoord = ycoord.substring(0,4);
  }
  String coordinate = xcoord + " + " + ycoord + "i";
  text(coordinate,360,height-23); 
   
}

void mouseClicked()
{
  int mx = mouseX;
  int my = mouseY;

  //Button Checker
  //Resolution Buttons
  if (mx >= 256 && mx <= 331 && my > (height - 54) && my < (height - 34))
  {
    resolution += 1;
  }
  if (mx >= 256 && mx <= 331 && my > (height - 34) && my < (height - 21))
  {
    if (resolution > 5)
    {
      resolution -= 5;
    }
    else if (resolution > 0)
    {
      resolution -= 1;
    }
  }
  if (mx >= 256 && mx <= 331 && my > (height - 21) && my < (height))
  {
    resolution += 10;
  }
  
  //Reset all button
  if (mx >= 544 && mx <= 619 && my >= (height - 54) && my < height)
  {
    resolution = 0;
    color_mode = 0;
  }
  
  //Change color mode button
  if (mx >= 619 && mx <= 694 && my >= (height - 54) && my < height)
  {
    color_mode += 1;
    if (color_mode > 5)
    {
      color_mode = color_mode % 6;
    }
  }
  
  drawfractal();
}