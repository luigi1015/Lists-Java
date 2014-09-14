/*
 * The MIT License
 *
 * Copyright 2014 Jeff Crone.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package net.codehobby;

/**
 * This is an item of a list defined in ItemList.
 * @author Jeff Crone
 */
public class ListItem
{
    private String description;//The description of the item. This will be displayed as part of the item.
    private boolean isChecked;//Whether or not the item should be checked in the GUI.

    /**
     * Constructor with just the description.
     * @param newDescription A String representation of the description of the item.
     */
    public ListItem( String newDescription )
    {
        description = newDescription;
    }

    /**
     * Constructor with the description and the isChecked values.
     * @param newDescription A String representation of the description of the item.
     * @param newIsChecked A boolean representation of whether or not the item should be checked in the GUI.
     */
    public ListItem( String newDescription, boolean newIsChecked )
    {
        description = newDescription;
        isChecked = newIsChecked;
    }

    /**
     * Sets the description.
     * @param newDescription The new description in String format.
     */
    public void setDescription( String newDescription )
    {
        description = newDescription;
    }

    /**
     * Returns the description.
     * @return The description as a String.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Sets whether or not the item should be checked in the GUI.
     * @param newIsChecked The boolean representation of whether or not the item should be checked in the GUI.
     */
    public void setChecked( boolean newIsChecked )
    {
        isChecked = newIsChecked;
    }

    /**
     * Returns whether or not the item should be checked in the GUI.
     * @return The boolean representation of whether or not the item should be checked in the GUI.
     */
    public boolean getIsChecked()
    {
        return isChecked;
    }
}
