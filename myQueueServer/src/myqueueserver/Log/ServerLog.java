/**
 * MIT License
 *
 * Copyright (c) 2022 Nikos Siatras
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package myqueueserver.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Nikos Siatras
 */
public class ServerLog
{

    private static SimpleDateFormat fDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static Calendar fCalendar = Calendar.getInstance();

    public ServerLog()
    {
    }

    public static void WriteToLog(String event, LogMessageType type)
    {
        event = fDateFormat.format(fCalendar.getTime()) + "\t" + event;

        switch (type)
        {
            case Error:
                event = "[Error]\t" + event;
                System.err.println(event);
                break;

            case Warning:
                event = "[Warning]\t" + event;
                System.out.println(event);
                break;

            case Information:
                event = "[Information]\t" + event;
                System.out.println(event);
                break;
        }
    }
}
