public class FrogSimulation {
    private int goalDistance;
    private int maxHops;

    public FrogSimulation (int dist, int numHops)
    {
        goalDistance = dist;
        maxHops = numHops;
    }

    private int hopDistance()
    {
        return (int) ((Math.random()*goalDistance) - goalDistance/4);
    }

    public boolean simulate()
    {
        int pos = 0;
        String str = ("Goal: " + goalDistance + " Hops: ");
        for (int i = 0; i < maxHops; i++)
        {
            pos += hopDistance();
            str += pos + " ";
            if (pos >= goalDistance)
            {
                System.out.println(str + "   Success Final Distance: " + pos);
                return true;
            }
            else if (pos < 0)
            {
                System.out.println(str + "   Failed Reached Negative Distance");
                return false;
            }
        }
        System.out.println(str + "      Failed Final Distance: " + pos);
        return false;
    }

    public double runSimulations(int num)
    {
        double goal = 0;
        for (int i = num; i > 0; i--)
        {
            if (simulate()) goal++;
        }
        return (goal/num);
    }
}
