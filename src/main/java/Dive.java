import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dive
{
    private static final String FILE_PATH = "/Users/melpomene/Downloads/input2.txt";

    public static void main(String[] args)
    {
        List<Movement> movements = getDirections();
        System.out.println(getPosition(movements));
    }

    private static List<Movement> getDirections()
    {
        List<Movement> movements = new ArrayList<>();
        try
        {
            File myObj = new File(FILE_PATH);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                movements.add(new Movement(myReader.nextLine()));
            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return movements;
    }

    private static int getPosition(List<Movement> movements)
    {
        int horizontalPosition = 0;
        int aim = 0;
        int depth = 0;
        for (Movement movement: movements)
        {
            switch (movement.direction)
            {
                case "forward" ->
                        {
                            horizontalPosition += movement.length;
                            depth += movement.length * aim;
                        }
                case "up" -> aim -= movement.length;
                case "down" -> aim += movement.length;
            }
        }
        return horizontalPosition * depth;
    }
}
