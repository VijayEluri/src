/*
 * RobotServerInfo
 *
 * Copyright (C) 2010  Jaroslav Merxbauer
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package robot.server;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import robot.common.RobotInfo;
import robot.server.exception.RobotOutOfFieldException;

/**
 *
 * @author Jaroslav Merxbauer
 * @version %I% %G%
 */
public class RobotServerInfo extends RobotInfo {

    private int stepsSoFar;

    private static final int MAX_X =  17;
    private static final int MAX_Y =  17;
    private static final int MIN_X = -17;
    private static final int MIN_Y = -17;

    public RobotServerInfo(int battery, int x, int y, Direction direction) {
        super(battery, x, y, direction);
        this.stepsSoFar = 0;
    }

    public void move() throws RobotOutOfFieldException {
        Vector vec = directions.get(direction);
        x = x + vec.x;
        y = y + vec.y;
        if (x < MIN_X || x > MAX_X || y < MIN_Y || y > MAX_Y) {
            throw new RobotOutOfFieldException(x,y);
        }
    }

    public void turn() {
        int directionIndex = directionRotationOrder.indexOf(direction);
        direction = directionRotationOrder.get((directionIndex + 1) % 4);
    }

    public int getStepsSoFar() {
        return stepsSoFar;
    }

    public void setStepsSoFar(int stepsSoFar) {
        this.stepsSoFar = stepsSoFar;
    }

}