package asml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        final InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        final BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(findMaximumMeasurementValue(parseLineToWafer(line)));
        }
    }

    /**
     * Finds maximum measurement value of all full exposed field of a given wafer
     *
     * @param wafer a circle with a given fixed diameter of 300 mm which that contains fields and measurements
     * @return the maximum measurement value found
     */
    private static float findMaximumMeasurementValue(Wafer wafer) {
        List<Field> fullyExposedFieldList = getFullyExposedFields(wafer);

        List<Measurement> measurementInFieldList = getMeasurementsInField(wafer.getMeasurements(), fullyExposedFieldList);

        Measurement maxValue = measurementInFieldList.stream().max(Comparator.comparing(v -> {
            return v.getValue() != Double.NaN ? v.getValue() : Double.NaN;
        })).get();

        return maxValue.getValue();
    }

    private static List<Field> getFullyExposedFields(Wafer wafer) {
        List<Field> fullExposedList = new ArrayList<Field>();
        List<Field> fields = wafer.getFields();
        for (Field field : fields) {
            double leftX = field.getCentreX() - field.getWidth() / 2;
            double rightX = field.getCentreX() + field.getWidth() / 2;

            double topY = field.getCentreY() + field.getHeight() / 2;
            double bottomY = field.getCentreY() - field.getHeight() / 2;

            boolean f1 = isCornerInWafer(leftX, topY, wafer.diameter / 2);
            boolean f2 = isCornerInWafer(rightX, topY, wafer.diameter / 2);
            boolean f3 = isCornerInWafer(leftX, bottomY, wafer.diameter / 2);
            boolean f4 = isCornerInWafer(rightX, bottomY, wafer.diameter / 2);

            if (f1 && f2 && f3 && f4) {
                fullExposedList.add(field);
            }
        }

        return fullExposedList;
    }

    private static boolean isCornerInWafer(double x, double y, double waferRadius) {
        return Math.sqrt(x * x + y * y) < waferRadius;
    }

    private static List<Measurement> getMeasurementsInField(List<Measurement> measurements, List<Field> fullExposedList) {
        List<Measurement> measurementInFieldList = new ArrayList<>();

        for (Field field : fullExposedList) {
            measurementInFieldList = measurements.stream()
                    .filter(measurement -> isMeasurementInFullExposedField(field, measurement))
                    .collect(Collectors.toList());
        }

        return measurementInFieldList;
    }

    public static boolean isMeasurementInFullExposedField(Field field, Measurement m) {
        double leftX = field.getCentreX() - field.getWidth() / 2;
        double rightX = field.getCentreX() + field.getWidth() / 2;

        double topY = field.getCentreY() + field.getHeight() / 2;
        double bottomY = field.getCentreY() - field.getHeight() / 2;

        return m.getX() > leftX && m.getX() < rightX && m.getY() > bottomY && m.getY() < topY;
    }

    /**
     * Parses input line to a wafer object representation.
     * Input line contains the list of fields and then the list of measurements, such as:
     * FIELD_1_CENTER_X,FIELD_1_CENTER_Y; FIELD_2_CENTER_X,FIELD_2_CENTER_Y |
     * MEASUREMENT_1_X, MEASUREMENT_1_Y, MEASUREMENT_1_VALUE; MEASUREMENT_2_X, MEASUREMENT_2_Y, MEASUREMENT_2_VALUE
     * <p>
     * For each field, there is given the field center on x and y.
     * FIELD_1_CENTER_X,FIELD_1_CENTER_Y
     * For each measurement, there is given the measurement position on x and y + the measurement value.
     * MEASUREMENT_1_X, MEASUREMENT_1_Y, MEASUREMENT_1_VALUE
     * Concrete example:
     * For a wafer with two fields, one with center position (10,10) and second one with center position (20,20)
     * and a list of 4 measurements at (0,10) with value 1, (10,15) with value 2, (20,25) with value 3 and (30,20) with value 4,
     * the input consists of:
     * 10,10;20,20|0,10,1;10,15,2;20,25,3;30,20,4
     * <p>
     * Notes:
     * Input line can contain NaN measurement values.
     * Measurement values are defined as float with a precision of 7 decimal digits
     * Field and measurement positions are defined as double with a precision of 15 decimal digits
     *
     * @param line the input line
     * @return the wafer containing the diameter, list of fields and list of measurements.
     */
    private static Wafer parseLineToWafer(String line) {
        final String[] splittedString = line.split("\\|");

        final List<Field> fieldLayout = Arrays.stream(splittedString[0].trim().split(";"))
                .map(f -> {
                    final List<String> props = Arrays.stream(f.split(",")).filter(prop -> !prop.isEmpty()).collect(Collectors.toList());
                    if (props.size() == 2) {
                        return new Field(Double.parseDouble(props.get(0)), Double.parseDouble(props.get(1)), 26, 32);
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        final List<Measurement> measurements = Arrays.stream(splittedString[1].trim().split(";"))
                .map(f -> {
                    final List<String> props = Arrays.stream(f.split(",")).filter(prop -> !prop.isEmpty()).collect(Collectors.toList());
                    if (props.size() == 3) {
                        return new Measurement(Double.parseDouble(props.get(0)), Double.parseDouble(props.get(1)), Float.parseFloat(props.get(2)));
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return new Wafer(300, fieldLayout, measurements);
    }

    /**
     * Wafer class containing the diameter, list of fields and list of measurements.
     * Note: For the given problem a fixed diameter of 300 mm is used.
     */
    private static class Wafer {
        double diameter;
        List<Field> fieldLayout;
        List<Measurement> measurements;

        public Wafer(double diameter, List<Field> fieldLayout, List<Measurement> measurements) {
            this.diameter = diameter;
            this.fieldLayout = fieldLayout;
            this.measurements = measurements;
        }

        public List<Field> getFields() {
            return this.fieldLayout;
        }

        public List<Measurement> getMeasurements() {
            return this.measurements;
        }
    }

    /**
     * Field class containing the field center position on x and y axis plus the field width and height.
     * Note: For the given problem a fixed width of 26.0 mm and height 32.0 mm are being used.
     */
    private static class Field {
        double centerX;
        double centerY;
        double width;
        double height;

        public Field(double centerX, double centerY, double width, double height) {
            this.centerX = centerX;
            this.centerY = centerY;
            this.width = width;
            this.height = height;
        }

        public double getCentreX() {
            return this.centerX;
        }

        public double getCentreY() {
            return this.centerY;
        }

        public double getWidth() {
            return this.width;
        }

        public double getHeight() {
            return this.height;
        }
    }

    /**
     * Measurement class containing the measurement position on x and y axis plus the measurement value.
     */
    private static class Measurement {
        double x;
        double y;
        float value;

        public Measurement(double x, double y, float value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public float getValue() {
            return value;
        }
    }
}