//Sadaf Saadman Jawad Ryerson Id #501126527

public class Ratings 
{

    private int zeroStar;
    private int oneStar;
    private int twoStar;
    private int threeStar;
    private int fourStar;
    private int fiveStar;


    public Ratings(int zerostar, int onestar, int twostar, int threestar, int fourstar, int fivestar){
        this.zeroStar = zerostar;
        this.oneStar = onestar;
        this.twoStar = twostar;
        this.threeStar = threestar;                         //initialize ratings
        this.fourStar = fourstar;
        this.fiveStar = fivestar;

    }

    //set ratings 
    public void setZeroStar()
    {
        zeroStar+=1;
    }

    public void setOneStar()
    {
        oneStar+=1;
    }

    public void setTwoStar()
    {
        twoStar+=1;
    }

    public void setThreeStar()
    {
        threeStar+=1;
    }

    public void setFourStar()
    {
        fourStar+=1;
    }

    public void setFiveStar()
    {
        fiveStar+=1;
    }

    //get ratings
    public int getZeroStar()
    {
        return zeroStar;
    }

    public int getOneStar()
    {
        return oneStar;
    }

    public int getTwoStar()
    {
        return twoStar;
    }

    public int getThreeStar()
    {
        return threeStar;
    }

    public int getFourStar()
    {
        return fourStar;
    }

    public int getFiveStar()
    {
        return fiveStar;
    }

    //return the average rating of a product
    public double calculateRating()
    {
        int zerostar = 0;
        int onestar = 1*oneStar;
        int twostar = 2*twoStar;
        int threestar = 3*threeStar;
        int fourstar = 4*fourStar;
        int fivestar = 5*fiveStar;
        double numerator = zerostar+onestar+twostar+threestar+fourstar+fivestar;
        double divisor = zeroStar+oneStar+twoStar+threeStar+fourStar+fiveStar;
 
        if (divisor==0){
            return 0.0;
        }
        else {
            return numerator/divisor;
        }
    }
}
