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
package myqueueserver.Config;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

/**
 *
 * @author Nikos Siatras
 */
public class Config
{

    public static String fApplicationStartUpPath;
    public static int fServerPort, fMaxConnections;
    public static int fReadBufferSize;
    public static int fCorePoolSize, fMaxPoolSize;
    public static int fConnectionsTimeOut;
    public static ArrayList<String> fBindAddresses = new ArrayList<>();

    public Config()
    {
    }

    public static void ReadConfigFile() throws Exception
    {
        java.io.File currentDir = new java.io.File("");
        fApplicationStartUpPath = currentDir.getAbsolutePath();

        String configPath = fApplicationStartUpPath + "\\myqueue.cnf";
        File confFile = new File(configPath);

        if (!confFile.exists())
        {
            throw new Exception("File 'myqueue.cnf' does not exist!");
        }
        else if (!confFile.canRead())
        {
            throw new Exception("File 'myqueue.cnf' exists but has no required read permissions!");
        }

        FileInputStream fstream = new FileInputStream(confFile);

        Properties properties = new Properties();
        properties.load(fstream);

        fServerPort = Integer.parseInt(properties.get("port").toString().trim());
        fBindAddresses.addAll(Arrays.asList(properties.getProperty("bind-address").toString().trim().split(",")));
        fReadBufferSize = Integer.parseInt(properties.get("read_buffer_size").toString().trim());
        fConnectionsTimeOut = Integer.parseInt(properties.get("connection_timeout").toString().trim());
        fMaxConnections = Integer.parseInt(properties.get("max_connections").toString().trim());

        fCorePoolSize = Integer.parseInt(properties.get("core_pool_size").toString().trim());
        fMaxPoolSize = Integer.parseInt(properties.get("max_pool_size").toString().trim());
    }

}
