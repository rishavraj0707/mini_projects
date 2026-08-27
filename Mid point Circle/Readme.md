# Midpoint Circle Drawing Algorithm

## Description

This project implements the **Midpoint Circle Drawing Algorithm** in Java using `Java Swing`.

The algorithm draws a circle efficiently using **8-way symmetry** and an integer decision parameter.

## File Name

```text
MidpointCircle.java
```

## Features

* Draws a circle using the Midpoint Circle Algorithm.
* Uses 8-way symmetry.
* Prints the calculated points in the console.
* Uses Java Swing for graphical output.

## Algorithm

The initial values are:

```text
x = 0
y = r
p = 1 - r
```

### Case 1: If `p < 0`

```text
x = x + 1
p = p + 2*x + 1
```

### Case 2: If `p >= 0`

```text
x = x + 1
y = y - 1
p = p + 2*(x-y) + 1
```

The algorithm continues until:

```text
x > y
```

## 8-Way Symmetry

For every calculated point `(x, y)`, the following points are plotted:

```text
(xc + x, yc + y)
(xc - x, yc + y)
(xc + x, yc - y)
(xc - x, yc - y)

(xc + y, yc + x)
(xc - y, yc + x)
(xc + y, yc - x)
(xc - y, yc - x)
```

## Requirements

* Java JDK 8 or later
* Java Swing (included with standard JDK)

## How to Run

### 1. Compile

Open a terminal in the project directory and run:

```bash
javac MidpointCircle.java
```

### 2. Run

```bash
java MidpointCircle
```

A window will open showing the circle, and the generated points will be printed in the console.

## Example

The program currently uses:

```text
Center = (250, 250)
Radius = 100
```

You can change these values in the `paintComponent()` method:

```java
drawCircle(g, 250, 250, 100);
```

For example:

```java
drawCircle(g, 300, 300, 150);
```

## Output

The program produces:

* A graphical circle in the Swing window.
* The calculated symmetric points in the console.


Computer Graphics — Midpoint Circle Drawing Algorithm
