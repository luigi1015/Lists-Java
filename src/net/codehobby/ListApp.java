/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2014 Jeff Crone
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package net.codehobby;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jeff Crone
 */
public class ListApp extends javax.swing.JFrame {
    
    //private List<ItemList> lists;//The list of lists as Strings with Integer IDs associated with them.
    private Map<Integer, ItemList> lists;//The list of lists as Strings with Integer IDs associated with them.
    private DefaultListModel listsJListModel;
    private ItemListener checkBoxListener;
    private List<JCheckBox> itemJCheckBoxes;//A list of all the displayed item checkboxes to make it easier to iterate through them.

    /**
     * Creates new form ListApp
     */
    public ListApp()
    {
        listsJListModel = new DefaultListModel();
        //lists = new ArrayList<ItemList>();
        lists = new HashMap<Integer, ItemList>();
        itemJCheckBoxes = new ArrayList<JCheckBox>();
        
        //Set up the object checkboxes use to call itemJCheckBoxValueChanged( ItemEvent evt ) when they're checked or unchecked.
        checkBoxListener = new ItemListener()
        {
            public void itemStateChanged( ItemEvent evt )
            {
                itemJCheckBoxValueChanged( evt );
            }
        };

        //Set up a hook that'll run right before the program is closed.
        ExitHook eHook = new ExitHook();
        Runtime.getRuntime().addShutdownHook( eHook );
        
        initComponents();
        
        getLists();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listsJScrollPane = new javax.swing.JScrollPane();
        listsJList = new javax.swing.JList();
        itemsJScrollPane = new javax.swing.JScrollPane();
        itemsJPanel = new javax.swing.JPanel();
        addListJButton = new javax.swing.JButton();
        addItemJButton = new javax.swing.JButton();
        deleteJButton = new javax.swing.JButton();
        mainMenuJMenuBar = new javax.swing.JMenuBar();
        fileMenuJMenu = new javax.swing.JMenu();
        openFileJMenuItem = new javax.swing.JMenuItem();
        saveFileMenuItem = new javax.swing.JMenuItem();
        exitButtonJMenuItem = new javax.swing.JMenuItem();
        editMenuJMenu = new javax.swing.JMenu();
        addListJMenuItem = new javax.swing.JMenuItem();
        deleteListJMenuItem = new javax.swing.JMenuItem();
        addItemJMenuItem = new javax.swing.JMenuItem();
        deleteItemJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lists");
        setName("mainJFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 450));
        setResizable(false);

        listsJList.setModel( listsJListModel );
        listsJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listsJListValueChanged(evt);
            }
        });
        listsJScrollPane.setViewportView(listsJList);

        itemsJPanel.setLayout(new javax.swing.BoxLayout(itemsJPanel, javax.swing.BoxLayout.PAGE_AXIS));
        itemsJScrollPane.setViewportView(itemsJPanel);

        addListJButton.setText("Add List");
        addListJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addListJButtonActionPerformed(evt);
            }
        });

        addItemJButton.setText("Add Item");
        addItemJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemJButtonActionPerformed(evt);
            }
        });

        deleteJButton.setText("Delete Item");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });

        fileMenuJMenu.setText("File");

        openFileJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openFileJMenuItem.setText("Open...");
        openFileJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileJMenuItemActionPerformed(evt);
            }
        });
        fileMenuJMenu.add(openFileJMenuItem);

        saveFileMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveFileMenuItem.setText("Save...");
        saveFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileMenuItemActionPerformed(evt);
            }
        });
        fileMenuJMenu.add(saveFileMenuItem);

        exitButtonJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitButtonJMenuItem.setText("Exit");
        exitButtonJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonJMenuItemActionPerformed(evt);
            }
        });
        fileMenuJMenu.add(exitButtonJMenuItem);

        mainMenuJMenuBar.add(fileMenuJMenu);

        editMenuJMenu.setText("Edit");

        addListJMenuItem.setText("Add List");
        addListJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addListJMenuItemActionPerformed(evt);
            }
        });
        editMenuJMenu.add(addListJMenuItem);

        deleteListJMenuItem.setLabel("Delete List");
        deleteListJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteListJMenuItemActionPerformed(evt);
            }
        });
        editMenuJMenu.add(deleteListJMenuItem);
        deleteListJMenuItem.getAccessibleContext().setAccessibleName("deleteListJMenuItem");

        addItemJMenuItem.setText("Add Item");
        addItemJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemJMenuItemActionPerformed(evt);
            }
        });
        editMenuJMenu.add(addItemJMenuItem);

        deleteItemJMenuItem.setLabel("Delete Item");
        deleteItemJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemJMenuItemActionPerformed(evt);
            }
        });
        editMenuJMenu.add(deleteItemJMenuItem);
        deleteItemJMenuItem.getAccessibleContext().setAccessibleName("deleteItemJMenuItem");

        mainMenuJMenuBar.add(editMenuJMenu);

        setJMenuBar(mainMenuJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listsJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addListJButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addItemJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteJButton))
                    .addComponent(itemsJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(itemsJScrollPane)
                    .addComponent(listsJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addListJButton)
                    .addComponent(addItemJButton)
                    .addComponent(deleteJButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This is called when the value on the lists JList is changed, so it'll start the process of changing the items JScrollPane.
     * 
     * @param evt The event object.
     */
    private void listsJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listsJListValueChanged
        if( !(evt.getValueIsAdjusting()) )
        {//If the selection value isn't still in flux, change the values in listElementsJList.
            updateItems();
        }
    }//GEN-LAST:event_listsJListValueChanged

    /**
     * Updates the GUI to show the items of the selected list.
     */
    private void updateItems()
    {
        itemsJPanel.removeAll();
        itemJCheckBoxes.clear();
        itemsJPanel.updateUI();

        for( Map.Entry<Integer, ItemList> listMap : lists.entrySet() )
        {//Go through each entry in the map until it finds the one with a String value equal to what the user has selected.
            if( (listsJList.getSelectedValue() != null) && (((ItemList)listsJList.getSelectedValue()).getID().equals(listMap.getValue().getID())) )
            {//If the selected value of listsJList is equal to the current entry in the map, add the list items.
                for( Map.Entry<Integer, ListItem> item : listMap.getValue() )
                {
                    //Set up a panel to add to itemsJPanel.
                    JPanel panel = new JPanel();
                    panel.setLayout( new BoxLayout(panel, BoxLayout.LINE_AXIS) );

                    //Add the checkbox to the panel.
                    JCheckBox checkBox = new JCheckBox( item.getValue().getDescription() );
                    checkBox.addItemListener( checkBoxListener );
                    checkBox.setName( item.getKey().toString() );
                    checkBox.setSelected( item.getValue().getIsChecked() );
                    panel.add( checkBox );
                    itemJCheckBoxes.add( checkBox );

                    //Add the label to the panel.
                    //JLabel label = new JLabel( item.getValue() );
                    //panel.add( label );

                    //Add the panel to itemsJPanel and revalidate to make the panel visible.
                    itemsJPanel.add( panel );
                    itemsJPanel.revalidate();
                }
            }
        }
    }

    /**
     * A method to be executed when the user clicks the exit button in the File menu.
     * @param evt The ActionEvent passed to the method.
     */
    private void exitButtonJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonJMenuItemActionPerformed
        exitProgram();
    }//GEN-LAST:event_exitButtonJMenuItemActionPerformed

    private void addListJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addListJButtonActionPerformed
        addList();
    }//GEN-LAST:event_addListJButtonActionPerformed

    private void addListJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addListJMenuItemActionPerformed
        addList();
    }//GEN-LAST:event_addListJMenuItemActionPerformed

    private void addItemJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemJButtonActionPerformed
        addItem();
    }//GEN-LAST:event_addItemJButtonActionPerformed

    private void addItemJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemJMenuItemActionPerformed
        addItem();
    }//GEN-LAST:event_addItemJMenuItemActionPerformed

    private void openFileJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileJMenuItemActionPerformed
        openFileJson();
    }//GEN-LAST:event_openFileJMenuItemActionPerformed

    /**
     * Opens a JSON file and imports the data.
     */
    private void openFileJson()
    {
        JFileChooser openFileChooser = new JFileChooser();
        
        //Ask if the user wants to save the current data first.
        int sureChoice = JOptionPane.showConfirmDialog(rootPane, "This will overwrite the current data, do you wish to save first?", "Sure?", JOptionPane.YES_NO_CANCEL_OPTION );

        if( sureChoice == JOptionPane.YES_OPTION )
        {//The user chose to save, so save.
            saveFileJson();
        }

        if( sureChoice != JOptionPane.CANCEL_OPTION )
        {//If the user didn't chose cancel, go ahead and open the file.
            //Create the filter to only show json files.
            FileNameExtensionFilter filenameFilter = new FileNameExtensionFilter( "JSON", "json" );
            openFileChooser.setFileFilter( filenameFilter );

            //Show the open dialog
            int returnState = openFileChooser.showOpenDialog( this );

            if( returnState == JFileChooser.APPROVE_OPTION )
            {//Basically if the user clicked open, go ahead and open.
                BufferedReader openFile = null;
                try
                {
                    //Get the path and set up the buffered reader.
                    String openFileName = openFileChooser.getSelectedFile().getAbsolutePath();
                    openFile = new BufferedReader( new FileReader(openFileName) );
                    Gson jsonData = new Gson();
                    String jsonString = "";
                    String fileInputLine = null;

                    //Get the json data as a String from the file.
                    while( (fileInputLine = openFile.readLine()) != null)
                    {
                        jsonString += fileInputLine;
                    }

                    //Parse the json data to objects and save it to the list of lists.
                    java.lang.reflect.Type listType = new TypeToken<List<ItemList>>() {}.getType();
                    lists = new Gson().fromJson( jsonString, listType );
                    listsJListModel.removeAllElements();
                    syncLists();
                } catch (IOException ex) {
                    //The file didn't open, give an error.
                    JOptionPane.showMessageDialog( rootPane, "Error opening file: " + ex.getMessage() );
                    ex.printStackTrace();
                }
                finally
                {
                    //Close the file.
                    if( openFile != null )
                    {
                        try {
                            openFile.close();
                        } catch (IOException ex) {
                            //The file didn't close properly, give an error.
                            JOptionPane.showMessageDialog( rootPane, "Error closing the input file: " + ex.getMessage() );
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /**
     * Action performed method for the save file menu button.
     * @param evt The event object.
     */
    private void saveFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileMenuItemActionPerformed
        saveFileJson();
    }//GEN-LAST:event_saveFileMenuItemActionPerformed

    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed
        deleteItem();
    }//GEN-LAST:event_deleteJButtonActionPerformed

    private void deleteItemJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemJMenuItemActionPerformed
        deleteItem();
    }//GEN-LAST:event_deleteItemJMenuItemActionPerformed

    private void deleteListJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteListJMenuItemActionPerformed
        deleteList();
    }//GEN-LAST:event_deleteListJMenuItemActionPerformed

    /**
     * Saves the current list data to a JSON file.
     */
    private void saveFileJson()
    {
        JFileChooser saveFileChooser = new JFileChooser();

        //Create the filter to only show json files.
        FileNameExtensionFilter filenameFilter = new FileNameExtensionFilter( "JSON", "json" );
        saveFileChooser.setFileFilter( filenameFilter );

        //Show the save dialog
        int returnState = saveFileChooser.showSaveDialog( this );

        if( returnState == JFileChooser.APPROVE_OPTION )
        {//Basically if the user clicked save, go ahead and save.
            FileWriter saveFile = null;
            try
            {
                //Get the path and set up the file writer.
                String saveFileName = saveFileChooser.getSelectedFile().getAbsolutePath();
                if( !(saveFileName.endsWith(".json")) )
                {//If the filename doesn't have the right extension, add it.
                    saveFileName += ".json";
                }
                saveFile = new FileWriter( saveFileName );
                Gson jsonData = new Gson();

                //System.out.println( jsonData.toJson(lists) );

                //Get the json data for the lists and save it to saveFile.
                saveFile.write( jsonData.toJson(lists) );
                saveFile.flush();
            } catch (IOException ex) {
                //The file didn't save, give an error.
                JOptionPane.showMessageDialog( rootPane, "Error saving file: " + ex.getMessage() );
                ex.printStackTrace();
            }
            finally
            {
                //Close the file.
                if( saveFile != null )
                {
                    try {
                        saveFile.close();
                    } catch (IOException ex) {
                        //The file didn't close properly, give an error.
                        JOptionPane.showMessageDialog( rootPane, "Error closing the save file: " + ex.getMessage() );
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
    /**
     * Kills the program.
     */
    private void exitProgram()
    {
        System.exit( 0 );
    }

    /**
     * Does some cleanup to get ready for the program to close. This is run by the ExitHook class.
     */
    private void cleanupBeforeExit()
    {
        //So far nothing here because no cleanup neccesary.
    }

    /**
     * Brings up a popup dialog to get the name of the ItemList and calls addList( String newName ) to actually add the ItemList.
     */
    private void addList()
    {
        String newName = JOptionPane.showInputDialog( rootPane, "Name of the list:", "List name", JOptionPane.PLAIN_MESSAGE );
        if( (newName != null) && !(newName.equals("")) )
        {//If newName isn't null, which would mean the Cancel button was hit, and newName isn't an empty String, then add the List.
            addList( newName );
        }
        
    }

    /**
     * Adds an ItemList of name newName to the lists object.
     * @param newName The name of the list.
     */
    private void addList( String newName )
    {
        //Figure out what the highest ItemList ID is so one can be added for the next ID.
        int maxId = 0;
        for( int i = 0; i < lists.size(); i++ )
        {
            if( lists.get(i).getID() > maxId )
            {
                maxId = lists.get(i).getID().intValue();
            }
        }

        //Adds one to maxId for the Id and, with the name in newName, creates the new ItemList and puts it in lists.
        lists.put( maxId+1, new ItemList(maxId+1, newName) );

        //Sync the lists with the GUI to make sure the new list shows up.
        syncLists();
    }

    /**
     * Adds an Item to the currently selected ItemList.
     */
    private void addItem()
    {
        //Get the correct list.
        for( Map.Entry<Integer, ItemList> listMap : lists.entrySet() )
        {//Go through each entry in the map until it finds the one with a String value equal to what the user has selected.
            if( (listsJList.getSelectedValue() != null) && (((ItemList)listsJList.getSelectedValue()).getID().equals(listMap.getValue().getID())) )
            {//If the selected value of listsJList is equal to the current entry in the map, add the item to this list.
                String newItemName = JOptionPane.showInputDialog( rootPane, "Description of the item:", "Item Description", JOptionPane.PLAIN_MESSAGE );
                if( (newItemName != null) && !(newItemName.equals("")) )
                {//If newItemName isn't null, which would mean the Cancel button was hit, and newItemName isn't an empty String, then add the List.
                    listMap.getValue().addItem( newItemName );
                }
            }
        }

        updateItems();
    }
    
    private void deleteItem()
    {
        int choice = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete the selected items?", "Sure?", JOptionPane.YES_NO_OPTION );
        if( choice == JOptionPane.YES_OPTION )
        {//If the user said yes, go ahead and delete the items.
            //Get the correct list.
            for( Map.Entry<Integer, ItemList> listMap : lists.entrySet() )
            {//Go through each entry in the map until it finds the one with a String value equal to what the user has selected.
                if( (listsJList.getSelectedValue() != null) && (((ItemList)listsJList.getSelectedValue()).getID().equals(listMap.getValue().getID())) )
                {//If the selected value of listsJList is equal to the current entry in the map, add the item to this list.
                    for( JCheckBox checkBox : itemJCheckBoxes )
                    {
                        if( checkBox.isSelected() )
                        {
                            //System.out.println( "Deleting checkbox " + Integer.decode(checkBox.getName()) );
                            //list.deleteItem( Integer.getInteger(checkBox.getName()) );
                            System.out.println( listMap.getValue().deleteItem( Integer.decode(checkBox.getName()) ) );
                            for( Map.Entry<Integer, ListItem> item : listMap.getValue() )
                            {
                                System.out.println( item.getKey() + ": " + item.getValue() );
                            }
                        }
                    }
                }
            }

            updateItems();
        }
    }
    
    private void deleteList()
    {
        int choice = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete the selected list?", "Sure?", JOptionPane.YES_NO_OPTION );
        if( choice == JOptionPane.YES_OPTION )
        {//If the user said yes, go ahead and delete the items.
            Map<Integer, ItemList> copy = new HashMap( lists );//Make a copy so you it doesn't have to delete what it's iterating through.
            //Get the correct list.
            for( Map.Entry<Integer, ItemList> listMap : copy.entrySet() )
            {//Go through each entry in the map until it finds the one with a String value equal to what the user has selected.
                if( (listsJList.getSelectedValue() != null) && (((ItemList)listsJList.getSelectedValue()).getID().equals(listMap.getValue().getID())) )
                {//If the selected value of listsJList is equal to the current entry in the map, delete the item from the list.
                    lists.remove( listMap.getKey() );
                }
            }

            syncLists();
        }
    }

    /**
     * A method to execute code when the user clicks one of the item checkboxes.
     * 
     * @param evt The event object.
     */
    private void itemJCheckBoxValueChanged( ItemEvent evt )
    {
        System.out.println( Integer.decode(((JCheckBox)evt.getItem()).getName()) );
        System.out.println( ((JCheckBox)evt.getItem()).getName() );
        lists.get(((ItemList)listsJList.getSelectedValue()).getID()).setItemChecked( Integer.decode(((JCheckBox)evt.getItem()).getName()), ((JCheckBox)evt.getItem()).isSelected() );
        ((JCheckBox)evt.getItem()).setOpaque( ((JCheckBox)evt.getSource()).isSelected() );

        if( ((JCheckBox)evt.getSource()).isSelected() )
        {
            //System.out.println( "You just checked JCheckBox: " + ((JCheckBox)evt.getSource()).getName() + " of List " + ((ItemList)listsJList.getSelectedValue()).getID() );
            //((JCheckBox)evt.getItem()).getParent().setBackground( Color.YELLOW );
            ((JCheckBox)evt.getItem()).setBackground( Color.YELLOW );
            //((JCheckBox)evt.getItem()).setOpaque( true );
        }
        else
        {
            //System.out.println( "You just unchecked JCheckBox: " + ((JCheckBox)evt.getSource()).getName() + " of List " + ((ItemList)listsJList.getSelectedValue()).getID() );
            //((JCheckBox)evt.getItem()).setOpaque( false );
        }
    }
    
    /**
     * This method gets the list of list from wherever and puts them in the lists object.
     * 
     * So far this method just makes up some lists, a more useful implementation will be written later.
     */
    private void getLists()
    {
        //For now just create a few lists, I'll write something more useful later.
        ItemList list1 = new ItemList( 1, "List 1" );
        list1.addItem( 1, "Item 1-1" );
        list1.addItem( 2, "Item 1-2" );
        list1.addItem( 3, "Item 1-3" );
        lists.put( 1, list1 );
        
        ItemList list2 = new ItemList( 2, "List 2" );
        list2.addItem( 1, "Item 2-1" );
        list2.addItem( 2, "Item 2-2" );
        list2.addItem( 3, "Item 2-3" );
        lists.put( 2, list2 );
        
        ItemList list3 = new ItemList( 3, "List 3" );
        list3.addItem( 1, "Item 3-1" );
        list3.addItem( 2, "Item 3-2" );
        list3.addItem( 3, "Item 3-3" );
        lists.put( 3, list3 );

        syncLists();
    }
    
    private void syncLists()
    {
        listsJListModel.clear();
        for( Map.Entry<Integer, ItemList> listMap : lists.entrySet() )
        {
            listsJListModel.addElement( listMap.getValue() );
        }
/*
        for( Map.Entry<Integer, ItemList> listMap : lists.entrySet() )
        {
            boolean isSynced = false;//To hold if the list has been synced to the GUI or not.

            for( int i = 0; i < listsJListModel.getSize(); i++ )
            {//Go through each item in listsJListModel and compare it to the list. If they're equal, set isSynced to true so the method will know not to sync it again.
                if( listsJListModel.elementAt(i).toString().equalsIgnoreCase(listMap.getValue().getName()) )
                {
                    isSynced = true;
                    break;
                }
            }

            if( !(isSynced) )
            {
                listsJListModel.addElement( listMap.getValue() );
            }
        }
*/
    }
    
    private class ExitHook extends Thread
    {
        public void run()
        {
            cleanupBeforeExit();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemJButton;
    private javax.swing.JMenuItem addItemJMenuItem;
    private javax.swing.JButton addListJButton;
    private javax.swing.JMenuItem addListJMenuItem;
    private javax.swing.JMenuItem deleteItemJMenuItem;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JMenuItem deleteListJMenuItem;
    private javax.swing.JMenu editMenuJMenu;
    private javax.swing.JMenuItem exitButtonJMenuItem;
    private javax.swing.JMenu fileMenuJMenu;
    private javax.swing.JPanel itemsJPanel;
    private javax.swing.JScrollPane itemsJScrollPane;
    private javax.swing.JList listsJList;
    private javax.swing.JScrollPane listsJScrollPane;
    private javax.swing.JMenuBar mainMenuJMenuBar;
    private javax.swing.JMenuItem openFileJMenuItem;
    private javax.swing.JMenuItem saveFileMenuItem;
    // End of variables declaration//GEN-END:variables
}
