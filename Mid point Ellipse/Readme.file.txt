# Midpoint Ellipse Drawing Algorithm

## Description

This project implements the **Midpoint Ellipse Drawing Algorithm** in Java using `Java Swing`.

The algorithm draws an ellipse efficiently by calculating points in two regions and using **4-way symmetry** to generate the complete ellipse.

The program also prints the calculated points in the console.

## File Name

```text
MidpointEllipse.java
```

## Features

* Draws an ellipse using the Midpoint Ellipse Drawing Algorithm.
* Uses **4-way symmetry**.
* Divides the ellipse into **two regions**.
* Prints the calculated points in the console.
* Uses Java Swing for graphical output.

## Requirements

* Java JDK 8 or later
* Java Swing

## Algorithm

The ellipse is divided into two regions based on the slope.

### Initial Values

```text
x = 0
y = ry

rx² = rx * rx
ry² = ry * ry

dx = 2 * ry² * x
dy = 2 * rx² * y
```

### Region 1 Decision Parameter

```text
p1 = ry² - rx² * ry + 0.25 * rx²
```

If:

```text
p1 < 0
```

then:

```text
x = x + 1
p1 = p1 + dx + ry²
```

Otherwise:

```text
x = x + 1
y = y - 1
p1 = p1 + dx - dy + ry²
```

### Region 2 Decision Parameter

```text
p2 = ry²(x + 0.5)² + rx²(y - 1)² - rx²ry²
```

If:

```text
p2 > 0
```

then:

```text
y = y - 1
p2 = p2 - dy + rx²
```

Otherwise:

```text
x = x + 1
y = y - 1
p2 = p2 + dx - dy + rx²
```

## 4-Way Symmetry

For every calculated point `(x, y)`, four points are plotted:

```text
(xc + x, yc + y)
(xc - x, yc + y)
(xc + x, yc - y)
(xc - x, yc - y)
```

## Current Example

The program uses:

```text
Center = (300, 300)
X-radius = 8
Y-radius = 6
```

This is set in:

```java
drawEllipse(g, 300, 300, 8, 6);
```

You can change these values to draw a different ellipse.

## How to Run

### 1. Compile

Open the terminal in the project directory:

```bash
javac MidpointEllipse.java
```

### 2. Run

```bash
java MidpointEllipse
```

A Swing window will display the ellipse, while the calculated points will be printed in the console.

## Output

The program produces:

1. A graphical ellipse in the Java Swing window.
2. The symmetric ellipse points in the console.

## Important Note

Java screen coordinates start from the **top-left corner**.

Therefore, using:

```java
drawEllipse(g, 0, 0, 8, 6);
```

places the center at the top-left corner.

For a clearly visible ellipse, use a center such as:

```java
drawEllipse(g, 300, 300, 8, 6);
```

Computer Graphics — Midpoint Ellipse Drawing Algorithm
