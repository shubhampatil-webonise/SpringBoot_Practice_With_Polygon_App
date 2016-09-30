import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class Application {

    private final Polygon polygon;
    private final Scanner scanner;

    private static final int MINIMUM_SIDE_LIMIT = 3;
    private static final int MAXIMUM_SIDE_LIMIT = 10;
    private static final Logger logger = Logger.getLogger(Application.class.getName());

    @Autowired
    public Application(Polygon polygon, Scanner scanner) {
        this.polygon = polygon;
        this.scanner = scanner;
    }


    public void start() {
        try {
            getDataAndInitObject();
        } catch (Exception exception) {
            logger.debug(exception.getMessage());
            System.exit(1);
        }

        printResults();
    }

    private void getDataAndInitObject() {
        int numberOfSides = 0;
        double lengthOfEachSide = 0.0;

        try {
            logger.debug("Enter number of sides :");
            numberOfSides = scanner.nextInt();

            logger.debug("Enter length of each side :");
            lengthOfEachSide = scanner.nextDouble();

        } catch (InputMismatchException inputMismatchError) {
            logger.debug("Aborting : Unexpected input types.");
            System.exit(1);
        }

        if (isValidateNumberOfSides(numberOfSides) && isValidateLength(lengthOfEachSide)) {
            polygon.setNumberOfSides(numberOfSides);
            polygon.setLengthOfEachSide(lengthOfEachSide);
        } else
            throw new IllegalArgumentException("Invalid Input");
    }

    private boolean isValidateNumberOfSides(int numberOfSides) {

        if (numberOfSides >= MINIMUM_SIDE_LIMIT && numberOfSides <= MAXIMUM_SIDE_LIMIT)
            return true;
        else
            return false;
    }

    private boolean isValidateLength(double lengthOfEachSide) {

        if (lengthOfEachSide > 0)
            return true;
        else
            return false;
    }

    private void printResults() {
        logger.debug("Sum of Interior Angles of Polygon : " + polygon.calculateSumOfInteriorAngles() + "\n");
        logger.debug("Parameter of Polygon : " + polygon.calculateParameter() + "\n");
    }
}
