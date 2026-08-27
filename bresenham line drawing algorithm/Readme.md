# Bresenham Line Drawing Algorithm

## Description

This project implements the **Bresenham Line Drawing Algorithm** in Java using `Java Swing`.

Bresenham's algorithm is an efficient line drawing algorithm that uses **integer arithmetic** to determine which pixels should be plotted between two endpoints.

The program also prints the calculated points in the console.

## File Name

```text
BresenhamLine.java
```

## Features

* Draws a line using the Bresenham Line Drawing Algorithm.
* Uses integer calculations.
* Prints the calculated `(x, y)` points in the console.
* Displays the line using Java Swing.
* Supports different line directions.

## Requirements

* Java JDK 8 or later
* Java Swing

## Algorithm

Given two points:

```text
(x1, y1)
(x2, y2)
```

Calculate:

```text
dx = |x2 - x1|
dy = |y2 - y1|
```

Determine the direction:

```text
sx = 1  if x1 < x2
     -1 otherwise

sy = 1  if y1 < y2
     -1 otherwise
```

Initialize the error:

```text
err = dx - dy
```

Then repeatedly calculate:

```text
e2 = 2 * err
```

If:

```text
e2 > -dy
```

update:

```text
err = err - dy
x1 = x1 + sx
```

If:

```text
e2 < dx
```

update:

```text
err = err + dx
y1 = y1 + sy
```

The algorithm stops when the destination point is reached.

## Example

The program currently draws a line from:

```text
Start Point = (100, 100)
End Point   = (500, 400)
```

This is defined in:

```java
drawLine(g, 100, 100, 500, 400);
```

You can change these values to draw a different line.

## How to Run

### 1. Compile

Open a terminal in the project directory and run:

```bash
javac BresenhamLine.java
```

### 2. Run

```bash
java BresenhamLine
```

A Swing window will open showing the line.

The calculated pixel coordinates will also be printed in the console.

## Output

The program produces:

1. A graphical line in the Swing window.
2. The calculated `(x, y)` pixel coordinates in the console.

## Advantages

* Fast and efficient.
* Uses integer arithmetic.
* Does not require floating-point calculations.
* Suitable for raster graphics.

## Author

Computer Graphics — Bresenham Line Drawing Algorithm
