/*
 * RobotDamagedException
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

package robot.common.exception;

/**
 *
 * @author Jaroslav Merxbauer
 * @version %I% %G%
 */
public class RobotDamagedException extends RobotException {
    private int damagedBlock;

    public RobotDamagedException(Throwable cause, int damagerBlock) {
        super(cause);
        this.damagedBlock = damagerBlock;
    }

    public RobotDamagedException(String message, Throwable cause, int damagerBlock) {
        super(message, cause);
        this.damagedBlock = damagerBlock;
    }

    public RobotDamagedException(String message, int damagerBlock) {
        super(message);
        this.damagedBlock = damagerBlock;
    }

    public RobotDamagedException(int damageBlock) {
        this.damagedBlock = damageBlock;
    }

    public int getDamagedBlock() {
        return damagedBlock;
    }

    public void setDamagedBlock(int damagedBlock) {
        this.damagedBlock = damagedBlock;
    }

}