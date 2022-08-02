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
package myqueueserver.Authentication;

import myqueueserver.Users.User;
import myqueueserver.Users.UsersManager;

/**
 *
 * @author Nikos Siatras
 */
public class UserAuthenticationManager
{

    public UserAuthenticationManager()
    {
    }

    public static void Initialize()
    {
    }

    /**
     * Check if user with the given username and password exists.
     *
     * @param username
     * @param password
     * @return true or false
     */
    public static boolean AuthenticateUser(String username, String password)
    {
        for (User u : UsersManager.fUsers)
        {
            if (u.getName().equals(username) && u.getPassword().equals(password))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if user has active permissions for a specific queue
     *
     * @param username is the user's name
     * @param queueName is the queue's name
     * @return true or false
     */
    public static boolean UserHasPermissionsForQueue(String username, String queueName)
    {
        for (User u : UsersManager.fUsers)
        {
            if (u.getName().equalsIgnoreCase(username))
            {
                if (u.CanConnectToQueue(queueName))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        return false;
    }
}
