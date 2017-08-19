//File Name: PositionInterface.java
//Gregory Delpe
//CSc221

package shapes;

public interface PositionInterface
{
    void getPoint();

    void moveTo(int xOffset, int yOffset);

    double distanceTo(double x1, double x2, double y1, double y2);
}
