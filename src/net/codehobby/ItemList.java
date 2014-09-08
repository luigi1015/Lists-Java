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

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * A representation of a list of items.
 * @author Jeff Crone
 */
public class ItemList
{
    private String name;
    private Map<Integer, String> items;

    /**
     * Constructor with the name of the list.
     * @param newName The name of the list.
     */
    public ItemList( String newName )
    {
        name = newName;
        items = new HashMap<Integer, String>();
    }
    
    /**
     * Adds an item to this list.
     * 
     * @param newId The Integer ID of the item.
     * @param newDescription The String description or text of the item.
     */
    public void addItem( Integer newId, String newDescription )
    {
        items.put( newId, newDescription );
    }
    
    /**
     * Creates and returns an iterator for going over the items in the list.
     * @return An iterator of type Iterator<Map.Entry<Integer, String>>.
     */
    public Iterator<Map.Entry<Integer, String>> iterator()
    {
        return items.entrySet().iterator();
    }
    
    /**
     * Converts this object to a Json representation.
     * @return The json as a string.
     */
    public String convertToJson()
    {
        Gson jsonCreator = new Gson();
        String jsonText = jsonCreator.toJson( this );
        return jsonText;
    }
    
    /**
     * Returns the name of the list.
     * @return the name of the list.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Sets the name of the list.
     * @param newName The name of the list.
     */
    public void setName( String newName )
    {
        name = newName;
    }
}