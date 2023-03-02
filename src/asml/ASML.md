Debug Challenge - Maximum measurement
Programming challenge description:
Description
A wafer is a circle with a given fixed diameter (300.0 mm) that contains fields and measurements. The center of the wafer is at position on x,y (0, 0) (See attachment)

An exposed field is a rectangular shape defined by a fixed width (26.0 mm) and height (32.0 mm). An exposed field has a center which is defined relatively from the center of a wafer.

An exposed field is a "fully exposed field" when it is fully on a wafer. The complete rectangular shape must be inside of the circle area. (See attachment)

An exposed field is a "partially exposed field" when it partially overlaps with a wafer. In this case, the rectangular shape is not fully inside the circle area. (See attachment)

A measurement is positioned relatively from the center of a wafer. A measurement's value is represented as a float and may contain 'NaN'.

In the attached diagram the measurement is a dot.

A measurement is considered part of a field when it is inside the exposed field.

GOAL
Find the "maximum measurement value" of all “fully exposed fields” of a wafer.

Rules
Use the existing Wafer, Field, Measurement classes
Do not change the return type or input arguments of the "findMaximumMeasurementValue" method
You are free to add new classes, methods, properties or extend existing ones if your solution requires this; however, it is not mandatory.
Input line can contain NaN measurement values
Measurement values are defined as float with a precision of 7 decimal digits
Field and measurement positions are defined as double with a precision of 15 decimal digits
If the answer cannot be calculated, it expects to return Float.NaN
Input:
A Wafer containing a list of fields and list of measurements. Input format first lists the fields separated by ';' and then the measurements divided by '|' also separated by ';'.

EXAMPLE FIELD_1_CENTER_X,FIELD_1_CENTER_Y; FIELD_2_CENTER_X,FIELD_2_CENTER_Y | MEASUREMENT_1_X, MEASUREMENT_1_Y, MEASUREMENT_1_VALUE; MEASUREMENT_2_X, MEASUREMENT_2_Y, MEASUREMENT_2_VALUE

Output:
The maximum measurement value of all 'fully exposed fields' within the given wafer.

EXAMPLE 33.0

Test 1
Test Input
Download Test 1 Input
0,0;-30,0;0,40 | 0,0,11;-10,10,22;-40,10,33;5,-10,44
Expected Output
Download Test 1 Output
44.0
Test 2
Test Input
Download Test 2 Input
0,0;150,0;-150,0 | 0,0,42;1,1,10;149,0,80
Expected Output
Download Test 2 Output
42.0
Test 3
Test Input
Download Test 3 Input
0,0;150,0;-150,0;106,106;106,-106;-106,106;-106,-106 | 0,0,10.1;1,1,10.2;149,0,80;-149,0,90
Expected Output
Download Test 3 Output
10.2