public class Movement
{
    public String direction;
    public int length;

    public Movement(String data)
    {
        String[] move = data.split(" ");
        direction = move[0];
        length = Integer.parseInt(move[1]);
    }
}
