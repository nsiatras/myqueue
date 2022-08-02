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
package myqueueserver.MachineStatus;

import java.lang.management.OperatingSystemMXBean;

/**
 *
 * @author Nikos Siatras
 */
public class MachineStatus
{

    private static com.sun.management.OperatingSystemMXBean fBean = (com.sun.management.OperatingSystemMXBean) java.lang.management.ManagementFactory.getOperatingSystemMXBean();

    public MachineStatus()
    {
    }

    public static void Initialize()
    {
    }

    /**
     * The system's CPU Load %
     *
     * @return
     */
    public static long getCPULoad()
    {
        return Math.round(fBean.getSystemCpuLoad() * 100);
    }

    /**
     * The system's Free Memory in Megabytes
     *
     * @return
     */
    public static long getFreeMemory()
    {
        return (long) (fBean.getFreePhysicalMemorySize() * 0.000976562 * 0.0009765625);
    }

    /**
     * The system's Total Memory in Megabytes
     *
     * @return
     */
    public static long getTotalMemory()
    {
        return (long) (fBean.getTotalPhysicalMemorySize() * 0.000976562 * 0.0009765625);
    }
}
