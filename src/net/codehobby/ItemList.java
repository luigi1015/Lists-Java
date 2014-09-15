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
public class ItemList implements Iterable<Map.Entry<Integer, ListItem>>
{
    private String name;
    private Map<Integer, ListItem> items;
    private Integer id;

    /**
     * Constructor with the ID and name of the list.
     * @param newName The name of the list.
     */
    public ItemList( Integer newId, String newName )
    {
        id = newId;
        name = newName;
        items = new HashMap<Integer, ListItem>();
    }

    /**
     * Constructor with the IDof the list.
     * @param newName The name of the list.
     */
    public ItemList( Integer newId )
    {
        id = newId;
        name = "";
        items = new HashMap<Integer, ListItem>();
    }
    
    /**
     * Adds an item to this list.
     * 
     * @param newId The Integer ID of the item.
     * @param newDescription The String description or text of the item.
     */
    public void addItem( Integer newId, String newDescription )
    {
        items.put( newId, new ListItem(newDescription) );
    }

    /**
     * Adds an item to this list with an automatically generated ID.
     * @param newDescription 
     */
    public void addItem( String newDescription )
    {
        //First, figure out what the max ID is.
        Integer newId = 0;
        for( Map.Entry<Integer, ListItem> item : items.entrySet() )
        {
            if( item.getKey() > newId )
            {
                newId = item.getKey();
            }
        }

        //Then add the item with the max ID and the description in newDescription.
        items.put( newId+1, new ListItem(newDescription) );
    }
    
    /**
     * Deletes an item in the list.
     * @param ID The ID of the item to delete.
     * @return The String value of the item.
     */
    public ListItem deleteItem( Integer ID )
    {
        return items.remove( ID );
    }
    
    /**
     * Creates and returns an iterator for going over the items in the list.
     * @return An iterator of type Iterator<Map.Entry<Integer, String>>.
     */
    public Iterator<Map.Entry<Integer, ListItem>> iterator()
    {
        return items.entrySet().iterator();
    }

    /**
     * Sets whether the item is checked or not.
     * @param itemID The ID of the item to set.
     * @param newIsChecked The checked value.
     */
    public void setItemChecked( Integer itemID, boolean newIsChecked )
    {
        items.get(itemID).setChecked( newIsChecked );
    }

    /**
     * Returns whether a given item is checked.
     * @param itemID The ID of the item to check.
     * @return A boolean representation of whether the item is checked.
     */
    public boolean getItemChecked( Integer itemID )
    {
        return items.get( itemID ).getIsChecked();
    }

    /**
     * Sets an item's description.
     * @param itemID The ID of the item to set.
     * @param newDescription A String representation of the new description.
     */
    public void setItemDescription( Integer itemID, String newDescription )
    {
        items.get(itemID).setDescription( newDescription );
    }

    /**
     * Returns the description of the item.
     * @param itemID The ID of the item in question.
     * @return A String representation of the item.
     */
    public String getItemDescription( Integer itemID )
    {
        return items.get( itemID ).getDescription();
    }

    /**
     * Returns an item.
     * @param itemID THe ID of the item in question.
     * @return The item as an ListItem object.
     */
    public ListItem getItem( Integer itemID )
    {
        return items.get( itemID );
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
     * Returns the ID of the list.
     * @return the ID of the list.
     */
    public Integer getID()
    {
        return id;
    }
    
    /**
     * Sets the ID of the list.
     * @param newID The new ID of the list.
     */
    public void setID( Integer newID )
    {
        id = newID;
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
     * @param newName The new name of the list.
     */
    public void setName( String newName )
    {
        name = newName;
    }
    
    public String toString()
    {
        return getName();
    }
}
