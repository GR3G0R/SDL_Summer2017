//File Name: ShapePositionInterface.java
//Gregory Delpe
//CSc221

package shapes;

import java.awt.*;

public interface ShapePositionInterface extends PositionInterface, ShapeInterface
{

    Rectangle getBoundingBox();

    boolean doOverlap(java.awt.Shape shapeA, java.awt.Shape shapeB);

}
