/*
 * RequestRecharge
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

package robot.common.request;

import java.util.List;
import robot.common.response.Response;
import robot.common.response.ResponseOk;
import robot.common.response.ResponseDamage;
import robot.common.response.ResponseCrumbled;
import java.util.Arrays;

/**
 *
 * @author Jaroslav Merxbauer
 * @version %I% %G%
 */
public class RequestRecharge extends Request {

    public RequestRecharge(String adress) {
    }

    public RequestRecharge() {
    }

    public String formatForTcp() {
        return new StringBuilder(getAdress()).append(" NABIT ").append("\r\n").toString();
    }

    public Response route(RequestProcessor processor) {
        return processor.processRecharge();
    }

    @Override
    protected List<Response> getSupportedResponses() {
        return Arrays.asList(new Response[] {new ResponseOk(), new ResponseCrumbled(), new ResponseDamage()});
    }

}