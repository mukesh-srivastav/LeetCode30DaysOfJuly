/**
 * Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.
 */
class  Day14_AngleBetweenHandsOfAClock{
    /**
    Basic Unitary Method

    Hour Hand
    In 12 hours Hour hand complete whole circle and cover 360°
    1 hour - 360° / 12 = 30°

    Minute Hand
    In 60 minutes Minute Hand coplete whole circle and cover 360°.
    1 minute -> 360° / 60 = 6°

    1 hour - 60 minutes
    1 hours - 30°
    1 minute hours hand rotate -> 30° / 60 = 0.5°
    */
    public double angleClock(int hour, int minutes) {
        double angle = Math.abs(30.0 * hour + 0.5  * minutes - 6 * minutes);
        return angle <= 180.0 ? angle : 360 - angle;
    }
}